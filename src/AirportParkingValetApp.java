// ShahXVI
// reed229
// Zufar


package src;

import java.util.Scanner;
import java.io.*;
public class AirportParkingValetApp {

    static Scanner scanner = new Scanner(System.in);
    static boolean exit = false;

    public static void main(String[] args){
        Valet[] val = new Valet[100];
        loadValet(val);

        while(!exit) {
            int choice = menu();


            switch (choice) {
                case 1:
                    //customer menu
                    Customer cus = new Customer();
                    cus = customerMenu(cus,val);
                    //chooseValet(cus, val);
                    calcPayment(cus);
                    paymentReceipt(cus, val);
                    break;
                case 2:
                    // Admin menu
                    Admin[] admins = new Admin[10]; // Adjust the size as needed
                    loadAdmin(admins);

                    Admin loggedInAdmin = adminLogin(admins);

                    if(loggedInAdmin != null) {
                        adminMenu(loggedInAdmin, val);
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again."); 
            }
            if(!exit && choice == 1 || choice == 2) {
                System.out.print("Do you want to countinue to the main menu or exit the application? (yes/exit): ");
                String response = scanner.nextLine();

                if(response.equalsIgnoreCase("exit")) {
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                }
            }
            valetShift(val);
        }

        outputfile(val);
        
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

        if (!(choice >= 1 && choice <= 3)) {
            choice = scanner.nextInt();
            scanner.nextLine();
        }

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
                String name = parts[0];
                String id = parts[1];
                String contact = parts[2];
                String rating = parts[3];
                val[index++] = new Valet(name, id, contact, rating);
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }



    public static int loadMemberIds(String[] ids){
        int count = 0;
        try{
            File file = new File("src/idMember.txt");
            if(file.exists()){
                Scanner fileScanner = new Scanner(file);
                while(fileScanner.hasNextLine() && count < ids.length){
                    String line = fileScanner.nextLine().trim();
                    if(!line.isEmpty()){
                        ids[count++] = line;
                    }
                }
                fileScanner.close();
            }else{
                System.out.println("Membership ID file not found.");
            }
        } catch (IOException e) {
            System.out.println("Error loading membership IDs: " + e.getMessage());
        }
        return count;
    }



    public static Customer customerMenu(Customer cus, Valet[] val) {
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

        System.out.print("\nDo you have membership yes/no : ");
        String membership = scanner.nextLine();
        
        if(membership.equalsIgnoreCase("yes")){
            String[] memberIds = new String[100];
            int memberCount = loadMemberIds(memberIds);

            boolean validId = false;
            int attempts = 0;
            String membershipId = "";

            while(!validId && attempts < 3){
                System.out.print("Enter membership ID (hint: VAL-XXXX): ");
                membershipId = scanner.nextLine();

                boolean found = false;
                for(int i = 0; i < memberCount; i++){
                    if(memberIds[i].equals(membershipId)){
                        found = true;
                        break;
                    }
                }

                if(found){
                    validId = true;
                    System.out.println("Membership ID verified. Welcome, member enjoy your 10% discount!");
                }else{
                    attempts++;
                    System.out.println("Invalid membership ID. Please try again.");
                }
            }

            if(validId){
                cus = new Member();
                ((Member) cus).setMembershipId(membershipId);

                cus.setName(name);
                cus.setId(id);
                cus.setContact(contact);
                cus.setDuration(duration);
                cus.setMembership("Member");
            }else{
                System.out.println("Maximum attempts reached. You will be charged as a Non-Member.");
                cus.setMembership("Non-Member");
            }
        }else{
            cus.setMembership("Non-Member");
        }

        // Vehicle details
        String vehicleType = "";
        while(!vehicleType.equalsIgnoreCase("car") && !vehicleType.equalsIgnoreCase("motorcycle") && !vehicleType.equalsIgnoreCase("van")) {
            System.out.print("\nEnter your vehicle type (Car/Motocycle/Van): ");
            vehicleType = scanner.nextLine();   
        }

        System.out.print("Enter vehicle brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter vehicle model: ");
        String vehicleBrand = scanner.nextLine();

        System.out.print("Enter license plate number: ");
        String platNum = scanner.nextLine();

        // Parking lot details
        String levelOfSecurity = "";
        while (!levelOfSecurity.equalsIgnoreCase("Low") && !levelOfSecurity.equalsIgnoreCase("Medium") && !levelOfSecurity.equalsIgnoreCase("High") ) {
            System.out.print("Enter level of security (Low/Medium/High): ");
            levelOfSecurity = scanner.nextLine();
        }

        System.out.print("Enter floor level(0 until 5) : ");
        int floorLevel = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter floor section(section A 1-5/B 6-11/C 12-21 ): ");
        String floorSection = scanner.nextLine();

        System.out.print("Whould you like extra service? (yes/no): ");
        String extraService = "";
        String extraServiceChoice = scanner.nextLine();
        if(extraServiceChoice.equalsIgnoreCase("yes")){
            System.out.println("\nAvailable Extra Services:");
            System.out.println("1. Polish");
            System.out.println("2. Vacuuming");
            System.out.println("3. Full car wash(Exterior & Interior)");
            System.out.print("Choose an extra service: ");
            String serviceOption = scanner.nextLine();

            switch(serviceOption){
                case "1":
                case "Polis":
                    extraService = "Polish";
                    break;
                case "2":
                case "Vacuuming":
                    extraService = "Vacuuming";
                    break;
                case "3":
                case "Full car wash(Exterior & Interior)":
                    extraService = "Full car wash(Exterior & Interior)";
                    break;
                default:
                    System.out.println("Invalid choice. No extra service selected.");
                    extraService = "None";
            }
        }else{
            extraService = "None";
        }

        ParkingLot parkingLot = new ParkingLot(levelOfSecurity, floorLevel, floorSection, extraService);
        
        Vehicle vehicle = null;

        if (vehicleType.equalsIgnoreCase("car"))
            vehicle = new Car(vehicleType, brand, vehicleBrand, parkingLot, platNum);
        else if (vehicleType.equalsIgnoreCase("motorcycle"))
            vehicle = new Motorcycle(vehicleType, brand, vehicleBrand, parkingLot, platNum);
        else if (vehicleType.equalsIgnoreCase("van"))
            vehicle = new Van(vehicleType, brand, vehicleBrand, parkingLot, platNum);

        cus.setVehicle(vehicle);

        // Assign a valet (for simplicity, assign the first valet)
        customeChoice(val, cus);
        

        // Display customer info
        System.out.println("\n--- Customer Information ---");
        System.out.println(cus.toString());

        return cus;
    }



    public static void loadAdmin(Admin[] admin) {
        try{
            File file = new File("src/admin.txt");
            Scanner fileScanner = new Scanner(file);
            int index = 0;

            while(fileScanner.hasNextLine() && index < admin.length){
                String line = fileScanner.nextLine();
                String[] parts = line.split(";");

                if(parts.length >= 3){
                    String name = parts[0];
                    String id = parts[1];
                    String contact = parts[2];
                    String password = (parts.length > 3) ? parts[3] : "";

                    admin[index++] = new Admin(name, id, contact, password);
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
            System.out.println("1. Add Valet");
            System.out.println("2. Remove Valet");
            System.out.println("3. Back to Main Menu");
            System.out.print("Please choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter valet name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter valet ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter valet contact: ");
                    String contact = scanner.nextLine();

                    System.out.print("Enter valet rating: ");
                    String rating = scanner.nextLine();



                    // Find first empty slot
                    int addIndex = -1;
                    for(int i = 0; i < val.length; i++) {
                        if(val[i] == null) {
                            addIndex = i;
                            break;
                        }
                    }
                    val[addIndex] = new Valet(name, id, contact, rating);

                    break;
                case 2:
                    System.out.print("Enter valet ID to remove: ");
                    String removeId = scanner.nextLine();

                    boolean found = false;
                    for(int i = 0; i < val.length; i++) {
                        if(val[i] != null && val[i].getId().equals(removeId)) {
                            val[i] = null;
                            found = true;
                            System.out.println("Valet removed successfully.");
                            break;
                        }
                    }
                    if(!found) {
                        System.out.println("Valet with ID " + removeId + " not found.");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    

    public static Admin adminLogin(Admin[] admins) {
        int attempts = 0;
        
        while(attempts < 3){
            System.out.print("Enyter Admin ID: ");
            String inputId = scanner.nextLine();

            System.out.print("Enter Admin Password: ");
            String inputPassword = scanner.nextLine();

            for (Admin admin : admins)
                if(admin != null && admin.verifyCredentials(inputId, inputPassword)){
                    return admin;
                }       
                attempts++;
                int remaining = 3 - attempts;
                if (remaining > 0){
                    System.out.println("Invalid credentials. Access denied." + remaining + " attempts remaining.");
                }
        }
        System.out.println("Maximum attempts reached. Please choose an option below to continue back to menu or exit the application.");
        return null;
    }



    public static double calcPayment(Customer cus){
        double totalCost = cus.totalVehicleCost();
        System.out.println("Total Cost: RM" + totalCost);

        double totalPrice = totalCost;

        if(cus instanceof Member){
            double discountPrice = totalCost * 0.1;
            totalPrice = totalCost - discountPrice;
            System.out.println("Membership Discount Applied: RM" + discountPrice);
            System.out.println("Discounted Total Cost: RM" + totalPrice);
        }else{
            System.out.println("No Membership Discount Applied.");
        }
        return totalPrice;
    }



    public static void outputfile(Valet[] val) {
        try {
            FileWriter writer = new FileWriter("src/valet.txt");

            for (Valet v : val) {
                if (v != null) {
                    writer.write(v.getName() + ";" + v.getId() + ";" + v.getContact() + ";" + v.getRating() + "\n");
                }
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }



   public static void paymentReceipt(Customer cus, Valet[] val) {
    System.out.println("\n========================================");
    System.out.println("           PAYMENT RECEIPT              ");
    System.out.println("========================================");
    
    // Using printf for alignment: %-18s pads the label to 18 characters
    System.out.printf("%-18s: %s\n", "Customer Name", cus.getName());
    System.out.printf("%-18s: %s\n", "Customer ID", cus.getId());
    System.out.printf("%-18s: %s\n", "Contact", cus.getContact());
    
    System.out.println("----------------------------------------");
    System.out.printf("%-18s: %s\n", "Vehicle Type", cus.getVehicle().getVehicleType());
    System.out.printf("%-18s: %s\n", "Vehicle Brand", cus.getVehicle().getBrand());

    //Retrieve parking lot object details
    ParkingLot Lot = cus.getVehicle().getParkingLot();
    System.out.printf("%-18s: %s\n", "Level of Security", Lot.getLevelOfSecurity());
    System.out.printf("%-18s: %s\n", "Extra Service", Lot.getExtraService());
    System.out.printf("%-18s: %d days\n", "Parking Duration", cus.getDuration());
    
    //check membership status
    String memStatus = cus.getMembership();
    if(memStatus == null){
        memStatus = (cus instanceof Member) ? "Member" : "Non-Member";
    }
    System.out.printf("%-18s: %s\n", "Membership Status", memStatus);

    System.out.println("----------------------------------------");
    double totalCost = calcPayment(cus);
    System.out.printf("%-18s: RM %.2f\n", "Total Payment", totalCost);
    System.out.printf("%-18s: %s\n", "Assigned Valet", cus.getVal().getName());
    
    System.out.println("========================================\n");
    }



    /* 
     * optimization of array
     * method to shift valet data in the text file after removing a valet
     * @author Zufar
    */
    public static void valetShift(Valet[] val) {
        //method to shift valet data in the text file after removing a valet
        for(int i = 0; i < val.length; i++) {
            if(val[i] == null){
                if (i + 1 < val.length && val[i + 1] != null){
                    val[i] = val[i+1];
                    val[i + 1] = null;
                }
            }

        }
    }



    public static void customeChoice(Valet[] val, Customer cus) {
         
        //method for customer to choose valet
        for (int i = 0; i < val.length; i++) {
            if(val[i] != null) {
                System.out.println("\nOur list of valets available:");
                System.out.println((i+1) + ". " + val[i].getName() + " (Rating: " + val[i].getRating() + ")");
            }
        }
        System.out.print("\nChoose a Valet: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        while(choice < 1 || choice > val.length) {
            System.out.println("Invalid choice. Please try again.");
            System.out.println("\nChoose a Valet: ");
            choice = scanner.nextInt();
        }

        Valet selectedValet = val[choice - 1];
        System.out.println("You have selected: " + selectedValet.getName());

        // Assign the selected valet to the customer
        cus.setVal(selectedValet);
        val[choice - 1] = null;

        valetShift(val);
    }
}