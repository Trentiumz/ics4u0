/*
 * Daniel Ye
 * Feb 9, 2022
 * Ms. Krasteva
 * This is a Driver class to display the usage of the Bank_Account.java class and its objects
 */

package daily.feb9;

public class BankDriver {
    public static void main(String[] args){
        // initialize two Bank_Account objects
        Bank_Account fred = new Bank_Account(1349290, 50.0, "checking", 0.1f);
        Bank_Account bob = new Bank_Account(1349291, 200, "savings", 0.3f);

        // inform the user of the accounts of the two characters' accounts
        System.out.println("Bob's " + bob.getType() + " account: $" + bob.getBalance());
        System.out.println("Fred's " + fred.getType() + " account: $" + fred.getBalance());

        // deposit funds
        System.out.println("Depositing reward to Bob and Fred...");
        bob.deposit(100.0);
        fred.deposit(50.0);

        // apply interest to both accounts
        System.out.println("Queued Transactions completed. New Quarter has begun. Applying interest...");
        bob.applyInterest();
        fred.applyInterest();

        // attempt to withdraw money from both accounts, informing the user of success and failure
        if(bob.withdrawal(200)) System.out.println("Bob, your withdrawal has been approved");
        else System.out.println("Bob, we were unable to extract the requested amount. Please check your balance.");
        if(fred.withdrawal(1000)) System.out.println("Fred, your withdrawal has been approved");
        else System.out.println("Fred, we were unable to extract the requested amount. Please check your balance.");

        // print out the resulting balance of both accounts
        System.out.println("Bob, your " + bob.getType() + " account has $" + bob.getBalance());
        System.out.println("Fred, your " + fred.getType() + " account has $" + fred.getBalance());
    }
} // BankDriver class
