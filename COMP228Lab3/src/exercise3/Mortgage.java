package exercise3;

public abstract class Mortgage implements MortgageConstants {
	private String mortgageNumber;
	private String mortgageType;
	private String customerName;
	private double mortgageAmount;
	private double interestRate;
	private int term;
	// this includes amount plus interest
	private double totalMortgageAmount;
	
	public Mortgage(String mortgageNumber, String customerName, String mortgageType)
	{
		this.mortgageNumber = mortgageNumber;
		this.customerName = customerName;
		this.mortgageType = mortgageType;
	}
	
	// retrieve mortgage number
	public String getMortgageNumber() {
		return mortgageNumber;
	}
	
	// set mortgage number
	public void setMortgageNumber(String mortgageNumber) {
		this.mortgageNumber = mortgageNumber;
	}

	// retrieve mortgage type
	public String getMortgageType() {
		return mortgageType;
	}

	// set mortgage type
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}
	
	// retrieve customer name
	public String getCustomerName() {
		return customerName;
	}
	
	// set customer name
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
		
	// retrieve mortgage amount
	public double getMortgageAmount() {
		return mortgageAmount;
	}
	
	// set mortgage amount
	public void setMortgageAmount(double mortgageAmount) {
		// don't allow mortgage that exceeds the maximum mortgage amount
		if (mortgageAmount > MAX_MORTGAGE_AMOUNT)
		{
			this.mortgageAmount = MAX_MORTGAGE_AMOUNT;
		}
		else
		{
			this.mortgageAmount = mortgageAmount;
		}
	}
	
	// retrieve interest rate
	public double getInterestRate() {
		return interestRate;
	}
	
	// set interest rate
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	// retrieve term
	public int getTerm() {
		return term;
	}
	
	// set term
	public void setTerm(int term) {
		// set term to SHORTTERM if argument term does not match any of the defined constants
		if (term != LONGTERM && term != MEDIUMTERM && term != SHORTTERM)
		{
			this.term = SHORTTERM;
		}
		else
		{
			this.term = term;
		}
	}
	
	// set total mortgage amount (plus the interest)
	public void setTotalMortgageAmount() {
		totalMortgageAmount = mortgageAmount + (mortgageAmount * interestRate);
	}

	// retrieve total mortgage amount
	public double getTotalMortgageAmount() {
		return totalMortgageAmount;
	}
	
	// return mortgage information
	public String getMortgageInfo()
	{
		String formattedInterestRate = String.format("%.2f", getInterestRate());
		String formattedMortgageAmount = String.format("%.2f", getMortgageAmount());
		String formattedTotalMortgageAmount = String.format("%.2f", getTotalMortgageAmount());
		
		return  "Mortrgage Number: " + getMortgageNumber() + "\n" +
				"Mortrgage type: " + getMortgageType() + "\n" +
				"Customer Name:  " + getCustomerName() + "\n" +
				"Loan Amount: $" + formattedMortgageAmount + "\n" +
				"Interest Rate:  " + formattedInterestRate + "\n" +
				"Term:  " + getTerm() + " year\n" +
				"Total Loan Amount:  $" + formattedTotalMortgageAmount;
	}
}
