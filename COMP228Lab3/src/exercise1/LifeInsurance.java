package exercise1;

public class LifeInsurance extends Insurance {
	private double lifeMonthlyFee = 5.00;
	
	public LifeInsurance(double cost) {
		// pass to base class Insurance
		super("Life Insurance", cost);
	}

	// override abstract method set insurance cost
	public void setInsuranceCost()
	{
		// add monthly fee to monthly fee to monthly cost
		System.out.println("Life Insurance monthly fee: $" + lifeMonthlyFee);
		System.out.println("Monthly cost without fee: $" + getMonthlyCost());
		double totalMonthly = getMonthlyCost() + lifeMonthlyFee;
		System.out.println("Monthly cost with fee: $" + totalMonthly);
	}

	// override abstract method to display info
	public void displayInfo()
	{
		System.out.println(" Insurance Type: Life\n Monthly Cost: $" + getMonthlyCost() + " (without fee)");
	}

}
