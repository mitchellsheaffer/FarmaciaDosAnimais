package models;
import classes.Locality;
import java.sql.*;
import java.util.*;
/*
 * Class City_Model, deals with the 'Cities' table;
 * class written by Philippe Ribeiro, 
 * University of Minnesota, Minneapolis, Minnesota, USA - 55113
 * 
 * the only field variable of the class is Connection Conn
 * June 9th, 2010
 * 
 */
public class City_Model extends Register{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn;
	
	public City_Model() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
		this.conn = this.getConnection();
	}
	/*
	 * creates a table, if is already does not exist
	 */
	public void createTableCities(){
		String query =  "CREATE TABLE IF NOT EXISTS Cities(id INT NOT NULL AUTO_INCREMENT."
						+ "PRIMARY KEY(id)," +
							"region VARCHAR(100) NOT NULL" +
							"city VARCHAR(100) NOT NULL" +
							"state VARCHAR(10) NOT NULL" +
							"country VARCHAR(30) NOT NULL);";
		if(this.executeQuery(query) == 0){
			System.out.println("Table cities was successful created");
		}
		else{
			System.out.println("Table already exists");
		}
	}
	/*
	 * inserts a new city into the database
	 */
	public void insertNewCity(Locality locality){
		
		System.out.println(locality.formatToString());
		String query = "INSERT INTO Cities(region, city, state, country) VALUES (" + locality.formatToString() + ");";
		System.out.println(query);
		if(this.executeQuery(query) == 0){
			System.out.println("New city was successfully inserted");
		}
		else{
			System.out.println("The insertion was not successful");
		}
	}
	/*
	 * updates the values of a given locality
	 * needs some testing and refinements
	 */
	public void updateCity(Locality locality){
		
		String query = "UPDATE Cities SET region, city, state, country = " + locality.formatToString();
		if(this.executeQuery(query) == 0){
			System.out.println("Updates were sucessfully performed");
		}
		else{
			System.out.println("The update was unsucessful");
		}
	}
	/*
	 * gets all the Cities
	 * and returns it as an
	 * ArrayList<Locality>
	 * 
	 */
	public ArrayList<Locality> getAllCities(){
		String query = "SELECT * FROM Cities;";
		ArrayList<Locality> results = new ArrayList<Locality>();
		
		Statement stmt;
		try {
			stmt = this.conn.createStatement();
			stmt.executeQuery (query);
			ResultSet rs = stmt.getResultSet ();

			while (rs.next ()){
				int idVal = rs.getInt ("id");
				String region = rs.getString ("region");
				String city = rs.getString ("city");
				String state = rs.getString("state");
				String country = rs.getString("country");
				
				Locality newLocality = new Locality(region, city, state, country);
				results.add(newLocality);
				
				System.out.println ("id = " + idVal + ", region = " + region + ", city = " + city + ", state = " + state + ", country = " + country);
					   
			}
			
			rs.close ();
			stmt.close ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return results;
	}

	/*
	 * Queries into the database given a city, returns
	 * all the values associates with that city
	 * and stores the result into a ArrayList
	 * 
	 *  returns an ArrayList
	 */
	public ArrayList<Locality> getCity(String city){
		String query = "SELECT * FROM Cities WHERE city='" + city + "';";
		
		ArrayList<Locality> results = new ArrayList<Locality>();
		
		Statement stmt;
		try {
			stmt = this.conn.createStatement();
			stmt.executeQuery (query);
			ResultSet rs = stmt.getResultSet ();

			while (rs.next ()){
				int idVal = rs.getInt ("id");
				String region = rs.getString ("region");
				String city1 = rs.getString ("city");
				String state = rs.getString("state");
				String country = rs.getString("country");
				
				Locality newLocality = new Locality(region, city1, state, country);
				results.add(newLocality);
				
				System.out.println ("id = " + idVal + ", region = " + region + ", city = " + city1 + ", state = " + state + ", country = " + country);
					   
			}
			
			rs.close ();
			stmt.close ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return results;
	}
	/*
	 * deletes a given city
	 */
	public void deleteCity(String city){
		String query = "DELETE FROM Cities WHERE city='%" + city + "%';";
		
		if(this.executeQuery(query) == 0){
			System.out.println("City has been Successfully deleted");
		}
		else{
			System.out.println("The deletion was unsuccessful");
		}
	}
	
	/*
	 * executes the query, given the string
	 */
	public int executeQuery(String query){
		int status = 0;
		
		Statement stmt;
		try {
			stmt = this.conn.createStatement();
				stmt.execute(query);
				System.out.println("Query executed Successfully");
				status = 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public void closeConnection() throws SQLException{
		this.conn.close();
	}
}
