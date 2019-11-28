package BankApplication;

import java.util.Scanner;

/**
 * A package to keep code organized
 *
 * We will call other classes and methods from within this package.
 */

public class Main {

    protected static int enterChoice(Scanner sc) {

        int choice = 0;

        do {

            System.out.print("\n [ ENTER OPTION: ] ");
            choice = sc.nextInt();

            if (choice < 1 || choice > 7)
                System.out.print("\n INVALID ENTRY. TRY AGAIN. \n");
        } while (choice < 1 || choice > 7);
            return choice;
    }

    protected static void printMainMenu() {

        System.out.println("\n                [ MAIN MENU ] \n" +
                " ______________________________________________" +
                "\n | 1) ADD ACCOUNT     |   2) SHOW ACCOUNT     |\n" +
                "\n | 3) UPDATE ACCOUNT  |   4) DELETE ACCOUNT   |\n" +
                "\n | 5) IMPORT ACCOUNT  |   4) EXPORT ACCOUNT   |\n" +
                "\n | 7) EXIT            |                       |\n" +
                " ______________________________________________");

    }
}