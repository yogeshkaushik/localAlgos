package kaush.yog.ATM;

import kaush.yog.ATM.dispenser.Denom1000Dispenser;
import kaush.yog.ATM.dispenser.IDispenser;

public class ATMMachine {
	
	public static void main(String[] args) {
		String card = readCard();
		String pin = enterPin();
		boolean bool = authenticate(card,pin);
		if (!bool) System.out.println("Wrong Pin!!!");
		else {
			System.out.println("Authentication Successfull!!!");
			int amount = enterAmount();
			Currency curr = new Currency(amount);
			IDispenser dispenser = new Denom1000Dispenser();
			dispenser.dispense(curr);
		}
	}

	private static int enterAmount() {
		return 11900;
	}

	private static boolean authenticate(String card, String pin) {
		return Authenticator.authenticate(card,pin);
	}

	private static String enterPin() {
		return "1234";
	}

	private static String readCard() {
		return "4111 1111 1111 1111";
	}
	
	/**
	 * 
	 * 
 	protected static final int[] currDenom = { 1000, 500, 100, 50 , 10 };
	protected static int[] currNo = {1,4,2,2,10};
	protected  int[] count = { 0, 0, 0, 0 ,0};
	protected static int totalCorpus = 0;
	protected  int amount=0;
	public  synchronized  void  withdrawCash(){
    	if(amount<=totalCorpus){
            for (int i = 0; i < currDenom.length; i++) {
                if (currDenom[i] <= amount) {//If the amount is less than the currDenom[i] then that particular denomination cannot be dispensed
                    int noteCount = amount / currDenom[i];
                    if(currNo[i]>0){//To check whether the ATM Vault is left with the currency denomination under iteration
                        //If the Note Count is greater than the number of notes in ATM vault for that particular denomination then utilize all of them 
                        count[i] = noteCount>=currNo[i]?currNo[i]:noteCount;
                        currNo[i] =  noteCount>=currNo[i]?0:currNo[i]- noteCount;
                        //Deduct the total corpus left in the ATM Vault with the cash being dispensed in this iteration
                        totalCorpus=totalCorpus-(count[i]*currDenom[i]);
                        //Calculate the amount that need to be addressed in the next iterations
                        amount = amount -(count[i]*currDenom[i]);
                    }                
                }
            }
            displayNotes();
            displayLeftNotes();

        }
        else{
            System.out.println("Unable to dispense cash at this moment for this big amount");
        }

    }
	 */
}
