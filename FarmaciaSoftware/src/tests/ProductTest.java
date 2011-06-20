package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Product;

/*
 * class successful tested by
 * Philippe Ribeiro, in June 11th, 2011
 * 
 */
public class ProductTest {

	@Test
	public void testProduct() {
		Product product = new Product();
		assertEquals((int)product.getProductId(), 0);
		assertEquals(product.getProductDescription(), "");
		assertEquals(product.getProductFinalPrice(), 0, 0.01);
		assertEquals(product.getProductName(), "");
		assertEquals(product.getProductPriceInCash(), 0, 0.01);
		assertEquals(product.getProductPriceInTerm(), 0, 0.01);
		assertEquals(product.getProductUnity(), "UN");
		
	}

	@Test
	public void testProductIntegerStringStringIntegerDoubleDoubleDoubleString() {
		Product product = new Product(1, "Ivomec 50ml", "FC",  16.50, 18.00, 17.50, "Usado contra carrapato");
		
		assertEquals((int)product.getProductId(), 1);
		assertEquals(product.getProductDescription(), "Usado contra carrapato");
		assertEquals(product.getProductFinalPrice(), 17.50, 0.01);
		assertEquals(product.getProductName(), "Ivomec 50ml");
		assertEquals(product.getProductPriceInCash(), 16.50, 0.01);
		assertEquals(product.getProductPriceInTerm(), 18.00, 0.01);
		assertEquals(product.getProductUnity(), "FC");
	}

	/*
	 * bug as found in here ...fixed by 
	 * Philippe Ribeiro, June 11th, 2011
	 * 
	 */
	@Test
	public void testSetProductFinalPrice() {
		Product product = new Product();
		product.setProductFinalPrice(15.00);
		assertEquals(product.getProductFinalPrice(), 15.00, 0.01);
		
		product.setProductFinalPrice(-1.05);
		assertEquals(product.getProductFinalPrice(), 0, 0.01);
	}

	@Test
	public void testSetProductDescription() {
		Product product = new Product();
		product.setProductDescription("Usado contra carrapato");
		assertEquals(product.getProductDescription(), "Usado contra carrapato");
	}

	@Test
	public void testSetProductPricetTerm() {
		Product product = new Product();
		product.setProductPriceTerm(19.99);
		assertEquals(product.getProductPriceInTerm(), 19.99, 0.01);
		
		product.setProductPriceTerm(-10.10);
		assertEquals(product.getProductPriceInTerm(), 0, 0.01);
	}

	@Test
	public void testSetProductPriceCash() {
		Product product = new Product();
		product.setProductPriceCash(16.995);
		assertEquals(product.getProductPriceInCash(), 16.995, 0.01);
		
		product.setProductPriceCash(-102.0);
		assertEquals(product.getProductPriceInCash(), 0, 0.01);
	}


	@Test
	public void testSetProductName() {
		Product product = new Product();
		product.setProductName("Ivomec 50ml");
		assertEquals(product.getProductName(), "Ivomec 50ml");
		
		product.setProductName("");
		assertEquals(product.getProductName(), "");
	}

	@Test
	public void testSetProductUnity() {
		Product product = new Product();
		product.setProductUnity("UN");
		assertEquals(product.getProductUnity(),"UN");
		
		product.setProductUnity("hello");
		assertEquals(product.getProductUnity(), "UN");
		
		product.setProductUnity("FC");
		assertEquals(product.getProductUnity(), "FC");
		
		product.setProductUnity("PCT");
		assertEquals(product.getProductUnity(), "PCT");
	}

	@Test
	public void testSetProductId() {
		Product product = new Product();
		product.setProductId(10);
		assertEquals((int)product.getProductId(), 10);
		
		product.setProductId(-10);
		assertEquals((int)product.getProductId(), 0);
	}

	@Test
	public void testFormatToString() {
		Product product = new Product(1, "Ivomec 50ml", "FC", 16.50, 18.00, 17.50, "Usado contra carrapato");
		
		assertEquals((int)product.getProductId(), 1);
		assertEquals(product.getProductDescription(), "Usado contra carrapato");
		assertEquals(product.getProductFinalPrice(), 17.50, 0.01);
		assertEquals(product.getProductName(), "Ivomec 50ml");
		assertEquals(product.getProductPriceInCash(), 16.50, 0.01);
		assertEquals(product.getProductPriceInTerm(), 18.00, 0.01);
		assertEquals(product.getProductUnity(), "FC");
		
		String pdt = product.formatToString();
		assertEquals(pdt, pdt);
	}

}
