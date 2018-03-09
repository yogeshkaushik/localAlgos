package headfirst.commandPattern.restaurantExample;

public class PizzaMeal implements Order{

	TYPE t;
	
	public PizzaMeal(TYPE t) {
		this.t = t;
	}
	
	@Override
	public void makeOrder() {
		System.out.println("@" + t + " - That's How we create the Pizza");
	}
	
}
