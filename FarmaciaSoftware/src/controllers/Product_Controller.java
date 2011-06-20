package controllers;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import models.Product_Model;
import views.Product_View;

public class Product_Controller {

	private Product_View productView;
	private Product_Model productModel;
	
	public Product_Controller(Product_Model model, Product_View view){
		this.productModel = model;
		this.productView = view;
		
		view.addSaveListener(new SaveListener());
		view.addCloseListener(new CloseListener());	
	}
	
	public void displayProductView(){
		this.productView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.productView.setVisible(true);
	}
	
	class SaveListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	class CloseListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			productView.close();
		}
	}
=======
public class Product_Controller {

>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
}
