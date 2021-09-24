package ru.ssau.tk.ildar.Practice;
import static ru.ssau.tk.ildar.Practice.Gender.*;

class Main {
    public static void main(String[] args) {

        NamedPoint namedPoint = new NamedPoint();
        NamedPoint namedPointTwo = new NamedPoint(1, 2, 3);
        NamedPoint namedPointThree = new NamedPoint(1, 2, 3, "Unknown");
        namedPoint.setName("Ildar");
        System.out.println(namedPoint.getName());
        namedPointTwo.setName("Ildar");
        System.out.println(namedPoint.getName());
        namedPointThree.setName("Ildar");
        System.out.println(namedPoint.getName());

        Person person = new Person();
        Person personTwo = new Person(1);
        Person personThree = new Person("Ildar", "Idiot");
        Person personFour = new Person("Ildar", "Idiot", 1);
        Person personFive = new Person("Ildar", "Idiot", 1, MALE);
        System.out.println(person.getFirstName() + personTwo.getFirstName() + personThree.getFirstName() + personFour.getFirstName() + personFive.getGender());
        personFive.setGender(FEMALE);


    }
}
