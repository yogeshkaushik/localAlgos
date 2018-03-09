package headfirst.commandPattern.houseHoldDevices;

public class GarageDoor implements IHouseHold {

	@Override
	public void on() {
		up();
	}

	@Override
	public void off() {
		down();
	}
	
	void up() {
		System.out.println("Raise the shutter up");
	}
	
	void down() {
		System.out.println("pull the shutter down");
	}
	
	public void stop() {
		System.out.println("stop the rolling");
	}
	
	public void lightsOn() {
		System.out.println("Switch ON the lights inside Garage");
	}
	
	public void lightsOff() {
		System.out.println("Switch OFF the lights inside Garage");
	}

}
