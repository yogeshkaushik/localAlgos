package kaush.yog.ATM.dispenser;

import kaush.yog.ATM.Currency;

/**
 * Chain of Responsibility Pattern
 * @author yogeshk
 *
 */
public interface IDispenser {
	
	public void setNextDispenser(IDispenser dispenser);
	
	public void dispense(Currency curr);	
}
