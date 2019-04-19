package SecretSanta;

import java.util.List;

public class Person {

    private String name;
    private int NumberOfImmediateFamilyMembers;
    private boolean isSecertSanta;
    private List<Person> immediateFamilyMembers;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public static Person createContact(String name, String phoneNumber) {
        return new Person(name, phoneNumber);
    }
}
