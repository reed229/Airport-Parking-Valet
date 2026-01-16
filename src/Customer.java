package src;
public class Customer extends User { 
    private int duration;
    private Vehicle vehicle;
    private Valet val;
    private String membership;

    public Customer() {
        super();
        this.duration = 0;
        this.vehicle = null;
        this.val = new Valet();
    }

    public Customer(String name, String id, String contact, int duration, Vehicle vehicle, Valet val, String membership) {
        super(name, id, contact);
        this.duration = duration;
        this.vehicle = vehicle;
        this.val = val;
        this.membership = membership;
    }

      public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setVal(Valet val) {
        this.val = val;
    }
    public void setMembership(String membership) {
        this.membership = membership;
    }

    public int getDuration() {
        return duration;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public Valet getVal() {
        return val;
    }
    public String getMembership() {
        return membership;
    }
    

	public double totalVehicleCost() {
		return vehicle.vehicleCost() * getDuration();
	}
    
  

    @Override
    public String toString() {
        return super.toString() + 
               "\nDuration       : " + duration + " hours\n" +
               "Vehicle Info   : \n" + vehicle.toString() +
               "Assigned Valet : \n" + val.toString();
               
    }
}
