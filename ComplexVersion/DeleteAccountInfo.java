import java.util.Arrays;

public class DeleteAccountInfo {
	
	static Functions functions = new Functions();
	static AccountInfo accountInfo = new AccountInfo();
	
	public void deleteAccounts() {
		// TODO Auto-generated method stub
		
		/*
		 * 1. Verify array is not empty
		 * 2. Ask for accountID to remove
		 * 3. Search (accountID)
		 * 4. IF exist, then;
		 * 		4.1 update the record with "9999"
		 */
		
		char checkIfEmpty;
		int requestNewAccountInfo = 9999;
		int position;
		
		do {
			System.out.println("\n UPDATING ACCOUNT...\n");
			int accountID = accountInfo.enterAccount();
			
			if (accountID != -1) { //will check if valid/ exist
				
				if (functions.existAccountID(accountID)) { //if exist, then will replace accountID with 9999
					Arrays.sort(functions.idArray);
					position = Arrays.binarySearch(functions.idArray, accountID);
					functions.idArray[position] = requestNewAccountInfo;
					
					functions.lastIndex--;
					
					System.out.println("\n RECORD DELETED \n");
					System.out.println(Arrays.toString(functions.idArray));
					
				} else {
					System.out.println("\n Does not Exist \n");
				}
			}
			
			checkIfEmpty = functions.enterAnswer();
			
		} while (checkIfEmpty == 'Y' || checkIfEmpty == 'y');
		
	}
		
	}
