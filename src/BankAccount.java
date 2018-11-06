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
	private ArrayList<Transaction> trans  ;

	//Default constructor
	public BankAccount()
	{
		trans = new ArrayList <Transaction>();
		accDet = new Depositor();
		accNum = 0;
		accType = "none";
		accBal = 0.00;
		status  = "Open";
		Transaction transaction = new Transaction ("Default", accBal);
		trans.add(transaction);
	}

	//Constructor for initializing object with values
	public BankAccount(String first, String last, String social,int accountNum,
			String type, double bal)
	{
		trans = new ArrayList <Transaction>();
		accNum = accountNum;
		accType = type;
		accBal= bal;
		accDet = new Depositor(first, last, social);
		first = accDet.getNameOnAcc().getFirst();
		last = accDet.getNameOnAcc().getLast();
		social= accDet.getSocSec();
		status  = "Open";
		Transaction transaction = new Transaction ( "Open Account", bal);
		trans.add(transaction);
		//		Bank.calcTotalAmt(bal);

	}

	//Constructor for bank account to be copy
	//Do i need this or just use the CopyConst
//	public BankAccount(Depositor d , int n,  String t,String s,
//			double b, ArrayList<Transaction> arl)
//	{
//		status = s;
//		accDet = new Depositor(d);
//		accType = t;
//		accNum = n;
//		accBal = b;
//		trans = new ArrayList <Transaction>();
//		for(int i =0; i < trans.size();i++) {
//			trans.add(new Transaction(trans.get(i)));
//		}
//	}
//	//Gets a copy of bank account with new address 
//		public BankAccount getAccCopy () {
//			return new BankAccount(accDet, accNum, accType,
//					status, accBal, trans);
//		}

	public void clacAmountType() {
		if (accType.equalsIgnoreCase("CD")) {
			Bank.setTotCD(accBal);
		} else if (accType.equalsIgnoreCase("Savings")){
			Bank.setTotSav(accBal);
		} else if (accType.equalsIgnoreCase("Checkings")){
			Bank.setTotCh(accBal);	
		}
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
			trans.add(new Transaction (b.trans.get(i)));

		}
	}

	public String toString() {
		String accString;
		accString = String.format(accDet +" %-10d %-14s %-7.2f %8s" , accNum,
				accType,  accBal, status );
		return accString;

	}
	public void makeDeposit(int accNumber, int index, double amount) {
		accBal += amount; //Makes deposit 

		Transaction transaction = new Transaction(  "Deposit", amount);
		trans.add(transaction);//Adding trans with associated index
		clacAmountType();// Calculates the amount and type of account

	}

	public boolean makeWithdrawal(int accNumber, double amt) {
		if( amt >= 0) {
			accBal -= amt; //Makes withdrawal 
			Transaction transaction = new Transaction( "Withdrawal", amt);
			trans.add(transaction);
			clacAmountType();
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
	public  ArrayList<Transaction>  getTransactions()
	{
		return trans ;
	}
	

	//Adds transaction given account object and type of transaction and account number

	public void addTransaction(BankAccount bankAcc, String type, double amount) {
//		Transaction transaction = new Transaction (bankAcc.getAccNum(), type, amount);
		trans.add( new Transaction (type, amount));

	}
	//Adds transaction given account object and type of transaction 
	public void addTransaction(BankAccount bankAcc, String type) {
		Transaction transaction = new Transaction (bankAcc.getAccNum(), type);
		trans.add(transaction);

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
		return (accDet); //new Depositor 
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
