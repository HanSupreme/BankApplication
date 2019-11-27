package BankApplication;

public class Account {

    protected int accountId;
    protected Person primaryAccountHolder; //has-a relationship

    protected Account (int accountId) {
        this.accountId = accountId;
        this.primaryAccountHolder = new Person();
    }

    protected Account(int accountId, Person accountHolder) {
        this.accountId = accountId;
        this.primaryAccountHolder = new Person(accountHolder);
    }

    protected void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    protected int getAccountId() {
        return accountId;
    }

    protected void setPrimaryAccountHolder(Person primaryAccountHolder) {
        this.primaryAccountHolder = primaryAccountHolder;
    }

    protected Person getPrimaryAccountHolder() {
        return primaryAccountHolder;
    }

    protected Account(Account account) {
        this.accountId = account.getAccountId();
        this.primaryAccountHolder = new Person(account.getPrimaryAccountHolder());
    }

}
