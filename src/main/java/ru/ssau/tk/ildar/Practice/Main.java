package ru.ssau.tk.ildar.Practice;
import  ru.ssau.tk.ildar.Practice.Person;

class Main{
    public static void main(String[] args) {
        Person person=new Person();
        person.getFirstName();
        person.getLastName();
        person.getPassportId();
        person.setFirstName("Ильдар");
        person.setSecondName("Идиятов");
        person.setPassportId(9216);
        person.getFirstName();
        person.getLastName();
        person.getPassportId();
    }
}
