package src;
public class Customer extends User{
    private int duration;
    private String membership;
    private Vehicle vehicle;
    private Valet val;
    private Member mem;

    public Customer() {
        super();
        this.duration = 0;
        this.membership = "";
        this.vehicle = null;
        this.val = new Valet();
        this.mem = new Member();
    }

    public Customer(String name, String id, String contact, int duration, String membership, Vehicle vehicle, Valet val, Member mem) {
        super(name, id, contact);
        this.duration = duration;
        this.membership = membership;
        this.vehicle = vehicle;
        this.val = val;
        this.mem = mem;
    }

      public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setVal(Valet val) {
        this.val = val;
    }
    public void setMem(Member mem) {
        this.mem = mem;
    }

    public int getDuration() {
        return duration;
    }
    public String getMembership() {
        return membership;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public Valet getVal() {
        return val;
    }
    public Member getMem() {
        return mem;
    }

	public double totalVehicleCost() {
		return vehicle.vehicleCost() * getDuration();
	}
  

    @Override
    public String toString() {
        return super.toString() + 
               "\nDuration       : " + duration + " hours\n" +
               "Membership     : " + membership + "\n" +
               "Vehicle Info   : \n" + vehicle.toString() +
               "Assigned Valet : \n" + val.toString();
               
    }
}
