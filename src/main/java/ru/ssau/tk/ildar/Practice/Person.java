package ru.ssau.tk.ildar.Practice;

public class Person {
    private String firstName;
    private String lastName;
    private int passportId;

    public String getFirstName(){return this.firstName;}
    public String getLastName(){return this.lastName;}
    public int getPassportId(){return this.passportId;}

    public Person(){  // Конструктор без параметров
        this.firstName="Unknown";
        this.lastName="Unknown";
        this.passportId=0;
    }

    public Person(int passportId){  // Конструктор с одним параметром
        this.firstName="Unknown";
        this.lastName="Unknown";
        this.passportId=passportId;
    }

    public Person(String firstName,String lastName){  // Конструктор с двумя параметрами
        this.firstName=firstName;
        this.lastName=lastName;
        this.passportId=0;
    }

    public Person(String firstName,String lastName,int passportId){  // Конструктор с тремя параметрами
        this.firstName=firstName;
        this.lastName=lastName;
        this.passportId=passportId;
    }


    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setPassportId(int passportId){
        this.passportId=passportId;
    }
}
