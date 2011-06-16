package models;
import java.sql.*;
import java.util.*;

import classes.Address;
import classes.Birthday;
import classes.Client;
import classes.Locality;
import classes.Name;
import classes.PersonalIdentification;
import classes.SocialSecurity;
import classes.Telephone;

public class Client_Model extends Register{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Connection conn;
		
		public Client_Model() throws SQLException {
			super();
			// TODO Auto-generated constructor stub
			this.conn = this.getConnection();
		}
		/*
		 * creates a table, if is already does not exist
		 * works fine, tested
		 */
		public void createTableClients(){
			String query =  "CREATE TABLE IF NOT EXISTS Clients(id INT NOT NULL AUTO_INCREMENT,"
							+ "PRIMARY KEY(id)," +
								"name VARCHAR(100) NOT NULL," +
								"address VARCHAR(100) NOT NULL," +
								"telephone VARCHAR(30) NOT NULL," +
								"birthday VARCHAR(10) NOT NULL," +
								"email VARCHAR(30) NOT NULL," +
								"socialsecurity VARCHAR(30) NOT NULL," +
								"stateid VARCHAR(30) NOT NULL," +
								"accountbalance FLOAT NOT NULL, " +
								"region VARCHAR(30) NOT NULL," +
								"city VARCHAR(30) NOT NULL," +
								"state VARCHAR(30) NOT NULL," +
								"country VARCHAR(30) NOT NULL);";
			
			if(this.executeQuery(query) == 0){
				System.out.println("Table Clients was successful created");
			}
			else{
				System.out.println("Table already exists");
			}
		}
		/*
		 * inserts a new city into the database
		 * working probably, and tested
		 */
		public void insertNewClient(Client client){
			
			System.out.println(client.formatToString());
			String query = "INSERT INTO Clients(name, address, telephone, birthday, email, socialsecurity, stateid, accountbalance, " +
					"region, city, state, country) VALUES (" + client.formatToString() + ");";
			System.out.println(query);
			if(this.executeQuery(query) == 0){
				System.out.println("New Client was successfully inserted");
			}
			else{
				System.out.println("The insertion was not successful");
			}
		}
		/*
		 * updates the values of a given locality
		 * needs some testing and refinements
		 */
		public void updateCity(Client client){
			
			String query = "UPDATE Cities SET region, city, state, country = " + client.toString();
			if(this.executeQuery(query) == 0){
				System.out.println("Updates were sucessfully performed");
			}
			else{
				System.out.println("The update was unsucessful");
			}
		}
		/*
		 * gets all the Clients
		 * and returns it as an
		 * ArrayList<Locality>
		 * 
		 */
		public ArrayList<Client> getAllClients(){
			String query = "SELECT * FROM Clients;";
			ArrayList<Client> results = new ArrayList<Client>();
			
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
					String social = rs.getString("socialsecurity");
					String name = rs.getString("name");
					String address = rs.getString("address");
					String telephone = rs.getString("telephone");
					String birthday = rs.getString("birthday");
					String email = rs.getString("email");
					String stateid = rs.getString("stateid");
					results.add(new Client());
					
					System.out.println ("id = " + idVal + ", region = " + region + ", city = " + city + ", state = " + state + ", country = " + country + ", social = " + social
							+ ", name = " + name + ", address = " + address + ", telephone = " + telephone + ", birthday = " + birthday + ", email = " + email + ", stateid = " + stateid );
						   
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
		public ArrayList<Client> getCity(String city){
			String query = "SELECT * FROM Cities WHERE city='" + city + "';";
			
			ArrayList<Client> results = new ArrayList<Client>();
			
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
					results.add(new Client());
					
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
		
		public static void main(String []args){
			
			try {
				Locality loc = new Locality("Centro", "Espinosa", "Minas Gerais", "Brasil");
				Client client = new Client(new Name("Philippe", "Gabriel", "Souza Moraes Ribeiro"), new Telephone("3838121453", "Brasil"), 
						new Address(449, "Avenida Dr Jose Cangussu", "39510000", loc), "ribeiro.phillipe@gmail.com", new SocialSecurity("79388360607", "Brasil"), new PersonalIdentification("MG14793883", "Brasil"), 1,
						new Birthday(8,2,1989));
		
				Client_Model model = new Client_Model();
				model.createTableClients();
				model.insertNewClient(client);
				ArrayList<Client> clients = model.getAllClients();
				model.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	

}
