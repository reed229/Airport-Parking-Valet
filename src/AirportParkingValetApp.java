// ShahXVI
// Zufar
// reed229

package src;

import java.util.Scanner;
import java.io.*;
import java.io.File;

public class AirportParkingValetApp {

    static Scanner scanner = new Scanner(System.in);
    static boolean exit = false;

    public static void main(String[] args){
        Valet[] val = new Valet[10];
        loadValet(val);


        while(!exit) {
            int choice = menu();

            switch (choice) {
                case 1:
                    //customer menu
                    break;
                case 2:
                    // Adming menu
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

    public static int menu() {
        System.out.println("\n====================================");
        System.out.println("Welcome to Airport Parking Valet App");
        System.out.println("====================================");
        System.out.println("1. Customer");
        System.out.println("2. Admin");
        System.out.println("3. Exit");
        System.out.print("Please choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (!scanner.hasNextInt()) {
            scanner.nextLine();
        }

        choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        return choice;
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
            fileScanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}