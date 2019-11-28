package BankApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class AccountFile {

    static Scanner sc = new Scanner(System.in);

    protected static String enterFilePath() {

        String filePath = null;
        char answer = ' ';
        boolean boo = false;

        do {
            System.out.println("\n ENTER FILE LOCATION: \n");
            filePath = sc.nextLine();
            Path path = Paths.get(filePath);

            if (!Files.exists(path)) {
                System.out.println("\n ERROR: INVALID FILE LOCATION \n");
                answer = AccountsAPP.enterAnswer("\n DO YOU WANT TO CONTINUE? [Y] | [N] \n");
                boo = answer == 'Y' ? false:true;
                filePath = null;
            } else
                boo = false;
        } while(boo);
            return filePath;
    }

    protected static String enterFileName(String filePath) {
        String fileName = null;
        String pathName;
        char answer = ' ';
        boolean boo = false;

        do {
            System.out.println("\n ENTER CSV FILE NAME, INCLUDING THE EXTENSION: \n");
            fileName = sc.nextLine();
            pathName = filePath + "\\" + fileName;
            File f = new File(pathName);

            if (! f.exists()) {
                System.out.println("\n ERROR: INVALID FILE NAME AND/ OR LOCATION \n");
                answer = AccountsAPP.enterAnswer("\n CONTINUE? [Y] | [N] \n");
                boo = answer == 'Y' ? false:true;
                fileName = null;
            } else
                boo = false;

        } while(boo);

        return fileName;
    }

    protected static AccountDAO readFileAccount(String filePath, String fileName) {

        String fileLine = null;
        String[] data = null;
        AccountDAO accounts = new AccountDAO();
        Account account = null;

        accounts.initAccountArray();

        try {
            File f = new File(filePath + "\\" + fileName);
            Scanner fileReader = new Scanner(f);

            while (fileReader.hasNextLine() && !accounts.isAccountsFull()) {
                fileLine = fileReader.nextLine();
                data = fileLine.split(",");
                account = new Account(Integer.parseInt(data[10]),
                        new Person(data[1], data[2]));
                accounts.addAccount(account);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\n FILE NOT FOUND! \n");
        }

        return accounts;
    }

    protected static void writerFileAccount(String filePath, String fileName, AccountDAO accounts) {

        Account account;

        try {
        File f = new File(filePath + "\\" + fileName);
        FileWriter writer = new FileWriter(f, true);

        for (int i = 0; i < accounts.last; i++) {
            account = accounts.accounts[i];

            if (account.getAccountId() != 9999) {
                System.out.println(
                account.getAccountId() + "," +
                        account.getPrimaryAccountHolder().getFirstName() + "," +
                        account.getPrimaryAccountHolder().getLastName() + "," + "\n");
                }
            }
            writer.close();

        } catch (IOException i) {
            System.out.println("IOException");
        }
    }

}
