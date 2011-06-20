package models;
<<<<<<< HEAD
import classes.ListTableModel;
import classes.Locality;

=======
import classes.Locality;
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
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
<<<<<<< HEAD
		String query =  "CREATE TABLE IF NOT EXISTS Cities(id INT NOT NULL AUTO_INCREMENT,"
						+ "PRIMARY KEY(id)," +
							"region VARCHAR(100) NOT NULL," +
							"city VARCHAR(100) NOT NULL," +
							"state VARCHAR(10) NOT NULL," +
=======
		String query =  "CREATE TABLE IF NOT EXISTS Cities(id INT NOT NULL AUTO_INCREMENT."
						+ "PRIMARY KEY(id)," +
							"region VARCHAR(100) NOT NULL" +
							"city VARCHAR(100) NOT NULL" +
							"state VARCHAR(10) NOT NULL" +
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
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
<<<<<<< HEAD
	public int insertNewCity(Locality locality){
=======
	public void insertNewCity(Locality locality){
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		System.out.println(locality.formatToString());
		String query = "INSERT INTO Cities(region, city, state, country) VALUES (" + locality.formatToString() + ");";
		System.out.println(query);
		if(this.executeQuery(query) == 0){
<<<<<<< HEAD
			return 0;
		}
		else{
			return -1;
=======
			System.out.println("New city was successfully inserted");
		}
		else{
			System.out.println("The insertion was not successful");
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
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
<<<<<<< HEAD
	public ListTableModel getCity(String city){
		String query = "SELECT * FROM Cities WHERE city='" + city + "';";
		
		ListTableModel model = null;
		Statement stmt;
		
=======
	public ArrayList<Locality> getCity(String city){
		String query = "SELECT * FROM Cities WHERE city='" + city + "';";
		
		ArrayList<Locality> results = new ArrayList<Locality>();
		
		Statement stmt;
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		try {
			stmt = this.conn.createStatement();
			stmt.executeQuery (query);
			ResultSet rs = stmt.getResultSet ();
<<<<<<< HEAD
			model = ListTableModel.createModelFromResultSet(rs);  

=======

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
			
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
			rs.close ();
			stmt.close ();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
<<<<<<< HEAD
		return model;
=======
		return results;
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
	}
	/*
	 * deletes a given city
	 */
<<<<<<< HEAD
	public int deleteCity(String city){
		String query = "DELETE FROM Cities WHERE city='" + city + "';";
		
		if(this.executeQuery(query) == 0){
			return 0;
		}
		else{
			return 1;
=======
	public void deleteCity(String city){
		String query = "DELETE FROM Cities WHERE city='%" + city + "%';";
		
		if(this.executeQuery(query) == 0){
			System.out.println("City has been Successfully deleted");
		}
		else{
			System.out.println("The deletion was unsuccessful");
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
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
<<<<<<< HEAD
=======
				System.out.println("Query executed Successfully");
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
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
