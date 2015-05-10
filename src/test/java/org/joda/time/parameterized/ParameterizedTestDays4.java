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
public class ParameterizedTestDays4 extends TestCase {
 
	@Parameters(name = "start and end MonthDay: ")
	public static Iterable<MonthDay> data() {
		return Arrays.asList(new MonthDay[] {(2,1), (2,28), (2, 28), (2,29) }); 
	}

	// two parameters
	private final MonthDay start;
	private final MonthDay end;

	// constructor
	public TestDaysParameters(final MonthDay start, final MonthDay end) {
		this.start = start;
		this.end = end;
	}

	@Test
	 public void testFactory_daysBetween_RPartial_MonthDay() {
        assertEquals(27, Days.daysBetween(start, end).getDays());
        assertEquals(28, Days.daysBetween(start, end).getDays());
        assertEquals(0, Days.daysBetween(start, end).getDays());
        assertEquals(1, Days.daysBetween(start, end).getDays());
        
        assertEquals(-27, Days.daysBetween(end, start).getDays());
        assertEquals(-28, Days.daysBetween(end, start).getDays());
        assertEquals(0, Days.daysBetween(end, start).getDays());
        assertEquals(-1, Days.daysBetween(end, start).getDays());
    }      

}
    
