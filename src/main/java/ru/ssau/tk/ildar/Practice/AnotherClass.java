package ru.ssau.tk.ildar.Practice;

public class AnotherClass {
    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("Arkadiy");
        checkAnotherPerson(person);
        System.out.println(person.getFirstName());
    }
    private static void checkAnotherPerson(Person person) {
        person = new Person();
        person.setFirstName("Ignat");
        System.out.println(person.getFirstName());
    }
}
