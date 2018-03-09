package headfirst.decoratorPattern.decorators;

import headfirst.decoratorPattern.Beverage;

public class Whip implements CondimentDecorator{

	Beverage beverage;
	
	public Whip(Beverage mBeverage) {
		beverage = mBeverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + " with Whip cream";
	}

	@Override
	public double cost() {
		return beverage.cost() + 15.32;
	}

}
