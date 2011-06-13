package classes;

public class Person {

	private Name name;
	private Telephone telephone;
	private Address address;
	private String email;
	private Birthday birthday;
	
	public Person(){
		this.name = new Name();
		this.telephone = new Telephone();
		this.address = new Address();
		this.birthday = new Birthday();
		this.email = "";
	}
	
	public Person(Name name, Telephone telephone, Address address, String email, Birthday birthday){
		this.setPersonName(name);
		this.setPersonTelephone(telephone);
		this.setPersonAddress(address);
		this.setPersonEmail(email);
		this.setPersonBirthday(birthday);
	}

	public void setPersonBirthday(Birthday birthday) {
		// TODO Auto-generated method stub
		this.birthday = birthday;
		
	}

	public void setPersonEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
	}

	public void setPersonAddress(Address address) {
		// TODO Auto-generated method stub
		this.address = address;
	}

	public void setPersonTelephone(Telephone telephone) {
		// TODO Auto-generated method stub
		this.telephone = telephone;
	}

	public void setPersonName(Name name) {
		// TODO Auto-generated method stub
		this.name = name;	
	}
	
	public Birthday getPersonBirthday(){
		return this.birthday;
	}
	
	public Address getPersonAddress(){
		return this.address;
	}
	public Telephone getPersonTelephone(){
		return this.telephone;
	}
	public Name getPersonName(){
		return this.name;
	}
	public String getPersonEmail(){
		return this.email;
	}
	
	public String formatToString(){
		String person = "'" + this.name.formatToString() + "', '" + this.address.formatToString()  + "', '"  
		+ this.telephone.getTelephone() + "', '" + this.birthday.formatToString()  + "', '" + this.getPersonEmail() + "'";
		
		return person;
	}
}
