package Phonebook;

/**
 * ED: Setting up nodes to use in the Hash Table
 * @param <string> Name
 * @param <person> person
 */

class HashTableNode<string, person> {
    // ED: The hash value
    final int hash;
    // ED: The Name of the person
    final string name;
    // ED: The Person
    person person;
    // ED: The linked list, showing the next node
    HashTableNode<string, person> next;

    HashTableNode(int hash, string name, person person, HashTableNode<string, person> next) {
        this.hash = hash;
        this.name = name;
        this.person = person;
        this.next = next;
    }
}