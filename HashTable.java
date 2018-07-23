package Phonebook;

/*
 * ED: Part 1A - Hash Table
 * ED: Implemting the Hash Table
 */


class HashTable {

    // ED: Creating the dictionary array for nodes.

    private HashTableNode<String, person>[] nodes;

    /*
     * ED: Part 4A - Creating buckets (based on size)
     * ED: Creating the Constructor for the Hash Table
     * ED: @param size Size of the hash table
     */

    @SuppressWarnings("unchecked")
    HashTable(int size) {
        nodes = new Phonebook.HashTableNode[size];
    }


     // ED: Get has index for the hash table
     // ED: @param name Name
     // ED: @return Integer The hash index if found

    private Integer getIndex(String name) {
        Integer hash = name.hashCode() % nodes.length;

        if (hash < 0) {
            hash += nodes.length;
        }

        return hash;
    }

    /*
     ED: Namify concatenates (combines) both first, and last name
     ED: @param first_name First name of person
     ED: @param last_name Last name of person
     ED: @return the result of contactenation
     */

    private static String namify(String first_name, String last_name) {
        return first_name + " " + last_name;
    }

    /*
     ED: Part 1A - Insert Function
     ED: Inserts a new person into the binary tree
     ED: @param first_name - First name of the party being inserted.
     ED: @param last_name - Last name of the party being inserted.
     ED: @param email - Email address of the party being inserted.
     ED: @param phone - Phone Number of the party being inserted.
     ED: @return person - Returns the person inserted.
     */

    @SuppressWarnings("unchecked")
    person insert(String first_name, String last_name, String email_address, String phone_number) {
        person person = new person(first_name, last_name, email_address, phone_number);
        int hash = getIndex(person.name);

        // ED: Finds out if the person was already in the table, and if they were, updates the person.


        for (HashTableNode<String, person> node = nodes[hash]; node != null; node = node.next) {
            if (hash == node.hash && person.name.equals(node.name)) {
                person previous = node.person;

                node.person = person;

                System.out.println(person.name + " was updated in the hash table with the updated details of this person");

                return previous;
            }
        }

        // DL: Inserting the person into the hash table


        HashTableNode<String, person> node = new Phonebook.HashTableNode(hash, person.name, person, nodes[hash]);
        nodes[hash] = node;

        System.out.println(person.name + " was successfully inserted into the hash table");

        return person;
    }

    /*
     ED: Part 2A - Delete Function
     ED: Deletes a person by thier name
     ED @param first_name First name of the party being deleted.
     ED @param last_name Last name of the party being deleted.
     ED @return True if the person was deleted, False if they were not deleted.
     */

    Boolean delete(String first_name, String last_name) {
        String name = namify(first_name, last_name);
        int hash = getIndex(name);
        HashTableNode<String, person> previous = null;

        // ED: Searches the table for the person. If they are there, they are deleted.

        for (HashTableNode<String, person> node = nodes[hash]; node != null; node = node.next) {
            if (hash == node.hash && name.equals(node.name)) {
                if (previous != null) {
                    previous.next = node.next;
                }

                else {
                    nodes[hash] = node.next;
                }

                System.out.println(name + " was successfully deleted from the hash table");

                return true;
            }

            previous = node;
        }

        System.out.println(name + " was not deleted from the hash table as the person could not be located");

        return false;
    }

    /*
     ED: Part 3B - Lookup Function
     ED: Lookup a person by name within the tree
     ED: @param first_name First name of the person to Lookup
     ED: @param last_name Last name of the person to Lookup
     ED: @return A person's name if the party was found, and null if not.
     */

    person lookup(String first_name, String last_name) {
        String name = namify(first_name, last_name);
        int hash = getIndex(name);

        // ED: Looks through both the hash table, and nodes for the person

        for (HashTableNode<String, person> node = nodes[hash]; node != null; node = node.next) {
            if (name.equals(node.name)) {
                System.out.println(name + " was found in the hash table with the email " + node.person.email + " and phone " + node.person.phone);

                return node.person;
            }
        }

        System.out.println(name + " was not found in the hash table");

        return null;
    }

}