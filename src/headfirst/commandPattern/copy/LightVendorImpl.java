package headfirst.commandPattern.copy;

public class LightVendorImpl {
	//No control over this class.
	void onSomeColoLight() {
		System.out.println(this.getClass().getSimpleName() + " - Performed 'on' operation with Yellow color");
	}
	
	void OffThat() {
		System.out.println(LightVendorImpl.class.getSimpleName() + " - performed 'off' op");
	}
}
