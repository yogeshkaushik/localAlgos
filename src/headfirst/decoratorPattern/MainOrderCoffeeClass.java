package headfirst.decoratorPattern;

import headfirst.decoratorPattern.decorators.CondimentDecorator;
import headfirst.decoratorPattern.decorators.Mocha;
import headfirst.decoratorPattern.decorators.SteamedMilk;
import headfirst.decoratorPattern.decorators.Whip;

public class MainOrderCoffeeClass {
	
	public static void main(String[] args) {
		System.out.println("Hello, What would you like to order");
		Beverage houseBlend = new HouseBlend();
		CondimentDecorator withMocha = new Mocha(houseBlend);		
		CondimentDecorator steamed = new SteamedMilk(withMocha);		
		CondimentDecorator withWhip = new Whip(steamed);
		
		System.out.println("here is your total amount : "+withWhip.cost());
		System.out.println("Your coffee : "+withWhip.getDescription()+" is ready sir");
	}
}
