package org.joda.time;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Arrays;
 
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *  * This class is a parameterized Junit unit test for Days.
 *   */
@RunWith(Parameterized.class)
public class ParameterizedTestDays3 extends TestCase {
 
	@Parameters(name = "start and end YearMonth: ")
	public static Iterable<YearMonth> data() {
		return Arrays.asList(new YearMonth[] {(2011, 1), (2012,1), (2011,3), (2012, 3) }); 
	}

	// two parameters
	private final YearMonth start;
	private final YearMonth end;

	// constructor
	public TestDaysParameters(final YearMonth start, final YearMonth end) {
		this.start = start;
		this.end = end;
	}

	@Test
	public void testFactory_daysBetween_RPartial_YearMonth() {
		assertEquals(59, Days.daysBetween(start, end).getDays());
        assertEquals(60, Days.daysBetween(start, end).getDays());
        assertEquals(-59, Days.daysBetween(end, start).getDays());
        assertEquals(-60, Days.daysBetween(end, start).getDays());
	}       

}
    
