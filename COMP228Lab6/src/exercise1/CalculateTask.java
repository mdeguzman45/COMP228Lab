package exercise1;

public class CalculateTask implements Runnable {
	private int firstNumber;
	private int secondNumber;
	private Operations oper;
	
	public CalculateTask(int firstNum, int secondNum, Operations op) {
		firstNumber = firstNum;
		secondNumber = secondNum;
		oper = op;
	}
	
	public int getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	public Operations getOper() {
		return oper;
	}

	public void setOper(Operations oper) {
		this.oper = oper;
	}

	
	public void run() {
		switch (oper) {
		case ADDITION:
			int sum = firstNumber + secondNumber;
			System.out.printf("The result of the addition operation on %d and %d is %d.%n", firstNumber, secondNumber, sum);
			break;
		case SUBTRACTION:
			int difference = firstNumber - secondNumber;
			System.out.printf("The result of the subtraction operation on %d and %d is %d.%n", firstNumber, secondNumber, difference);
			break;
		case MULTIPLICATION:
			int product = firstNumber * secondNumber;
			System.out.printf("The result of the multiplication operation on %d and %d is %d.%n", firstNumber, secondNumber, product);
			break;
		case DIVISION:
			int quotient = firstNumber / secondNumber;
			System.out.printf("The result of the division operation on %d and %d is %d.%n", firstNumber, secondNumber, quotient);
			break;
		}
	}
}
