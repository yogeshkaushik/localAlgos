package kaush.yog.parkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level {
	
	int id;
	public Map<SPOT_SIZE, List<Spot>> spotMap;
	int smallAvailable = 5; //20
	int compactAvailable = 5; //15
	int largeAvailable = 6; //10

	public Level(int id) {
		this.id = id;
		
		spotMap = new HashMap<>();
		List<Spot> list = new ArrayList<>();
		
		for (int i=0; i<20; i++) list.add(new Spot(i, id, SPOT_SIZE.SMALL));
		spotMap.put(SPOT_SIZE.SMALL, new ArrayList<Spot>(list));
		list.clear();
		
		for (int i=0; i<15; i++) list.add(new Spot(i, id, SPOT_SIZE.COMPACT));
		spotMap.put(SPOT_SIZE.COMPACT, new ArrayList<Spot>(list));
		list.clear();
		
		for (int i=0; i<10; i++) list.add(new Spot(i, id, SPOT_SIZE.LARGE));
		spotMap.put(SPOT_SIZE.LARGE, new ArrayList<Spot>(list));
		
	}

	public boolean isSpotAvailable(Vehicle vehicle) {
		if (vehicle instanceof MotorCycle) return smallAvailable != 0 || compactAvailable != 0;
		else if (vehicle instanceof Car) return compactAvailable != 0 || largeAvailable != 0; 
		else if (vehicle instanceof Bus) return isBusSizeAvailable() != -1;
		else throw new RuntimeException("This particular type of vehicle is not supported.");
	}

	private int isBusSizeAvailable() {
		if (largeAvailable >= 5) {
			List<Spot> spots = spotMap.get(SPOT_SIZE.LARGE);
			for (int i=0; i< spots.size(); i++) {
				if (spots.get(i).isAvailable()) {
					int j = i;
					int count = 1;
					while (++i<spots.size() && spots.get(i) == null) {
						count++;
						if (count == 5) return j;
					}					
				}
			}
		}
		return -1;
	}

	public Spot bookSpot(Vehicle vehicle) {
		if (vehicle instanceof Bus) return bookSpotForBus(vehicle);
		int index = getIndex(vehicle, vehicle.SIZE);
		Spot spot = spotMap.get(vehicle.SIZE).get(index);
		spot.parkVehicle(vehicle);
		int i = spot.SIZE == SPOT_SIZE.SMALL ? smallAvailable-- : (spot.SIZE == SPOT_SIZE.COMPACT ? compactAvailable-- : largeAvailable--);
		return spot;
	}

	private Spot bookSpotForBus(Vehicle vehicle) {
		List<Spot> spots = spotMap.get(SPOT_SIZE.LARGE);
		int j = isBusSizeAvailable();
		for (int i=j;i<j+5; i++) {
			spots.get(i).parkVehicle(vehicle);
		}
		largeAvailable -= 5;
		return spots.get(j);
	}

	private int getIndex(Vehicle vehicle, SPOT_SIZE size) {
		if (size == null) return -1;
		List<Spot> spots = spotMap.get(vehicle.SIZE);
		int index = -1;
		for (int i=0; i<spots.size(); i++) 
			if (spots.get(i).isAvailable()) {
				index = i;
				break;
			}
		if (index == -1) {
			return getIndex(vehicle, nextBigSize(vehicle));
		}
		return index;
	}

	private SPOT_SIZE nextBigSize(Vehicle vehicle) {
		if (vehicle.SIZE == SPOT_SIZE.SMALL) return SPOT_SIZE.COMPACT;
		if (vehicle.SIZE == SPOT_SIZE.COMPACT) return SPOT_SIZE.LARGE;
		return null;
	}

}
