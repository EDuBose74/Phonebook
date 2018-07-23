package Phonebook;
/**
 * ED: person
 * ED: Represents the person in the phone book
 */

class person {
    String name;
    String email;
    String phone;

    /**
     * ED: Constructor
     * ED: @param first_name First name of the person
     * ED: @param last_name Last name of the person
     * ED: @param email Email address of the person
     * ED: @param phone Phone number of the person
     */
    person(String first_name, String last_name, String email, String phone) {
        this.name = first_name + " " + last_name;
        this.email = email;
        this.phone = phone;
    }
}