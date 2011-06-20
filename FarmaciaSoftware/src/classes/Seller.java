package classes;
/*
 * class written by Philippe Gabriel Souza Moraes Ribeiro
 * Department of Computer Science, University of Minnesota
 * Minneapolis, Minnesota, USA - 55455 in June 12th, 2011
 * 
 * Class Seller, extends the class Employee ... 
 * a seller differs from a employee when the employer is paying commission
 * 
 */
public class Seller extends Employee{

	//the commission rate that is being paid to the seller
	private Double commissionRate;
	//the total sales performed by this seller during a 
	//a certain period of time
	private Double totalSales;
	//if the employer is paying commission
	private Boolean payingCommission;
	
	/*
	 * default constructor
	 */
	public Seller() {
		super();
		this.commissionRate = 0.00;
		this.totalSales = 0.00;
		this.payingCommission = false;
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * argument constructor
	 * @param: payingCommission : Boolean
	 * @param: employee : Employee
	 */
	public Seller(Boolean payingCommission, Employee employee){
		super(employee.getPersonBirthday(), employee.getPersonName(), employee.getEmployeeSocialSecurityNumber(),
				employee.getEmployeeSalary(), employee.getPersonTelephone(), employee.getPersonAddress(), employee.getEmployeeEmail(), employee.getPreviousEmployed(),
				employee.getEmployeeStartingDay());
		
		this.setPayingCommission(payingCommission);
	}


	/*
	 * checks if the Employer is paying commission over the sales
	 * to the seller, and sets it to the field variable payingCommission;
	 * 
	 * @access: public
	 * @param: payingCommission : Boolean
	 * @return: void
	 */
	public void setPayingCommission(Boolean payingCommission) {
		// TODO Auto-generated method stub
		this.payingCommission = payingCommission;
		
	}
	
	/*
	 * if the employer is paying commission to the seller,
	 * then the employer can set the rate of the commission that he 
	 * is paying to the employer, and it will be reflected 
	 * 
	 * @access: public
	 * @param: rate : Double
	 * @return: void
	 */
	public void setCommissionRate(Double rate){
		//payingCommision must be true
		//in other to the seller get Commission
		if(this.payingCommission == true){
			this.commissionRate = rate;
		}
		else{
			this.commissionRate = 0.00;
		}
	}
	
	/*
	 * sets the total sales performed by a seller
	 * during certain period of time.
	 * 
	 * @access: public
	 * @param: sales : double
	 * @return: void
	 * 
	 */
	public void setTotalSales(Double sales){
		
		//if the total sales was valid
		if(sales > 0){
			this.totalSales = sales;
		}
		else{
			this.totalSales = 0.00;
		}
	}
	
	/*
	 * returns if the employer is paying commission to the seller
	 * @access : public
	 * @param: void
	 * @return: Boolean
	 */
	public Boolean getPayingCommission(){
		return this.payingCommission;
	}
	/*
	 * returns the seller's commission rate over the sales
	 * @access : public
	 * @param : void
	 * @return : Double
	 */
	public Double getCommissionRate(){
		return this.commissionRate;
	}
	/*
	 * returns the total sales performed by the seller
	 * during a certain period of time
	 * 
	 * @access : public
	 * @param: void
	 * @return : Double
	 */
	public Double getTotalSales(){
		return this.totalSales;
	}
	
	/*
	 * calculates the seller salary, based whether or not commission is being paid
	 * @access : public
	 * @param : void
	 * @return : Double
	 */
	public Double getSalary(){
		/*
		 * if commission if being paid, so define
		 * seller salary as base salary + totalsales * commissionrate;
		 */
		if(this.payingCommission == true){
			return super.getEmployeeSalary().getSalary() + this.totalSales* this.commissionRate;
		}
		//no commission is being paid
		else{
			return super.getEmployeeSalary().getSalary();
		}
	}
	

}
