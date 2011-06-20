package models;
import java.sql.*;
<<<<<<< HEAD
import java.util.*;

import classes.*;
import classes.Date;

/*
 * class not completed yet
 */
=======

import classes.Sale;

>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
public class Sale_Model extends Register{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn;
	public Sale_Model() throws SQLException{
		super();
		this.conn = super.getConnection();
	}
	/*
	 * function createSalesTable, creates the sale table
	 * @param: void
	 * @return: void
	 * 
	 * saves the SQL query into a string
	 * then executes that string
	 * 
	 */
	public void createSalesTable(){
		//creates the SQL query
		String query =  "CREATE TABLE IF NOT EXISTS Sales(id INT NOT NULL AUTO_INCREMENT,"
			+ "PRIMARY KEY(id)," +
				"productId INT NOT NULL," + 
				"productName VARCHAR(100) NOT NULL," +
				"productQuantity VARCHAR(100) NOT NULL," +
				"productUnity VARCHAR(5) NOT NULL," +
				"unitySalePrice FLOAT NOT NULL," +
				"totalPurchase FLOAT NOT NULL," +
				"clientId INT NOT NULL," +
				"customerName VARCHAR(100) NOT NULL," +
				"saleDate DATE NOT NULL);";
		
		//checks if it went all right
		if(this.executeQuery(query) == 0){
			System.out.println("Table Sales was successful created");
		}
		else{
			System.out.println("Table already exists");
		}
	}
	
	public void insertNewSale(Sale sale){
		
		String  query = "INSERT INTO TABLE Sales(productId, productName, productQuantity, " +
						"productUnity, unitySalePrice, totalPurchase, clientId, customerName, saleDate) VALUES("
					+	sale.getSaleId().toString() + ", " + sale.getProduct().getProductName() + ", " + sale.getQuantity().toString() + ", " 
					+	sale.getProduct().getProductUnity() + ", " + sale.getProduct().getProductFinalPrice() + ", " + sale.getTotalSale().toString() + ", " 
					+   sale.getClient().getClientId().toString() + ", " + sale.getClient().getPersonName().formatToString() + ", " + sale.getSaleDate().formatToString() + ");";
		
		if(this.executeQuery(query) == 0){
			System.out.println("Product was successful inserted");
		}
		else{
			System.out.println("Table already exists");
		}
					
		
	}
	
<<<<<<< HEAD
	public ArrayList<Sale> getAllSales(Date date){
		ArrayList<Sale> sales = new ArrayList<Sale>();
		String query = "SELECT * FROM Sales WHERE date=" + date.formatToString() + ";";
		sales = this.getList(query);
		
		return sales;
	}
	
	public Sale getSaleById(Integer id){
		String query = "SELECT * FROM Sales WHERE id=" + id.toString() + ";";
		
		Sale sale = new Sale();
		return sale;
	}
	
=======
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
	private int executeQuery(String query){
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
<<<<<<< HEAD
	private ArrayList<Sale> getList(String query){

		ArrayList<Sale> list = new ArrayList<Sale>();
		Statement stmt;
		try {
				stmt = this.conn.createStatement();
				stmt.execute(query);
				ResultSet rs = stmt.getResultSet ();

				while (rs.next ()){
					Sale sale = new Sale();
					list.add(sale);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void main(String args[]){
		Product p = new Product(1, "Ivomec 50ml", "UN", 12.50, 14.00, 13.00, "matar carrapato");
	
=======
	
	public static void main(String args[]){
		
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		try {
			Sale_Model model = new Sale_Model();
			model.createSalesTable();
			
			System.exit(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
