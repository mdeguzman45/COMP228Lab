package exercise3;

import java.util.Scanner;

public class ProcessMortgage {

	public static void main(String[] args) {
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		// hold mortgages
		Mortgage[] mortgageList = new Mortgage[3]; 
		
		// hold current interest rate
		double inputPrimeRate;
		double primeRate;
		String mortgageType;
		
		// check if we got a valid mortgage type
		boolean validmortgageType; 
		// customer name
		// for personal mortgage customer name is first name + last name
		String customerName;
		String firstName;
		String lastName;
		// mortgage identifier
		String mortgageNumber;
		// mortgage term
		int term;
		// mortgage amount
		double mortgageAmount;
		
		System.out.println("Enter current rate [1-100]:");
		// lets get the current prime rate before setting up the mortgages
		do
		{
			// prompt user until we get a valid double
			while(!input.hasNextDouble())
			{
				System.out.println("Please enter a valid number!");
				input.next(); // this is important!
			}
			
			inputPrimeRate = input.nextDouble();
			if(inputPrimeRate == 0)
			{
				System.out.println("Please enter a non zero value: ");
			}
			
			if(inputPrimeRate == 100)
			{
				System.out.println("Please enter a value not greater than or equal to 100: ");
			}

		} while (inputPrimeRate <= 0 || inputPrimeRate >= 100);
		
		// this is important for next inputs
		input.nextLine();
		
		// convert to percentage which we will pass on the mortgage creation
		primeRate = inputPrimeRate/100;
		System.out.println("Prime rate: " + primeRate);
		
		System.out.println("mortgage length: " + mortgageList.length);
		
		System.out.println("Setup mortgages:");
		for (int x = 0; x < mortgageList.length; x++)
		{
			validmortgageType = false;
			System.out.println("Setup mortgage " + (x + 1));
			System.out.println("--------------------------------------------------");
			
			// prompt for mortgage type
			System.out.println("Enter mortgage type: Enter B or P");
			System.out.println("[B] Business Mortgage");
			System.out.println("[P] Personal Mortgage");
			
			do {
				mortgageType = input.nextLine(); // read user input of mortgage type

				if (mortgageType.toUpperCase().trim().equals("B") || mortgageType.toUpperCase().trim().equals("P"))
				{	
					// prompt for mortgage number
					System.out.println("Enter mortgage number: ");
					mortgageNumber = input.nextLine();
					
					// prompt for mortgage amount
					System.out.println("Enter mortgage amount (maximum allowed mortgage is $300000): ");

					// prompt user until we get a valid double
					while(!input.hasNextDouble())
					{
						System.out.println("Please enter a valid number!");
						input.next(); // this is important!
					}

					mortgageAmount = input.nextDouble();
					
					// this is required for next inputs
					input.nextLine();
					
					// prompt mortgage term
					System.out.println("Enter mortgage term (1/3/5). If invalid term, default will be short term: ");
					System.out.println("[1] Short-Term");
					System.out.println("[3] Medium-Term");
					System.out.println("[5] Long-Term");

					// prompt user until we get a valid integer
					while(!input.hasNextInt())
					{
						System.out.println("Invalid value. Allowed values (1/3/5)");
						input.next(); // this is important!
					}
					term = input.nextInt();
					
					// this is required for next inputs
					input.nextLine();

					// set business name
					if(mortgageType.toUpperCase().trim().equals("B")) 
					{
						// prompt business name
						System.out.println("Enter business name: ");
						customerName = input.nextLine();
						// create the business mortgage object
						BusinessMortgage businessMortgage = new BusinessMortgage(mortgageNumber, customerName, mortgageAmount, term, primeRate);
						mortgageList[x] = businessMortgage;
					}
					else
					{
						// prompt first name
						System.out.println("Enter your first name: ");
						firstName = input.nextLine();
						
						// prompt last name
						System.out.println("Enter your last name: ");
						lastName = input.nextLine();
						
						customerName = firstName + " " + lastName;
						
						// create the personal mortgage object
						PersonalMortgage personalMortgage = new PersonalMortgage(mortgageNumber, customerName, mortgageAmount, term, primeRate);
						mortgageList[x] = personalMortgage;
					}
					
					// exit flag
					validmortgageType = true;
				}
				else {
					System.out.println("Please enter a valid mortgage type [B/P].");
				}
			} while (!validmortgageType);
		}
		System.out.println("End of mortgage setup:");
		
		System.out.println("Mortgage information:\n");
		System.out.println("--------------------------------------------------");
		// print mortgages
		for (Mortgage mortgage : mortgageList)
		{
			System.out.println(mortgage.getMortgageInfo());
			System.out.println("--------------------------------------------------");
		}
		
		input.close();
	}

}

