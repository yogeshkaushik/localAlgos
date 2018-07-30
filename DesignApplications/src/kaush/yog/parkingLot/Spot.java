package kaush.yog.parkingLot;

public class Spot {
	
	Vehicle vehicle;
	int levelNo;
	int id;	
	SPOT_SIZE SIZE;
	
	public Spot(int spotNum, int levelNum, SPOT_SIZE size) {
		this.id = spotNum;
		this.SIZE = size;
		this.levelNo = levelNum;
	}

	public boolean isAvailable() {
		return vehicle==null;
	}

	public Vehicle vacateSpot() {
		Vehicle temp = vehicle;
		vehicle = null;
		return temp;
	}

	public void parkVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
