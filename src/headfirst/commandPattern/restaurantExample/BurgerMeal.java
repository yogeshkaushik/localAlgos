package headfirst.commandPattern.restaurantExample;

import java.util.HashSet;
import java.util.Set;

public class BurgerMeal implements Order {
	
	private Set<TYPE> orders = new HashSet<TYPE>();
	
	public void createOrder() {
		System.out.println("Creating Order ...");
	}

	public void addOrder(TYPE string) {
		orders.add(string);
	}
	
	public Set<TYPE> getOrders() {
		return orders;
	}

	@Override
	public void makeOrder() {
		System.out.println("Making The Order ... ");
		for (TYPE t : orders) {
			System.out.println("@"+t.toString()+" Done!!!");
		}
	}
}
