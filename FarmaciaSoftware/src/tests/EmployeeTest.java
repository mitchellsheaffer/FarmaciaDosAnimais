package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Employee;

public class EmployeeTest {

	@Test
	public void testFormatToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testEmployee() {
		Employee employee = new Employee();
		
		assertEquals(employee.getEmployeeEmail(), "");
		assertEquals(employee.getEmployeeId(), 0);
		assertEquals(employee.getEmployeeSalary().getSalary(), 0, 0.01);
		assertEquals(employee.getEmployeeSocialSecurityNumber().getSocialSecurityNumber(), "");
		//assertEquals(employee.getPersonAddress().formatToString(), "");
		
	}

	@Test
	public void testEmployeeBirthdayNameSocialSecuritySalaryTelephoneAddressString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetStartingDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPreviousEmployed() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmployeeSalary() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetStartingDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeeId() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmployeeId() {
		fail("Not yet implemented");
	}

}
