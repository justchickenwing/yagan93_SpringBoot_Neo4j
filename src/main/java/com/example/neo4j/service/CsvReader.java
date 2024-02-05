package com.example.neo4j.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CsvReader {

    private String filePath;

    public CsvReader(String filePath) {
        this.filePath = filePath;
    }

    public void readCSV(CSVLineProcessor lineProcessor) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lineProcessor.processLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Functional interface for processing each line
    public interface CSVLineProcessor {
        void processLine(String line);
    }
}