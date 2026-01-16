package src;
public class Van extends Vehicle {
	public Van( String vehicleType, String brand, String vehicleBrand, ParkingLot parkingLot, String platNum) {
		super(vehicleType, brand, vehicleBrand, parkingLot, platNum);
	}
		@Override
	public double vehicleCost() {
		return 75.0;
	}
	
	public String toString() {
		return super.toString() + 
			   "Vehicle Cost per Hour: RM75.0\n";
	}
}
