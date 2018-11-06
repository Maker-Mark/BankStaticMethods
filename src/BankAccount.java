/**
 * @author Mark Goldstein
 */
import java.util.ArrayList;

public class BankAccount {
	//data members of BankAccount object
	private Depositor accDet ;
	private int accNum;
	private String accType;
	private String status  = "Open";
	private double accBal;
	private ArrayList<Transaction> trans ;

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
	
	//Constructor for bank account to be copy
	//Do i need this or just use the CopyConst
	public BankAccount(Depositor d , int n,  String t,String s,
			double b, ArrayList<Transaction> arl)
	{
		status = s;
		accDet = new Depositor(d);
		accType = t;
		accNum = n;
		accBal = b;
		trans = new ArrayList <Transaction>();
		for(int i =0; i < trans.size();i++) {
			trans.add(new Transaction(trans.get(i)));
	}
	}
	
//Gets a copy of bank account with new address 
	public BankAccount getAccCopy () {
		BankAccount bankCopy = new BankAccount(accDet, accNum,
				accType, status, accBal, trans);
		return bankCopy;
	}
	
	//Copy constructor 
	public BankAccount (BankAccount b) {

		status = b.status;
		accDet = new Depositor(b.getAccDet());
		accType = b.accType;
		accNum = b.accNum;
		accBal = b.accBal;
		trans = new ArrayList <Transaction>();
		for(int i =0; i < b.trans.size();i++) {
			trans.add(new Transaction(b.trans.get(i)));

		}
	}
	
	public String toString() {
		String accString;
		accString = String.format(accDet +" %-10d %-14s %-7.2f %8s" , accNum, accType,  accBal, status );
		return accString;

	}
	public void makeDeposit(int accNumber, int index, double amount) {
		accBal += amount; //Makes deposit 
		Transaction transaction = new Transaction( accNumber, "Deposit", amount);
		trans.add(transaction);//Adding trans with associated index
		Bank.calcTotalAmt(accBal);
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
	//Uses .equals to test if account object have same account number
	public int equals(BankAccount acc) {
		if (accNum == acc.getAccNum() && accDet.getSocSec().equals(acc.getAccDet().getSocSec())) {
			return accNum;

		} else {
			return -1;
		}

	}
	
	public boolean equals(BankAccount acc, boolean b) 
	{
		// if we want to compare accNum
		if (b = false) {
			return accNum == acc.getAccNum(); //retruns on if did accNum compare
		}
		//Compares Social
		return accDet.getSocSec().equals(acc.getAccDet().getSocSec());
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
