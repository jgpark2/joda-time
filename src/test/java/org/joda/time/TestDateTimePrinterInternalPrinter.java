/*
 *  *  Copyright 2015 Matthew Ly
 *   *
 *    *  Licensed under the Apache License, Version 2.0 (the "License");
 *     *  you may not use this file except in compliance with the License.
 *      *  You may obtain a copy of the License at
 *       *
 *        *      http://www.apache.org/licenses/LICENSE-2.0
 *         *
 *          *  Unless required by applicable law or agreed to in writing, software
 *           *  distributed under the License is distributed on an "AS IS" BASIS,
 *            *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *             *  See the License for the specific language governing permissions and
 *              *  limitations under the License.
 *               */
package org.joda.time;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *  * Test case.
 *   *
 *    * @author Matthew Ly
 *     */
public class TestDateTimePrinterInternalPrinter extends TestCase {

    /**
 *      * The main method for this test program.
 *           * @param args command line arguments.
 *                */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    /**
 *      * TestSuite is a junit required method.
 *           */
    public static TestSuite suite() {
        return new TestSuite(TestDateTimeConstants.class);
    }

    /**
 *      * TestDateTimePrinterInternalPrinter constructor.
 *           * @param name
 *                */
    public TestDateTimePrinterInternalPrinter(String name) {
        super(name);
    }

	public void testDateTimePrinterInternalPrinter() {
		DateTimePrinter underlying = new DateTimePrinter();
		DateTimePrinterInternalPrinter printer = new DateTimePrinterInternalPrinter();
		printer.DateTimePrinterInternalPrinter(underlying);
	}
}
