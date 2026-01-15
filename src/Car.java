package src;
public class Car extends Vehicle {
	public Car( String vehicleType, String brand, String vehicleBrand, String roadTax, ParkingLot parkingLot, String platNum) {
        super(vehicleType, brand, vehicleBrand, roadTax, parkingLot, platNum);
    }
    @Override
    public double vehicleCost() {
        return 65.0;
    }
    @Override
    public String toString() {
        return super.toString() + 
               "Vehicle Cost per Hour: RM65.0\n";
    }
}
