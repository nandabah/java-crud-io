package com.enigma.gosling;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReaderWriter {
    private static File file = new File("Example.txt");

    public static void main(String[] args) {

        try( BufferedReader reader = new BufferedReader(new FileReader(file)) ){
            
        }catch (IOException e){

        }
        /*try {
            // char stream
            FileInputStream byteFile = new FileInputStream(fileInput);
            FileReader      charFile = new FileReader(fileInput);

            // Read file
            System.out.println((char) byteFile.read());
            System.out.println((char) charFile.read());
            System.out.println((char) byteFile.read());
            System.out.println((char) charFile.read());

            byteFile.close();
            charFile.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }*/
        /*try {
            writeFile();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }*/
        updateFile();
        readFile();
    }

    public static void readFile() {
        // try with resource
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            List<String> fruits = new ArrayList<>();

            while (true) {
                /** Stream
                 * int read = fileReader.read();
                 if (read == -1) {
                 break;
                 }
                 System.out.print((char) read);*/

                // Buffer
                String fruit = bufferedReader.readLine();
                if (fruit == null) break;
                fruits.add(fruit);
            }

            for (String fruit : fruits) {
                System.out.println(fruit);
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void writeFile() throws IOException {
        // otomatis terbuat kalo filenya tidak ada
        FileWriter fileWriter = new FileWriter(file, true);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Fruit name: ");
            String fruit = scanner.nextLine();
            fileWriter.write(fruit);
            fileWriter.write("\n");

            System.out.print("Input lagi(Y/N) ? ");
            char input = scanner.nextLine().charAt(0);
            if (input == 'N' || input == 'n') break;
        }

        fileWriter.close();
    }

    public static void updateFile() {
        Scanner scanner = new Scanner(System.in);
        List<String> fruits = new ArrayList<>();

        System.out.print("Nama Buah: ");
        String oldFruit = scanner.nextLine();

        // Baca filenya
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String fruit;
            while ((fruit = bufferedReader.readLine()) != null) { // looping sampai baris terakhir / null
                if (fruit.equalsIgnoreCase(oldFruit)) {
                    System.out.print("Nama Buah Baru: ");
                    String newFruit = scanner.nextLine();
                    fruits.add(newFruit);
                } else {
                    fruits.add(fruit);
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }

        // Update
        try (FileWriter fileWriter = new FileWriter(file);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            for (String fruit : fruits) {
                bufferedWriter.write(fruit);
                bufferedWriter.newLine();
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
