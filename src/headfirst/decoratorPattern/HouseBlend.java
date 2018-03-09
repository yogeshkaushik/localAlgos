package headfirst.decoratorPattern;

public class HouseBlend implements Beverage{

	@Override
	public String getDescription() {
		return "House Blend Coffee";
	}

	@Override
	public double cost() {
		return 89.55;
	}	
}
