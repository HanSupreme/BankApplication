package November19BankAccount;

import java.util.Arrays;
import java.util.Scanner;

public class Functions {
	
	final int SIZE = 500;
	int[] idArray = new int [SIZE];
	int lastIndex; //will represent the LAST position that is added to the array, minimum value 0, maximum 499 (500 total)
	
	public void intAccountArray() {
		
		/*
		 * PUBLIC - can be accessed anywhere
		 * public - only accessible within the class
		 * STATIC - can be used without having to create an instance of a class
		 * VOID - will return nothing
		 * psv intAccountArray() is our method signature
		 * intAccountArray() method name
		 */
		
		this.lastIndex = -1; //this is referring back to the property of the class | which is in the functions class
		
		for (int i = 0; i < this.SIZE; i++) {
			
			this.idArray[i] = 9999;
		}
		
	} //closing braces for intAccountArray() method

	public boolean isArrayEmpty() {
		// TODO Auto-generated method stub
		
		if (this.lastIndex < 0) return false;
		return true;
	}
	
	public boolean existAccountID(int accountID) {
		// TODO Auto-generated method stub
		
		Arrays.sort(this.idArray);
		
		int result = Arrays.binarySearch(this.idArray, accountID);
		
		return result < 0 ? false : true; //return if the result is less than zero, else if result is greater than zero = true, return
	}
	
	public boolean isAccountArrayFull() {
		
		if (this.lastIndex == 499)
			
		return true;
		return false;
		
	}
	
	public void addNewAccount(int accountID) {
		
		this.lastIndex++;
		
		this.idArray[this.lastIndex] = accountID;
		
		//this is how we add/ store into our array
		
	}
	
	public char enterAnswer() {
		
		boolean answer = false;
		String response;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.println("\n Would you like to continue? \n" + "\n [YES] | [NO] \n");
			
			response = sc.nextLine();
			
			if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
				answer = false;
			} else if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n")) {
				answer = false;
				System.exit(0);
			} else {
				answer = true;
			}
		
		} while (answer);
		
		sc.close();
		
		return response.charAt(0);
		
	}

}