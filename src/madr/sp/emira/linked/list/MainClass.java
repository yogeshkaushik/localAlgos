package madr.sp.emira.linked.list;

import java.util.HashMap;
import java.util.Map;

import javax.print.PrintServiceLookup;

import org.w3c.dom.Node;

public class MainClass {
	
	public static void main(String[] args) {
		/*LinkedNode<Integer> head = LinkedNode.createLinkedList(1,2,3,4,5,6,7);
		head.print();
		System.out.println("Count == "+ head.getCount());
		*
		*
		*/
		/*Node n0 = new Node();
		n0.data = 4;
		n0.next = null;
		
		Node n1 = new Node();
		n1.data = 21;
		n1.next = n0;
		
		Node n2 = new Node();
		n2.data = 5;
		n2.next = null;
		
		DoubleNode d = createdoublyLinkedList(1,2,3,4,5,6,7,8,9);
		printDLL(d);
		System.out.println();
		DoubleNode dll = rotateN_nodes(d, 3);
		printDLL(dll);*/
		
		//System.out.println("Ans : " + CompareLists(n1, n2));
		Node n = createLinkedList(8,3,4,2,6,9,7,0,1,5);
		printLL(n);
		System.out.println();
		Node sorted = sortLinkedList(n);
		System.out.println();
		printLL(sorted);
		
	}
	
	public static Node createLinkedList(int... values) {
		Node head = new Node();
		head.data = values[0];
		Node prev = head;
		for (int i=1; i<values.length; i++) {
			Node current = new Node();
			current.data = values[i];
			prev.next = current;
			prev = current;
		}
		return head;
	}
	
