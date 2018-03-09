package madr.sp.emira.linked.list;

public class Node<A> {
	
	private A value;
	
	private Node<A> next;
	
	public Node(A pValue) {
		value = pValue;
	}
	
	public Node(A pValue, Node<A> n) {
		value = pValue;
		next = n;
	}
	
	public Node() {
	}

	public A getValue() {
		return value;
	}

	public void setValue(A value) {
		this.value = value;
	}

	public Node<A> getNext() {
		return next;
	}

	public void setNext(Node<A> next) {
		this.next = next;
	}

	public int getCount() {
		return getCount(this);
	}
	
	public int getCount(Node<A> linkedNode) {
		int count = 1;
		while(linkedNode.hasNext()) {
			count++;
			linkedNode = linkedNode.next;
		}
		return count;
	}

	public boolean hasNext() {
		if (this.next != null) {
			return true;
		}
		return false;
	}
	
	public void print() {
		print(this);
	}

	public void print(Node<A> node) {
		StringBuffer str = new StringBuffer();
		str = str.append("##head##");
		while(node.hasNext()) {
			str.append("--->" + node.value);
			node = node.next;
		}
		str.append("--->"+node.value);
		System.out.println(str.toString());
	}
	
	public static <A> Node<A> createLinkedList(A... values) {
		Node<A> head = new Node<A>(values[0]);
		Node<A> prev = head;
		for (int i=1; i<values.length; i++) {
			Node<A> current = new Node<A>(values[i]);
			prev.next = current;
			prev = current;
		}
		return head;
	}
	
	public String toString() {
		return this.value.toString();
	}
}
