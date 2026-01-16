package src;
public class Motorcycle extends Vehicle {
	public Motorcycle( String vehicleType, String brand, String vehicleBrand, ParkingLot parkingLot, String platNum) {
		super(vehicleType, brand, vehicleBrand, parkingLot, platNum);
	}
		
	@Override
	public double vehicleCost() {
		return 55.0;
	}
}
