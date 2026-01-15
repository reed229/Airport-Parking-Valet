package src;

// ShahXVI
// Zufar
//reed229

import java.util.Scanner;
import java.io.*;
import java.io.File;

public class AirportParkingValetApp {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
    Valet[] val = new Valet[10];
    loadValet(val);

    boolean exit = false;

        while(!exit) {
            menu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            boolean choseCustomer = false;
            boolean choseAdmin = false;

            switch (choice) {
                case 1:
                    choseCustomer = true;
                    choseAdmin = false;
                    break;
                case 2:
                    choseAdmin = true;
                    choseCustomer = false;
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); 
            }
             
        }
    }

    public static void menu() {
        System.out.println("\n====================================");
        System.out.println("Welcome to Airport Parking Valet App");
        System.out.println("====================================");
        System.out.println("1. Customer");
        System.out.println("2. Admin");
        System.out.println("3. Exit");
        System.out.print("Please choose an option: ");
    }

    public static void loadValet(Valet[] val) {
        try{
            File file = new File("src/valet.txt");
            Scanner fileScanner = new Scanner(file);
            
            int index = 0;
            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] parts = line.split(";");

                if(parts.length >= 4) {
                    val[index++] = new Valet(parts[0], parts[1], parts[2], parts[3]);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}