	/**
	 * Given an array {5,1,3,2,8}
	 * Sort the linked list in that order. LL contains elements from array, duplicate possible.
	 * 
	 * @param arr
	 * @return
	 */
	public static Node getLinkedListSorted(int[] arr, Node node) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i=0;
		int len = arr.length;
		for (;i<len;i++) map.put(arr[i], i);
		Node curr = node;
		Node head = node;
		while (node != null && node.next != null) {
			
		}
		return node;
	}
	
	/**
	 * 
	 * @param root
	 * @return
	 */
	public static Node sortLinkedList(Node root) {
		if (root == null || root.next == null) {
			return root;
		}
		Node mid = getMiddleNode(root);
		Node Lmerged = sortLinkedList(root);
		Node Rmerged = sortLinkedList(mid);
		root = mergeLists(Lmerged, Rmerged);
		//printLL(root);
		return root;
	}
	
	private static Node getMiddleNode(Node root) {
		Node fastNode = root;
		Node prev = null;
		while (fastNode != null && fastNode.next != null) {
			fastNode = fastNode.next.next;
			prev = root;
			root = root.next;
		}
		if (prev != null) prev.next = null;
		return root;
	}
	
	private static DoubleNode createdoublyLinkedList(int... v) {
		DoubleNode curr = null;
		DoubleNode root = null;
		for (int val : v) {
			if (curr == null) {
				curr = getDLLNode(val);
				root = curr;
			} else {
				DoubleNode temp = getDLLNode(val);
				curr.next = temp;
				temp.prev = curr;
				curr = curr.next;
			}
		}
		return root;
	}
	
	private static void printDLL(DoubleNode root) {
		System.out.print("Null");
		while(root != null) {
			System.out.print("<-->"+root.data);
			root = root.next;
		}
		System.out.print("<-->Null");
	}

	private static void printLL(Node root) {
		while(root != null) {
			System.out.print(root.data + "--->");
			root = root.next;
		}
		System.out.print("Null");
	}
	
	private static DoubleNode getDLLNode(int v) {
		DoubleNode d = new DoubleNode();
		d.data = v;
		return d;
	}

	public static DoubleNode rotateN_nodes(DoubleNode root, int n) {		
		int t = n;
		DoubleNode curr = root;
		DoubleNode temp = root;
		while (curr != null && curr.next != null ) {
			while(t>1 && curr != null) {
				t--;
				curr = curr.next;
				temp = temp.next;
			}
			curr = curr.next;			
		}
		curr.next = root;
		root.prev = curr;
		root = temp.next;
		temp.next = null;
		root.prev = null;
		return root;		
	}
	
	/*
	Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

	A Node is defined as: 
	    class Node {
	        int data;
	        Node next;
	    }
	*/
	boolean hasCycle(Node head) {
	    if (head  == null || head.next == null) {
	        return false;
	    }
	    Node curr = head;
	    while (curr != null && curr.next != null) {
	        head = head.next;
	        curr = curr.next.next;
	        if (curr != null && curr.next != null && head.next == curr.next) {
	            return true;
	        }
	    }
	    return false;
	}

	
	/*
	Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	Node RemoveDuplicates(Node head) {
		Node curr = head;
	    Node temp = head;
	    while (head != null) {
	        head = head.next;
	        if (head == null) {
	            break;
	        }
	        if (curr.data != head.data) {
	            curr = curr.next;
	        } else {
	            while (head != null && head.next != null && head.data == head.next.data) {
	                head = head.next;
	            }
	            curr.next = head.next;
	        }
	    }
	    return temp;
	}

	/*
	  Find merge point of two linked lists
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	int FindMergeNode(Node headA, Node headB) {
	    if (headA == null || headA.next == null || headB ==null || headB.next == null) {
	        return -1;
	    }
	    int countA = getCountNew(headA);
	    int countB = getCountNew(headB);
	    int diff = 0;
	    if (countA > countB) {
	        diff = countA - countB;
	        while (diff != 0) {
	            diff--;
	            headA = headA.next;
	        }
	    } else if (countA < countB) {
	        diff = countB - countA;
	        while (diff != 0) {
	            diff--;
	            headB = headB.next;
	        }
	    } else {
	        while (headA.next != null) {
	            if (headA.next == headB.next) {
	                return headA.next.data;
	            }
	            headA = headA.next;
	            headB = headB.next;
	        }
	    }
	    while (headA.next != null) {
	        if (headA.next == headB.next) {
	            return headA.next.data;
	        }
	        headA = headA.next;
	        headB = headB.next;
	    }	    
	    return headA.data;
	}
	
	/*
	  Insert Node at the end of a linked list 
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	     Node prev;
	  }
	*/
	DoubleNode SortedInsert(DoubleNode head,int data) {
		DoubleNode n = new DoubleNode();
	    n.data = data;
	    n.prev = null;
	    n.next = null;
	    if (head == null) {
	        head = n;
	        return head;
	    }
	    DoubleNode temp = head;
	    DoubleNode prev = null;
	    while (temp != null) {
	        if (temp.data >= n.data) {
	            temp.prev = n;
	            n.next = temp;
	            n.prev = prev;
	            if (prev != null) {
	                prev.next = n;
	            }
	            break;
	        } else {
	            if (temp.next == null) {
	                temp.next = n;
	                n.prev = temp;
	                break;
	            }
	            prev = temp;
	            temp = temp.next;
	        }
	    }
	    return head;
	}

	public static class DoubleNode {
		int data;
		DoubleNode next;
		DoubleNode prev;
	}

	public static int getCountNew(Node node) {
	    int count = 0;
	    while(node != null) {
	        count++;
	        node = node.next;
	    }
	    return count;
	}
	
	/*
	  Get Nth element from the end in a linked list of integers
	  Number of elements in the list will always be greater than N.
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	int GetNodeFromEnd(Node head,int n) {
	    Node curr = head;
	    while (head.next != null) {
	        if (n == 0) {
	            curr = curr.next;
	        } else {
	            n--;
	        }
	        head = head.next;
	    }
	    return curr.data;
	}

	/*
	  Insert Node at the end of a linked list 
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	     Node prev;
	  }
	*/
	DoubleNode ReverseDoublyLinkedList(DoubleNode head) {
	    if (head == null || head.next == null) {
	        return head;
	    }
	    DoubleNode prev = null;
	    while (head != null) {
	    	DoubleNode curr = head;
	        head = head.next;
	        curr.next = prev;
	        curr.prev = head;
	        prev = curr;
	    }
	    return prev;
	}

	
	/*
	  Reverse a linked list and return pointer to the head
	  The input list will have at least one element  
	  Node is defined as  
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	Node Reverse(Node head) {
	    if (head == null || head.next == null) {
	        return head;
	    }
	    Node curr = head;
	    Node prev = null;
	    while(curr != null) {
	        Node n = curr.next;
	        curr.next = prev;
	        prev = curr;
	        curr = n;
	    }
	    return prev;
	}

	/*
	  Merge two linked lists 
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	static Node mergeLists(Node headA, Node headB) {
	    if (headA == null || headB == null) {
	        return headA == null ? headB : headA;
	    }
	    Node currA = headA;
	    Node prevA = null;
	    Node currB = headB;
	    Node prevB = null;
	    while (currA != null && currB != null) {
	        if (currA.data <= currB.data) {
	            prevA = currA;
	            currA = currA.next;
	        } else {
	            Node n = currB.next;
	            currB.next = currA;
	            if (prevA != null) {
	                prevA.next = currB;
	            } else {
	                headA = headB;
	            }
	            prevA = currB;
	            currB = n;
	        }
	    }
	    if (currA == null) {
	        prevA.next = currB;
	    }
	    return headA;
	}

	
	/*
	  Print elements of a linked list in reverse order 
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	void ReversePrint(Node head) {
	    if (head == null) {
	        return;
	    }
	    StringBuffer str = new StringBuffer();
	    while(head != null) {
	        str.append(head.data+",");
	        head = head.next;
	    }
	    String[] strArr = (str.toString()).split(",");
	    for (int i=strArr.length-1; i>=0; i--){
	        System.out.println(strArr[i]);
	    }
	}

	
	/*
	  Delete Node at a given position in a linked list 
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	Node DeleteNth(Node head, int position) {
	    if (head == null) {
	        return head;
	    }
	    if (position == 0) {
	        Node curr = head;
	        curr = head.next;
	        head.next = null;
	        return curr;
	    }    
	    Node curr = head;
	    Node prev = null;
	    while (position != 0 && curr.next != null) {
	        position--;
	        prev = curr;
	        curr = curr.next;
	    }
	    prev.next = curr.next;
	    curr.next = null;
	    return head;
	}
	
	/*
	  Insert Node at the end of a linked list 
	  head pointer input could be NULL as well for empty list
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	Node InsertAtLast(Node head,int data) {
	    if (head == null) {
	        head = new Node();
	        head.data = data;
	        return head;
	    }
	    Node curr = head;
	    while(curr.next != null) {
	        curr = curr.next;
	    }
	    Node n = new Node();
	    n.data = data;
	    n.next = null;
	    curr.next = n;
	    return head;
	}

	/*
	  Insert Node at a given position in a linked list 
	  head can be NULL 
	  First element in the linked list is at position 0
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	Node InsertNth(Node head, int data, int position) {
	    Node n = new Node();
	    n.data = data;
	    n.next = null;
	    if (head == null) {
	        return n;
	    }
	    if (position == 0) {
	        n.next = head;
	        return n;
	    }    
	    Node next = head;
	    Node curr = null;
	    while(position != 0 && next != null) {
	        position--;
	        curr = next;
	        next = next.next;
	    }
	    curr.next = n;
	    n.next = next;
	    return head;
	}

	
	/*
	  Compare two linked lists A and B
	  Return 1 if they are identical and 0 if they are not. 
	  Node is defined as 
	  class Node {
	     int data;
	     Node next;
	  }
	*/
	static int CompareLists(Node headA, Node headB) {
	    if (headA == null || headB == null || getCount(headA) != getCount(headB)) {
	        return 0;
	    }
	    Node nextA = headA;
	    Node nextB = headB;
	    do {
	        if (nextA.data != nextB.data) {
	            return 0;
	        }
	        nextA = nextA.next;
	        nextB = nextB.next;        
	    } while(hasNext(nextA));
	    
	    return 1;  
	}

	public static int getCount(Node linkedNode) {
	    int count = 1;
	    while(hasNext(linkedNode)) {
	        count++;
	        linkedNode = linkedNode.next;
	    }
	    return count;
	}

	public static boolean hasNext(Node node) {
	    /*if (node.next != null) {
	        return true;
	    }
	    return false;*/
	    return node.next != null;
	}
	
	public static class Node {
		int data;
		Node next;
	}
}
