package classes;

public class Client extends Person{

	private SocialSecurity socialSecurityNumber;
	private PersonalIdentification stateId;
	private Integer clientId;
	private Double clientBalance;
	
	public Client(){
		super();
		this.socialSecurityNumber = new SocialSecurity();
		this.stateId = new PersonalIdentification();
		this.clientId = 0;
		this.clientBalance = 0.0;
	}
	
	public Client(Name name, Telephone telephone, Address address, String email, SocialSecurity number, PersonalIdentification stateId, Integer id, Birthday birthday){
	
		super(name, telephone, address, email, birthday);
		this.setClientSocialSecurityNumber(number);
		this.setClientPersonalIdentification(stateId);
		this.setClientId(id);
		this.initBalance();
	}

	/*
	 * bug was found here. 
	 * Fixed by Philippe Ribeiro, June 12th 2011
	 */
	public void setClientId(Integer id) {
		// TODO Auto-generated method stub
		if(id > 0){
			this.clientId = id;
		}
		else{
			this.clientId = 0;
		}
	}

	public void setClientPersonalIdentification(PersonalIdentification stateId) {
		// TODO Auto-generated method stub
		this.stateId = stateId;
	}

	public void setClientSocialSecurityNumber(SocialSecurity number) {
		// TODO Auto-generated method stub
		this.socialSecurityNumber = number;
	}
	
	public Integer getClientId(){
		return this.clientId;
	}
	
	public SocialSecurity getClientSocialSecurity(){
		return this.socialSecurityNumber;
	}
	
	public PersonalIdentification getClientStateId(){
		return this.stateId;
	}
	
	public void addToBalance(Double value){
		if(value >= 0.0){
			this.clientBalance += value;
		}
		else{
			this.clientBalance += 0;
		}
	}
	
	public void initBalance(){
		this.clientBalance = 0.0;
	}
	public Double getClientBalance(){
		return this.clientBalance;
	}
	public String formatToString(){
		String client = super.formatToString() + ", '" + this.getClientSocialSecurity().getSocialSecurityNumber() + "', '" + this.getClientStateId().getIdNumber() + "', " +
		this.getClientBalance() + ", '" + super.getPersonAddress().getAddressLocality().getRegion() + "', '" + super.getPersonAddress().getAddressLocality().getCity() + "', '" + 
		super.getPersonAddress().getAddressLocality().getState() + "', '" + super.getPersonAddress().getAddressLocality().getCountry() + "'";
		
		return client;
	}
	
}
