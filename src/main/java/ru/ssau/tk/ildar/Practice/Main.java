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

        byte a=0;
        GetType.printType(a);
        GetType.printType((char) a);
        GetType.printType((short) a);
        GetType.printType((int) a);
        GetType.printType((long) a);
        GetType.printType((float) a);
        GetType.printType((double) a);
        GetType.printType(true);
        GetType.printType(null);
        GetType.printType(namedPoint);
        GetType.printType("Fuck u");
        GetType.printType(person);
    }
}
