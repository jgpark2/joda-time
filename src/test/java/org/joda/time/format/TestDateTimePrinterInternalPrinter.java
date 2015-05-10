package org.joda.time.format;

import java.text.DateFormat;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.Chronology;
import org.joda.time.ReadablePartial;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimePrinterInternalPrinter;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;

/**
 * This class is a Junit unit test for DateTimeFormat styles.
 *
 * @author Matthew Ly and Jonathan Park
 */
public class TestDateTimePrinterInternalPrinter extends TestCase {

	private Locale originalLocale = null;

	protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        originalDateTimeZone = DateTimeZone.getDefault();
        originalTimeZone = TimeZone.getDefault();
        originalLocale = Locale.getDefault();
        DateTimeZone.setDefault(LONDON);
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Locale.setDefault(Locale.UK);
    }

	protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(originalDateTimeZone);
        TimeZone.setDefault(originalTimeZone);
        Locale.setDefault(originalLocale);
        originalDateTimeZone = null;
        originalTimeZone = null;
        originalLocale = null;
    }
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestDateTimeFormatStyle.class);
    }

	public void testEstimatePrintedLength() {
		DateTimeFormatterBuilder bld = new DateTimeFormatterBuilder();
		bld.appendLiteral('Y');
		DateTimePrinter p = bld.toPrinter();

		DateTimePrinterInternalPrinter ip = DateTimePrinterInternalPrinter(p);
		assertEquals(1, p.estimatePrintedLength());
	}

	public void testGetUnderlying() {
		DateTimePrinter printer = new DateTimePrinter();
		DateTimeFormatterBuilder bld = new DateTimeFormatterBuilder();
        bld.appendLiteral('Y');
        DateTimePrinter p = bld.toPrinter();

        DateTimePrinterInternalPrinter ip = DateTimePrinterInternalPrinter(p);
		assertEquals(printer, ip.getUnderlying());
	}

	public void testPrintTo() {
		try {
			StringBuffer appendable1 = new StringBuffer();
			Writer appendable2 = new Writer();
			Chronology chrono = new Chronology();
			DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
			
			DateTimePrinter printer = new DateTimePrinter();
      		DateTimeFormatterBuilder bld = new DateTimeFormatterBuilder();
        	bld.appendLiteral('Y');
        	DateTimePrinter p = bld.toPrinter();

        	DateTimePrinterInternalPrinter ip = DateTimePrinterInternalPrinter(p);
			ip.printTo(appendable1, 10, chrono, 10, PARIS, originalLocale); //appendable is type StringBuffer
			ip.printTo(appendable2, 10, chrono, 10, PARIS, originalLocale); //appendable is type Writer
		} catch (IOException e) {
		}
	}

	public void printToWithReadablePartial() {
		try {
			ReadablePartial localTime = new LocalTime();
            StringBuffer appendable1 = new StringBuffer();
            Writer appendable2 = new Writer();

            DateTimePrinter printer = new DateTimePrinter();
            DateTimeFormatterBuilder bld = new DateTimeFormatterBuilder();
            bld.appendLiteral('Y');
            DateTimePrinter p = bld.toPrinter();

            DateTimePrinterInternalPrinter ip = DateTimePrinterInternalPrinter(p);
            ip.printTo(appendable1, localTime, originalLocale); //ap
pendable is type StringBuffer
            ip.printTo(appendable2, localTime, originalLocale); //ap
pendable is type Writer
        } catch (IOException e) {
        }
	}
}
