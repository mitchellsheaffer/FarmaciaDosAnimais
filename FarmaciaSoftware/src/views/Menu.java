package views;

import controllers.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import models.City_Model;
import models.Product_Model;

/*
 * Main interface of the program
 * 
 * made by Philippe Ribeiro 
 * Department of Computer Science, University of Minnesota
 * Minneapolis, Minnesota, USA - 55455
 * 
 * 
 */
public class Menu extends JFrame implements ActionListener, ItemListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel displayLabel;
	private JMenuBar bar;
	
	/*
	 * constructor of the class Menu
	 */
	public Menu(){
		super("Farmacia dos Animais");
		
		/*
		 * Creates the bar to insert the menus
		 * 
		 */
		this.bar = new JMenuBar();
		setJMenuBar(this.bar);
		/*
		 * these functions add a new Menu to the menu bar ... 
		 */
		this.createRegisterMenu();
		this.createStockMenu();
		this.createProductMenu();
		this.createSalesMenu();
		this.createAccountsReceivable();
		
		//CYB·RT·XTRON Inc. · 
		displayLabel = new JLabel("Farmacia dos Animais", SwingConstants.CENTER);
		displayLabel.setForeground(Color.DARK_GRAY);
		displayLabel.setFont(new Font("Serif", Font.PLAIN, 72));
		
		getContentPane().setBackground(Color.GRAY);
		getContentPane().add(displayLabel, BorderLayout.CENTER);
		
		setSize(1200, 1200);
		setVisible(true);
	
 	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent event){
		
		Frameform frame = new Frameform("Activity");
	}
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	public void itemStateChanged(ItemEvent event){
		
	}
	public void createAccountsReceivable(){
		
		JMenu contasReceber = new JMenu("Contas a Receber");
		contasReceber.setMnemonic('F');
		
		JMenuItem novasContas = new JMenuItem("Novas Contas");
		novasContas.setMnemonic('A');
		contasReceber.add(novasContas);
		novasContas.addActionListener(
				
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){
						JOptionPane.showMessageDialog(Menu.this, "This is an example\nof using menus", "About", JOptionPane.PLAIN_MESSAGE);
					}
				});
		
		this.bar.add(contasReceber);
	}
	
	public void addMenuItemListener(JMenuItem item, JMenu menu){
		item.setMnemonic('A');
		menu.add(item);
		item.addActionListener(
				
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){

						java.awt.EventQueue.invokeLater(new Runnable() {

				            public void run() {
				            	City_Model model;
								try {
									model = new City_Model();
									new City_View(model).setVisible(true);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				            
				            }
				        });
					}});
	}

	public void addRegisterCity(JMenuItem item, JMenu menu){
		item.setMnemonic('A');
		menu.add(item);
		item.addActionListener(
				
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){

						java.awt.EventQueue.invokeLater(new Runnable() {

				            public void run() {
				            	try {
				            		City_Model model = new City_Model();
				            		City_View view = new City_View(model);
				            		
									City_Controller city = new City_Controller(model, view);
									city.displayCityView();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				                
				            }
				        });
					}
				}
			);
	}
	
	public void addRegisterEmployee(JMenuItem item, JMenu menu){
		item.setMnemonic('A');
		menu.add(item);
		item.addActionListener(
				
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){

						java.awt.EventQueue.invokeLater(new Runnable() {

				            public void run() {
				                new Employee_View().setVisible(true);
				            }
				        });
					}});
	}
	
	public void addRegisterProduct(JMenuItem item, JMenu menu){
		item.setMnemonic('A');
		menu.add(item);
		item.addActionListener(
				
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){

						java.awt.EventQueue.invokeLater(new Runnable() {

				            public void run() {
				            	try {
				            		Product_Model model = new Product_Model();
				            		Product_View view = new Product_View(model);
				            		
									Product_Controller city = new Product_Controller(model, view);
									city.displayProductView();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				            }
				        });
					}});
	}
	public void addRegisterSeller(JMenuItem item, JMenu menu){
		item.setMnemonic('A');
		menu.add(item);
		item.addActionListener(
				
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){

						java.awt.EventQueue.invokeLater(new Runnable() {

				            public void run() {
				                new Seller_View().setVisible(true);
				            }
				        });
					}});
	}
	
	/*
	 * Used the "Register Membership", which could be a new employee, a new product or a new sale
	 * implements a ActionListener, to perform a action when the user requires
	 */
	public void createRegisterMenu(){
		
		JMenu register = new JMenu("Cadastro");
		register.setMnemonic('F');
		
		/*
		 * adds the city item to the menu Cadastro
		 */
		JMenuItem cidade = new JMenuItem("Cidade");
		this.addRegisterCity(cidade, register);
		
		/*
		 * adds a new activity
		 */
		JMenuItem ramoAtividade = new JMenuItem("Ramo de Atividade");
		this.addMenuItemListener(ramoAtividade, register);
		
		/*
		 * add a new payment method
		 */
		JMenuItem formaPagamento = new JMenuItem("Forma de Pagamento");
		this.addMenuItemListener(formaPagamento, register);
		
		/*
		 * adds a new seller
		 * stops here
		 */
		
		JMenuItem sellers = new JMenuItem("Vendedores");
		this.addRegisterSeller(sellers, register);
		
		/*
		 * adds new products
		 */
		
		JMenuItem products = new JMenuItem("Produtos");
		this.addRegisterProduct(products, register);
		
		/*
		 * adds forms of payment
		 */
		JMenuItem paymentMethods = new JMenuItem("Formas de Recebimento");
		this.addMenuItemListener(paymentMethods, register);
		
		/*
		 * adds new Clients 
		 */
		JMenuItem clients = new JMenuItem("Clientes");
		this.addMenuItemListener(clients, register);
		
		/*
		 * adds new account register
		 */
		JMenuItem registerAccount = new JMenuItem("Cadastro de Conta");
		this.addMenuItemListener(registerAccount, register);
		
		/*
		 * adds new account plan
		 */
		JMenuItem accountPlan = new JMenuItem("Plano de Conta");
		this.addMenuItemListener(accountPlan, register);
		
		/*
		 * add a new kind of payment
		 */
		JMenuItem paymentForms = new JMenuItem("Tipo de Pagamento");
		this.addMenuItemListener(paymentForms, register);
		
		/*
		 * Suppliers
		 */
		
		JMenuItem suppliers = new JMenuItem("Fornecedores");
		this.addMenuItemListener(suppliers, register);
		
		/*
		 * register a new employee
		 */
		
		JMenuItem registerEmployees = new JMenuItem("Cadastro de Funcionarios");
		this.addRegisterEmployee(registerEmployees, register);
		
		/*
		 * option to close the program
		 */
		JMenuItem exitItem = new JMenuItem("Saida");
		exitItem.setMnemonic('x');
		register.add(exitItem);
		exitItem.addActionListener(
				new ActionListener(){			
					public void actionPerformed(ActionEvent event){
						System.exit(0);
					}
				});
		
		this.bar.add(register);
	}
	
	/*
	 * creates the Stock menu (Estoque, in Portuguese)
	 */
	public void createStockMenu(){
		JMenu estoque = new JMenu("Estoque");
		estoque.setMnemonic('A');
		
		JMenuItem produtosEstoque = new JMenuItem("Produtos em estoque");
		estoque.add(produtosEstoque);
		
		JMenuItem codigoProduto = new JMenuItem("Codigo Produto");
		estoque.add(codigoProduto);
		
		this.bar.add(estoque);
	}
	
	/*
	 * 
	 * creates the Sales Menu
	 */
	public void createSalesMenu(){
		
		JMenu vendas = new JMenu("Vendas");
		vendas.setMnemonic('F');
		
		JMenuItem sales = new JMenuItem("Vendas");
		vendas.add(sales);
		
		sales.setMnemonic('A');
		vendas.add(sales);
		sales.addActionListener(
				
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){

						java.awt.EventQueue.invokeLater(new Runnable() {

				            public void run() {
				                new Sales_View().setVisible(true);
				            }
				        });
					}});
		
		this.bar.add(vendas);
	}
	
	/*
	 * creates the product Menu
	 */
	public void createProductMenu(){
		JMenu produtos = new JMenu("Faturamento");
		produtos.setMnemonic('F');
		
		JMenuItem aboutItem = new JMenuItem("Veterinarios");
		aboutItem.setMnemonic('A');
		produtos.add(aboutItem);
		aboutItem.addActionListener(
				
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){
						JOptionPane.showMessageDialog(Menu.this, "Produtos Veterinarios", "About", JOptionPane.PLAIN_MESSAGE);
					}
				});
		
		/*
		 * adds a new tab called produtos agropecuarios
		 * 
		 */
		JMenuItem  agropecuarios = new JMenuItem("Agropecuarios");
		agropecuarios.setMnemonic('A');
		produtos.add(agropecuarios);
		aboutItem.addActionListener(
				
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){
						JOptionPane.showMessageDialog(Menu.this, "Produtos agropecuarios", "About", JOptionPane.PLAIN_MESSAGE);
					}
				});
		
		JMenuItem saudeAnimal = new JMenuItem("Saude animal");
		aboutItem.setMnemonic('A');
		produtos.add(saudeAnimal);
		aboutItem.addActionListener(
				
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){
						JOptionPane.showMessageDialog(Menu.this, "This is an example\nof using menus", "About", JOptionPane.PLAIN_MESSAGE);
					}
				});
		
		this.bar.add(produtos);
	}
	
	public static void main(String args[]){
		Menu application = new Menu();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}