package models;

import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Stock_Model extends Register{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn;
	
	public Stock_Model() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
		this.conn = this.getConnection();
	}
	
	public void getProductsInStockById(Integer id){
		String query = "SELECT id, name, unity, quantity, description FROM Products WHERE id = '" + id.toString() + "';";
		ArrayList<ArrayList<String>> list = this.executeQuery(query);
		
		System.out.println("Length: " + list.size());
		for(ArrayList<String> pre : list){
			
			for(String value : pre){
				System.out.println(value);
			}
		}
	}
	
	public void getProductsInStockByName(String name){
		
		String query = "SELECT id, name, unity, quantity, description FROM Products WHERE name like '" + name + "%';";
		
		ArrayList<ArrayList<String>> list = this.executeQuery(query);
		for(ArrayList<String> pre : list){
			
			for(String value : pre){
				System.out.print(value + " ");
			}
			
			System.out.println();
		}
	}

	private ArrayList<ArrayList<String>> executeQuery(String query){

		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		Statement stmt;
		try {
				stmt = this.conn.createStatement();
				stmt.execute(query);
				ResultSet rs = stmt.getResultSet ();

				while (rs.next ()){
					ArrayList<String> temp = new ArrayList<String>();
					String id = rs.getString("id");
					temp.add(id);
					String name = rs.getString("name");
					temp.add(name);
					String unity = rs.getString("unity");
					temp.add(unity);
					String quantity = rs.getString("quantity");
					temp.add(quantity);
					String description = rs.getString("description");
					temp.add(description);
					
					list.add(temp);
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public void closeConnection() throws SQLException{
		this.conn.close();
	}
	
	public static void main(String args[]){
		try {
			Stock_Model model = new Stock_Model();
			model.getProductsInStockByName("abobora");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
