package org.example;

import java.io.*;

public class Product {
    public static void main(String[] args) {
        String inputFile = "products.csv";
        String outputFile = "expensive_products.csv";

        // Step 1: Create sample products.csv file
        createSampleCSV(inputFile);

        try (
                BufferedReader br = new BufferedReader(new FileReader(inputFile));
                FileWriter fw = new FileWriter(outputFile)
        ) {
            String line;

            // Write header in output file
            fw.write("Name,Price\n");

            // Step 2: Read each line from products.csv
            while ((line = br.readLine()) != null) {
                // Skip header
                if (line.startsWith("Name")) continue;

                // Step 3: Split line by comma
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);

                // Step 4: Check if price > 1000
                if (price > 1000) {
                    // Step 5: Write to new CSV file
                    fw.write(name + "," + price + "\n");
                }
            }

            System.out.println("Expensive products written to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to create sample CSV
    private static void createSampleCSV(String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Name,Price\n");
            fw.write("Laptop,55000\n");
            fw.write("Mobile,25000\n");
            fw.write("Keyboard,800\n");
            fw.write("Mouse,500\n");
            fw.write("Headphones,1500\n");
            fw.write("USB Cable,300\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
