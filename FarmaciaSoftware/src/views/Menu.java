package views;
import classes.*;
import models.*;
import controllers.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

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
	private JCheckBoxMenuItem styleItems[];
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
	/*
	 * Used the "Register Membership", which could be a new employee, a new product or a new sale
	 * implements a ActionListener, to perform a action when the user requires
	 */
	public void createRegisterMenu(){
		
		JMenu cadastro = new JMenu("Cadastro");
		cadastro.setMnemonic('F');
		
		/*
		 * adds the city item to the menu Cadastro
		 */
		JMenuItem cidade = new JMenuItem("Cidade");
		this.addMenuItemListener(cidade, cadastro);
		
		/*
		 * adds a new activity
		 */
		JMenuItem ramoAtividade = new JMenuItem("Ramo de Atividade");
		this.addMenuItemListener(ramoAtividade, cadastro);
		
		/*
		 * add a new payment method
		 */
		JMenuItem formaPagamento = new JMenuItem("Forma de Pagamento");
		this.addMenuItemListener(formaPagamento, cadastro);
		
		/*
		 * adds a new seller
		 */
		
		JMenuItem vendedores = new JMenuItem("Vendedores");
		this.addMenuItemListener(vendedores, cadastro);
		
		/*
		 * adds new products
		 */
		
		JMenu produtos = new JMenu("Produtos");
		this.addMenuItemListener(produtos, cadastro);
		
		/*
		 * adds forms of payment
		 */
		JMenu formasPagamento = new JMenu("Formas de Recebimento");
		this.addMenuItemListener(formasPagamento, cadastro);
		
		/*
		 * adds new Clients 
		 */
		JMenu clientes = new JMenu("Clientes");
		this.addMenuItemListener(clientes, cadastro);
		
		/*
		 * adds new account register
		 */
		JMenu cadastroContas = new JMenu("Cadastro de Conta");
		this.addMenuItemListener(cadastroContas, cadastro);
		
		/*
		 * adds new account plan
		 */
		JMenu planoConta = new JMenu("Plano de Conta");
		this.addMenuItemListener(planoConta, cadastro);
		
		/*
		 * add a new kind of payment
		 */
		JMenu tipoPagamento = new JMenu("Tipo de Pagamento");
		this.addMenuItemListener(tipoPagamento, cadastro);
		
		/*
		 * Suppliers
		 */
		
		JMenu fornecedores = new JMenu("Fornecedores");
		this.addMenuItemListener(fornecedores, cadastro);
		
		/*
		 * register a new employee
		 */
		
		JMenu cadastroFuncionario = new JMenu("Cadastro de Funcionarios");
		this.addRegisterEmployee(cadastroFuncionario, cadastro);
		
		/*
		 * option to close the program
		 */
		JMenuItem exitItem = new JMenuItem("Saida");
		exitItem.setMnemonic('x');
		cadastro.add(exitItem);
		exitItem.addActionListener(
				new ActionListener(){			
					public void actionPerformed(ActionEvent event){
						System.exit(0);
					}
				});
		
		this.bar.add(cadastro);
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
		
		JMenuItem mercadoria = new JMenuItem("mercadoria");
		mercadoria.setMnemonic('A');
		vendas.add(mercadoria);
		vendas.addActionListener(
				new ActionListener(){
					
					public void actionPerformed(ActionEvent event){
						JOptionPane.showMessageDialog(Menu.this, "Produtos Veterinarios", "About", JOptionPane.PLAIN_MESSAGE);
					}
				});
		
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