package src;
// ShahXVI
// Zufar

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean choseCustomer = true;
        boolean choseAdmin = false;
        boolean exit = false;
	    do {
		    if (choseCustomer) {
                Customer customer = createCustomer();
			    makeReservation(customer);
	    	} else if (choseAdmin) {

			    editValet();
	    	}
	    } while (!exit);
    }

    public void makeReservation() {
        

    }

    public void editValet() {
        boolean add = true;
        boolean remove = false;
	    if (add) {
		    // Enter add logicc
	    } else if (remove) {
		    // enter remove logic
	    }
    }

    // Customer only
    public void makePayment() {
        

    }
    
    public Customer createCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        System.out.print("Enter Duration (hours): ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Membership Type: ");
        String membership = scanner.nextLine();

        return new Customer(name, id, contact, duration, membership, vehicle, val);
    }


    public void viewReceipt() {

    }
}
