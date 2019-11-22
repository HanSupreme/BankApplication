package BankApplication;

public interface AccountDAOi {
	
	/*
	 * Our Interface
	 * 
	 * Why do we need an interface?
	 * 
	 * 		- It allows us to write flexible code
	 * 			which can adapt to handle future requirements
	 */
	
	public void addAccount(Account account);
	
	public void updateAccount(int index, Account account);
	
	public void deleteAccount(int index);
	
	public Account showAccount(int index);
	
	public int findAccount(Account account);
	
	public boolean isAccountEmpty();
	
	public boolean isAccountFull();

}
