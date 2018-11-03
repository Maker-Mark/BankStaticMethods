
public class Transaction {
	private int accNum;
	private String type;
	private double amount;

	//Default constructor 
	public Transaction() {
		type = "one";
		amount = 0;
	}
	//Constructor given account number, type and amount
	public Transaction(int accountNum, String typeGiven, double amt) {
		accNum = accountNum;
		type = typeGiven;
		amount = amt;
	}
	
	public Transaction(Transaction t) {
		type = t.type;
		accNum = t.accNum;
		amount = t.amount;
	}
	
	//Constructor given account number and type only to allow
	// removal of amount with no amount 
	public Transaction(int accountNum, String typeGiven) {
		accNum = accountNum;
		type = typeGiven;
		amount = 0;	//Set amount flag for non-amount transaction
	}
	
	
	public String toString() {
		String accString;
		accString = String.format("%-17s $%17.2f" , type, amount );
		return accString;
	}

	//Gets transaction account number
	public int getTransAcc(){
		return accNum;
	}
	//Sets transaction type
	public void setTransType(String givenType) {
		type = givenType;
	}
	public String getTransType() {

		return type;
	}
	//Sets transaction amount
	public void setTransAmt(double transAmt) {
		amount = transAmt;
	}
	//Gets transaction amount
	public double getTransAmt() 
	{
		return amount;
	}



}
