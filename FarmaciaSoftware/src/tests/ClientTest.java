package tests;
import classes.*;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Client;

public class ClientTest {

	@Test
	public void testClient() {
		Client client = new Client();
		assertEquals((int)client.getClientId(), 0);
		assertEquals(client.getClientSocialSecurity().getSocialSecurityNumber(), "");
		assertEquals(client.getClientStateId().getIdNumber(), "");
	}

	@Test
	public void testClientNameTelephoneAddressStringSocialSecurityPersonalIdentificationIntegerBirthday() {
		Client client = new Client(new Name(), new Telephone(),new Address(), "ribeiro.phillipe@gmail.com", new SocialSecurity("79388360607", "Brasil"), new PersonalIdentification("MG14793883", "Brasil"), 1,
				new Birthday());
		assertEquals(client.getClientSocialSecurity().getSocialSecurityNumber(), "793.883.606-07");
		assertEquals((int)client.getClientId(), 1);
		assertEquals(client.getClientStateId().getIdNumber(), "MG-14.793.883");
	}

	@Test
	public void testSetClientId() {
		Client client = new Client();
		client.setClientId(10);
		assertEquals((int)client.getClientId(), 10);
		
		client.setClientId(-10);
		assertEquals((int)client.getClientId(), 0);
	}

	@Test
	public void testSetClientPersonalIdentification() {
		Client client = new Client();
		client.setClientPersonalIdentification(new PersonalIdentification("MG14793883", "Brasil"));
		assertEquals(client.getClientStateId().getIdNumber(), "MG-14.793.883");
		
	}

	@Test
	public void testSetClientSocialSecurityNumber() {
		Client client = new Client();
		client.setClientSocialSecurityNumber(new SocialSecurity("79388360607", "Brasil"));	
		assertEquals(client.getClientSocialSecurity().getSocialSecurityNumber(), "793.883.606-07");
	}
	
	public void testSetClientBalance(){
		Client client = new Client();
		client.addToBalance(140.10);
		assertEquals((double)client.getClientBalance(), 140.10, 0.01);
		
		client.addToBalance(-10.50);
		assertEquals((double)client.getClientBalance(), 140.10, 0.01);
	}
	
	public void testClientFormatToString(){
		Locality loc = new Locality("Centro", "Espinosa", "Minas Gerais", "Brasil");
		Client client = new Client(new Name("Philippe", "Gabriel", "Souza Moraes Ribeiro"), new Telephone("3838121453", "Brasil"), 
				new Address(449, "Avenida Dr Jose Cangussu", "39510000", loc), "ribeiro.phillipe@gmail.com", new SocialSecurity("79388360607", "Brasil"), new PersonalIdentification("MG14793883", "Brasil"), 1,
				new Birthday(8,2,1989));
		String fmt = client.formatToString();
		assertEquals("'Philippe Gabriel Souza Moraes Ribeiro, '449 Avenida Dr Jose Cangussu, Centro, Espinosa, Minas Gerais, Brasil - 39510000', '(38) 3812-1453', '8/2/1989', 'ribeiro.phillipe@gmail.com', " +
				"'793.883.606-07', 'MG-14.793.883', '0.0'", fmt);
	}

}
