package controllers;
<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import classes.ListTableModel;
import classes.Locality;
import views.City_View;
import models.City_Model;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class City_Controller{
	private City_View cityView;
	private City_Model cityModel;
	private Locality locality;
	
	public City_Controller(City_Model model, City_View view) throws SQLException{
		this.cityModel = model;
		this.cityView = view;
		
		view.addSaveListener(new SaveListener());
		view.addCancelListener(new ClearListener());
		view.addCloseListener(new CloseListener());
		view.addSearchSingleListener(new SearchSingleListener());
		view.addDeleteListener(new DeleteListener());
	}
	
	public void displayCityView(){
    	this.cityView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.cityView.setVisible(true);
	}
	
	//inner class SaveListener
	class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
				//gets the locality from the cityView
				cityView.setLocality();
				locality = cityView.getLocality();
				//if it was successfully inserted into the db, the show a 
				//successful message
				if(cityModel.insertNewCity(locality) == 0){
					JOptionPane.showMessageDialog(null, "New city was sucessfully added");
				}
				else{
					JOptionPane.showMessageDialog(null, "An error happened");
				}
			}
			catch(Exception ex){
				System.out.println("An error happened");
			}
		}
		
	}
	//end of the SaveListener class
	
	/*
	 * inner class ClearListener, performs a clear operation in the JTextFields
	 * or any other component of the JFrame
	 */
	class ClearListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cityView.reset();
		}
	}// end of the class ClearListener
	
	class CloseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			cityView.close();
		}
	}
	
	class DeleteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String city = cityView.getCity();
			
			if(cityModel.deleteCity(city) == 0){
				JOptionPane.showMessageDialog(null, "City " + city + " has been deleted.");
			}
		}
		
	}
	class SearchSingleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try{
				//gets the locality from the cityView
				String city = cityView.getCity();
				System.out.println(city);
				ListTableModel model = cityModel.getCity(city);
				//if it was successfully inserted into the db, the show a 
				//successful message
				JTable table = new JTable(model);
				cityView.createTable(table);
			}
			catch(Exception ex){
				System.out.println("An error happened");
			}
			
		}
		
	}
	
=======
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
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
}
