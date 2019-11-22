package BankApplication;

/*
 * This is a  Model for Accounts
 * Fields:
 * - Account ID
 * - Primary Account Holder
 * - 		- First Name
 * 			- Last Name
 * 
 * - UPDATE - MOVED!!
 *  				Primary Account Holder
 * 							- First Name
 * 							- Last Name
 * 
 * - UPDATE - MOVED!!
 * 					To a NEW CLASS called PERSON
 * 						- PERSON will be our PARENT CLASS
 * 
 */

//Our Child Class (Account)
public class Account extends Person {

	/*
	 * How do we make a class inherit from another?
	 * 
	 * - We use the "EXTENDS" keyword - check above method signature for example
	 * 
	 * 	"Is-a" relationship
	 * for example; Account object "is-a" Person
	 * 
	 * 		- Account can do anything a Person Class can do (maybe even more)
	 * 		- It can be substituted wherever a Person Class is needed
	 * 		- A variable of type Person can refer to Account
	 * 
	 * Account is inheriting Person methods
	 */
	
	private int accountId;
	private Person primaryAccountHolder;
	
//	public Account(int accountId, String firstName, String lastName) {
//		super(firstName, lastName);
//		this.accountId = accountId; 
//	}
	//Above code is  
	
	/*
	The below is an easier way to retype the above method
	Instead of typing String firstName, String lastName over and over we can just REFER to the PERSON class
	*/
	
	public Account(int acccountId, Person accountHolder) {
//		super(accountHolder.getFirstName(), accountHolder.getLastName()); // << not needed anymore because of the new primaryAccountHolder that we've added
		this.accountId = accountId;
		this.primaryAccountHolder = new Person(accountHolder);
	}
	
	public Account (Account account ) {
		this.accountId = account.getAccountId();
		this.primaryAccountHolder = new Person(account.getPrimaryAccountHolder());
	}

	//SETTER - Set Method that SETS the value
	public void setAccountId (int accountId) {
		this.accountId = accountId;
	}

	//GETTER - Returns the VALUE of the VARIABLE
	public int getAccountId() {
		return accountId;
	}
	
	//SETTER - Set Method that SETS the value
	public void setPrimaryAccountHolder (Person primaryAccountHolder) {
		this.setPrimaryAccountHolder(primaryAccountHolder);
	}
	
	//GETTER - Get Method that returns the variable of the value
	public Person getPrimaryAccountHolder () {
		return this.primaryAccountHolder;
	}
}