/**
 * @author Mark Goldstein
 */
public class Depositor {
	//data members of Depositor object
	private Name nameOnAcc; 
	private String socSec;

	//Default constructor for Depositor
	public Depositor()
	{
		nameOnAcc = new Name();
		socSec = "none";
	}

	//Constructor for Depositor object with attributes being passes
	public Depositor(String first, String last,String soc){
		nameOnAcc = new Name(first, last);
		socSec = soc;
	}
	
	
	//copy Constructor
	public Depositor (Depositor d) {
		socSec = d.socSec;
		nameOnAcc = new Name (d.nameOnAcc);
	}
	
	public Depositor getCopyDep() {
		Depositor depCopy = new Depositor(nameOnAcc.getFirst(),nameOnAcc.getLast(), socSec);
		return depCopy;
	}
	
	public String toString() {
		String accString;
		accString = String.format(nameOnAcc + " %-16s" , socSec );
		return accString;
	}


	//Social security setter
	public void setSocSec(String s) 
	{
		socSec = s;
	}
	/*Setter for name on account via data member 
	 *Object Name's instantiated "nameOnAcc"
	 *To set the name.
	 */
	public void setNameOnAcc(String first, String last) 
	{
		nameOnAcc.setFirst(first);
		nameOnAcc.setLast(last);
	}
	//Object getters
	public String getSocSec() 
	{
		return socSec;
	}
	public Name getNameOnAcc()
	{
		return nameOnAcc;
	}
	
	public boolean equals (Depositor dep) {
		return socSec.equals(dep.socSec);
}
	
	
}
