package exercise3;

public class BusinessMortgage extends Mortgage {

	double businessInterestRate;
	
	public BusinessMortgage(String mortgageNumber, String customerName, double mortgageAmount, int term, double primeRate)
	{
		// pass data to super class
		super(mortgageNumber, customerName, "Business");
		
		// set business interest rate
		// business interest rate are 1% over the prime rate
		businessInterestRate = primeRate + 0.01;
		setInterestRate(businessInterestRate);
		
		// set the term
		setTerm(term);
		
		// set the mortgage amount
		setMortgageAmount(mortgageAmount);
		
		// set the total mortgage amount 
		setTotalMortgageAmount();
	}	
}
