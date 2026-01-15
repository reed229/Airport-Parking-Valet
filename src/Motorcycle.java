package src;
public class Motorcycle extends Vehicle {
	public Motorcycle( String vehicleType, String brand, String vehicleBrand, String roadTax, ParkingLot parkingLot, String platNum) {
		super(vehicleType, brand, vehicleBrand, roadTax, parkingLot, platNum);
	}
		
	@Override
	public double vehicleCost() {
		return 55.0;
	}
}
