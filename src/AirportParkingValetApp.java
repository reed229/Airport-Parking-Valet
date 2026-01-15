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
                    Customer cus = new Customer();
                    customerMenu(cus,val);
                    break;
                case 2:
                    // Admin menu
                    Admin admin = new Admin();
                    loadAdmin(admin);
                    adminMenu(admin, val);
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

    public static void customerMenu(Customer cus, Valet[] val) {
        System.out.println("\n--- Customer Menu ---");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter your contact: ");
        String contact = scanner.nextLine();

        cus.setName(name);
        cus.setId(id);
        cus.setContact(contact);

        System.out.print("Enter parking duration (in days): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        cus.setDuration(duration);

        System.out.print("Enter membership yes/no : ");
        String membership = scanner.nextLine();
        cus.setMembership(membership);

        // Vehicle details
        String vehicleType = "";
        while(!vehicleType.equalsIgnoreCase("car") && !vehicleType.equalsIgnoreCase("motorcycle") && !vehicleType.equalsIgnoreCase("van")) {
            System.out.print("Enter vehicle type: ");
            vehicleType = scanner.nextLine();   
        }
        System.out.print("Enter vehicle type: ");
        vehicleType = scanner.nextLine();

        System.out.print("Enter vehicle brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter vehicle model: ");
        String vehicleBrand = scanner.nextLine();

        System.out.print("Enter road tax number: ");
        String roadTax = scanner.nextLine();

        System.out.print("Enter license plate number: ");
        String platNum = scanner.nextLine();

        // Parking lot details
        System.out.print("Enter level of security (Low/Medium/High): ");
        String levelOfSecurity = scanner.nextLine();

        System.out.print("Enter floor level: ");
        int floorLevel = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter floor section: ");
        String floorSection = scanner.nextLine();

        System.out.print("Enter extra service (if any): ");
        String extraService = scanner.nextLine();

        ParkingLot parkingLot = new ParkingLot(levelOfSecurity, floorLevel, floorSection, extraService);
        
        Vehicle vehicle = null;

        if (vehicleType.equalsIgnoreCase("car"))
            vehicle = new Car(vehicleType, brand, vehicleBrand, roadTax, parkingLot, platNum);
        else if (vehicleType.equalsIgnoreCase("motorcycle"))
            vehicle = new Motorcycle(vehicleType, brand, vehicleBrand, roadTax, parkingLot, platNum);
        else if (vehicleType.equalsIgnoreCase("van"))
            vehicle = new Van(vehicleType, brand, vehicleBrand, roadTax, parkingLot, platNum);
        else

        cus.setVehicle(vehicle);

        // Assign a valet (for simplicity, assign the first valet)
        if(val[0] != null) {
            cus.setVal(val[0]);
        }

        // Display customer info
        System.out.println("\n--- Customer Information ---");
        System.out.println(cus.toString());
    }

    public static void loadAdmin(Admin admin) {
        try{
            File file = new File("src/admin.txt");
            Scanner fileScanner = new Scanner(file);
            
            if(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                String[] parts = line.split(";");

                if(parts.length >= 3) {
                    admin.setName(parts[0]);
                    admin.setId(parts[1]);
                    admin.setContact(parts[2]);
                }
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //admin menu to choose add or remove valet
    public static void adminMenu(Admin admin, Valet[] val) {
        System.out.println("\n--- Admin Menu ---");
        System.out.println("Welcome, " + admin.getName());

        boolean back = false;
        while(!back) {
            System.out.println("\n1. View Valets");
            System.out.println("2. Add Valet");
            System.out.println("3. Remove Valet");
            System.out.println("4. Back to Main Menu");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch(choice) {
                case 1:
                    System.out.println("\n--- List of Valets ---");
                    for(Valet v : val) {
                        if(v != null) {
                            System.out.println(v.toString());
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter valet name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter valet ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter valet contact: ");
                    String contact = scanner.nextLine();

                    System.out.print("Enter valet rating: ");
                    String rating = scanner.nextLine();

                    // Find first empty slot
                    for(int i = 0; i < val.length; i++) {
                        if(val[i] == null) {
                            val[i] = new Valet(name, id, contact, rating);
                            System.out.println("Valet added successfully.");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter valet ID to remove: ");
                    String removeId = scanner.nextLine();

                    for(int i = 0; i < val.length; i++) {
                        if(val[i] != null && val[i].getId().equals(removeId)) {
                            val[i] = null;
                            System.out.println("Valet removed successfully.");
                            break;
                        }
                    }
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
