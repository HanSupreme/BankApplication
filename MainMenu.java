package November19BankAccount;

import java.util.Arrays;
import java.util.Scanner;

public class MainMenu {

	static Functions functions = new Functions();
	static AccountInfo addAccounts = new AccountInfo();
	
	static Scanner sc;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		
		mainMenu();
		
		functions.intAccountArray();
		functions.isArrayEmpty();
		functions.existAccountID(9999);
		functions.isAccountArrayFull();
		functions.addNewAccount(9999);
		
		addAccounts.addAccounts();

		sc.close();
		
	}
	
	private static void mainMenu() {
		
		int choice = 0;
		
		do {
			
			printMainMenu();
			choice = enterChoice();
			executeOperation(choice);
			
		} while(choice != 5);
		System.out.println("GOOD-BYE");
		
	}
	
	private static void printMainMenu() {
		
		
		System.out.println(
				"\n   			WELCOME TO METRO BANK 		     | \n"
				+ "\n 1. [ADD ACCOUNTS]		|	2. [SHOW ACCOUNTS]   |\n"
				+ "\n 3. [UPDATE ACCOUNTS]		|	4. [DELETE ACCOUNTS] |\n"
				+ "\n 			   5. [EXIT] \n"
				);
		
	}
	
	private static int enterChoice() {
		
		int choice = 0;
		
		System.out.print("Enter option: ");
		
		do {
			choice = sc.nextInt();
			
			if (choice < 1 || choice > 5)
				System.out.println("INVALID ENTRY. TRY AGAIN.");
			
		} while (choice < 1 || choice > 5);
		
		return choice;
	}
	
	private static void executeOperation(int choice) {
		
		switch (choice) {
		case 1:
			
			break;
		case 2:
			showAccounts();
			break;
		case 3:
			updateAccounts();
			break;
		case 4:
			//deleteAccounts();
			break;
		case 5:
			exit();
			break;
		default:
			System.out.println("ERROR");
			
	} //closing braces for Switch statement
} //closing braces for executeOperation() method
	
	private static void exit() {
		// TODO Auto-generated method stub
		
		System.out.println("\n GOOD-BYE \n");
		System.exit(0);
		
	}

	private static void updateAccounts() {
		
		/*
        1. Verify array is not empty
        2. Ask for accountID to update
        3. search(accountID)

        4. if valid/ exist; THEN;
            4.1 ask for new valid accountID
            4.2 verify is not duplicate
            4.3 update the record or element
         */
		
		char checkIfEmpty;
		int requestNewAccountInfo;
		int position;
		
		do {
			System.out.println("\n UPDATING ACCOUNT...\n");
			int accountID = enterAccount();
			if (accountID != -1) {
				if (functions.existAccountID(accountID)) {
					System.out.println("\n UPDATE COMPLETE \n");
					requestNewAccountInfo = enterAccount();
					if (requestNewAccountInfo != -1);

					Arrays.sort(functions.idArray);
					
					position = Arrays.binarySearch(functions.idArray, accountID);
					functions.idArray[position] = requestNewAccountInfo;
					
					System.out.println("\n RECORD UPDATED \n");
					System.out.println(Arrays.toString(functions.idArray));
					
				} else {
					System.out.println("\n Does not Exist \n");
				}
			}
			
			checkIfEmpty = enterAnswer();
			
		} while (checkIfEmpty == 'Y' || checkIfEmpty == 'y');
		
	}

	private static void showAccounts() {
		
		/*
		 * 1. verify array is not empty
		 * 2. Ask for accountID to show
		 * 3. Search (accountID)
		 * 4. If exist print - "Record found"
		 * 		else - record not found
		 * 5. ask user if they would like to continue searching
		 */
		
	if (!functions.isArrayEmpty()) {
		
		int accountID = 0;
		
		char answer = ' '; //have to initialize otherwise can not be used in while loop
		
		do {
			accountID = enterAccount();
			if (accountID != -1) {
				if (functions.existAccountID(accountID)) {
					System.out.println("\n Record Found \n"
							+ "\n" + accountID + " exist \n");
				} else {
					System.out.println("\n Record Not Found \n"
							+ "\n" + accountID + " does not exist \n");
				}
			
			System.out.println("\n Do you want to continue? \n");
				
			}
			
			
			
		} while (answer == 'Y' || answer == 'y');
		
	}
	}

	private static void addAccounts() {
		
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

	private static int enterAccount() {
		
		int accountID = -1;
		char answer = ' ';
		boolean continueyn = false; //continue yes or no
		
		do {
			
			System.out.print("\n ENTER ACCOUNT ID: \n");
			
			accountID = sc.nextInt();
			
			if (!isAccountValid(accountID)) {
				System.out.println("\n ERROR: INVALID ACCOUNT \n");
				answer = enterAnswer();
				
				enterAnswer();
				
				//continueyn = true;
				continueyn = false;
				
				if (answer == 'Y') continueyn = true; //<<< not needed
				else continueyn = false; // <<< originally these two, in case it doesn't work delete this code >>>>>> continueyn = true; <<<<< and uncomment these two lines
				
				accountID = -1;
			
			} else {
				
				continueyn = false;
			}
			

		} while(continueyn);
		
		
		return accountID;
		
	}
	
	private static boolean isAccountValid(int accountID) {
	
			if (accountID <= 1000 || accountID >= 5000) {
				return false;
			}
			
			return true;
	}

	private static char enterAnswer() {
		
		boolean answer = false;
		String response;
		
		do {
			
			System.out.println("\n Would you like to continue? \n" + "\n [YES] | [NO] \n");
			
			response = sc.nextLine();
			
			if (response.equalsIgnoreCase("yes") || response.equalsIgnoreCase("y")) {
				answer = false;
			} else if (response.equalsIgnoreCase("no") || response.equalsIgnoreCase("n")) {
				answer = false;
				exit();
			} else {
				answer = true;
			}
		
		} while (answer);
		
		return response.charAt(0);
	}


}