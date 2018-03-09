package headfirst.commandPattern;

import headfirst.commandPattern.houseHoldDevices.IHouseHold;

public class Intent {
	
	enum Action{
		ON,Off
	}
	
	IHouseHold _instance;
	Action action;
	
	public Intent(IHouseHold houseHold, Action action) {
		_instance = houseHold;
		this.action = action;
	}
	
	public void performAction() {
		if (action == Action.ON) {
			_instance.on();
		} else {
			_instance.off();
		}
	}
}
