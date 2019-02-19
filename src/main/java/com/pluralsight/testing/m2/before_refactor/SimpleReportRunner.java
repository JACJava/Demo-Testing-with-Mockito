package com.pluralsight.testing.m2.before_refactor;

public class SimpleReportRunner {

    public static void main(String[] args) {

        // put the file just in the c:\ directory, permission error if elsewhere
        // add to run->edit configurations->program arguments
        if (args.length < 1) {
            System.err.println("You must provide a commandline argument specifying the file to analyze");
            System.exit(-1);
        }

        // to use the common lang library, had to download it and stick it in the project directory after extracting
        // then go into file-project structure and add as a dependency
        // also had to add a dependency to the demo xml thing

        SalesReport report = new SalesReport(System.out, args[0]);
        report.report();


    }



}
