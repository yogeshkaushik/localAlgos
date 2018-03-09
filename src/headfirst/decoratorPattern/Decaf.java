package headfirst.decoratorPattern;

public class Decaf implements Beverage{

	@Override
	public String getDescription() {
		return "Decaf";
	}

	@Override
	public double cost() {
		return 92.35;
	}	
}
