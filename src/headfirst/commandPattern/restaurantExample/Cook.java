package headfirst.commandPattern.restaurantExample;

public class Cook {
	
	public void prepareOrder(Order order){		
		System.out.println("Started Preparing Each Order");
		/*for (String order : ((BurgerMeal) o).getOrders()) {
			System.out.println("Prepare .... ::" + order);
		}*/
		order.makeOrder();
		sendOrder();
	}
	
	public void sendOrder() {
		System.out.println("Order Done!!! Give it to customers");
	}

}
