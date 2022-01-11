package exercise2;

import exercise1.Operations;
import javafx.concurrent.Task;

public class CalculateTask extends Task<String> {
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

	public String call() {
		String result = "";
		switch (oper) {
		case ADDITION:
			int sum = firstNumber + secondNumber;
			result = "The result of the addition operation on " + firstNumber + " and " + secondNumber + " is " + sum + ".";
			break;
		case SUBTRACTION:
			int difference = firstNumber - secondNumber;
			result = "The result of the subtraction operation on " + firstNumber + " and " + secondNumber + " is " + difference + ".";
			break;
		case MULTIPLICATION:
			int product = firstNumber * secondNumber;
			result = "The result of the multiplication operation on " + firstNumber + " and " + secondNumber + " is " + product + ".";
			break;
		case DIVISION:
			int quotient = firstNumber / secondNumber;
			result = "The result of the division operation on " + firstNumber + " and " + secondNumber + " is " + quotient + ".";
			break;
		}
		return result;
	}
}