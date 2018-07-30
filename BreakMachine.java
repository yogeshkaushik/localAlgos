public class BreakMachine {
    static class Node {
	Node next;
    }
    public static void main(String[] args) {
	boolean bool = true;
	Node root = new Node();
	try {
	    System.out.println("Expect the Unexpect");
	    while (bool) {
	        Node temp = new Node();
	    	root.next = temp;
	    	root = root.next;
	    }
	} catch (Throwable t) {
	    System.out.println("Exception :: ");
	    t.printStackTrace();
	}	 	
    }
}
