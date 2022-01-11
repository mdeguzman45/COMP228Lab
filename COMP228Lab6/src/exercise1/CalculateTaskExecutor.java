package exercise1;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalculateTaskExecutor {

	public static void main(String[] args) {
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);

		// variable to hold user inputs
		int integerNum1;
		int integerNum2;
		// create ExecutorService to manage threads
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		// Ask for Integers inputs
		System.out.println("Enter two integer numbers  (1, 5, 25, 356).");
		System.out.println("Enter first integer number [non-zero]:");
		do
		{
			// prompt user until we get a valid integer
			while(!input.hasNextInt())
			{
				System.out.println("[1st] That's not an integer!");
				System.out.println("[1st] Please Enter a valid integer [Not zero]: ");
				input.next(); // this is important!
			}
			integerNum1 = input.nextInt();
			if(integerNum1 == 0)
			{
				System.out.println("[1st] Please enter a non zero integer: ");
			}

		} while (integerNum1 <= 0);

		System.out.println("Enter second integer number [Not zero]: ");
		do
		{
			// prompt user until we get a valid integer
			while(!input.hasNextInt())
			{
				System.out.println("[2nd] That's not an integer!");
				System.out.println("[2nd] Please Enter a valid integer [Not zero]: ");
				input.next(); // this is important!
			}
			integerNum2 = input.nextInt();
			if(integerNum2 == 0)
			{
				System.out.println("[2nd] Please enter a non zero integer: ");
			}
		} while(integerNum2 <= 0);

		System.out.printf("1st integer number: %d; 2nd integer number: %d\n", integerNum1, integerNum2); // display inputs
		input.close();
		
		// create task
		CalculateTask addTask = new CalculateTask(integerNum1, integerNum2, Operations.ADDITION);
		CalculateTask subtractTask = new CalculateTask(integerNum1, integerNum2, Operations.SUBTRACTION);
		CalculateTask multiplyTask = new CalculateTask(integerNum1, integerNum2, Operations.MULTIPLICATION);
		CalculateTask divideTask = new CalculateTask(integerNum1, integerNum2, Operations.DIVISION);
		
		// start the calculate tasks
		executorService.submit(addTask); // start addTask	
		executorService.submit(subtractTask); // start subtractTask
		executorService.submit(multiplyTask); // start multiplyTask
		executorService.submit(divideTask); // start divideTask
		
		executorService.shutdown();
	}
}
