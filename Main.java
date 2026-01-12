// ShahXVI
// Zufar

public class Main {
    public static void main(String[] args) {
        boolean choseCustomer = true;
        boolean choseAdmin = false;
        boolean exit = false;
	    do {
		    if (choseCustomer) {
			    makeReservation();
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

    public void viewReceipt() {

    }
}
