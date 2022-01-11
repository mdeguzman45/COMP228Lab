package exercise1;

import java.util.Scanner;

public class ProcessNumbers {

	public static void main(String[] args) {
		// create a Scanner to obtain input from the command window
		Scanner input = new Scanner(System.in);
		
		// variable to hold user inputs
		int integerNum1;
		int integerNum2;
		double doubleNum1;
		double doubleNum2;
		float floatNum1;
		float floatNum2;

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
		
		System.out.printf("1st integer number: %d; 2nd integer number: %d\n", integerNum1, integerNum1); // display inputs
		
		// process integer numbers
		processNum(integerNum1, integerNum2);
		System.out.println("------------------------------------------------------------------------");
		// end process integers
		
		// ask for double inputs
		System.out.println("Enter two double numbers  (1.02, 5.45, 25.41, 35.65).");
		System.out.println("Enter first double number [non-zero]:");
		do
		{
			// prompt user until we get a valid double
			while(!input.hasNextDouble())
			{
				System.out.println("[1st] That's not a double value!");
				System.out.println("[1st] Please Enter a valid double value [Not zero]: ");
				input.next(); // this is important!
			}
			doubleNum1 = input.nextDouble();
			if(doubleNum1 == 0)
			{
				System.out.println("[1st] Please enter a non zero double value: ");
			}

		} while (doubleNum1 <= 0);

		System.out.println("Enter second double number [non-zero]:");
		do
		{
			// prompt user until we get a valid double
			while(!input.hasNextDouble())
			{
				System.out.println("[2nd]That's not a double value!");
				System.out.print("[2nd] Please Enter a valid double value [Not zero]: ");
				input.next(); // this is important!
			}
			doubleNum2 = input.nextDouble();
			if(doubleNum2 == 0)
			{
				System.out.print("[2nd] Please enter a non zero double value: ");
			}
		} while(doubleNum2 <= 0);

		System.out.printf("1st double number: %.2f; 2nd double number: %.2f\n", doubleNum1, doubleNum2); // display inputs

		// process double numbers
		processNum(doubleNum1, doubleNum2);
		System.out.println("------------------------------------------------------------------------");
		// end process double numbers
		
		// ask for float inputs
		System.out.println("Enter two float numbers  (1.02421419, 5.45539181, 56.41456701, 105.65325104).");
		System.out.println("Enter first float number [non-zero]:");
		do
		{
			// prompt user until we get a valid float
			while(!input.hasNextFloat())
			{
				System.out.println("[1st] That's not a float value!");
				System.out.println("[1st] Please Enter a valid float value [Not zero]: ");
				input.next(); // this is important!
			}
			floatNum1 = input.nextFloat();
			if(floatNum1 == 0)
			{
				System.out.println("[1st] Please enter a non zero float value: ");
			}

		} while (floatNum1 <= 0);

		System.out.println("Enter second float number [non-zero]:");
		do
		{
			// prompt user until we get a valid float
			while(!input.hasNextFloat())
			{
				System.out.println("[2nd]That's not a float value!");
				System.out.print("[2nd] Please Enter a valid float value [Not zero]: ");
				input.next(); // this is important!
			}
			floatNum2 = input.nextFloat();
			if(floatNum2 == 0)
			{
				System.out.print("[2nd] Please enter a non zero float value: ");
			}
		} while(floatNum2 <= 0);

		System.out.printf("1st float number: %f; 2nd float number: %f\n", floatNum1, floatNum2); // display inputs

		// process float numbers
		processNum(floatNum1, floatNum2);
		System.out.println("------------------------------------------------------------------------");
		// end process float numbers
		
		input.close();
	}
	
	// process numbers that accepts integer values
	public static void processNum(int num1, int num2)
	{
		// process parameters by doing basic Math operations
		int sum = num1 + num2;
		int difference = num2 - num1;
		int product = num1 * num2;
		int quotient = num1 / num2;
		
		System.out.println("Result from processNum(int, int)");
		System.out.printf("Sum of {%d} and {%d}: %d%n", num1, num2, sum); // display sum
		System.out.printf("Difference of {%d} and {%d}: %d%n", num1, num2, difference); // display difference
		System.out.printf("Product of {%d} and {%d}: %d%n", num1, num2, product); // display product
		System.out.printf("Quotient of {%d} and {%d}: %d%n", num1, num2, quotient); // display quotient
	}
	
	// process numbers that accepts double values
	public static void processNum(double num1, double num2)
	{
		// process parameters by doing basic Math operations
		double sum = num1 + num2;
		double difference = num2 - num1;
		double product = num1 * num2;
		double quotient = num1 / num2;
		
		System.out.println("Result from processNum(double, double)");
		System.out.printf("Sum of {%.2f} and {%.2f}: %.2f%n", num1, num2, sum); // display sum
		System.out.printf("Difference of {%.2f} and {%.2f}: %.2f%n", num1, num2, difference); // display difference
		System.out.printf("Product of {%.2f} and {%.2f}: %.2f%n", num1, num2, product); // display product
		System.out.printf("Quotient of {%.2f} and {%.2f}: %.2f%n", num1, num2, quotient); // display quotient
	}
	
	// process numbers that accepts float values
	public static void processNum(float num1, float num2)
	{
		// process parameters by doing basic Math operations
		float sum = num1 + num2;
		float difference = num2 - num1;
		float product = num1 * num2;
		float quotient = num1 / num2;
		
		System.out.println("Result from processNum(float, float)");
		System.out.printf("Sum of {%f} and {%f}: %f%n", num1, num2, sum); // display sum
		System.out.printf("Difference of {%f} and {%f}: %f%n", num1, num2, difference); // display difference
		System.out.printf("Product of {%f} and {%f}: %f%n", num1, num2, product); // display product
		System.out.printf("Quotient of {%f} and {%f}: %f%n", num1, num2, quotient); // display quotient
	}
}
