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
public class ParameterizedTestDays1 extends TestCase {
 
	@Parameters(name = "start and end DateTime: ")
	public static Iterable<DateTime> data() {
		return Arrays.asList(new DateTime[] {(2006,6,9,12,0,0,0,PARIS), (2006,6,12,12,0,0,0,PARIS), (2006,6,15,18,0,0,0,PARIS) }); 
	}

	// two parameters
	private final DateTime start;
	private final DateTime end;

	// constructor
	public TestDaysParameters(final DateTime start, final DateTime end) {
		this.start = start;
		this.end = end;
	}

	@Test
	public void testFactory_daysIn_RInterval() {
		assertEquals(0, Days.daysIn((ReadableInterval) null).getDays());
        assertEquals(3, Days.daysIn(new Interval(start, end)).getDays());
        assertEquals(0, Days.daysIn(new Interval(start, start)).getDays());
        assertEquals(0, Days.daysIn(new Interval(end, end)).getDays());
	}       

}
    
