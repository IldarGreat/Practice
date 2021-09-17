
public class Person {
    private String firstName;
    private String lastName;
    private int passportId;
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
