package headfirst.commandPattern;

import headfirst.commandPattern.Intent.Action;
import headfirst.commandPattern.houseHoldDevices.CellingFan;
import headfirst.commandPattern.houseHoldDevices.GarageDoor;
import headfirst.commandPattern.houseHoldDevices.IHouseHold;

public class RemoteControl {
	
	enum HOUSEHOLD {
		FAN,GARAGE,TV,Stereo,Light
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Testing the Remote");
		
		IHouseHold houseHold = HouseHoldFactory.getHouseHold(HOUSEHOLD.GARAGE);
		Intent intent = new Intent(houseHold,Action.ON);
		intent.performAction();
	}

	
	public static class HouseHoldFactory {
		
		public static IHouseHold getHouseHold(HOUSEHOLD e) {
			if (e == HOUSEHOLD.FAN) {
				return new CellingFan();
			} else if (e == HOUSEHOLD.GARAGE) {
				return new GarageDoor();
			}
			return null;
		}
	}
}
