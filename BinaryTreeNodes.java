package Phonebook;

/*
 * ED: Binary Tree Node
 * ED: Links the nodes together
 */

class BinaryTreeNode {
    private BinaryTreeNode right;
    BinaryTreeNode left;
    person person;

     // ED: Constructor for an empty node

    BinaryTreeNode() {
        person = null;
        left = null;
        right = null;
    }


    // ED: Constructor for a node occupied by a person
    // ED: @param person references the Person class


    BinaryTreeNode(person person) {
        this.person = person;
        left = null;
        right = null;
    }

     // ED: Get the minimum node out of populated nodes
     // @return Will return person, or null if there is no person on the left as the minimum value

    private person min() {
        if (left == null) {
            return person;
        }
        else {
            return left.min();
        }
    }

    /*
     ED: Part 3A - Insert Function
     ED: Inserts a new person into the binary tree
     @param first_name - First name of the party being inserted.
     @param last_name - Last name of the party being inserted.
     @param email - Email address of the party being inserted.
     @param phone - Phone Number of the party being inserted.
     @return person - Returns the person inserted.
     */
    person insert(String first_name, String last_name, String email, String phone) {
        person person = new person(first_name, last_name, email, phone);

        // ED: If the new person matches this node, then update the node with the new information.


        if (person.name.compareTo(this.person.name) == 0) {
            this.person = person;

            System.out.println(person.name + " was updated in the binary tree with the updated details of this person");

            return this.person;
        }

        else if (person.name.compareTo(this.person.name) < 0) {

            // ED: If the inserted person comes before the node, then set it to the left hand side.
            // ED: And if the left is null, make this person the left.


            if (left == null) {
                left = new BinaryTreeNode(person);

                System.out.println(person.name + " was successfully inserted into the binary tree");

                return left.person;
            }
            else {
                return left.insert(first_name, last_name, email, phone);
            }
        }

        else {

            // ED: If the inserted person comes after the node, then set it to the right hand side.
            // ED: And if the right is null, make this person the right.


            if (right == null) {
                right = new BinaryTreeNode(person);

                System.out.println(person.name + " was successfully inserted into the binary tree");

                return right.person;
            }
            else {
                return right.insert(first_name, last_name, email, phone);
            }
        }
    }

    /**
     * ED: Lookup
     * ED: Searches for a person by name
     * @param name Name
     * @return person|Null A person if one was found
     */
    person lookup(String name) {
        // ED: If this node is the person return it
        if (name.compareTo(person.name) == 0) {
            System.out.println(name + " was found in the binary tree with email " + person.email + " and phone " + person.phone);

            return person;
        }
        else if (name.compareTo(person.name) < 0) {
            // ED: If the person comes before this node's person search the left
            // ED: If there is no left there is no match
            if (left == null) {
                System.out.println(name + " could not be located in the binary tree");

                return null;
            }
            else {
                return left.lookup(name);
            }
        }
        else {
            // ED: If the person comes after this node's person search the right
            // ED: If there is no right there is no match
            if (right == null) {
                System.out.println(name + " could not be located in the binary tree");

                return null;
            }
            else {
                return right.lookup(name);
            }
        }
    }

    /*
     ED: Delete Function
     ED: Deletes a person by thier name and parent node
     ED @param first_name First name of the party being deleted.
     ED @param Parent of the party being deleted.
     ED @return True if the person was deleted, False if they were not deleted.
     */

    Boolean delete(String name, BinaryTreeNode parent) {

        // ED: If this person is the node, then remove them with no change to the tree structure

        if (name.compareTo(person.name) == 0) {

            // ED: Traverse to find a match if there is a left and right

            if (left != null && right != null) {
                return right.delete(name, this);
            }
            else if (parent.left == this) {

                // ED: If the parent's left matches, set it to null to delete

                parent.left = left != null ? left: right;

                System.out.println(name + " was successfully deleted from the binary tree");

                return true;
            }
            else if (parent.right == this) {

                // ED: If the parent's right matches, set it to null to delete

                parent.right = left != null ? left : right;

                System.out.println(name + " was successfully deleted from the binary tree");

                return true;
            }
        }
        else if (name.compareTo(person.name) < 0) {


        // ED: If the person we looked for is less than this node, delete it from the left.
        // ED: If there is a left for the node, keep searching. If there is no further left, then no match, or delete

            if (left != null) {
                return left.delete(name, this);
            }
            else {
                System.out.println(name + " was not deleted from the binary because the person could not be located");

                return false;
            }
        }
        else {

        //ED: If the person we looked for is greater than this node, remove it from the right.
        //ED: If there is a right, keep looking further. If no right, then there is no match, no delete.

            if (right != null) {
                return right.delete(name, this);
            } else {
                System.out.println(name + " was not deleted from the binary because the person could not be located");

                return false;
            }
        }

        System.out.println(name + " was not deleted from the binary because the person could not be located");

        return false;
    }
}