/**
 * @author Mark Goldstein
 */

import java.util.ArrayList;

public class Bank {
	private static double totalAmountInSavingsAccts ;
	private static double totalAmountInCheckingAccts ;
	private static double totalAmountInCDAccts ;
	private static double totalAmountInAllAccts ;
	
	
public static void calcTotalAmt(double a) {
	totalAmountInAllAccts = a +  totalAmountInCDAccts 
			+ totalAmountInCheckingAccts +totalAmountInSavingsAccts; 
	
}
public static double  getTotalAmt() {
return totalAmountInAllAccts;
}
	
	private  ArrayList <BankAccount> bankAccList ;

	//Default constructor for creating bank account
	public Bank()
	{
		bankAccList = new ArrayList<BankAccount>();
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
			if (bankAccList.get(index).getAccNum() == bankAccount.getAccNum()) {
				System.out.print("from FIND");
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

	public BankAccount getAcct(int index)
	{			
		return bankAccList.get(index);
	}
	//Gets account
	public  BankAccount getAcct(String social)
	{
		int index = findAcctSSN(social) ;
		System.out.println(index);
		System.out.println(bankAccList.size());
		return bankAccList.get(index);
	}


	public void setAcct( int index, BankAccount acct)
	{

		// Set account at index of accounts arraylist to account
		bankAccList.set(index, acct);
	}

	//Gets number accounts
	public int getNumAcc() {
		return bankAccList.size();
	}

}
