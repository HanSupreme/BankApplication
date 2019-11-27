package BankApplication;

public class AccountDAO {
    final int SIZE = 500;
    Account[] accounts = new Account[SIZE];
    int last = -1;

    protected void initAccountArray() {
        this.last = -1;

        for (int i = 0; i < this.SIZE; i++) {
            this.accounts[i] = new Account(9999);
            this.accounts[i] = new Account(9999, new Person());
        }
    }

    protected void addAccount(Account account) {
        last++;
        accounts[last] = new Account(account);
    }

    protected Account showAccount(int index) {
        return accounts[index];
    }

    protected void updateAccount(int index, Account account) {
        accounts[index].setAccountId(account.getAccountId());
        accounts[index].getPrimaryAccountHolder().setFirstName(account.getPrimaryAccountHolder().getFirstName());
        accounts[index].getPrimaryAccountHolder().setLastName(account.getPrimaryAccountHolder().getFirstName());
    }

    protected void deleteAccount(int index) {
        accounts[index].setAccountId(9999);
        accounts[index].getPrimaryAccountHolder().setFirstName("");
        accounts[index].getPrimaryAccountHolder().setLastName("");
        last--;
    }
    public int findAccount(Account account) { //linear search
        int i = 0;
        int index = -1;
        while(i<=last  && (accounts[i].getAccountId()!= account.getAccountId())) {
            i++;
        }
        if (i<=last) index = i;
        return index;
    }
    public boolean isAccountsEmpty() {
        return last < 0 ? true:false;
    }
    public boolean isAccountsFull() {
        return last == SIZE -1 ? true:false;
    }

}