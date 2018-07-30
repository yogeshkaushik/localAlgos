package kaush.yog.parkingLot;

import java.util.List;

public class ParkingLot {
	
	private volatile static ParkingLot _instance;

	private Level[] levels;
	
	private ParkingLot() {
		levels = new Level[5];
		for (int i=0; i<5; i++) {
			levels[i] = new Level(i);
		}
	}
	
	public static ParkingLot getInstance() {
		if (_instance == null) {
			synchronized (ParkingLot.class) {
				if (_instance == null) {
					_instance = new ParkingLot();
				}
			}
		}
		return _instance;
	}
	
	public Spot parkVehicle(Vehicle vehicle) {
		Spot spot = null;
		for (int i=0; i<levels.length; i++) {
			Level level = levels[i];
			if (level.isSpotAvailable(vehicle)) {
				spot = level.bookSpot(vehicle);
				return spot;
			}
		}
		System.out.println("Sorry!!! No Space Available");
		//parkingMap.put(vehicle.getNumberPlate(), spot);
		return spot;
	}
	
	public void getVehicle(Vehicle v) {
		/*Spot spot = parkingMap.get(v.getNumberPlate());
		spot.vacateSpot(v);*/
		if (v instanceof Bus) vacateBusSpots(v);
		else {
			int levelId = v.levelId;
			int spotId = v.spotId;
			levels[levelId].spotMap.get(v.SIZE).get(spotId).vacateSpot();
		}
	}
	
	public void getVehicle(Spot spot) {
		int levelId = spot.levelNo;
		int spotId = spot.id;
		levels[levelId].spotMap.get(spot.SIZE).get(spotId).vacateSpot();
	}

	private void vacateBusSpots(Vehicle v) {
		Level level = levels[v.levelId];
		List<Spot> spots = level.spotMap.get(v.SIZE);
		int spotId = v.spotId;
		for (int i=spotId; i<spotId+5; i++) spots.get(i).vacateSpot();
	}
}
