package headfirst.decoratorPattern.decorators;

import headfirst.decoratorPattern.Beverage;

public class Mocha implements CondimentDecorator{

	Beverage beverage;
	
	public Mocha(Beverage mBeverage) {
		beverage = mBeverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + " with Mocha";
	}

	@Override
	public double cost() {
		return beverage.cost() + 15.33;
	}

}
