package kaush.yog.parkingLot;

public enum SPOT_SIZE {
	SMALL,
	COMPACT,
	LARGE;
	
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
}
