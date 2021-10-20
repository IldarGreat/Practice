package ru.ssau.tk.ildar.Practice;

public class Person {
    private String firstName;
    private String lastName;
    private int passportId;


    Gender gender;

    public Person() {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.passportId = 0;
    }

    public Person(int passportId) {
        this.firstName = "Unknown";
        this.lastName = "Unknown";
        this.passportId = passportId;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = 0;
    }

    public Person(String firstName, String lastName, int passportId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
    }

    public Person(String firstName, String lastName, int passportId, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportId = passportId;
        this.gender = gender;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getPassportId() {
        return this.passportId;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public static String staticToString(Person person){
        return person.toString();
    }
}
