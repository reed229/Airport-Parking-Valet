package src;
public class Car extends Vehicle {
	public Car( String vehicleType, String brand, String vehicleBrand, ParkingLot parkingLot, String platNum) {
        super(vehicleType, brand, vehicleBrand, parkingLot, platNum);
    }
    @Override
    public double vehicleCost() {
        return 65.0;
    }
    @Override
    public String toString() {
        return super.toString() + 
               "Vehicle Cost per Days: RM65.0\n";
    }
}
