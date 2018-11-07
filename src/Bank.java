/**
 * @author Mark Goldstein
 */

import java.util.ArrayList;

public class Bank {
	private static double totalAmountInSavingsAccts ;
	private static double totalAmountInCheckingAccts ;
	private static double totalAmountInCDAccts ;
	private static double totalAmountInAllAccts ;
	private  ArrayList <BankAccount> bankAccList ;

	//Default constructor for creating bank account
	public Bank()
	{
		totalAmountInSavingsAccts = 0;
		totalAmountInCheckingAccts = 0;
		totalAmountInCDAccts = 0;
		totalAmountInAllAccts = 0;
		bankAccList = new ArrayList<BankAccount>();
	}
	// Uses copy constructor to return a copy
	public BankAccount getAcct(int index)
	{			
		return new BankAccount (bankAccList.get(index)); 
		// Uses Copy Cons for the  BankAccount
	}

	//Gets account
	public  BankAccount getAcct(String social)
	{
		int index = findAcctSSN(social) ;
		System.out.println(index);
		System.out.println(bankAccList.size());
		// Uses Copy Cons new BankAccount
		return new BankAccount (bankAccList.get(index));
	}

	/*
	 *Opens new account when being sent an account number and 
	 *Bank Account object
	 */
	public boolean openNewAccount( int accNum, BankAccount bankAcc)
	{
		int index = findAcct(accNum);
		// Checks that account not in use
		if(index == -1) {
			bankAccList.add(bankAcc);
			return true;
		} else {
			return false;

		}
	}

	/*
	 * Method deleteAcct():
	 * Deletes account object from arraylist 
	 * Output: none
	 */
	public boolean deleteAcct(int index )
	{
		//Makes sure account is there
		if( index != 1 ){
			bankAccList.remove(index); 
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * Method findAcc():
	 * Input:requested account object
	 * Process: linear search requested account.
	 * Output: index of account requested
	 */
	public int findAcct( BankAccount  bankAccount)
	{
		for (int index = 0; index < bankAccList.size(); index++)
			if (bankAccList.get(index).getAccNum() 
					== bankAccount.getAccNum()) {
				
				return index;// returns index
			}
		return -1;
	}
	// Method for find account when given  account number 
	public int findAcct(int accNum)
	{
		for (int i = 0; i < bankAccList.size(); i++) {

			if (bankAccList.get(i).getAccNum() == accNum ) {
				System.out.println(bankAccList.get(i).getAccNum());
				return i;// returns index
			}
		}
		return - 1;
	}

	//Method to find account given SSN
	public int findAcctSSN(String social )
	{
		if(social.length() == 9) {
			for (int index = 0; index < bankAccList.size(); index++) {
				if (bankAccList.get(index).getAccDet().
						getSocSec().equals(social)) {
					return index;
				}
			}
			return -1;
			//flag for no account found	
		}
		else
		{
			//flag for invalid length
			return -2;
		}
	}


	//Uses ArrayList to set Account
	public void setAcct( int index, BankAccount acct)
	{
		// Set account at index of accounts arraylist to account
		bankAccList.set(index, acct);
	}

	//Gets number accounts
	public int getNumAcc() {
		return bankAccList.size();
	}

	//Allows the addition and subtraction of static totals 
	public static void setTotSav(double d) {
		totalAmountInSavingsAccts += d;
	}
	public static void setTotCh(double d) {
		totalAmountInCheckingAccts += d;
	}
	public static void  setTotCD(double d) {
		totalAmountInCDAccts += d;
	}

	public static void  setTotalAmt() {
		totalAmountInAllAccts = totalAmountInCDAccts 
			+ totalAmountInCheckingAccts + totalAmountInSavingsAccts;
	}

	public static double getTotalAmt() {
		return totalAmountInAllAccts; 
	}

	public static double getTotCD()
	{
		return totalAmountInCDAccts;
	}
	public static double getTotSav()
	{
		return totalAmountInSavingsAccts;
	}
	public static double getTotCh()
	{
		return totalAmountInCheckingAccts;
	}


}
