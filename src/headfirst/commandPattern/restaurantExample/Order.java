package headfirst.commandPattern.restaurantExample;

public interface Order {
	
	enum TYPE {
		BURGER,FRENCH_FRIES,COKE,POTATOCHIPS,PIZZA,NOODLES
	}
	public void makeOrder();
}
