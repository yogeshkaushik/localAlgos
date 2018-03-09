package headfirst.commandPattern.copy;

import headfirst.commandPattern.copy.RemoteController.OPS;

public class CPMainClass {
	
	public static void main(String[] args) {
		IRemoteHandler remoteLight = new LightImpl(new LightVendorImpl());
		RemoteController controller = new RemoteController();
		controller.addSlot(1, remoteLight);
		
		controller.runSlot(1, OPS.ON);
	}

}
