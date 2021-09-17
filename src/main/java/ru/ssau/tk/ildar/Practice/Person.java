package ru.ssau.tk.ildar.Practice;

public class Person {
    private String firstName;
    private String lastName;
    private int passportId;
    public Person(){
        this.firstName="Unknow";
        this.lastName="Unknow";
        this.passportId=0;
    }
    public void getFirstName(){
        System.out.println(firstName);
    }
    public void getLastName(){
        System.out.println(lastName);
    }
    public void getPassportId(){
        System.out.println(passportId);
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setSecondName(String lastName){
        this.lastName=lastName;
    }
    public void setPassportId(int passportId){
        this.passportId=passportId;
    }
}

