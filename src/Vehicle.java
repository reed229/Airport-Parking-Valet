package src;
public abstract class Vehicle {
	protected String vehicleType;
	protected String brand;
	protected String vehicleBrand;
	protected ParkingLot parkingLot;
	protected String platNum;

	// Constructors
	public Vehicle() {
		this.vehicleType = "";
		this.brand  = "";
		this.vehicleBrand = "";
		this.parkingLot = new ParkingLot();
		this.platNum = "";
	}

	public Vehicle( String vehicleType, String brand, String vehicleBrand, ParkingLot parkingLot, String platNum) {
		this.vehicleType = vehicleType;
		this.brand  = brand;
		this.vehicleBrand = vehicleBrand;
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
	protected ParkingLot getParkingLot() {
		return parkingLot;
	}
	protected String getPlatNum() {
		return platNum;
	}

	public abstract double vehicleCost();
	
		public String toString() {
		return "Vehicle Type: " + vehicleType + "\n" +
			   "Brand: " + brand + "\n" +
			   "Vehicle Brand: " + vehicleBrand + "\n" + 
			   "Parking Lot: " + parkingLot + "\n" +
			   "Plate Number: " + platNum + "\n";
	}
}

