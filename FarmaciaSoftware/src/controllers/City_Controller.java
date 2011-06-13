package controllers;
import java.sql.SQLException;

import views.City_View;
import models.City_Model;

public class City_Controller {
	private City_View cityView;
	private City_Model cityModel;
	
	public City_Controller() throws SQLException{
		this.cityModel = new City_Model();
		this.cityView = new City_View();
	}
}
