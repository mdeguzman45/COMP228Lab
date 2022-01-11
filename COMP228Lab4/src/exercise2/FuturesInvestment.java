package exercise2;

public class FuturesInvestment {
	private double investmentAmount;
    private double interestRate;
    private int numberOfYears;
    
    public FuturesInvestment(double amount, double rate, int years)
    {
    	investmentAmount = amount;
    	interestRate = rate;
    	numberOfYears = years;
    }
    
    public double getInvestmentAmount() 
    {
		return investmentAmount;
	}
    
	public void setInvestmentAmount(double investmentAmount) 
	{
		this.investmentAmount = investmentAmount;
	}
	
	public double getInterestRate() 
	{
		return interestRate;
	}
	
	public void setInterestRate(double interestRate) 
	{
		this.interestRate = interestRate;
	}
	
	public int getNumberOfYears() 
	{
		return numberOfYears;
	}
	
	public void setNumberOfYears(int numberOfYears) 
	{
		this.numberOfYears = numberOfYears;
	}
	
	public double calculateFutureValue()
	{
		double compoundRate = Math.pow((1 + interestRate/(100 * 12)), numberOfYears * 12);
        double futureInvestment = investmentAmount * compoundRate;
        
        return futureInvestment;
	}
}
