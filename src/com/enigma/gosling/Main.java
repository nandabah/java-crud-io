package com.enigma.gosling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * Path: 
     * 1. Relative  -> "input.txt" (tergantung working directory)
     * 2. Absolute  -> "c:programfiles/bla/bla" (pathnya lengkap)
     * */
    private static File fileInput = new File("input.txt");
    private static File fileOutput = new File("output.txt");
    
    public static void main(String[] args) {
        // readFile();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Tulis Nama: ");
//        String text = scanner.nextLine();
//        writeFile(text);
//        readFile();
        updateFile();
    }

    public static void updateFile() {
        // Read file
        // byte stream
        try {
            FileInputStream fileInputStream = new FileInputStream(fileInput);
            StringBuilder builder = new StringBuilder(); // Memanipulasi string

            int data = fileInputStream.read();
            while (data != -1) {
                builder.append((char) data);
                data = fileInputStream.read();
            }
            fileInputStream.close();

            // Ganti
            // String updateText =  builder.toString().replace("Gosling","TORVALDS");
            // Ubah ke array
            String[] textPerLines = builder.toString().split("\n");

            // minta input scanner old text

            // replace sama new text

            for (int i = 0; i < textPerLines.length; i++) {
                if (textPerLines[i].equalsIgnoreCase("GOSLING TUJUH")) {
                    textPerLines[i] = textPerLines[i].replace("GOSLING TUJUH", "Adib dan Heri");
                }
            }

            // gabungin lagi jadi string utuh
            String updateText = String.join("\n", textPerLines);

            // Tulis ulang
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutput, false);
            fileOutputStream.write(updateText.getBytes());
            fileOutputStream.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void writeFile(String input) {
        try {
            // Otomatis dibuat kalau tidak ada
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutput, true);
            /* fileOutputStream.write(65);
            fileOutputStream.write(68);
            fileOutputStream.write(73);
            fileOutputStream.write(66);*/
            // String name = input;
            fileOutputStream.write(input.getBytes()); // konversi string menjadi array byte
            fileOutputStream.write("\n".getBytes());

            // Close
            fileOutputStream.close();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void readFile() {
        // Read file
        try {
            // Membaca berdasarkan byte code
            // FileReader / FileWriter -> Buffer
            FileInputStream fileInputStream = new FileInputStream(fileOutput);
            // int read1 = fileInputStream.read();
            // int read2 = fileInputStream.read();
            // int read3 = fileInputStream.read();

            // System.out.println((char) read2);
            // System.out.println((char) read3);
            /*System.out.println((char) fileInputStream.read());
            System.out.println((char) fileInputStream.read());
            System.out.println((char) fileInputStream.read());
            System.out.println((char) fileInputStream.read());
            System.out.println((char) fileInputStream.read());
            System.out.println((char) fileInputStream.read());
            System.out.println((char) fileInputStream.read());
            System.out.println( fileInputStream.read());*/
            int data = fileInputStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = fileInputStream.read();
            }
            fileInputStream.close(); // supaya tidak terjadi yang namanya memory leak
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
