package kaush.yog.ATM.dispenser;

import kaush.yog.ATM.Currency;

public class Denom100Dispenser implements IDispenser {
	
	IDispenser next;

	@Override
	public void setNextDispenser(IDispenser dispenser) {
		next = dispenser;	
	}

	@Override
	public void dispense(Currency curr) {
		System.out.println("100Denomintaion Notes => "+curr.getAmount()/100);
	}
}
