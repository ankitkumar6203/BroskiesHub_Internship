package org.example;

import java.io.*;

class InvalidProductDataException extends Exception{
    public InvalidProductDataException(String message){
        super(message);
    }
}

public class ExceptionHandling {
    public static void main(String[] args) {
        String inputFile = "products.csv";
        String outputFile = "expensive_products.csv";

        // Step 1: Create sample products.csv file
        createSampleCSV(inputFile);

        BufferedReader br = null;
        FileWriter fw = null;

        try{
            br = new BufferedReader(new FileReader(inputFile));
            fw = new FileWriter(outputFile);

            String line;
            fw.write("Name,Price\n");

            while((line=br.readLine())!=null){
                if (line.startsWith("Name")) continue;
                try{
                    String[] parts = line.split(",");

                    if(parts.length != 2){
                        throw new InvalidProductDataException("Invalid row format: "+line);
                    }
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());

                    if (price > 1000) {
                        fw.write(name + "," + price + "\n");
                    }
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid number in row: " + line);
                }
                catch (InvalidProductDataException e) {
                    System.out.println(" " + e.getMessage());
                }
            }
            System.out.println("Expensive products written to " + outputFile);
        }catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createSampleCSV(String filename) {
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write("Name,Price\n");
            fw.write("Laptop,55000\n");
            fw.write("Mobile,25000\n");
            fw.write("Keyboard,800\n");
            fw.write("Mouse,abc\n");            // Invalid price
            fw.write("Headphones,1500\n");
            fw.write("InvalidRowWithoutPrice\n"); // Invalid format
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
