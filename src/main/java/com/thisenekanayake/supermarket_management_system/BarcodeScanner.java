package com.thisenekanayake.supermarket_management_system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BarcodeScanner {
    public String scanBarcode() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Scan a barcode: ");
            return reader.readLine(); // reads input until enter is pressed
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

/**
 * public class Main {
 *     public static void main(String[] args) {
 *         BarcodeScanner scanner = new BarcodeScanner();
 *         String barcode = scanner.scanBarcode();
 *         System.out.println("Scanned barcode: " + barcode);
 *     }
 * }
 */