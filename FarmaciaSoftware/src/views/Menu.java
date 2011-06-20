package views;
<<<<<<< HEAD

=======
import classes.*;
import models.*;
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
import controllers.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

<<<<<<< HEAD
import models.City_Model;
import models.Product_Model;

=======
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
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
<<<<<<< HEAD
	
=======
	private JCheckBoxMenuItem styleItems[];
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
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
		
<<<<<<< HEAD
		//CYB·RT·XTRON Inc. · 
=======
		//CYBï¿½RTï¿½XTRON Inc. ï¿½ 
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
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
<<<<<<< HEAD
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
=======
				                new City_View().setVisible(true);
				            }
				        });
					}});
					    /*
					    submit.addActionListener(new ActionListener() {
					      public void actionPerformed(ActionEvent e) {
					    	  Integer id = Integer.parseInt(form.getText(0));
					    	  String name = form.getText(1);
					    	  String unity = form.getText(2).toUpperCase();
					    	  Integer quantity = Integer.parseInt(form.getText(3));
					    	  Double priceCash = Double.parseDouble(form.getText(4));
					    	  Double priceTerm = Double.parseDouble(form.getText(5));
					    	  Double priceFinal = Double.parseDouble(form.getText(6));
					    	  String description = form.getText(7);
					    	  
					    	  Product product = new Product(id, name, unity, quantity, priceCash, priceTerm, priceFinal, description);
					    	  try {
								Product_Model model = new Product_Model();
								if(model.addNewProduct(product) == 0){
									JOptionPane.showMessageDialog(null, "Object added successfully", null, JOptionPane.PLAIN_MESSAGE);
								}
								else{
									JOptionPane.showMessageDialog(null, "There is an error in the input");
								}
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					    	  
					        
					      }
					    });
					    
					   close.addActionListener(new ActionListener() {
						   public void actionPerformed(ActionEvent e){
							   System.exit(0);
						   }
					   });
	
					    JFrame f = new JFrame("Text Form Example");
					    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					    f.getContentPane().add(form, BorderLayout.NORTH);
					    JPanel p = new JPanel();
					    p.add(submit);
					    p.add(close);
					    f.getContentPane().add(p, BorderLayout.SOUTH);
					    f.pack();
					    f.setVisible(true);
					    f.setSize(800, 600);
					  }*/
	}
	public void addSalesMenuItemListener(JMenuItem item, JMenu menu){
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		item.setMnemonic('A');
		menu.add(item);
		item.addActionListener(
				
				new ActionListener(){
					
<<<<<<< HEAD
=======
                                        @Override
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
					public void actionPerformed(ActionEvent event){

						java.awt.EventQueue.invokeLater(new Runnable() {

<<<<<<< HEAD
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
	
=======
                                            @Override
				            public void run() {
                                                Sales_View sale_View = new Sales_View();
				            }
				        });
			}});
                
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
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
	/*
	 * Used the "Register Membership", which could be a new employee, a new product or a new sale
	 * implements a ActionListener, to perform a action when the user requires
	 */
	public void createRegisterMenu(){
		
<<<<<<< HEAD
		JMenu register = new JMenu("Cadastro");
		register.setMnemonic('F');
=======
		JMenu cadastro = new JMenu("Cadastro");
		cadastro.setMnemonic('F');
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * adds the city item to the menu Cadastro
		 */
		JMenuItem cidade = new JMenuItem("Cidade");
<<<<<<< HEAD
		this.addRegisterCity(cidade, register);
=======
		this.addMenuItemListener(cidade, cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * adds a new activity
		 */
		JMenuItem ramoAtividade = new JMenuItem("Ramo de Atividade");
<<<<<<< HEAD
		this.addMenuItemListener(ramoAtividade, register);
=======
		this.addMenuItemListener(ramoAtividade, cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * add a new payment method
		 */
		JMenuItem formaPagamento = new JMenuItem("Forma de Pagamento");
<<<<<<< HEAD
		this.addMenuItemListener(formaPagamento, register);
		
		/*
		 * adds a new seller
		 * stops here
		 */
		
		JMenuItem sellers = new JMenuItem("Vendedores");
		this.addRegisterSeller(sellers, register);
=======
		this.addMenuItemListener(formaPagamento, cadastro);
		
		/*
		 * adds a new seller
		 */
		
		JMenuItem vendedores = new JMenuItem("Vendedores");
		this.addMenuItemListener(vendedores, cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * adds new products
		 */
		
<<<<<<< HEAD
		JMenuItem products = new JMenuItem("Produtos");
		this.addRegisterProduct(products, register);
=======
		JMenu produtos = new JMenu("Produtos");
		this.addMenuItemListener(produtos, cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * adds forms of payment
		 */
<<<<<<< HEAD
		JMenuItem paymentMethods = new JMenuItem("Formas de Recebimento");
		this.addMenuItemListener(paymentMethods, register);
=======
		JMenu formasPagamento = new JMenu("Formas de Recebimento");
		this.addMenuItemListener(formasPagamento, cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * adds new Clients 
		 */
<<<<<<< HEAD
		JMenuItem clients = new JMenuItem("Clientes");
		this.addMenuItemListener(clients, register);
=======
		JMenu clientes = new JMenu("Clientes");
		this.addMenuItemListener(clientes, cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * adds new account register
		 */
<<<<<<< HEAD
		JMenuItem registerAccount = new JMenuItem("Cadastro de Conta");
		this.addMenuItemListener(registerAccount, register);
=======
		JMenu cadastroContas = new JMenu("Cadastro de Conta");
		this.addMenuItemListener(cadastroContas, cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * adds new account plan
		 */
<<<<<<< HEAD
		JMenuItem accountPlan = new JMenuItem("Plano de Conta");
		this.addMenuItemListener(accountPlan, register);
=======
		JMenu planoConta = new JMenu("Plano de Conta");
		this.addMenuItemListener(planoConta, cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * add a new kind of payment
		 */
<<<<<<< HEAD
		JMenuItem paymentForms = new JMenuItem("Tipo de Pagamento");
		this.addMenuItemListener(paymentForms, register);
=======
		JMenu tipoPagamento = new JMenu("Tipo de Pagamento");
		this.addMenuItemListener(tipoPagamento, cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * Suppliers
		 */
		
<<<<<<< HEAD
		JMenuItem suppliers = new JMenuItem("Fornecedores");
		this.addMenuItemListener(suppliers, register);
=======
		JMenu fornecedores = new JMenu("Fornecedores");
		this.addMenuItemListener(fornecedores, cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * register a new employee
		 */
		
<<<<<<< HEAD
		JMenuItem registerEmployees = new JMenuItem("Cadastro de Funcionarios");
		this.addRegisterEmployee(registerEmployees, register);
=======
		JMenu cadastroFuncionario = new JMenu("Cadastro de Funcionarios");
		this.addRegisterEmployee(cadastroFuncionario, cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
		/*
		 * option to close the program
		 */
		JMenuItem exitItem = new JMenuItem("Saida");
		exitItem.setMnemonic('x');
<<<<<<< HEAD
		register.add(exitItem);
=======
		cadastro.add(exitItem);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		exitItem.addActionListener(
				new ActionListener(){			
					public void actionPerformed(ActionEvent event){
						System.exit(0);
					}
				});
		
<<<<<<< HEAD
		this.bar.add(register);
=======
		this.bar.add(cadastro);
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
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
		
<<<<<<< HEAD
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
=======
                JMenuItem sales = new JMenuItem("Sales");
                sales.setMnemonic('A');
                vendas.add(sales);
                this.addSalesMenuItemListener(sales, vendas);
                sales.addActionListener(
                        new ActionListener(){
						
                            @Override
                            public void actionPerformed(ActionEvent event){
                                Sales_View sales_View = new Sales_View();
                            }
                        });
                
		JMenuItem mercadoria = new JMenuItem("mercadoria");
		mercadoria.setMnemonic('A');
		vendas.add(mercadoria);
		vendas.addActionListener(
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){
						JOptionPane.showMessageDialog(Menu.this, "Produtos Veterinarios", "About", JOptionPane.PLAIN_MESSAGE);
					}
				});
>>>>>>> eadc923cd8718cdc6d96396a8161c62d94b0338f
		
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