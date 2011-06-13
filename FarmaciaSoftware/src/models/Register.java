package models;
import javax.swing.*;
import java.sql.*;

public class Register extends JFrame{
	
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
	
}
