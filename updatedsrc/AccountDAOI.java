package BankApplication;

public interface AccountDAOI {

    void initAccountArray();
    void addAccount(Account account);
    Account showAccount(int index);
    void updateAccount(int index, Account account);
    void deleteAccount(int index);
    int findAccount(Account account);
    boolean isAccountsEmpty();
    boolean isAccountsFull();

}
