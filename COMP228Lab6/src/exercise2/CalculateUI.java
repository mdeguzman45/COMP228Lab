package exercise2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JOptionPane;

import exercise1.Operations;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculateUI extends Application {
	private TextField intNum1FX = new TextField();
    private TextField intNum2FX = new TextField();
    private Button calculateTask = new Button("Calculate");
    private Label sumResult = new Label();
    private Label differenceResult = new Label();
    private Label productResult = new Label();
    private Label quotientResult = new Label();
    
    // create ExecutorService to manage threads
    ExecutorService executorService = Executors.newFixedThreadPool(10);
	
	@Override
	public void start(Stage primaryStage) {
		GridPane gridPane = new GridPane();
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        gridPane.add(new Label("First Number:"),0,0);
        gridPane.add(intNum1FX, 1, 0);
        
        gridPane.add(new Label("Second Number"), 0, 1);
        gridPane.add(intNum2FX, 1, 1);
        
        intNum1FX.setMaxWidth(100);
        intNum2FX.setMaxWidth(100);
        
        gridPane.add(calculateTask, 1, 2);
        
        gridPane.add(sumResult, 0, 3, 2, 1);
        gridPane.add(differenceResult, 0, 4, 2, 1);
        gridPane.add(productResult, 0, 5, 2, 1);
        gridPane.add(quotientResult, 0, 6, 2, 1);
        
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setPadding(new Insets(10, 20, 10, 20));
        
        calculateTask.setOnAction(e -> {
        	calculateNumbers();
        });
        
        Scene scene = new Scene(gridPane, 460, 200);
        primaryStage.setTitle("GUI Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
	}
	
	@Override
	public void stop(){
		executorService.shutdownNow();
	}

	private void calculateNumbers() {
		int num1 = 0;
		int num2 = 0;
		boolean validInputs = true; // flag to check if we can proceed
		
		// handle invalid input
        try 
        {
        	num1 = Integer.parseInt(intNum1FX.getText());
        }
        catch (Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Invalid first number!");
        	validInputs = false;
        }
        
        // handle invalid annual interest rate
        try 
        {
        	num2 = Integer.parseInt(intNum2FX.getText());
        }
        catch (Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Invalid second number!");
        	validInputs = false;
        }
        
        if (validInputs) 
        {
            sumResult.setText("");
            differenceResult.setText("");
            productResult.setText("");
            quotientResult.setText("");

        	// create task
    		CalculateTask addTask = new CalculateTask(num1, num2, Operations.ADDITION);
    		CalculateTask subtractTask = new CalculateTask(num1, num2, Operations.SUBTRACTION);
    		CalculateTask multiplyTask = new CalculateTask(num1, num2, Operations.MULTIPLICATION);
    		CalculateTask divideTask = new CalculateTask(num1, num2, Operations.DIVISION);
    		
    		// update the labels on success
    		addTask.setOnSucceeded((succeededEvent) -> {
    			sumResult.setText(addTask.getValue());
             });
    		
    		subtractTask.setOnSucceeded((succeededEvent) -> {
    			differenceResult.setText(subtractTask.getValue());
             });
    		
    		multiplyTask.setOnSucceeded((succeededEvent) -> {
    			productResult.setText(multiplyTask.getValue());
             });
    		
    		divideTask.setOnSucceeded((succeededEvent) -> {
    			quotientResult.setText(divideTask.getValue().toString());
             });
    		
    		// start the calculate tasks
    		executorService.submit(addTask); // start addTask	
    		executorService.submit(subtractTask); // start subtractTask
    		executorService.submit(multiplyTask); // start multiplyTask
    		executorService.submit(divideTask); // start divideTask
        }
	}
	
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
