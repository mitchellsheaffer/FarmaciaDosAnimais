package models;
<<<<<<< HEAD
import java.sql.*;

public class Register{
=======
import javax.swing.*;
import java.sql.*;

public class Register extends JFrame{
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DatabaseConn conn;
	private Connection connection;
	
	public Register() throws SQLException{
		
		this.conn = new DatabaseConn();
		this.connection = this.conn.getConnection();
	}
	
	public Connection getConnection(){
		return this.connection;
	}
	
<<<<<<< HEAD
	
=======
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
}
