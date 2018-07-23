package Phonebook;

/*
ED: Part B - Binary Tree
ED: Implementing the tree structure
*/


class BinaryTree {


    // ED: Root of the tree itself

    private Phonebook.BinaryTreeNode root;


     // ED: Constructor for the tree, starting with no active nodes.

    BinaryTree() {
        root = null;
    }

    /*
     ED: Namify concatenates (combines) both first, and last name
     @param first_name First name of person
     @param last_name Last name of person
     @return the result of contactenation
     */

    private static String namify(String first_name, String last_name) {
        return first_name + " " + last_name;
    }

    /*
     ED: Part 1B - Insert Function
     ED: Inserts a new person into the binary tree
     @param first_name - First name of the party being inserted.
     @param last_name - Last name of the party being inserted.
     @param email - Email address of the party being inserted.
     @param phone - Phone Number of the party being inserted.
     @return person - Returns the person inserted.
     */

    person insert(String first_name, String last_name, String email, String phone) {
        person person = new person(first_name, last_name, email, phone);

        // ED: Sets the entry to be the root if we haven't inserted anything into the tree yet.

        if (root == null) {
            root = new Phonebook.BinaryTreeNode(person);

            System.out.println(person.name + " was successfully inserted into the binary tree");

            return root.person;
        }

        else {

        // ED: If the root isn't null, this inserts the person through the root.

            return root.insert(first_name, last_name, email, phone);
        }
    }

    /*
     ED: Part 2B - Delete Function
     ED: Deletes a person by thier name
     ED @param first_name First name of the party being deleted.
     ED @param last_name Last name of the party being deleted.
     ED @return True if the person was deleted, False if they were not deleted.
     */

    Boolean delete(String first_name, String last_name) {
        String name = namify(first_name, last_name);

        // ED: We have to check to see if the root is null first, as if so, we won't have entries to delete
        if (root == null) {
            System.out.println(name + " was not deleted from the binary tree as the person could not be located");

            return false;
        }

        else {

        // ED: If there is a root, we need to find out if the root is the party to be deleted.

            if (root.person.name.compareTo(name) == 0) {

                // ED: If the root needs to be deleted, we need a temporary root.

                Phonebook.BinaryTreeNode temporaryRoot = new Phonebook.BinaryTreeNode();

                // ED: The code sets the temp root left, removes the root, then sets the root back to the empty temporary location.

                temporaryRoot.left = root;
                root.delete(name, temporaryRoot);
                root = temporaryRoot.left;

                System.out.println(name + " was successfully deleted from the binary tree");

                return true;
            }

            else {

                return root.delete(name, null);
            }
        }
    }

    /*
     ED: Part 3B - Lookup Function
     ED: Lookup a person by name within the tree
     @param first_name First name of the person to Lookup
     @param last_name Last name of the person to Lookup
     @return A person's name if the party was found, and null if not.
     */

    person lookup(String first_name, String last_name) {
        String name = namify(first_name, last_name);

        // ED: Like delete, we need to ensure the root is even there. If not, it can save time in the function.

        if (root == null) {
            System.out.println(name + " could not be found in the binary tree");

            return null;
        }

        else {
            //ED Lookup the name via the root.
            return root.lookup(name);
        }
    }
}