package exercise2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//JOtionPane
import javax.swing.JOptionPane;

public class FuturesController extends Application
{   
    private TextField InvestmentAmountFX = new TextField();
    private TextField NumberOfYearsFX = new TextField();
    private TextField AnnualInterestRateFX = new TextField();
    private TextField FutureValueFX = new TextField();
    private TextField NameFX = new TextField();
    private TextField AddressFX = new TextField();
    
    private Button CalculateFuture = new Button("Calculate");
    private Button ResetInputs = new Button("Reset");
    
    @Override
    public void start(Stage primaryStage){

        GridPane gridPane = new GridPane();
        
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        
        gridPane.add(new Label("Investment Amount:"),0,0);
        gridPane.add(InvestmentAmountFX, 1, 0);
        
        gridPane.add(new Label("Years:"), 0, 1);
        gridPane.add(NumberOfYearsFX, 1, 1);
        
        gridPane.add(new Label("Annual Interest Rate:"), 0, 2);
        gridPane.add(AnnualInterestRateFX, 1, 2);

        gridPane.add(new Label("Future Value:"), 0, 3);
        gridPane.add(FutureValueFX, 1, 3);
        
        gridPane.add(new Label("Name:"), 0, 4);
        gridPane.add(NameFX, 1, 4);
        
        gridPane.add(new Label("Address:"), 0, 5);
        gridPane.add(AddressFX, 1, 5);
        
        gridPane.add(ResetInputs, 1, 6);
        gridPane.add(CalculateFuture, 1, 6);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10, 20, 10, 20));
        
        InvestmentAmountFX.setAlignment(Pos.BOTTOM_RIGHT);
        NumberOfYearsFX.setAlignment(Pos.BOTTOM_RIGHT);
        AnnualInterestRateFX.setAlignment(Pos.BOTTOM_RIGHT);
        NameFX.setAlignment(Pos.BOTTOM_RIGHT);
        AddressFX.setAlignment(Pos.BOTTOM_RIGHT);
        
        FutureValueFX.setAlignment(Pos.BOTTOM_RIGHT);
        FutureValueFX.setStyle("-fx-control-inner-background: #D3D3D3");
        
        FutureValueFX.setEditable(false);

        GridPane.setHalignment(CalculateFuture, HPos.RIGHT);

        CalculateFuture.setOnAction(e -> {
            calculateFutureAmount();
        });
        
        ResetInputs.setOnAction(e -> {
        	resetInputForm();
        });

        Scene scene = new Scene(gridPane);
        primaryStage.setTitle("COMP228 Future Value Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void calculateFutureAmount()
    {
    	double investmentAmount = 0;
        double interest = 0;
        int years = 0;
        boolean validInputs = true;
        
        // handle invalid investment amount
        try 
        {
        	investmentAmount = Double.parseDouble(InvestmentAmountFX.getText());
        }
        catch (Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Invalid Investment Amount!");
        	validInputs = false;
        }
        
        // handle invalid annual interest rate
        try 
        {
        	interest = Double.parseDouble(AnnualInterestRateFX.getText());
        }
        catch (Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Invalid Interest Rate!");
        	validInputs = false;
        }
        
    	// handle invalid years
        try 
        {
        	years = Integer.parseInt(NumberOfYearsFX.getText());
        }
        catch (Exception e)
        {
        	JOptionPane.showMessageDialog(null, "Invalid Years! Enter whole number only.");
        	validInputs = false;
        }
        
        // compute future value if all fields are valid
        if (validInputs)
        {           
            FuturesInvestment futureInvestment = new FuturesInvestment(investmentAmount, interest, years);
            double futurevalue = futureInvestment.calculateFutureValue();
            
            FutureValueFX.setText(String.format("$%.2f", futurevalue));
            
            showCustomerMessage(futurevalue);
        }
    }
    
    private void resetInputForm()
    {
    	InvestmentAmountFX.clear();
        AnnualInterestRateFX.clear();
        NumberOfYearsFX.clear();
        NameFX.clear();
        AddressFX.clear();
        FutureValueFX.clear();
    }
    
    private void showCustomerMessage(double futureValue)
    {
    	String resultString = "Your Future Investment calculation:" +
    					"\n\tName: " + NameFX.getText() + 
    					"\n\tAddress: " + AddressFX.getText() + 
    					"\n\tFuture Value of Your Investment: " + String.format("$%.2f", futureValue);
    	
    	JOptionPane.showMessageDialog(null, resultString);
    }

	public static void main(String[] args)
	{
		Application.launch(args);
	}

}

