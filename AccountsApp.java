package BankApplication;

public class AccountsApp {

	public static void main(String[] args) {

		System.out.println("\n RETRIEVING DATA: \n");
		
		//testing();
		testingTwo();
		testDataTypes();
		
	}
	
	public static void testing() {
		
		AccountDAO accountDAO = new AccountDAO();
		Person accountHolder = new Person();
		
		accountHolder.setFirstName("John");
		accountHolder.setLastName("Doe");
		
		Account account = new Account(1001, accountHolder);
		accountDAO.addAccount(account);
		
		if (accountDAO.isAccountEmpty())
			System.out.println("\n ACCOUNT IS EMPTY \n");
		else
			System.out.println("\n ACCOUNT IS NOT EMPTY \n");
		
		account.setAccountId(1001);
		
		Account tempAccount = new Account(1001, new Person("Tim", "Allan"));
		
		int position = accountDAO.findAccount(tempAccount);
		if (position < 0) {
			System.out.println("\n NOT FOUND \n");
		} else {
			accountDAO.updateAccount(position, tempAccount);
			System.out.println("\n ACCOUNT UPDATED \n" + position);	
			tempAccount = accountDAO.showAccount(position);
			System.out.println(tempAccount.getPrimaryAccountHolder());
			System.out.println(tempAccount.getPrimaryAccountHolder().getFirstName());
			System.out.println(tempAccount.getPrimaryAccountHolder().getLastName());
			
			accountDAO.deleteAccount(position);
			accountDAO.findAccount(tempAccount);
			
			if (position < 0) {
				System.out.println("\n YAAHHH DELETED \n"); 
			} else {
				System.out.println("\n NOT DELETED \n");
			}
			
			//the above code starting from TEMPACCOUNT is called a METHOD CHAIN
	}
}
	
	public static void testingTwo() {
		
		AccountDAO accounts = new AccountDAO();
		
		Person inputPerson = new Person("John", "Doe");
		Account inputAccount = new Account(1001, inputPerson);
		accounts.addAccount(inputAccount); //added the above account information
		
		System.out.println("ID# " + inputAccount.getAccountId() + ": " 
				+ inputAccount.getFirstName() 
				+ " " + inputAccount.getLastName());
		
		inputAccount.setAccountId(1002);
		inputAccount.setFirstName("George");
		inputAccount.setLastName("Clooney");
		accounts.addAccount(inputAccount); //ID# 1002, George Clooney << has been added now
		
		System.out.println("ID# " + inputAccount.getAccountId() + ": " 
		+ inputAccount.getFirstName() 
		+ " " + inputAccount.getLastName());
		
	}
	
	private static void testDataTypes() {
		int number1 = 100;
		int number2 = 0;
		
		number1 = number2; //replacing the value with the second variable
		
		Person person1 = new Person("AA", "LA");
		Person person2 = new Person("BB", "LB");
		
		person1 = person2;
		
		System.out.println(number1);
		printNumber(number1);
		
		System.out.println(person1);
		
		
		
	}

	private static void printPerson(Person person1) {
		// TODO Auto-generated method stub
		
		printPerson(person1);
		person1.setFirstName("Marcial");
		person1.setLastName("Cordon");

		System.out.println(person1);
		
	}

	private static void printNumber(int number1) {
		int n = 99;
		number1 = n;
		
		System.out.println(number1);
		
		
	}

}