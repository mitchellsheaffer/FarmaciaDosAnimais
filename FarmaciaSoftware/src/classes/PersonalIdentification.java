package classes;

public class PersonalIdentification {

	private String idNumber;
	
	public PersonalIdentification(){
		this.idNumber = "";
	}
	
	public PersonalIdentification(String id, String country){
		if(country.equals("Brasil")){
			this.setIdBrazilFormat(id);
		}
		else if(country.equals("United States of America")){
			this.setIdUSAFormat(id);
		}
		else{
			System.out.println("Unknown");
		}
	}

	//MG-14.793.883
	private void setIdUSAFormat(String id) {
		// TODO Auto-generated method stub
		this.idNumber = id;
	}

	private void setIdBrazilFormat(String id) {
		// TODO Auto-generated method stub
		String fNum = "";
		if(10 == id.length()){
		    fNum = id.substring(0, 2) + "-";
		    fNum += id.substring(2, 4) + ".";
		    fNum += id.substring(4, 7) + ".";
		    fNum += id.substring(7, 10);
		        
		 }
		 else{
		    System.out.println("Invalid Id Number.");
		    this.idNumber = "";
		 }
		 
		 this.idNumber = fNum;   
		
	}
	
	public String getIdNumber(){
		return this.idNumber;
	}
}
