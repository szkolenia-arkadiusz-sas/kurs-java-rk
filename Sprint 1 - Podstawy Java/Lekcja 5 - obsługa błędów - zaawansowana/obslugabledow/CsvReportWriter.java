package org.example.obslugabledow;

import java.io.FileWriter;
import java.io.IOException;

public class CsvReportWriter {

    public static void saveCsvReport(String fileContent, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(fileContent);
        fileWriter.close();
    }
}
