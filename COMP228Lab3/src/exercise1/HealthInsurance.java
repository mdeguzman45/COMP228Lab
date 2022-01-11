package exercise1;

public class HealthInsurance extends Insurance {
	double healthMonthlyFee = 6.00;
	
	public HealthInsurance(double cost) {
		// pass to base class Insurance
		super("Health Insurance", cost);
	}

	// override abstract method set insurance cost
	public void setInsuranceCost()
	{
		// add monthly fee to monthly fee to monthly cost
		System.out.println("Life Insurance monthly fee: $" + healthMonthlyFee);
		System.out.println("Monthly cost without fee: $" + getMonthlyCost());
		double totalMonthly = getMonthlyCost() + healthMonthlyFee;
		System.out.println("Monthly cost with fee: $" + totalMonthly);
	}

	// override abstract method to display info
	public void displayInfo()
	{
		System.out.println(" Insurance Type: Health\n Monthly Cost: $" + getMonthlyCost());
	}

}
