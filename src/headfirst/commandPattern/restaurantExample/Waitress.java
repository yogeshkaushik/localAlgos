package headfirst.commandPattern.restaurantExample;

public class Waitress implements IWaitress{
	
	Order order;
	Cook cook;

	public Waitress(Cook cook) {
		this.cook = cook;				
	}
	
	@Override
	public void createOrder(Order o) {
		order = o;
		System.out.println("Creating Order ...");
	}
	
	@Override
	public void orderUp() {
		cook.prepareOrder(order);
	}
}
