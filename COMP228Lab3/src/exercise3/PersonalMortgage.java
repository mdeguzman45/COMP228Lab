package exercise3;

public class PersonalMortgage extends Mortgage {

	double personalInterestRate;
	
	public PersonalMortgage(String mortgageNumber, String customerName, double mortgageAmount, int term, double primeRate)
	{
		// pass data to super class
		super(mortgageNumber, customerName, "Personal");
		
		// set personal interest rate
		// personal interest rate are 2% over the prime rate
		personalInterestRate = primeRate + 0.02;
		setInterestRate(personalInterestRate);
		
		// set the term
		setTerm(term);
		
		// set the mortgage amount
		setMortgageAmount(mortgageAmount);
		
		// set the total mortgage amount 
		setTotalMortgageAmount();
	}	
}
