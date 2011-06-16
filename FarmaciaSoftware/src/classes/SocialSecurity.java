package classes;

public class SocialSecurity {

	private String socialSecurityNumber;
	
	public SocialSecurity(){
		
		this.socialSecurityNumber = "";
	}
	
	public SocialSecurity(String numbers, String country){
		
		if(country.equals("Brasil")){
			this.setSocialBrazilianFormat(numbers);
		}
		else if(country.equals("United States of America")){
			this.setSocialUSAFormat(numbers);
		}
		else{
			this.socialSecurityNumber = "";
		}
	}
	
	/*
	 * numbers is in the format xxxxxxxxxx
	 */
	public void setSocialBrazilianFormat(String numbers){
		/*
		 * regular expression that formats to 
		 * xxx.xxx.xxx - xx
		 */
		String fNum = "";
		numbers.replaceAll("[^0-9]", "");
		if(11 == numbers.length()){
		    fNum = numbers.substring(0, 3);
		    fNum += "." + numbers.substring(3, 6);
		    fNum += "." + numbers.substring(6, 9);
		    fNum += "-" + numbers.substring(9, 11);
		        
		 }
		 else{
		    System.out.println("Invalid Social Number.");
		    this.socialSecurityNumber = "";
		 }
		 
		 this.socialSecurityNumber = fNum;   
	}
	
	/*
	 * regular expression that formats to
	 * xxx - xx - xxxx
	 */
	public void setSocialUSAFormat(String numbers){
		String fNum = null;
		numbers.replaceAll("[^0-9]", "");
		 
	   if(9 == numbers.length()){
		   fNum = numbers.substring(0, 3);
		   fNum += "-" + numbers.substring(3, 5) ;
		   fNum += "-" + numbers.substring(5, 9);
		}
		else{
		        System.out.println("Invalid Social Number.");
		        this.socialSecurityNumber = "";
		}
		 
	   this.socialSecurityNumber = fNum;
	}
	
	/*
	 * returns the social security number
	 */
	public String getSocialSecurityNumber(){
		return this.socialSecurityNumber;
	}
}
