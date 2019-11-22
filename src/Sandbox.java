package BankApplication;

public class Sandbox {
	
	public static void main(String[] args) {
		
		sampleNewPerson();
		
	}
	
	private static void sampleNewPerson() {
		Person primaryAcountHolder = new Person();
		
		System.out.println(primaryAcountHolder.toString()); //output NONE
		
		Person primaryAccountHolder2 = new Person("Marcial", "Cordon");
		
		System.out.println(primaryAccountHolder2.toString()); //output Marcial Cordon
		
		Person primaryAccountHolder3 = new Person("Victor", "Zenin");
		
		System.out.println(primaryAccountHolder3.toString());
		
//		Person testing4 = new Person();
		Person testing5 = new Person();
		
		System.out.println(testing5); //output none <<< now let's improve on this
		
		testing5.setFirstName("John");
		testing5.setLastName("Doe");
		System.out.println(testing5); //output John Doe
		
		Person testing6 = new Person("David", "Washington"); // << this is best practice //output "David Washington"
		System.out.println(testing6.toString());
		
		
		
	}

	public static void testingPersonOne() {
		
		Person accountHolder = new Person("Marcial", "Cordon");
		
		System.out.println(accountHolder.getFirstName() + " " + accountHolder.getLastName());
		
	}

}
