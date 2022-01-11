package exercise2;

public class ProcessArrays {
	
	public static void main(String[] args) {
		double[] doubleValues = {24.56, 12.52, 33.12, 99.43};
		int[] intValues = { 5, 53, 26, 72, 96};
		String[] stringValues = {"Master", "Student", "Lessons", "Roadblocks", "Opportunities"};
		char charValue = 'a';

		// output original integer array elements 
		System.out.printf("%nThe values of the integer array before calling arrayTest(int[]):%n");
		displayIntegerArray(intValues);
		
		// modify integer array elements
		arrayTest(intValues);
		
		// output modified integer array elements 
		System.out.printf("%nThe values of the integer array after calling arrayTest(int[]):%n");
		displayIntegerArray(intValues);
		System.out.printf("%n---------------------------------------------------------------");
		
		// output original integer array elements 
		System.out.printf("%nThe values of the integer array before calling arrayTest(int[], double[]):%n");
		displayIntegerArray(intValues);
		
		// output original double array elements 
		System.out.printf("%nThe values of the double array before calling arrayTest(int[], double[]):%n");
		displayDoubleArray(doubleValues);

		// modify integer array elements and double array elements
		arrayTest(intValues, doubleValues);

		// output modified integer array elements 
		System.out.printf("%nThe values of the integer array after calling arrayTest(int[], double[]):%n");
		displayIntegerArray(intValues);
		
		// output modified double array elements 
		System.out.printf("%nThe values of the double array after calling arrayTest(int[], double[]):%n");
		displayDoubleArray(doubleValues);
		System.out.printf("%n---------------------------------------------------------------");
		
		// output original char value
		System.out.printf("%nThe value of char before calling arrayTest(char, String[], double[]):%n");
		System.out.printf("    %c", charValue);
		
		// output original string array elements 
		System.out.printf("%nThe values of the string array before calling arrayTest(char, String[], double[]):%n");
		displayStringArray(stringValues);
		
		// output original double array elements 
		System.out.printf("%nThe values of the double array before calling arrayTest(char, String[], double[]):%n");
		displayDoubleArray(doubleValues);
		
		// modify string array elements and double array elements
		arrayTest(charValue, stringValues, doubleValues);
		
		// output modified char value
		System.out.printf("%nThe value of char after calling arrayTest(char, String[], double[]):%n");
		// char value would still have the same value since its not a reference type
		System.out.printf("    %c", charValue);

		// output modified string array elements 
		System.out.printf("%nThe values of the string array after calling arrayTest(char, String[], double[]):%n");
		displayStringArray(stringValues);

		// output modified double array elements 
		System.out.printf("%nThe values of the double array after calling arrayTest(char, String[], double[]):%n");
		displayDoubleArray(doubleValues);
		System.out.printf("%n---------------------------------------------------------------%n");
	}

	/* multiply each element of an integer array by 4
	 * @param intValues - array of integer values
	*/
	public static void arrayTest(int intValues[])
	{
		for (int counter = 0; counter < intValues.length; counter++)
		{
			intValues[counter] *= 4;
		}
	}
	
	/* add each element of an integer array by 10
	 * add each element of a double array by 15.50
	 * @param intValues - array of integer values
	 * @param doubleValues - array of double values
	*/
	public static void arrayTest(int intValues[], double doubleValues[])
	{
		for (int counter = 0; counter < intValues.length; counter++)
		{
			intValues[counter] += 10;
		}
		
		for (int counter = 0; counter < doubleValues.length; counter++)
		{
			doubleValues[counter] += 15.50;
		}
	}
	
	/* modify and print a char value
	 * concatenate each element of a string array with "_modified"
	 * add each element of a double array by 20.30
	 * @param charValue - a character value
	 * @param stringValues - array of string values
	 * @param doubleValues - array of double values
	*/
	public static void arrayTest(char charValue, String stringValues[], double doubleValues[])
	{
		charValue = 'b';
		System.out.printf("%nmodified char value inside arrayTest(char, String[], double[])%n");
		System.out.printf("    %c", charValue);
		
		for (int counter = 0; counter < stringValues.length; counter++)
		{
			stringValues[counter] += "_modified";
		}
		
		for (int counter = 0; counter < doubleValues.length; counter++)
		{
			doubleValues[counter] += 20.30;
		}
	}
	
	// helper function to print elements of an integer array
	public static void displayIntegerArray(int[] intValues) 
	{
		for (int element : intValues)
		{
			System.out.printf("    %d", element);
	    }
	}
	
	// helper function to print elements of a double array
	public static void displayDoubleArray(double[] doubleValues)
	{
		for (double doubleElement : doubleValues)
		{
			System.out.printf("    %.2f", doubleElement);
		}
	}
	
	// helper function to print elements of a string array
	public static void displayStringArray(String[] stringValues)
	{
		for (String stringElement : stringValues)
		{
			System.out.printf("    %s", stringElement);
		}
	}
}
