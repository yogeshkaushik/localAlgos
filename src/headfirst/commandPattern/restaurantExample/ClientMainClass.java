package headfirst.commandPattern.restaurantExample;

import headfirst.commandPattern.restaurantExample.Order.TYPE;

public class ClientMainClass {

	public static void main(String[] args) {
		Order o1 = new BurgerMeal();
		((BurgerMeal) o1).addOrder(TYPE.BURGER);
		((BurgerMeal) o1).addOrder(TYPE.COKE);
		((BurgerMeal) o1).addOrder(TYPE.FRENCH_FRIES);
		
		Order pizza = new PizzaMeal(TYPE.PIZZA);
		
		Cook c = new Cook();
		
		
		IWaitress w = new Waitress(c);
		w.createOrder(o1);
		w.orderUp();
		
		w.createOrder(pizza);
		w.orderUp();
	}
}
