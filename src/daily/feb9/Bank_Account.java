/*
* Daniel Ye
* Feb 9, 2022
* Ms. Krasteva
* This is a class to be used with BankDriver. It holds information and various tools for one's bank account.
 */

package daily.feb9;

public class Bank_Account {
    public long acct_num; // account number
    private double balance; // balance in the account
    private String type; // type of account
    private float interest_rate; // interest rate

    // class constructor
    public Bank_Account(long acct, double bal, String ty, float interest){
        // initialize instance variables
        acct_num = acct;
        balance = bal;
        type = ty;
        interest_rate = interest;
    }

    // return the balance
    public double getBalance(){
        return balance;
    }

    // return the account type
    public String getType(){
        return type;
    }

    // deposit money in
    public void deposit(double amt){
        balance += amt;
    }

    // attempt to withdraw money, returning success or failure
    public boolean withdrawal(double amt){
        if(balance >= amt){
            balance -= amt;
            return true;
        } else return false;
    }

    // apply interest to the account
    public void applyInterest(){
        balance *= 1 + interest_rate;
    }
} // Bank_Account class
