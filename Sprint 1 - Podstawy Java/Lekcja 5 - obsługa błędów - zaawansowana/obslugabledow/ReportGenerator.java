package org.example.obslugabledow;

import java.io.IOException;

public class ReportGenerator {

    public static void main(String[] args) {
        generateReport();
    }

    public static void generateReport() {
        try {
            CsvReportWriter.saveCsvReport("header1,header2;a,b;", "report.csv");
        } catch (IOException e) {
            throw new ReportGenerationException();
        }
    }
}
