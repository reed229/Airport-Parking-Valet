package src;
public abstract class Vehicle {
	protected String vehicleType;
	protected String brand;
	protected String vehicleBrand;
	protected String roadTax;
	protected ParkingLot parkingLot;
	protected String platNum;

	public Vehicle( String vehicleType, String brand, String vehicleBrand, String roadTax, ParkingLot parkingLot, String platNum) {
		this.vehicleType = vehicleType;
		this.brand  = brand;
		this.vehicleBrand = vehicleBrand;
		this.roadTax = roadTax;
		this.parkingLot = parkingLot;
		this.platNum = platNum;
	}

	// Setters
	protected void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	protected void setBrand(String brand) {
		this.brand = brand;
	}
	protected void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	protected void setRoadTax(String roadTax) {
		this.roadTax = roadTax;
	}
	protected void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	protected void setPlatNum(String platNum) {
		this.platNum = platNum;
	}

	// Getters
	protected String getVehicleType() {
		return vehicleType;
	}
	protected String getBrand() {
		return brand;
	}
	protected String getVehicleBrand() {
		return vehicleBrand;
	}
	protected String getRoadTax() {
		return roadTax;
	}
	protected ParkingLot getParkingLot() {
		return parkingLot;
	}
	protected String getPlatNum() {
		return platNum;
	}
}
