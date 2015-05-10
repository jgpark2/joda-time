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
public class ParameterizedTestDays2 extends TestCase {
 
	@Parameters(name = "start and end LocalDate: ")
	public static Iterable<LocalDate> data() {
		return Arrays.asList(new DateTime[] {(2006,6,9), (2006,6,12), (2006,6,15) }); 
	}

	// two parameters
	private final LocalDate start;
	private final LocalDate end;

	// constructor
	public TestDaysParameters(final LocalDate start, final LocalDate end) {
		this.start = start;
		this.end = end;
	}

	@Test
	public void testFactory_daysBetween_RPartial_LocalDate() {
        assertEquals(3, Days.daysBetween(start, end).getDays());
        assertEquals(0, Days.daysBetween(start, start).getDays());
        assertEquals(0, Days.daysBetween(end, end).getDays());
        assertEquals(-3, Days.daysBetween(end, start).getDays());
    }      

}
    
