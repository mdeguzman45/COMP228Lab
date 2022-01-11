package exercise2;

import java.util.Scanner;

public class GameTesterTest {

	public static void main(String[] args) {
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		String testerType; // variable to handle tester type
		boolean validTesterType = false; // check if we got a valid tester type
		String fName;
		String lName;
		double partTimeHours;
		
		System.out.println("Start setup Game Tester Account:");
		// prompt for insurance type
		System.out.println("Select Game Tester Type: Enter F or P");
		System.out.println("[F] Full Time");
		System.out.println("[P] Part Time");
		
		do {
			testerType = input.nextLine(); // read user input of tester type

			if (testerType.toUpperCase().trim().equals("F") || testerType.toUpperCase().trim().equals("P"))
			{	
				// prompt first name
				System.out.println("Enter your first name: ");
				fName = input.nextLine();
				
				// prompt last name
				System.out.println("Enter your last name: ");
				lName = input.nextLine();
				
				if(testerType.toUpperCase().trim().equals("F")) 
				{
					// create full time game tester object
					FullTimeGameTester fullTimeTester = new FullTimeGameTester(fName, lName);
					System.out.println("Your Game Tester Profile");
					System.out.println(fullTimeTester);
				}
				else
				{			
					System.out.println("Please enter your part time hours: ");
					do
					{
						// prompt user until we get a valid double
						while(!input.hasNextDouble())
						{
							System.out.println("Please enter a valid number!");
							input.next(); // this is important!
						}
						
						partTimeHours = input.nextDouble();
						if(partTimeHours == 0)
						{
							System.out.println("Please enter a non zero value: ");
						}

					} while (partTimeHours <= 0);
					
					// create part time game tester object
					PartTimeGameTester partTimeTester = new PartTimeGameTester(fName, lName, partTimeHours);
					System.out.println("Your Game Tester Profile");
					System.out.println(partTimeTester);
				}
				
				// exit flag
				validTesterType = true;
			}
			else {
				System.out.println("Please enter a valid Game Tester type [F/P].");
			}
		} while (!validTesterType);
		
		System.out.println("End setup Game Tester Account");
		input.close();
	}

}
