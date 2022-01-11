package exercise1;

public class Singer 
{
	// instance variables
	private int id;
	private String name;
	private String address;
	private String birthDate;
	private int numberOfAlbumsPublished;
	
	// constructor that doesn't require parameters
	public Singer()
	{
		
	}
	
	// constructor that accepts id parameter
	public Singer(int id)
	{
		this.id = id;
	}
	
	// constructor that accepts id and name parameter
	public Singer(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	// constructor that accepts id, name and address parameter
	public Singer(int id, String name, String address)
	{
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	// constructor that accepts id, name, address and date of birth parameter
	public Singer(int id, String name, String address, String birthDate)
	{
		this.id = id;
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
	}
	
	// constructor that accepts id, name, address, date of birth and number of albums published parameter
	public Singer(int id, String name, String address, String birthDate, int numberOfAlbumsPublished)
	{
		this.id = id;
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
		this.numberOfAlbumsPublished = numberOfAlbumsPublished;
	}
	
	// method to retrieve id
	public int getId() 
	{
		return id;
	}
	
	// method to set id
	public void setId(int id) 
	{
		this.id = id;
	}
	
	// method to retrieve name
	public String getName() 
	{
		return name;
	}
	
	// method to set name
	public void setName(String name) 
	{
		this.name = name;
	}
	
	// method to retrieve address
	public String getAddress() 
	{
		return address;
	}
	
	// method to set address
	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	// method to retrieve date of birth
	public String getBirthDate() 
	{
		return birthDate;
	}
	
	// method to set date of birth
	public void setBirthDate(String birthDate) 
	{
		this.birthDate = birthDate;
	}
	
	// method to retrieve number of albums published
	public int getNumberOfAlbumsPublished() 
	{
		return numberOfAlbumsPublished;
	}
	
	// method to set number of albums published
	public void setNumberOfAlbumsPublished(int numberOfAlbumsPublished) 
	{
		this.numberOfAlbumsPublished = numberOfAlbumsPublished;
	}
	
	// setter method that will set all the instance variables
	public void setAllInstanceVariables(int id, String name, String address, String birthDate, int numberOfAlbumsPublished)
	{
		this.id = id;
		this.name = name;
		this.address = address;
		this.birthDate = birthDate;
		this.numberOfAlbumsPublished = numberOfAlbumsPublished;
	}
	
	// This is the overidden method toString(). Display all the values of the instance variables
	public String toString()
	{
		return " ID: " + id
				+ "\n Name: " + name
				+ "\n Address: " + address
				+ "\n Date of birth: " + birthDate
				+ "\n Number of albums published: " + numberOfAlbumsPublished + "\n";
	}
	
} // end Singer class
