package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import classes.SocialSecurity;

public class SocialSecurityTest {

	@Test
	public void testSocialSecurity() {
		SocialSecurity number = new SocialSecurity();
		assertEquals(number.getSocialSecurityNumber(), "");
	}

	@Test
	public void testSocialSecurityStringString() {
		SocialSecurity number = new SocialSecurity("79488360607", "Brasil");
		assertEquals(number.getSocialSecurityNumber(), "794.883.606-07");
		
		SocialSecurity number2 = new SocialSecurity("516471405", "United States of America");
		assertEquals(number2.getSocialSecurityNumber(), "516-47-1405");
	}

	@Test
	public void testSetSocialBrazilianFormat() {
		SocialSecurity number = new SocialSecurity();
		number.setSocialBrazilianFormat("79488360607");
		assertEquals(number.getSocialSecurityNumber(), "794.883.606-07");
	}

	@Test
	public void testSetSocialUSAFormat() {
		SocialSecurity number2 = new SocialSecurity();
		number2.setSocialUSAFormat("516471405");
		assertEquals(number2.getSocialSecurityNumber(), "516-47-1405");
	}

	@Test
	public void testGetSocialSecurityNumber() {
		assertEquals(true, true);
	}

}
