package models;
import java.sql.*;

import classes.*;

public class Employee_Model extends Register{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn;
	
	public Employee_Model() throws SQLException{
		super();
		this.conn = this.getConnection();
	}
	
	/*
	 * creates the Employee Table, if it has not been created
	 * otherwise just skips it
	 * 
	 * works nicely, successful tested;
	 */
	public void createTableEmployee() throws SQLException{
		/*
		 * the other is:
		 * id, name, address, birthday, telephone, email, previous employed, ssn, salary, starting date, 
		 * region, city, state, country, 
		 * 
		 */
		String query =  "CREATE TABLE IF NOT EXISTS Employees(" +
						"id INT NOT NULL AUTO_INCREMENT, " +
						"PRIMARY KEY(id)," +
						"name VARCHAR(100) NOT NULL," +
						"address VARCHAR(100) NOT NULL," +
						"birthday VARCHAR(20) NOT NULL, " + 
						"telephone VARCHAR(30) NOT NULL," +
						"email VARCHAR(30) NOT NULL, " +
						"previousEmployed BOOL NOT NULL," +
						"socialSecurity VARCHAR(30) NOT NULL," +
						"salary FLOAT NOT NULL," +
						"startingDate VARCHAR(20) NOT NULL," +
						"region VARCHAR(50) NOT NULL," +
						"city VARCHAR(50) NOT NULL," +
						"state VARCHAR(50) NOT NULL," +
						"country VARCHAR(50) NOT NULL)ENGINE=INNODB";
			
			
			try{
					Statement st = this.conn.createStatement();
					st.execute(query);
					System.out.println("Table Employee created with success!");
				}
			catch (SQLException e) {
					// TODO Auto-generated catch block
					//System.out.println("Table already exists");
					e.printStackTrace();
				}
	}
	/*
	 * MySQL query to add a new employee into the database
	 * works nicely
	 * successful tested
	 */
	public void addNewEmployee(Employee employee){
		
		try{
			Statement st = this.conn.createStatement();
			
			String query =  "INSERT INTO Employees(name, address, birthday, telephone, email, previousEmployed," +
					"socialSecurity, salary, startingDate, region, city, state, country) VALUES('" 
					+ employee.getPersonName().formatToString() + "', '"
					+ employee.getPersonAddress().formatToString() + "', '"
					+ employee.getPersonBirthday().formatToString() + "', '"
					+ employee.getPersonTelephone().getTelephone() + "', '"
					+ employee.getEmployeeEmail() + "', "
					+ employee.getPreviousEmployed() + ", '"
					+ employee.getEmployeeSocialSecurityNumber().getSocialSecurityNumber() + "', '"
					+ employee.getEmployeeSalary().getSalary() + "', '"
					+ employee.getEmployeeStartingDay().formatToString() + "', '"
					+ employee.getPersonAddress().getAddressLocality().getRegion() + "', '"
					+ employee.getPersonAddress().getAddressLocality().getCity() + "', '"
					+ employee.getPersonAddress().getAddressLocality().getState() + "', '"
					+ employee.getPersonAddress().getAddressLocality().getCountry() + "');";
			
			System.out.println("Sucessful added");
			st.execute(query);
				
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Failed to add a new employee");
			
		}

	}
	
	public void updateEmployeeInformation(Employee employee){
		
		try{
			Statement st = this.conn.createStatement();
			String query = "UPDATE Employees SET col_string='a new string' WHERE col_string = 'a string'";
		    int updateCount = st.executeUpdate(query);
		    System.out.println(updateCount);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	/*
	 * works nicely ... 
	 * successful tested
	 */
	public void deleteEmployee(Integer employeeId){
		
		try{
			Statement st = this.conn.createStatement();
			String query = "DELETE FROM Employees WHERE id=" + employeeId.toString() + ";";
			st.execute(query);
			System.out.println("Successful deleted");
		}
		catch(SQLException e){
			System.out.println("Failed to delete the employee");
			e.printStackTrace();
		}
		
	}
	public void closeConnection() throws SQLException{
		this.conn.close();
	}
	
}
