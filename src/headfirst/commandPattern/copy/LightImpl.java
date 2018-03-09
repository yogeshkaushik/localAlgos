package headfirst.commandPattern.copy;

public class LightImpl implements IRemoteHandler {
	
	LightVendorImpl light;
	
	public LightImpl(LightVendorImpl pLight) {
		this.light = pLight;
	}

	@Override
	public String getName() {
		return "Light Implementaion of Light Vendor Class";
	}

	@Override
	public void on() {
		System.out.println("perform 'ON' ops");
		light.onSomeColoLight();
	}

	@Override
	public void off() {
		System.out.println("perform 'OFF' ops");
		light.OffThat();		
	}

}
