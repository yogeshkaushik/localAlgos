package headfirst.commandPattern.houseHoldDevices;

public class CellingFan implements IHouseHold{
	
	int i = 0;

	@Override
	public void on() {
		if (i == 0) {
			low();
			i++;
		} else if (i == 1) {
			medium();
			i++;
		} else if (i == 2) {
			high();
			i = 0; //reset
		}
	}

	@Override
	public void off() {
		System.out.println("Celling Fan is switched off");
	}
	
	void high() {
		System.out.println("Celling Fan is running with high speed");
	}
	
	void medium() {
		System.out.println("Celling Fan is running with medium speed");
	}
	
	void low() {
		System.out.println("Celling Fan is running with low speed");
	}
}
