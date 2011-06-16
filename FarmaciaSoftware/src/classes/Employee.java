package classes;
/*
 * class written by Philippe Gabriel Souza Moraes Ribeiro
 * Department of Computer Science, University of Minnesota
 * Minneapolis, Minnesota, USA - 55455
 * 
 * Defines the Employee ... a 
 */
public class Employee extends Person{

	/*
	 * different format: country = brazil;
	 */
	private SocialSecurity socialSecurityNumber;
	/*
	 * This object may be replaced by Salary,
	 * so Salary is wage * hours ... 
	 * and the employee may be paid also by month, instead by hours
	 */
	private Salary salary;
	/*
	 * 
	 */
	private Date startingDate;
	/*
	 * 
	 */
	private Boolean previousEmployed;

	private Integer employeeId;
	
	public Employee() {
		super();
		this.socialSecurityNumber = new SocialSecurity();
		this.salary = new Salary();
		this.startingDate = new Date();
		this.previousEmployed = false;
		this.employeeId = 0;
	}
	
	public Employee(Birthday birthday, Name name, SocialSecurity number, Salary salary, Telephone telephone, Address address, String email, boolean employed, Date start) {
		super(name, telephone, address, email, birthday);
		this.setEmployeeSocialSecurityNumber(number);
		this.setEmployeeSalary(salary);
		this.setPreviousEmployed(employed);
		this.setStartingDate(start);
	}
	
	public void setStartingDate(Date start){
		this.startingDate = start;
	}
	public void setPreviousEmployed(boolean answer){
		this.previousEmployed = answer;
	}
	public void setEmployeeSalary(Salary salary) {
		// TODO Auto-generated method stub
		this.salary = salary;
	}
	
	public Date getStartingDate(){
		return this.startingDate;
	}

	private void setEmployeeSocialSecurityNumber(SocialSecurity number) {
		// TODO Auto-generated method stub
		this.socialSecurityNumber = number;
		
	}
	
	public int getEmployeeId(){
		return this.employeeId;
	}
	
	public void setEmployeeId(int id){
		this.employeeId = id;
	}

	public Salary getEmployeeSalary(){
		return this.salary;
	}
	
	public SocialSecurity getEmployeeSocialSecurityNumber(){
		return this.socialSecurityNumber;
	}
	
	public Boolean getPreviousEmployed(){
		return this.previousEmployed;
	}
	
	
	public String getEmployeeEmail(){
		return this.getPersonEmail();
	}
	
	public Date getEmployeeStartingDay(){
		return this.startingDate;
	}
	public String formatToString(){
		Address add = this.getPersonAddress();
		Locality loc = add.getAddressLocality();
		/*
		 * the other is:
		 * id, name, address, birthday, telephone, email, previous employed, salary, starting date, 
		 * region, city, state, country, 
		 * 
		 */
		String employee =	super.formatToString()  + ", " + 
							this.getPreviousEmployed().toString() + ", " +
							this.getEmployeeSocialSecurityNumber().getSocialSecurityNumber() + ", " + 
							this.salary.formatToString() + ", " + 
							this.startingDate.formatToString() + ", " + 
							loc.getRegion() + ", " + 
							loc.getCity() + ", " +
							loc.getState() + ", " +
							loc.getCountry() + ", ";
		
		return employee;
	}
	
}
