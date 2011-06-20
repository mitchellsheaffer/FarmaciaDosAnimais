package classes;

/*
 *  * class successful tested by
 * Philippe Ribeiro, in June 11th, 2011
 * 
 * this class defines all the products into the store.
 * 
 * productId : Integer
 * 
 * 
 */
public class Product {
	
	/*
	 * defines the product id
	 */
	private Integer productId;
	/*
	 * defines the product name i.e "Ivomec 50ml"
	 */
	private String productName;
	/*
	 * which unity format is the product (UN, PCT, FC)
	 */
	private String productUnity;
	/*
	 * price if the customer pays in cash
	 */
	private Double productPriceInCash;
	/*
	 * price if the customer uses credit
	 */
	private Double productPriceInTerm;
	/*
	 * final price's sale
	 */
	private Double productFinalPrice;
	/*
	 * describes the fitting of the product
	 */
	private String productDescription;
	
	private final String unities[] = {"UN", "PCT", "FC"};
	
	/*
	 * default constructor, assigns default values
	 */
	public Product(){
		this.productId = 0;
		this.productName = "";
		this.productUnity = "UN";
		this.productPriceInCash = 0.00;
		this.productPriceInTerm = 0.00;
		this.productFinalPrice = 0.00;
		this.productDescription = "";
	}
	
	/*
	 * overrode constructor
	 */
	public Product(Integer id, String name, String unity, Double priceCash, Double priceTerm, Double finalPrice, String description){
		this.setProductId(id);
		this.setProductName(name);
		this.setProductUnity(unity);
		this.setProductPriceCash(priceCash);
		this.setProductPriceTerm(priceTerm);
		this.setProductDescription(description);
		this.setProductFinalPrice(finalPrice);
	}

	public void setProductFinalPrice(Double finalPrice) {
		// TODO Auto-generated method stub
		if(finalPrice >= 0.00){
			this.productFinalPrice = finalPrice;
		}
		else{
			this.productFinalPrice = 0.00;
		}
		
	}

	public void setProductDescription(String description) {
		// TODO Auto-generated method stub
		this.productDescription = description;
		
	}

	public void setProductPriceTerm(Double priceTerm) {
		// TODO Auto-generated method stub
		if(priceTerm >= 0.00){
			this.productPriceInTerm = priceTerm;
		}
		else{
			this.productPriceInTerm = 0.00;
		}
		
	}

	public void setProductPriceCash(Double priceCash) {
		// TODO Auto-generated method stub
		if(priceCash >= 0.00){
			this.productPriceInCash = priceCash;
		}
		else{
			this.productPriceInCash = 0.00;
		}
	}


	public void setProductName(String name) {
		// TODO Auto-generated method stub
		this.productName = name;
		
	}

	public void setProductUnity(String unity) {
		// TODO Auto-generated method stub
		/*
		 * checks if the unity as valid;
		 */
		for(String un : this.unities){
			if(unity.equals(un)){
				this.productUnity = unity;
			}
		}
		
	}


	public void setProductId(Integer id) {
		// TODO Auto-generated method stub
		
		if(id > 0){
			this.productId = id;
		}
		else{
			this.productId = 0;
		}
		
	}
	
	public Integer getProductId(){
		return this.productId;
	}
	
	public String  getProductName(){
		return this.productName;
	}
	
	public String getProductUnity(){
		return this.productUnity;
	}
	
	public Double getProductPriceInCash(){
		return this.productPriceInCash;
	}
	
	public Double getProductPriceInTerm(){
		return this.productPriceInTerm;
	}
	
	public String getProductDescription(){
		return this.productDescription;
	}
	
	public Double getProductFinalPrice(){
		return this.productFinalPrice;
	}
	
	public String formatToString(){
		String product;
		product = "'" + this.getProductName() + "', '" + this.getProductUnity() + "', " + 
		this.getProductPriceInCash() + ", " + this.getProductPriceInTerm() + ", " +  this.getProductFinalPrice() + ", '" + this.getProductDescription() +"'";
		
		return product;
	}
}

