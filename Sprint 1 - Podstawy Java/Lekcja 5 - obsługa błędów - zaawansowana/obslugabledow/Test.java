package org.example.obslugabledow;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Exception {

        // Zadanie 5  zadanie wykonane przez GPT

        FileWriter fileWriter = null;
        // BufferedWriter

        try {
            fileWriter = new FileWriter("plik.txt");
            fileWriter.write("To jest przykładowy tekst");

            // throw  new IOException(":(");
            //System.out.println("Plik został zapisany");
        }catch (IOException exception)
        {
            exception.printStackTrace();
        }finally {
            if (fileWriter != null)
            {
                fileWriter.close();
            }
        }
        System.out.println("------------------------------------------------");
    }
}
