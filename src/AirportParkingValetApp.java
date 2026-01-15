// ShahXVI
// Zufar
//reed229

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.ArrayList;
import java.io.File;
public class AirportParkingValetApp {

    static ArrayList<Valet> val = new ArrayList<Valet>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
    loadValet();
    boolean exit = false;

        whlie(!exit) {
            menu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (!scanner.hasNextInt) {
                Scanner.nextLine();
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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

public static void loadValet() {
    try{
        File file = new File("src/valet.txt");
        Scanner fileScanner = new Scanner(file);
        
        while(fileScanner.hasNextLine()){
            String linr = FileScanner.nextLine();
            String[] parts = line.split(";");
            if(parts.lenghth >= 4) {
                valetList.add(newValet(parts[0], parts[1], parts[2], parts[3], "Available"));
            }
        }
    }catch ()
}