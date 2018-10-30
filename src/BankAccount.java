/**
 * @author Mark Goldstein
 */
import java.util.ArrayList;

public class BankAccount {
	//data members of BankAccount object
	private Depositor accDet = new Depositor();
	private int accNum;
	private String accType;
	private String status  = "Open";
	private double accBal;
	private ArrayList<Transaction> trans = new ArrayList<>()  ;

	//Default constructor
	public BankAccount()
	{
		accDet = new Depositor();
		accNum = 0;
		accType = "none";
		accBal = 0.00;
		status  = "Open";
		Transaction transaction = new Transaction (accNum, "Default", accBal);
		trans.add(transaction);
	}

	//Constructor for initializing object with values
	public BankAccount(String first, String last, String social,int accountNum,
			String type, double bal)
	{
		accNum = accountNum;
		accType = type;
		accBal= bal;
		accDet = new Depositor(first, last, social);
		first = accDet.getNameOnAcc().getFirst();
		last = accDet.getNameOnAcc().getLast();
		social= accDet.getSocSec();
		status  = "Open";
		Transaction transaction = new Transaction (accountNum, "Open Account", bal);
		trans.add(transaction);
	}
	public void makeDeposit(int accNumber, int index, double amount) {
		accBal += amount; //Makes deposit 
		Transaction transaction = new Transaction( accNumber, "Deposit", amount);
		trans.add(transaction);//Adding trans with associated index

	}

	public boolean makeWithdrawal(int accNumber, double amt) {
		if( amt >= 0) {
			accBal -= amt; //Makes withdrawal 
			Transaction transaction = new Transaction(accNumber, "Withdrawal", amt);
			trans.add(transaction);
			return true;
		}else {
			return false; // message for less than
		}
	}


	//Gets arraylist of transactions attached to account
	public  ArrayList<Transaction>  getTransactions(BankAccount bankAcc, int accNum)
	{
		return trans ;
	}

	//Adds transaction given account object and type of transaction and account number

	public void addTransaction(BankAccount bankAcc, String type, double amount) {
		Transaction transaction = new Transaction (bankAcc.getAccNum(), type, amount);
		trans.add( transaction);

	}
	//Adds transaction given account object and type of transaction 
	public void addTransaction(BankAccount bankAcc, String type) {
		Transaction transaction = new Transaction (bankAcc.getAccNum(), type);
		trans.add( transaction);

	}

	//Method for setting data member accDet,
	//which is of Depositor-object type
	public  void setAccDet(String first, String last, String social)
	{
		accDet.setNameOnAcc(first, last);
		accDet.setSocSec(social);
	}

	//Changes account status 
	public void closeAcct() 
	{
		status  = "Closed";
	}
	//Changes account status 
	public  void reOpenAcct() 
	{
		status  = "Open";		
	}

	//Setters and getters for rest of data members
	public void setAccNum(int n)
	{
		accNum = n;
	}
	//Sets account type
	public void setAccType(String type)
	{
		accType = type;
	}
	//Sets account balance 
	public void setAccBal(double bal)
	{
		accBal = bal;
	}
	//Gets account balance
	public double getAccBal()
	{
		return accBal;
	}
	//Get account type
	public String getAccType()
	{
		return accType;
	}
	//Gets account num
	public int getAccNum()
	{
		return accNum;
	}
	//Gets account depositor
	public Depositor getAccDet()
	{
		return accDet;
	}
	//Gets number of transactions 
	public int getNumTrans() {
		return trans.size();
	}
	//Gets status 
	public String getStatus() {
		return status;
	}

}
