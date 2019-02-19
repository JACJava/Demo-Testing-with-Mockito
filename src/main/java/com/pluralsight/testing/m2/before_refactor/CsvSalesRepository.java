package com.pluralsight.testing.m2.before_refactor;

import com.opencsv.CSVReader;
// to use the opencsv, had to download the jar file it after searching for it
// then go into file-project structure and add as a dependency
// shows up under external libraries
// also had to add a dependency to the demo xml thing

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

//import com.opencsv.CSVReader;

public class CsvSalesRepository {

    private final String fileLocation;
    private PrintStream error;
    private List<Sale> sales;

    public CsvSalesRepository(String fileLocation) {
        this.fileLocation = fileLocation;
        error = System.out;
    }

    public void setError(PrintStream error) {
        this.error = error;
    }

    private int parseInt(String value) {
        return Integer.parseInt(value.trim());
    }

    public List<Sale> loadSales() {
        if (sales == null) {
            sales = new ArrayList<>();
            try (CSVReader reader = new CSVReader(new FileReader(fileLocation))) {
                String[] nextLine;
                while ((nextLine = reader.readNext()) != null) {
                    String product = nextLine[0].trim();
                    String store = nextLine[1].trim();
                    int number = parseInt(nextLine[2]);
                    int pricePerItem = parseInt(nextLine[3]);
                    sales.add(new Sale(product, store, number, pricePerItem));
                }
                return sales;
            } catch (IOException e) {
                e.printStackTrace(error);
                return null;
            }
        }
        return sales;
    }

}

