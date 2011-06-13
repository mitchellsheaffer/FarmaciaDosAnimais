
package models;
import java.sql.*;

import classes.*;
/*
 * this class has been tested by Philippe Ribeiro
 * 
 * ----- Missing testings for Updade --------
 */
public class Product_Model extends Register{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Connection conn;
		
		public Product_Model() throws SQLException{
			super();
			this.conn = this.getConnection();
		}
		
		/*
		 * creates the Product Table, if it has not been created
		 * otherwise just skips it
		 * 
		 * works nicely, successful tested;
		 */
		public void createTableProducts() throws SQLException{
			/*
			 * the other is: 
			 * ALWAYS ASSIGN THE ENGINE TO INNODB(MAKES POSSIBLE TO USE FOREIGN KEY)
			 * 
			 */
			String query =  "CREATE TABLE IF NOT EXISTS Products(" +
							"id INT NOT NULL AUTO_INCREMENT, " +
							"PRIMARY KEY(id)," +
							"name VARCHAR(100) NOT NULL," +
							"unity VARCHAR(5) NOT NULL," +
							"quantity INT NOT NULL," +
							"pricecash FLOAT NOT NULL," +
							"priceterm FLOAT NOT NULL," +
							"pricefinal FLOAT NOT NULL," +
							"description VARCHAR(100) NOT NULL)ENGINE=INNODB;";
				
				try{
						Statement st = this.conn.createStatement();
						st.execute(query);
						System.out.println("Table Products created with success!");
					}
				catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("Table already exists");
						e.printStackTrace();
					}
		}
		/*
		 * MySQL query to add a new employee into the database
		 * works nicely
		 * successful tested
		 */
		public int addNewProduct(Product product){
			
			try{
				Statement st = this.conn.createStatement();
				
				String query =  "INSERT INTO Products(name, unity, quantity, pricecash, priceterm, pricefinal, description) VALUES ("
					+ product.formatToString() + ");";
				st.execute(query);
				System.out.println("Sucessful added");
				return 0;
					
			}
			catch(SQLException e){
				e.printStackTrace();
				System.out.println("Failed to add a new product");
				return -1;
				
			}

		}
		
		public void updateProductInformation(Employee employee){
			
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
		public void deleteEmployee(Integer productId){
			
			try{
				Statement st = this.conn.createStatement();
				String query = "DELETE FROM Product WHERE id=" + productId.toString() + ";";
				st.execute(query);
				System.out.println("Successful deleted");
			}
			catch(SQLException e){
				System.out.println("Failed to delete the employee");
				e.printStackTrace();
			}
			
		}
		/*
		 * closes the MySQL connection
		 */
		public void closeConnection() throws SQLException{
			this.conn.close();
		}

}
