package exercise1;

public class SingerTest {

	public static void main(String[] args) {
		// create a Singer object
		Singer singer1 = new Singer();
		
		// output default information using toString function
		System.out.println("Default Singer1 information");
	    System.out.print(singer1);
	    
	    // set singer instance variables
		singer1.setId(1);
		singer1.setName("Elvis Presley");
		singer1.setAddress("Tupelo, Mississippi, United States");
		singer1.setBirthDate("January 8, 1935");
		singer1.setNumberOfAlbumsPublished(57);
		
		// output updated singer1 information using getter methods
		System.out.println("\nUpdated Singer1 Information:");
		System.out.printf(" ID: %d%n", singer1.getId());
		System.out.printf(" Name: %s%n", singer1.getName());
		System.out.printf(" Address: %s%n", singer1.getAddress());
		System.out.printf(" Date of birth: %s%n", singer1.getBirthDate());
		System.out.printf(" Number of albums published: %d%n", singer1.getNumberOfAlbumsPublished());
		
		// Additional sample singer2 using the 5 argument constructor
		Singer singer2 = new Singer(2, "Michael Jackson", "Gary, Indiana, United States", "August 29, 1958", 49);
		// output Singer2 information using getters
		System.out.println("\nSinger2 Information:");
		System.out.printf(" ID: %d%n", singer2.getId());
		System.out.printf(" Name: %s%n", singer2.getName());
		System.out.printf(" Address: %s%n", singer2.getAddress());
		System.out.printf(" Date of birth: %s%n", singer2.getBirthDate());
		System.out.printf(" Number of albums published: %d%n", singer2.getNumberOfAlbumsPublished());
	}

}
