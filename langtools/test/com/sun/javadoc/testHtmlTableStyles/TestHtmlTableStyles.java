/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * @test
 * @bug 8008164
 * @summary Test styles on HTML tables generated by javadoc.
 * @author Bhavesh Patel
 * @library ../lib/
 * @build JavadocTester TestHtmlTableStyles
 * @run main TestHtmlTableStyles
 */

public class TestHtmlTableStyles extends JavadocTester {

    private static final String BUG_ID = "8008164";

    //Input for string search tests.
    private static final String[][] TEST = {
        {BUG_ID + "/pkg1/TestTable.html",
            "<table border cellpadding=3 cellspacing=1>"
        },
        {BUG_ID + "/pkg1/TestTable.html",
            "<table class=\"memberSummary\" border=\"0\" cellpadding=\"3\" " +
            "cellspacing=\"0\" summary=\"Field Summary table, listing fields, " +
            "and an explanation\">"
        },
        {BUG_ID + "/pkg1/TestTable.html",
            "<table class=\"memberSummary\" border=\"0\" cellpadding=\"3\" " +
            "cellspacing=\"0\" summary=\"Constructor Summary table, listing " +
            "constructors, and an explanation\">"
        },
        {BUG_ID + "/pkg1/TestTable.html",
            "<table class=\"memberSummary\" border=\"0\" cellpadding=\"3\" " +
            "cellspacing=\"0\" summary=\"Method Summary table, listing methods, " +
            "and an explanation\">"
        },
        {BUG_ID + "/pkg1/package-summary.html",
            "<table class=\"typeSummary\" border=\"0\" cellpadding=\"3\" " +
            "cellspacing=\"0\" summary=\"Class Summary table, listing classes, " +
            "and an explanation\">"
        },
        {BUG_ID + "/pkg1/class-use/TestTable.html",
            "<table class=\"useSummary\" border=\"0\" cellpadding=\"3\" " +
            "cellspacing=\"0\" summary=\"Use table, listing fields, and an explanation\">"
        },
        {BUG_ID + "/overview-summary.html",
            "<table class=\"overviewSummary\" border=\"0\" cellpadding=\"3\" " +
            "cellspacing=\"0\" summary=\"Packages table, listing packages, and an explanation\">"
        },
        {BUG_ID + "/deprecated-list.html",
            "<table class=\"deprecatedSummary\" border=\"0\" cellpadding=\"3\" " +
            "cellspacing=\"0\" summary=\"Deprecated Methods table, listing " +
            "deprecated methods, and an explanation\">"
        },
        {BUG_ID + "/constant-values.html",
            "<table class=\"constantsSummary\" border=\"0\" cellpadding=\"3\" " +
            "cellspacing=\"0\" summary=\"Constant Field Values table, listing " +
            "constant fields, and values\">"
        },
    };

    private static final String[] ARGS = new String[] {
        "-d", BUG_ID, "-sourcepath", SRC_DIR, "-use", "pkg1", "pkg2"
    };

    /**
     * The entry point of the test.
     * @param args the array of command line arguments.
     */
    public static void main(String[] args) throws Exception {
        TestHtmlTableStyles tester = new TestHtmlTableStyles();
        tester.run(ARGS, TEST, NO_TEST);
        tester.printSummary();
    }

    /**
     * {@inheritDoc}
     */
    public String getBugId() {
        return BUG_ID;
    }

    /**
     * {@inheritDoc}
     */
    public String getBugName() {
        return getClass().getName();
    }
}
