package headfirst.commandPattern.copy;

import java.util.HashMap;
import java.util.Map;

public class RemoteController {
	
	enum OPS {
		ON,OFF;
	}
	
	private Map<Integer, IRemoteHandler> slots;
	
	public RemoteController() {
		slots = new HashMap<Integer, IRemoteHandler>();
		initializeSlots();
	}
	
	public void addSlot(Integer atPosition, IRemoteHandler appliance) {
		System.out.println("Added " + appliance.getName() + " appliance @slot number : " + atPosition);
		slots.put(atPosition, appliance);
	}
	
	public void undo() {
		slots.clear();
		initializeSlots();
		System.out.println("Removed all devices from all the slots.");
	}
	
	private void initializeSlots() {
		IRemoteHandler defaultOne = new DefaultControl();
		for (int i=1; i<=7; i++)
			slots.put(i, defaultOne);
	}

	public void runSlot(Integer slotNo, OPS ops) {
		if (slotNo < 1 || slotNo > 7) {
			throw new IllegalArgumentException("The pressed slot");
		}
		IRemoteHandler remote = slots.get(slotNo);
		if (ops == OPS.ON) remote.on();
		if (ops == OPS.OFF) remote.off();
	}
	
	private class DefaultControl implements IRemoteHandler {

		@Override
		public String getName() {
			return "Default One, Does nothing, but fills the unfilled space of remote, "
					+ "so no exception comes if someone presses unfilled slot by mistake.";
		}

		@Override
		public void on() {
			System.out.println("DO NOTHING");
		}

		@Override
		public void off() {
			System.out.println("DO NOTHING");
		}
		
	}
}
