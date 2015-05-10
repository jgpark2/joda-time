package org.joda.time.field;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateTimeZone;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.TimeOfDay;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.LenientDateTimeField;


public class TestStrictDateTimeField extends TestCase {

    //private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestStrictDateTimeField.class);
    }
    
    public TestStrictDateTimeField(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
    public void test_getInstance() {
        assertEquals(null, StrictDateTimeField.getInstance(null));
        
        LenientDateTimeField field = (LenientDateTimeField) new DelegatedDateTimeField(ISOChronology.getInstanceUTC().dayOfMonth());
        assertEquals(false, StrictDateTimeField.getInstance(field).isLenient());
    }
}
