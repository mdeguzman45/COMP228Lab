package exercise2;

public abstract class GameTester {
	private String firstName;
	private String lastName;
	private boolean isFullTime;
	
	/* two argument constructor
	 * @param fname - first name of the game tester
	 * @param lname - last name of the game tester
	 * @param isFullTimeTester - flag for full time game tester check
	 */
	public GameTester(String fName, String lName, boolean isFullTimeTester)
	{
		firstName = fName;
		lastName = lName;
		isFullTime = isFullTimeTester;
	}
	
	// method to retrieve first name
	public String getFirstName()
	{
		return firstName;
	}

	// method to set first name
	public void setFirstName(String fName)
	{
		firstName = fName;
	}
	
	// method to retrieve last name
	public String getLastName()
	{
		return lastName;
	}

	// method to set last name
	public void setLastName(String lName)
	{
		lastName = lName;
	}
	
	// method to retrieve last name
	public boolean getIsFullTime()
	{
		return isFullTime;
	}

	// method to set last name
	public void setIsFullTime(boolean isFullTimeTester)
	{
		isFullTime = isFullTimeTester;
	}
	
	// return first and last name of tester
	public String getFullName()
	{
		return firstName + " " + lastName;
	}
	
	// abstract method overridden by subclass to determine salary
	public abstract double determineSalary();
}
