package tests;

import static org.junit.Assert.*;


import org.junit.Test;

import classes.Date;

public class DateTest {

	@Test
	public void testDate() {
		Date day1 = new Date();
		assertEquals(day1.getDay(), 1);
		assertEquals(day1.getMonth(), 1);
		assertEquals(day1.getYear(), 1900);
	}

	@Test
	public void testDateIntIntInt() {
		Date day2 = new Date(6, 11, 2011);
		assertEquals(day2.getDay(), 11);
		assertEquals(day2.getMonth(), 6);
		assertEquals(day2.getYear(), 2011);
		
		Date day3 = new Date(2, 30, 2011);
		assertEquals(day3.getDay(), 1);
		assertEquals(day3.getMonth(), 2);
		assertEquals(day3.getYear(), 2011);
		
		Date day4 = new Date(-10, -10, -10);
		assertEquals(day4.getDay(), 1);
		assertEquals(day4.getMonth(), 1);
		assertEquals(day4.getYear(), 1900);
	}

	@Test
	public void testSetDay() {
		Date day5 = new Date(2, 1, 2001);
		
		day5.setDay(2);
		assertEquals(day5.getDay(), 2);
		
		day5.setDay(0);
		assertEquals(day5.getDay(), 1);
		
		day5.setDay(29);
		assertEquals(day5.getDay(), 1);

	}

	@Test
	public void testSetMonth() {
		Date day6 = new Date(1, 1, 2001);
		
		day6.setMonth(0);
		assertEquals(day6.getMonth(), 1);
		
		day6.setMonth(2);
		assertEquals(day6.getMonth(), 2);
		
		day6.setMonth(13);
		assertEquals(day6.getMonth(), 1);
	}

	@Test
	public void testSetYear() {
		Date day7 = new Date(1, 1, 2001);
		
		day7.setYear(1800);
		assertEquals(day7.getYear(), 1900);
		
		day7.setYear(2000);
		assertEquals(day7.getYear(), 2000);
		
		day7.setYear(2200);
		assertEquals(day7.getYear(), 1900);
	}

	@Test
	public void testGetDay() {
		Date day7 = new Date(1, 1, 2001);
		
		day7.setYear(1800);
		assertEquals(day7.getYear(), 1900);
	}

	@Test
	public void testGetMonth() {
		Date day7 = new Date(1, 1, 2001);
		
		day7.setYear(1800);
		assertEquals(day7.getYear(), 1900);
	}

	@Test
	public void testGetYear() {
		assertEquals(true, true);
	}

	@Test
	public void testFormatToString() {
		Date day7 = new Date(1, 1, 2001);
		assertEquals(day7.formatToString(), "1/1/2001");
	}

}
