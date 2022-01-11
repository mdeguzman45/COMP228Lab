package exercise2;

public class FullTimeGameTester extends GameTester {

	public FullTimeGameTester(String fName, String lName) {
		// pass to base GameTester
		super(fName, lName, true);
	}
	
	// method implementation to return salary of full time game tester
	public double determineSalary() {
		// base salary of full time game tester is $3000
		return 3000.00;
	}

	// overridden method print game tester information
	public String toString()
	{
		return "Game Tester Type: Full Time\n"
				+ "First Name: " + getFirstName() + "\n"
				+ "Last Name: " + getLastName() + "\n"
				+ "Base Salary: $" + determineSalary();
	}
}
