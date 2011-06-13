package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Address;
import classes.Birthday;
import classes.Locality;
import classes.Name;
import classes.Person;
import classes.Telephone;

public class PersonTest {

	@Test
	public void testPerson() {
		Person person = new Person();
		assertEquals(person.getPersonName().getFirstName(), "");
		assertEquals(person.getPersonName().getMiddleName(), "");
		assertEquals(person.getPersonName().getLastName(), "");
		
		assertEquals(person.getPersonEmail(), "");
		
		assertEquals(person.getPersonBirthday().getDay(), 1);
		assertEquals(person.getPersonBirthday().getMonth(), 1);
		assertEquals(person.getPersonBirthday().getYear(), 1900);
		
		assertEquals(person.getPersonTelephone().getTelephone(), "");
		
		assertEquals(person.getPersonAddress().getAddressNumber(), 0);
		assertEquals(person.getPersonAddress().getAddressStreetName(), "");
		assertEquals(person.getPersonAddress().getAddressZipCode(), "");

	}

	@Test
	public void testPersonNameTelephoneAddressStringBirthday() {
		Name name = new Name("Philippe", "Gabriel", "Souza Moraes Ribeiro");
		Telephone telephone = new Telephone("6129658329", "United States of America");
		Birthday birthday = new Birthday(8, 2, 1989);
		Locality locality = new Locality("Falcon Heights", "Saint Paul", "Minnesota","United States of America");
		Address address = new Address(1855, "Larpenteur Avenue West apt 6", "55113", locality);
		Person philippe = new Person(name, telephone, address, "ribei017@umn.edu", birthday);
		
		assertEquals(philippe.getPersonTelephone().getTelephone(), "(612) 965-8329");
		assertEquals(philippe.getPersonBirthday().formatToString(), "8/2/1989"); 
		//assertEquals(philippe.getPersonAddress().formatToString(), "1855 Larpenteur Avenue West, Falcon Heights, Saint Paul, Minnesota, United States of America - 55113");
		
	}

	@Test
	public void testSetPersonBirthday() {
		Person person = new Person();
		person.setPersonBirthday(new Birthday(12,29, 1989));
		
		assertEquals(person.getPersonBirthday().formatToString(), "12/29/1989");
		
	}

	@Test
	public void testSetPersonEmail() {
		Person person = new Person();
		person.setPersonEmail("ribei017@umn.edu");
		assertEquals(person.getPersonEmail(), "ribei017@umn.edu");
	}

	@Test
	public void testSetPersonAddress() {
		Locality locality = new Locality("Falcon Heights", "Saint Paul", "Minnesota","United States of America");
		Address address = new Address(1855, "Larpenteur Avenue West apt #6", "55113", locality);
		
		Person person = new Person();
		person.setPersonAddress(address);
		assertEquals(person.getPersonAddress().formatToString(), "1855 Larpenteur Avenue West apt #6, Falcon Heights, Saint Paul, Minnesota, United States of America - 55113");

	}

	@Test
	public void testSetPersonTelephone() {
		Person person = new Person();
		Telephone telephone = new Telephone("6129658329", "United States of America");
		person.setPersonTelephone(telephone);
		
		assertEquals(person.getPersonTelephone().getTelephone(), "(612) 965-8329");
	}

	@Test
	public void testSetPersonName() {
		Name name = new Name("Philippe", "Gabriel", "Souza Moraes Ribeiro");
		Person person = new Person();
		person.setPersonName(name);
		assertEquals(person.getPersonName().formatToString(), "Philippe Gabriel Souza Moraes Ribeiro");
	}

	@Test
	public void testFormatToString() {
		Name name = new Name("Philippe", "Gabriel", "Souza Moraes Ribeiro");
		Telephone telephone = new Telephone("6129658329", "United States of America");
		Birthday birthday = new Birthday(8, 2, 1989);
		Locality locality = new Locality("Falcon Heights", "Saint Paul", "Minnesota","United States of America");
		Address address = new Address(1855, "Larpenteur Avenue West apt 6", "55113", locality);
		Person philippe = new Person(name, telephone, address, "ribei017@umn.edu", birthday);
		
		System.out.println(philippe.formatToString());
	}

}
