package kaush.yog.parkingLot;

public abstract class Vehicle {
	
	private String numberPlate;
	SPOT_SIZE SIZE;
	int spotId;
	int levelId;
	
	public Vehicle(String numberPlate, SPOT_SIZE size) {
		this.numberPlate = numberPlate;
		this.SIZE = size;
	}

	public String getNumberPlate() {
		return numberPlate;
	}
}
