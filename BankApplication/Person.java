package BankApplication;

public class Person {
    protected String firstName;
    protected String lastName;

    public Person() {
        super();
        this.firstName = "";
        this.lastName = "";
    }

    protected Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected Person(String firstName) {
        this.firstName = firstName;
        this.lastName = "";
    }

    protected void setFirstName(String firstName){
        this.firstName = firstName;
    }

    protected String getFirstName () {
        return firstName;
    }

    protected void setLastName(String lastName){
        this.lastName = lastName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected Person(Person inputPerson) {
        this.firstName = inputPerson.getFirstName();
        this.lastName = inputPerson.getLastName();
    }

    @Override
    public String toString() {
        String msg = "";
        msg = "[" + this.firstName + ", " + this.lastName + "]";
        return msg;
    }

}
