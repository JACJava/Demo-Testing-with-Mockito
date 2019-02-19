package com.pluralsight.testing.m2.after_refactor;

public class SimpleReportRunner {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.err.println("You must provide a commandline argument specifying the file to analyse");
            System.exit(-1);
        }

        // to run from the command line, put the plugin lines in the pom
        /*
         <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>1.2.1</version>
                <configuration>
                    <mainClass>com.pluralsight.testing.m2.after_refactor.SimpleReportRunner</mainClass>
                </configuration>
            </plugin>
         */
        //mvn exec:java -Dexec.args="C:\example-sales.csv"

        CsvSalesRepository repo = new CsvSalesRepository(args[0]);
        repo.setError(System.err);

        SalesAnalysisService analysisService = new SalesAnalysisService(repo);
        SalesReport report = new SalesReport(System.out, analysisService);
        report.report();
    }

}
