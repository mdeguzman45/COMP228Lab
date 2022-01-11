package exercise_1_2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class FindGradeWithPreparedStatement extends Application
{
	private PreparedStatement gradePreparedStatement;
	private PreparedStatement coursePreparedstatement;
	private PreparedStatement updateGradePreparedStatement;
	private TextField tfSIN = new TextField();
	private Label lblStatus = new Label();
	private Connection dbConnection;
	
	// modification 4: label to hold student courses
	private Label lblStudentCourses = new Label();
	
	// modification 5: text field for grade update
	private TextField tfNewGrade = new TextField();
	 String[] validGrades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D", "E", "F"};
	
	@Override
	public void start(Stage primaryStage)
	{
		//initialize database connection and create a statement object
		initializeDB();
		Button btShowGrade = new Button("Show Grade");
		HBox hBox = new HBox(10);
		
		// modification 1: add clear button
		Button btnClear = new Button("Clear");
		btnClear.setStyle("-fx-font: 16 Verdana; -fx-base: #cccc00;-fx-border-radius:10;-fx-padding:5,5,5,5; -fx-background-radius:10;");
		btnClear.setMouseTransparent(false);
		
		// modification 4: add show student courses
		Button btnShowCourses = new Button("Show Courses");
		btnShowCourses.setStyle("-fx-font: 16 Verdana; -fx-base: #cccc00;-fx-border-radius:10;-fx-padding:5,5,5,5; -fx-background-radius:10;");
		btnShowCourses.setMouseTransparent(false);
		
		// modification 5: update a students grade
		Button btnUpdateGrade = new Button("Update Grade");
		btnUpdateGrade.setStyle("-fx-font: 16 Verdana; -fx-base: #cccc00;-fx-border-radius:10;-fx-padding:5,5,5,5; -fx-background-radius:10;");
		btnUpdateGrade.setMouseTransparent(false);
		tfNewGrade.setStyle("-fx-font: 14 Verdana; -fx-base: #cccc00;-fx-border-radius:10;-fx-padding:5,5,5,5; -fx-background-radius:10");
		tfNewGrade.setPrefWidth(200);
		HBox hBox2 = new HBox(10);
		hBox2.setStyle("-fx-margin:20,10,10,10; -fx-padding:10,10,10,10;-fx-background-color:WHITE; -fx-border-radius:10;-fx-padding:5; -fx-background-radius:10");
		hBox2.getChildren().addAll(new Label(" Grade: "), tfNewGrade, btnUpdateGrade);
				
		hBox.setStyle("-fx-margin:20,10,10,10; -fx-padding:10,10,10,10;-fx-background-color:WHITE; -fx-border-radius:10;-fx-padding:5; -fx-background-radius:10");
		hBox.getChildren().addAll(new Label(" SIN"), tfSIN, btShowGrade, btnShowCourses, btnClear);
		btShowGrade.setStyle("-fx-font: 16 Verdana; -fx-base: #cccc00;-fx-border-radius:10;-fx-padding:5,5,5,5; -fx-background-radius:10;");
		tfSIN.setStyle("-fx-font: 14 Verdana; -fx-base: #cccc00;-fx-border-radius:10;-fx-padding:5,5,5,5; -fx-background-radius:10");
		tfSIN.setPrefWidth(200);
		btShowGrade.setMouseTransparent(false);
		
		lblStatus.setStyle("-fx-font: 18 Verdana;");
		lblStudentCourses.setStyle("-fx-font: 18 Verdana;");
		
		tfSIN.setPrefColumnCount(5);
		
		VBox vBox = new VBox(20);
		vBox.setStyle("-fx-margin:20,10,10,10; -fx-padding:10,10,10,10;-fx-background-color:#ffff99;-fx-border-radius:10;-fx-padding:5; -fx-background-radius:10;");
		vBox.getChildren().addAll(hBox, hBox2, lblStatus, lblStudentCourses);
		
		//Register handler
		btShowGrade.setOnAction(e -> showGrade());
		
		//Register Clear Handler
		btnClear.setOnAction(e -> clearAll());
		
		//Register Show Courses handler
		btnShowCourses.setOnAction(e -> showCourse());
		
		//Register update grade handler
		btnUpdateGrade.setOnAction(e -> updateGrade());
		
		//routine for UI
		Scene scene = new Scene(vBox, 600, 450);
		primaryStage.setTitle("Lab5 COMP228");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	// add close connection call on close of window
	@Override
	public void stop(){
	    System.out.println("Stage is closing");
		try
		{
			// close connection
			if (dbConnection != null)
			{
				dbConnection.close();
				System.out.println("Closed database connection.");
			}
		}
		catch (SQLException ex)
		{
			System.out.println("Failed closing database connection.");
		}
	}
	
	private void initializeDB()
	{
		try
		{
			//load jdbc driver
			Class.forName("oracle.jdbc.OracleDriver");
			//for sqlserver
			//Class.forName(com.mysql.jdbc.Driver");
			System.out.println("Driver loaded.");
			
			//establish a connection
			dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@ 199.212.26.208:1521:SQLD","COMP228_W21_sy_73", "password");
			System.out.println("Database connected.");
			
			String gradeQueryString = "select firstName, mi, lastName, grade from STUDENT1 where sin = ?";
			String courseQueryString = "SELECT C.SUBJECT, C.COURSE, C.TITLE, S.FIRSTNAME, S.MI, S.LASTNAME FROM STUDENT_COURSE SC "
					+ "JOIN COURSE C USING(CRN) JOIN STUDENT1 S USING (SIN) WHERE SIN = ?";
			String updateGradeQueryString = "UPDATE STUDENT1 SET GRADE = ? WHERE SIN = ?";
			
			//create a statement
			gradePreparedStatement = dbConnection.prepareStatement(gradeQueryString);
			coursePreparedstatement = dbConnection.prepareStatement(courseQueryString);
			updateGradePreparedStatement = dbConnection.prepareStatement(updateGradeQueryString);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	
	private void showGrade()
	{
		String sin = tfSIN.getText().trim();
		
		if (isSinEmpty())
		{
			JOptionPane.showMessageDialog(null, "SIN should not be blank!");
		}
		else
		{
			try
			{
				gradePreparedStatement.setString(1, sin);
				ResultSet rset = gradePreparedStatement.executeQuery();
				
				if(rset.next())
				{
					String firstName = rset.getString(1);
					String mi = rset.getString(2);
					String lastName = rset.getNString(3);
					String grade = rset.getString(4);
					
					//display result in a label
					lblStatus.setText(firstName + " " + mi + " " + lastName + "'s grade is " + grade);
				}
				else
				{
					lblStatus.setText("Not found.");
				}
				
				if (rset != null)
				{
					rset.close();
				}
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
	}
	
	// modification 1: clear all text fields and label fields
	private void clearAll()
	{
		tfSIN.clear();
		tfNewGrade.clear();
		lblStatus.setText("");
		lblStudentCourses.setText("");
	}
	
	// modification 4: handler to show the students course
	private void showCourse()
	{
		String sin = tfSIN.getText().trim();

		if (isSinEmpty())
		{
			JOptionPane.showMessageDialog(null, "SIN should not be blank!");
		}
		else
		{
			try
			{
				coursePreparedstatement.setString(1, sin);
				ResultSet rset = coursePreparedstatement.executeQuery();

				String fullName = "";
				String courses = "";
				if(rset.next())
				{	
					// loop thru the rows
					do
					{
						String subject = rset.getNString(1);
						String course = rset.getNString(2);
						String title = rset.getNString(3);

						if (fullName == "")
						{
							String firstName = rset.getString(4);
							String mi = rset.getString(5);
							String lastName = rset.getNString(6);

							fullName = firstName + " " + mi + " " + lastName;
						}

						courses += "[" + subject + "-" + course + "] " + title + "\n";
					} while(rset.next());

					//display courses in a label
					lblStudentCourses.setText(fullName + "'s courses:\n" + courses);
				}
				else
				{
					lblStatus.setText("Not found.");
				}

				if (rset != null)
				{
					rset.close();
				}
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
	}

	// modification 5: update a students grade
	private void updateGrade()
	{
		String sin = tfSIN.getText().trim();
		String newGrade = tfNewGrade.getText().trim().toUpperCase();
		boolean proceedUpdate = false;
		String lastName = "";
		String mi = "";
		String firstName = "";
		String grade = "";

		if (isSinEmpty())
		{
			JOptionPane.showMessageDialog(null, "SIN should not be blank!");
			return;
		}
		
		if (newGrade.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Grade should not be blank!");
			return;
		}
		
		// lets wrap validGrades as a list for now to check if the grade entered is valid
		if (!Arrays.asList(validGrades).contains(newGrade.toUpperCase())) {
			JOptionPane.showMessageDialog(null, "Please enter a valid grade!");
			return;
		}
		
		// get the student's grade first
		try
		{
			gradePreparedStatement.setString(1, sin);
			ResultSet rset = gradePreparedStatement.executeQuery();
			
			if(rset.next())
			{
				firstName = rset.getString(1);
				mi = rset.getString(2);
				lastName = rset.getNString(3);
				grade = rset.getString(4).toUpperCase().trim();
				
				// Proceed only on updating when the current grade is not the same
				if (newGrade != grade)
				{
					proceedUpdate = true;
				}
			}
			else
			{
				lblStatus.setText("Update grade failed. Student Not found.");
				proceedUpdate = false;
			}
			
			if (rset != null)
			{
				rset.close();
			}
			
			if (proceedUpdate)
			{
				updateGradePreparedStatement.setString(1, newGrade);
				updateGradePreparedStatement.setString(2, sin);
				
				int runUpdate = updateGradePreparedStatement.executeUpdate();
				String fullName = firstName + " " + mi + " " + lastName;
				String gradeUpdateLabel;
				if (runUpdate > 0)
				{
					gradeUpdateLabel = "Successful updating grade of " + fullName + "\n"
							+ "Old Grade: " + grade + "\n"
							+ "New Grade: " + newGrade;
				}
				else
				{
					gradeUpdateLabel = "Failed updating grade of " + fullName;;
				}
				
				lblStatus.setText(gradeUpdateLabel);
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Application.launch();
	}
	
	private boolean isSinEmpty() 
	{
		String sin = tfSIN.getText().trim();
		return sin.isEmpty();
	}
}
