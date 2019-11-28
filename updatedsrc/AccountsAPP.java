package BankApplication;

import java.util.Scanner;

public class AccountsAPP {

    static AccountDAO accounts = new AccountDAO();
    static Account newAccount = new Account(0, new Person());
    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        accounts.initAccountArray();

        mainMenu();


        sc.close();
    }

    protected static void mainMenu() {
        Main printMethods = new Main();
        int userSelection;

        System.out.println("\n              | W E L C O M E | " +
                "\n           _______________________");

        do {
            printMethods.printMainMenu();
            userSelection = printMethods.enterChoice(sc);
            executeOperation(userSelection);

        } while (userSelection != -7);

    }

    protected static void executeOperation(int choice) {

        switch (choice) {
            case 1:
                addAccount();
                break;
            case 2:
                showAccount();
                break;
            case 3:
                updateAccount();
                break;
            case 4:
                deleteAccount();
                break;
            case 5:
                importAccount();
                break;
            case 6:
                exportAccount();
                break;
            default:
                System.out.println("\n GOOD-BYE \n");
                System.exit(0);
        }

    }

    protected static void addAccount() {
        int accountId = 0;

        if(!accounts.isAccountsFull()) {
            accountId = enterAccount("\n ENTER NEW ACCOUNT ID#: \n");
            if (accountId != -1) {
                newAccount.setAccountId(accountId);
                if (accounts.findAccount(newAccount) != -1) {
                    System.out.println("\n ERROR: DUPLICATE ACCOUNT ID# \n");
                } else {
                    enterNames(newAccount.getPrimaryAccountHolder());

                    accounts.addAccount(newAccount);

                    printAllAccountsIds();
                }
            }

        }
    }

    protected static void showAccount() {
        int accountId = 0;
        char answer = ' ';

        if (!accounts.isAccountsEmpty()) {

            do {
                accountId = enterAccount("\n ENTER ACCOUNT ID# TO UPDATE: ");
                if (accountId != -1) {
                    if (accounts.existAccountId(accountId)); {
                        System.out.println("\n RECORD NOT FOUND: ");
                    }
                    System.out.print("\n CONTINUE? [Y] | [N] ");
                }

            } while (answer == 'Y');

        }

    }

    protected static void updateAccount() {
        int accountId = 0;
        int newAccountId = 0;
        char answer = ' ';
        int position = 0;

        if (! accounts.isAccountsEmpty()) {

            do {
                System.out.print("\n UPDATE ACCOUNT(S): ");
                accountId = enterAccount("\n ENTER ACCOUNT ID# TO UPDATE: ");

                if (accountId != -1) {
                    newAccount.setAccountId(accountId);
                    position = accounts.findAccount(newAccount);

                    if (position != -1) {
                        newAccountId = enterAccount("\n ENTER NEW ACCOUNT ID# ");
                        if (newAccountId != -1) {

                            printAccount(accounts.showAccount(position));
                            newAccount.setAccountId(newAccountId);
                            enterNames(newAccount.getPrimaryAccountHolder());
                            accounts.updateAccount(position, newAccount);
                        }
                    } else {
                        System.out.println("\n RECORD NOT FOUND \n");
                    }

                }

                answer = enterAnswer("\n DO YOU WANT TO CONTINUE? [Y] | [N] ");

            } while (answer == 'Y');
        }

    }

    protected static void deleteAccount() {
        int accountId = 0;
        char answer = ' ';
        int position = 0;

        if (! accounts.isAccountsEmpty()) {
            System.out.print("\n DELETE ACCOUNT ");
            accountId = enterAccount("\n ENTER ACCOUNT ID# TO DELETE ");
            if (accountId != -1) {

                newAccount.setAccountId(accountId);
                position = accounts.findAccount(newAccount);

                if (position != 1) {
                    accounts.deleteAccount(position);
                    System.out.print("\n RECORD DELETED ");
                } else {
                    System.out.print("\n RECORD NOT FOUND ");
                }
            }
            answer = enterAnswer("\n DO YOU WANT TO DELETE ANOTHER ACCOUNT ID#? ");
        } while (answer == 'Y');

    }

    protected static void importAccount() {
        String filePath = AccountFile.enterFilePath();

        if (filePath != null) {
            System.out.println("\n VALID FILE PATH. FILE PATH INFO: " + filePath + "\n");

        }

    }

    protected static void exportAccount() {
        String path = AccountFile.enterFilePath();
        String fileName;

        if(path != null) {
            System.out.println("\n VALID FILE PATH. \n" + path);
            fileName = AccountFile.enterFileName(path);
            AccountFile.writerFileAccount(path, fileName, accounts);
        }
    }

    protected static void printAllAccountsIds() {

        for (int i = 1; i < accounts.last; i++) {
            System.out.println(i + " = " +
                    accounts.accounts[i].getAccountId());

            System.out.println(accounts.accounts[i].getPrimaryAccountHolder().getFirstName()
            + accounts.accounts[i].getPrimaryAccountHolder().getLastName());
        }

    }

    protected static int enterAccount(String msg) {

        int accountId = -1;
        char answer = ' ';
        boolean boo = false;

        do {
            System.out.print(msg);
            accountId = sc.nextInt();

            if (!isAccountIdValid(accountId)) {
                System.out.println("\n ERROR: INVALID ACCOUNT ID# ");
                answer = enterAnswer("\n DO YOU WANT TO CONTINUE? [Y] | [N] ");
                if (answer == 'y')  boo = true;
                else boo = false;
                accountId = -1;
            } else
                boo = false;
        } while(boo);

        return accountId;
    }

    protected static char enterAnswer(String msg) {
        String response = " ";

        do {
            System.out.print(msg);
            response = sc.next();
        } while ( ! (response.toUpperCase().equalsIgnoreCase("Y") ||
                response.toUpperCase().equalsIgnoreCase("N")));

        return response.toUpperCase().charAt(0);
    }

    protected static Person enterNames(Person person) {

        System.out.print("\n ENTER FIRST NAME: ");
        person.setFirstName(sc.next());

        System.out.print("\n ENTER LAST NAME: ");
        person.setLastName(sc.next());

        return person;
    }

    protected static boolean isAccountIdValid(int accountId) {

        if (accountId >= 1000 && accountId <= 5000)
            return true;

        return false;
    }

    protected static void printAccount(Account currentAccount) {
        System.out.println(currentAccount.getAccountId());
        System.out.println(currentAccount.getPrimaryAccountHolder().getFirstName());
        System.out.println(currentAccount.getPrimaryAccountHolder().getLastName());

    }


}
