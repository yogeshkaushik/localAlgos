package kaush.yog.ATM.dispenser;

import kaush.yog.ATM.Currency;

public class Denom500Dispenser implements IDispenser {
	
	IDispenser next;
	
	public Denom500Dispenser() {
		next = new Denom100Dispenser();
	}

	@Override
	public void setNextDispenser(IDispenser dispenser) {
		next = dispenser;	
	}

	@Override
	public void dispense(Currency curr) {
		if (curr.getAmount() > 700) {
			int remainder = curr.getAmount()%500;
			System.out.println("500Denomination Notes => " + curr.getAmount()/500);
			if (remainder!=0) next.dispense(new Currency(remainder));
		} else {
			next.dispense(curr);
		}
	}
}
