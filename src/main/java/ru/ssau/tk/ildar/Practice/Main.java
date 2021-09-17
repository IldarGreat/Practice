package ru.ssau.tk.ildar.Practice;
import  ru.ssau.tk.ildar.Practice.Person;

class Main{
    public static void main(String[] args) {
        Person person=new Person();
        Person personTwo=new Person(9234);
        Person personThree=new Person("Валерия","Атапина");
        Person personFour=new Person("Екатерина","Арьева",1342);
        personFour.getLastName();
    }
}
