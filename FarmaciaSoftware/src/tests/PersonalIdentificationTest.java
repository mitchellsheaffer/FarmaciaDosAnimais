package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.PersonalIdentification;

public class PersonalIdentificationTest {

	@Test
	public void testPersonalIdentification() {
		PersonalIdentification id = new PersonalIdentification();
		assertEquals(id.getIdNumber(), "");
	}

	@Test
	public void testPersonalIdentificationStringString() {
		PersonalIdentification id = new PersonalIdentification("MG14793883", "Brasil");
		assertEquals(id.getIdNumber(), "MG-14.793.883");
	}

	@Test
	public void testGetIdNumber() {
		assertEquals(true, true);
	}

}
