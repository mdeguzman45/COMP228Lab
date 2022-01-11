package exercise1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class InsuranceTest {
		
	public static void main(String[] args) {
		// flag to check if user don't want to add insurance anymore
		boolean userExit = false;
		
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		List<Insurance> listInsurance = new ArrayList<Insurance>();
				
		System.out.println("Start setup insurance:");
		// prompt for insurance type
		System.out.println("Select Insurace Type: Enter L or H");
		System.out.println("[L] Life Insurance ");
		System.out.println("[H] Health Insurance");
		do {
			double monthlyCost = 0;
			String insuranceType = input.nextLine(); // read user input of insurance type

			if (insuranceType.toUpperCase().trim().equals("L") || insuranceType.toUpperCase().trim().equals("H"))
			{
				System.out.println("Please enter monthly fee in this format [00.00]: ");
				do
				{
					// prompt user until we get a valid double
					while(!input.hasNextDouble())
					{
						System.out.println("Please enter a valid value [00.00]!");
						input.next(); // this is important!
					}
					
					monthlyCost = input.nextDouble();
					if(monthlyCost == 0)
					{
						System.out.println("Please enter a non zero value: ");
					}

				} while (monthlyCost <= 0);
				
				if(insuranceType.toUpperCase().trim().equals("L")) 
				{
					// create life insurance object
					LifeInsurance lifeInsurance = new LifeInsurance(monthlyCost);
					System.out.println("You have added the following insurance: ");
					lifeInsurance.displayInfo();
					
					// add To insurance list
					listInsurance.add(lifeInsurance);
				}
				else
				{
					// create health insurance object
					HealthInsurance healthInsurance = new HealthInsurance(monthlyCost);
					System.out.println("You have added the following insurance: ");
					healthInsurance.displayInfo();
					
					// add To insurance list
					listInsurance.add(healthInsurance);
				}
				
				// ask user if they want to add another insurance
				System.out.println("Do you want to add another insurance? [Y/N] ");
				String addAnother = input.next(); // read user confirmation
				if (!addAnother.toUpperCase().trim().equals("Y"))
				{
					System.out.println("Thanks for adding your insurance/s");
					userExit = true;
				}
			}
			else {
				System.out.println("Please enter a valid insurance type [L/H].");
			}
				
		} while (!userExit);
		
		System.out.println("End setup insurance");
		System.out.println("---------------------------------------------------\n");
		
		System.out.println("Show insurance monthly calculation");
		System.out.println("---------------------------------------------------");
		
		// send set insurance cost of each insurance
		for (Insurance insurance : listInsurance)
		{
			insurance.setInsuranceCost();
		}
		
		input.close();
	}
}
