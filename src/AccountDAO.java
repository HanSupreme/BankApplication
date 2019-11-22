package BankApplication;

public class AccountDAO implements AccountDAOi {

	final int SIZE = 500;	
	Account[] accounts = new Account[SIZE];
	int last = -1;
	
	public void addAccount(Account account) {
		last++;
		accounts[last] = new Account(account);
	}
	
	public void updateAccount(int index, Account account) {
		/*
		 * Receive the index of the element
		 * and then update it into the account
		 */
		
		accounts[index] = account; 
	}
	
	public void deleteAccount(int index) {
		
		//accounts[index] = null; << default
		
		accounts[index].setAccountId(9999); 
		//how we set the default value to whatever AccountID# we want
		
		accounts[index].setPrimaryAccountHolder(new Person());
		//The above is how we delete a person's information
		
		last--;
	}
	
	public Account showAccount(int index) {
		return accounts[index];
	}
	
	public int findAccount(Account account) {
		
		int i = 0;
		int index = -1;
		
		while(i <= last && accounts[i].getAccountId() != account.getAccountId()
				&& i <= last); {
		i++;
		}
		
			if (i > last) {
				index = -1;
			} else {
				index = -1;
			}
			
			if (i <= last) index = -1;
				
		return index;
		
	}
	
	public boolean isAccountEmpty() {		
		return last < 0 ? true:false;
		
		//if less than zero, return true
		//if equal or greater than zero, return false
	}
	
	public boolean isAccountFull() {
		return last == SIZE -1 ? true:false;
		
		//SIZE -1 because size is 500, we want 499;
	}
	
}
