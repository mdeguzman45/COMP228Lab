package exercise1;

public abstract class Insurance {
	private String insuranceType;
	private double monthlyCost;
	
	/* two argument constructor
	 * @param type - determines the type of insurance
	 * @param cost - determines the monthly cost
	 */
	public Insurance(String type, double cost)
	{
		insuranceType = type;
		monthlyCost = cost;
	}
	
	// method to retrieve insurance type
	public String getInsuranceType()
	{
		return insuranceType;
	}
	
	// method to set insurance type
	public void setInsuranceType(String type)
	{
		insuranceType = type;
	}
	
	// method to retrieve monthlyCost
	public double getMonthlyCost()
	{
		return monthlyCost;
	}
	
	// method to set monthly cost
	public void setMonthlyCost(double cost)
	{
		monthlyCost = cost;
	}
	
	// abstract method overridden by subclass to set insurance cost
	public abstract void setInsuranceCost();
	
	// abstract method overridden by subclass to display information
	public abstract void displayInfo();
}
