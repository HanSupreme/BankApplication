package BankApplication;


public class Person {
	
	private String firstName;
	private String lastName;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	
	public Person() {
		super();
		this.firstName = "NONE";
		this.lastName = "NONE";
		
		//Testing to print but not ideal
	}
	
	public Person(Person inputPerson) {
		this.firstName = inputPerson.getFirstName();
		this.lastName = inputPerson.getLastName();
	}
	
	//GETTER - Sets a variable and returns the value
	public String getFirstName() {
		return firstName;
	}
	
	//SETTER - Sets the value
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//GETTER - Sets a variable and returns the value
	public String getLastName() {
		return lastName;
	}
	
	//SETTER - Sets the value
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		String msg = " ";
		msg = "[" + this.firstName + " " + this.lastName + "]";
		
		return msg;
	}

}