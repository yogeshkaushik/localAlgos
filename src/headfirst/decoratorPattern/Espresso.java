package headfirst.decoratorPattern;

public class Espresso implements Beverage{

	@Override
	public String getDescription() {
		return "Espresso";
	}

	@Override
	public double cost() {
		return 118.45;
	}	
}
