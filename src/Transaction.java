
public class Transaction {
	private int accNum;
	private String type;
	private double amount;

	//Default constructor 
	public Transaction() {
		type = "one";
		amount = -1;
	}
	//Constructor given account number, type and amount
	public Transaction(int accountNum, String typeGiven, double amt) {
		accNum = accountNum;
		type = typeGiven;
		amount = amt;
	}
	//Constructor given account number and type only to allow
	// removal of amount with no amount 
	public Transaction(int accountNum, String typeGiven) {
		accNum = accountNum;
		type = typeGiven;
		amount = -1;	//Set amount flag for non-amount transaction
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
