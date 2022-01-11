package exercise2;

public class PartTimeGameTester extends GameTester {
	double hours;
	
	// part-time game testers get $20 per hour
	double payPerHour = 20.0;
	
	public PartTimeGameTester(String fName, String lName, double workedHours) {
		// pass to base GameTester
		super(fName, lName, false);
		hours = workedHours;
	}
	
	// method implementation to return salary of part time game tester
	public double determineSalary() {
		// compute hours worked * pay per hour
		return hours * payPerHour;
	}
	
	// overridden method print game tester information
	public String toString()
	{
		return "Game Tester Type: Part Time\n"
				+ "First Name: " + getFirstName() + "\n"
				+ "Last Name: " + getLastName() + "\n"
				+ "Base Salary: $" + determineSalary();
	}
}
