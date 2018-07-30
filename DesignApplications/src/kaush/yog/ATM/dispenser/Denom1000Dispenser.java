package kaush.yog.ATM.dispenser;

import kaush.yog.ATM.Currency;

public class Denom1000Dispenser implements IDispenser {
	
	IDispenser next;
	
	public Denom1000Dispenser() {
		next = new Denom500Dispenser();
	}

	@Override
	public void setNextDispenser(IDispenser dispenser) {
		next = dispenser;	
	}

	@Override
	public void dispense(Currency curr) {
		if (curr.getAmount() > 1500) {
			int remainder = curr.getAmount()%1000;
			System.out.println("1000Denomination Notes => " + curr.getAmount()/1000);
			if (remainder!=0) next.dispense(new Currency(remainder));
		} else {
			next.dispense(curr);
		}
	}

}
