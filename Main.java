package Phonebook;

/**
 * ED: Data Structures Project
 * @author Eric DuBose
 */
public class Main {
    /**
     * ED: Main
     * ED: Executes the program
     * @param args Optons are help, hash table, or binary tree
     */
    public static void main(String[] args) {
        // ED: If there are no arguments or the argument is help display help text
        testHashTable();
        testBinaryTree();
    }

    /**
     * ED: Test Hash Table
     * ED: Part 4A - Creating buckets (based on size)
     * ED: Tests the hash table implementation with the inserts, lookups, and deletions
     */
    private static void testHashTable() {
        HashTable hash_table = new HashTable(13);

        hash_table.insert("Bob", "Smith", "bsmith@somewhere.com", "555-235-1111");
        hash_table.insert("Jane", "Williams", "jw@something.com", "555-235-1112");
        hash_table.insert("Mohammed", "al-Salam", "mas@someplace.com", "555-235-1113");
        hash_table.insert("Pat", "Jones", "pjones@homesweethome.com", "555-235-1114");
        hash_table.insert("Billy", "Kidd", "billy_the_kid@nowhere.com", "555-235-1115");
        hash_table.insert("H.", "Houdini", "houdini@noplace.com", "555-235-1116");
        hash_table.insert("Jack", "Jones" , "jjones@hill.com" , "555-235-1117");
        hash_table.insert("Jill", "Jones", "jillj@hill.com", "555-235-1118");
        hash_table.insert("John", "Doe", "jdoe@somedomain.com", "555-235-1119");
        hash_table.insert("Jane", "Doe", "jdoe@somedomain.com", "555-235-1120");

        hash_table.lookup("Pat", "Jones");
        hash_table.lookup("Billy", "Kidd");

        hash_table.delete("John", "Doe");

        hash_table.insert("Test", "Case", "Test_Case@testcase.com", "555-235-1121");
        hash_table.insert("Nadezhda", "Kanachekhovskaya", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru" , "555-235-1122");
        hash_table.insert("Jo", "Wu", "wu@h.com", "555-235-1123");
        hash_table.insert("Millard", "Fillmore", "millard@theactualwhitehouse.us", "555-235-1124");
        hash_table.insert("Bob", "vanDyke", "vandyke@nodomain.com", "555-235-1125");
        hash_table.insert("Upside", "Down", "upsidedown@rightsideup.com", "555-235-1126");

        hash_table.lookup("Jack", "Jones");
        hash_table.lookup("Nadezhda", "Kanachekhovskaya");

        hash_table.delete("Jill", "Jones");
        hash_table.delete("John", "Doe");

        hash_table.lookup("Jill", "Jones");
        hash_table.lookup("John", "Doe");
    }

    /**
     * ED: Binary Tree
     * ED: Tests the binary tree implementation with the inserts, lookups, and deletions
     */
    private static void testBinaryTree() {
        BinaryTree binary_tree = new BinaryTree();

        binary_tree.insert("Bob", "Smith", "bsmith@somewhere.com", "555-235-1111");
        binary_tree.insert("Jane", "Williams", "jw@something.com", "555-235-1112");
        binary_tree.insert("Mohammed", "al-Salam", "mas@someplace.com", "555-235-1113");
        binary_tree.insert("Pat", "Jones", "pjones@homesweethome.com", "555-235-1114");
        binary_tree.insert("Billy", "Kidd", "billy_the_kid@nowhere.com", "555-235-1115");
        binary_tree.insert("H.", "Houdini", "houdini@noplace.com", "555-235-1116");
        binary_tree.insert("Jack", "Jones" , "jjones@hill.com" , "555-235-1117");
        binary_tree.insert("Jill", "Jones", "jillj@hill.com", "555-235-1118");
        binary_tree.insert("John", "Doe", "jdoe@somedomain.com", "555-235-1119");
        binary_tree.insert("Jane", "Doe", "jdoe@somedomain.com", "555-235-1120");

        binary_tree.lookup("Pat", "Jones");
        binary_tree.lookup("Billy", "Kidd");

        binary_tree.delete("John", "Doe");

        binary_tree.insert("Test", "Case", "Test_Case@testcase.com", "555-235-1121");
        binary_tree.insert("Nadezhda", "Kanachekhovskaya", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru" , "555-235-1122");
        binary_tree.insert("Jo", "Wu", "wu@h.com", "555-235-1123");
        binary_tree.insert("Millard", "Fillmore", "millard@theactualwhitehouse.us", "555-235-1124");
        binary_tree.insert("Bob", "vanDyke", "vandyke@nodomain.com", "555-235-1125");
        binary_tree.insert("Upside", "Down", "upsidedown@rightsideup.com", "555-235-1126");

        binary_tree.lookup("Jack", "Jones");
        binary_tree.lookup("Nadezhda", "Kanachekhovskaya");

        binary_tree.delete("Jill", "Jones");
        binary_tree.delete("John", "Doe");

        binary_tree.lookup("Jill", "Jones");
        binary_tree.lookup("John", "Doe");
    }
}
