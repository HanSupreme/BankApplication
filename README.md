# BankApplication

ADD
---------

1. Ask user to enter the account number they want to add
2. Verify that the account is not in the array
          - If it is, throw a message saying this account already exists
          - If account doesn't exist, add it into the array

3. Verify that the account number is valid (between 1000 and 5000)
User can enter more than one account number, one at a time - ask the user "do you want to enter another account number?"
If user says yes, you will ask for another account. If user says no, exit the adding accounts

Read
------

1. look for an account; called LookupAccounts (in CRUD; lookup)
2. Ask user to enter a valid account number and we will print to the user that the account exists or not (that will be the output)
3. Ask user if they want to check for other account number (yes/no)

Update
--------
1. Ask user for a valid account number
2. Verify if the account exists
3. If account exists, ask for the new account number
4. New account number should be valid and not duplicate
5. Ask user if they want to continue updating another account

Delete
--------

1. Ask user for a valid account number
2. Verify if the account exists
3. If yes, delete it from the array
4. Ask the user if they want to delete another account
 
The application will have a menu to give user the options
---------------------------------------------------------

1. Option 1 - Add
2. Option 2 - Lookup/read (showAccounts)
3. Option 3 - Update (updateAccounts)
4. Option 4 - Delete (remove/delete accounts)
5. Option 5 - Exit
 
What is the maximum amount of accounts we can handle?
------------------------------------------------------

1. 500
2. Keep array sorted in ascending order
3. When we insert a value to the array, add the new account to the end of the array (after the last one) and then we sort it
4. Whenever we change the array, we sort the array
5. If we delete/remove an account, we will replace that account number with 9999 and then we sort the array after
6. The array will be initialized (empty) with 9999
