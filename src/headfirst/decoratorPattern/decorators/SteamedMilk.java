package headfirst.decoratorPattern.decorators;

import headfirst.decoratorPattern.Beverage;

public class SteamedMilk implements CondimentDecorator{

	Beverage beverage;
	
	public SteamedMilk(Beverage mBeverage) {
		beverage = mBeverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + " with Steamed milk";
	}

	@Override
	public double cost() {
		return beverage.cost() + 25.00;
	}

}
