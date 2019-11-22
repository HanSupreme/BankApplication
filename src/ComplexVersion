package November19BankAccount;

import java.util.Arrays;
import java.util.Scanner;

public class AccountInfo {
	
	static Functions functions = new Functions(); //calling the functions class into this class so that we can use its methods
	
	public void addAccounts() {
		
		int accountID = 0;
		System.out.println("testing");
		
		if (!functions.isAccountArrayFull()) {
			accountID = enterAccount(); // -1 or valid accountID
			if (accountID != -1) {
				if (functions.existAccountID(accountID)) {
					System.out.println("\n ERROR: Duplicate Account ID# \n");
				} else {
					functions.addNewAccount(accountID);
					System.out.println(Arrays.toString(functions.idArray));
				}
			}
		}
		
	} //closing braces for addAccounts(); method
	
	public int enterAccount() {
		
		int accountID = -1;
		char answer = ' ';
		boolean continueyn = false; //continue yes or no
		Scanner sc = new Scanner(System.in);
		
		do {
			
			System.out.print("\n ENTER ACCOUNT ID: \n");
			
			accountID = sc.nextInt();
			
			if (!isAccountValid(accountID)) {
				System.out.println("\n ERROR: INVALID ACCOUNT \n");
				answer = functions.enterAnswer();
				
				functions.enterAnswer();
				
				//continueyn = true;
				continueyn = false;
				
				if (answer == 'Y') continueyn = true; //<<< not needed
				else continueyn = false; // <<< originally these two, in case it doesn't work delete this code >>>>>> continueyn = true; <<<<< and uncomment these two lines
				
				accountID = -1;
			
			} else {
				
				continueyn = false;
			}
			

		} while(continueyn);
		
		sc.close();
		
		return accountID;
		
	}
	
	public boolean isAccountValid(int accountID) {
		
		if (accountID <= 1000 || accountID >= 5000) {
			return false;
		}
		
		return true;
}
	
}
