package kaush.yog.parkingLot;

public class MainClassParkingLot {
	public static void main(String[] args) {
		
		ParkingLot parkingLot = ParkingLot.getInstance();
		
		
		String vehicleId = "UP55V8977";
		Vehicle vehicle = new Car(vehicleId);
		Spot spot = parkingLot.parkVehicle(vehicle);

		
		parkingLot.getVehicle(spot);
		//take spot tkt
		//find Spot
		//charge money
		//return vehicle
		
	}
}
