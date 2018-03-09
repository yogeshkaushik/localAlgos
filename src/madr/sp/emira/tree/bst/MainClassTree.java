package madr.sp.emira.tree.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.omg.CORBA.INTERNAL;

public class MainClassTree {
	
	static Node root;
	static int counter;
	
	public static void main(String[] args) {		
		createTree();		
		System.out.println(searchNode(root, 44));
		System.out.println(searchNode(root, 12));
		System.out.println(searchNode(root, 32));
		
		preorder(root);
		System.out.println();
		System.out.println(preorderNonRecursive(root));
		inOrder(root);
		System.out.println();
		inOrderNonRecursive(root);
		postOrder(root);
		System.out.println();
		System.out.println(postOrderNonRecursive(root));
		levelOrderTraversal(root);
		System.out.println(levelOrderQueue(root));
		
		System.out.println(heightOfTree(root));
		topView(root);
	}

	private static void createTree() {
		root = insertNode(null, 25);
		insertNode(root, 15);
		insertNode(root, 50);
		insertNode(root, 10);
		insertNode(root, 22);
		insertNode(root, 35);
		insertNode(root, 70);
		insertNode(root, 4);
		insertNode(root, 12);
		insertNode(root, 18);
		insertNode(root, 24);
		insertNode(root, 31);
		insertNode(root, 44);
		insertNode(root, 66);
		insertNode(root, 90);
	}
	
	public static void preorder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.leftChild);
			preorder(root.rightChild);
		}
	}
	
	public static List<Integer> preorderNonRecursive(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while (!s.isEmpty()) {
			Node temp = s.pop();
			list.add(temp.data);
			if (temp.rightChild != null) s.push(temp.rightChild);
			if (temp.leftChild != null) s.push(temp.leftChild);
		}
		return list;
	}
	
	public static void inOrder(Node root) {
		if (root != null) {
			inOrder(root.leftChild);
			System.out.print(root.data + " ");
			inOrder(root.rightChild);
		}
	}
	
	public static void postOrder(Node root) {
		if (root != null) {
			postOrder(root.leftChild);
			postOrder(root.rightChild);
			System.out.print(root.data + " ");
		}
	}
	
	public static void inOrderNonRecursive(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		Node temp = root;
		while (true) {
			if ( temp!=null ) {
				stack.push(temp);
				temp = temp.leftChild;
			} else {
				if (stack.isEmpty()) {
					break;
				}
				temp = stack.pop();
				list.add(temp.data);
				temp = temp.rightChild;
			}
		}
		System.out.println(list.toString());
	}
	
	public static List<Integer> postOrderNonRecursive(Node root) {
		if (root == null) {
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		Node prev = root;
		while (!stack.isEmpty()) {
			Node curr = stack.peek();
			boolean isLeaf = curr.leftChild == null && curr.rightChild == null;
			boolean subtreeDone = curr.rightChild == prev || curr.leftChild == prev;
			if (isLeaf || subtreeDone) {
				Node temp = stack.pop();
				list.add(temp.data);
				prev = curr;
			} else {
				if (curr.rightChild != null) {
			      stack.push(curr.rightChild);
			    }
			    if (curr.leftChild != null) {
			      stack.push(curr.leftChild);
			    }
			}
		}
		return list;
	}
	
	public static void levelOrderTraversal(Node root) {
		int height = height(root);
		List<Integer> list = new ArrayList<Integer>();
		list.add(root.data);
		for (int i=1;i<=height;i++) {
			list.addAll(levelOrderRecursiveHelp(root, i));			
		}
		System.out.println(list);
	}
	
	public static List<Integer> levelOrderRecursiveHelp(Node root, int level) {
		level--;
		if (root == null) {
            return new ArrayList<Integer>();
        }
		if (level == 0) {
			List<Integer> l = new ArrayList<Integer>();
			if (root.leftChild != null) {
                l.add(root.leftChild.data);
            }
            if (root.rightChild != null) {
                l.add(root.rightChild.data);
            }
			return l;
		}
		List<Integer> child = new ArrayList<Integer>();
		child.addAll(levelOrderRecursiveHelp(root.leftChild, level));
		child.addAll(levelOrderRecursiveHelp(root.rightChild, level));
		return child;
	}
	
	public static List<Integer> levelOrderQueue(Node root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			throw new IllegalArgumentException("Tree is a null tree");
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node temp = q.poll();
			list.add(temp.data);
			if (temp.leftChild != null) {
				q.add(temp.leftChild);
			}
			if (temp.rightChild != null) {
				q.add(temp.rightChild);
			}
		}
		return list;
	}
	
	public static Node insertNode(Node root, int data) {
		if (root == null) {
			return new Node(data);			
		}		
		if (data <= root.data) {
			Node n = insertNode(root.leftChild, data);
			root.leftChild = n;
		} else {
			Node n = insertNode(root.rightChild, data);
			root.rightChild = n;
		}
		return root;
	}
	
	public static boolean searchNode(Node root, int data) {		
		if (root == null) {
			return false;
		}
		
		if (root.data == data) {
			return true;
		}
		
		if (data < root.data) {
			return searchNode(root.leftChild, data);
		} else {
			return searchNode(root.rightChild, data);
		}
	}
	
	public static int heightOfTree(Node root) {
		if (root == null) {
			return 0;
		} else {
			int left = heightOfTree(root.leftChild);
			int right = heightOfTree(root.rightChild);
			
			if (left > right) {
				return left + 1;
			} else {
				return right + 1;
			}
		}
	}
	
	public static void topView(Node root) {
	}
	
	public static boolean heightWithoutRec(Node root) {
		Stack<Node> sL = new Stack<Node>();
		String s = "DS";
		char c = s.charAt(0);
		s = s + c;
		return c=='D' ? true : false;
	}
	
	public void decode(String S ,Node root){
	    String str = "";
	    Node temp = root;
	    for (int i=0; i<S.length(); i++) {
	        char c = S.charAt(i);
	        if (c == '0') {
	            temp = temp.leftChild;            
	        } else if (c == '1') {
	            temp = temp.rightChild;
	        }
	        if (temp.data == 'ϕ') {
	            continue;
	        } else {
	            str = str + temp.data;
	            temp = root;
	        }
	    }
	    System.out.print(str);
	}
	
	public static int height(Node root) {
		if (root == null) {
			return -1;
		}
		int left = height(root.leftChild) + 1;
		int right = height(root.rightChild) + 1;
		if (left > right) {
			return left;
		} else {
			return right;
		}
	}
	
	public static class Node {
		
		public int data;		
		public Node leftChild;		
		public Node rightChild;
		
		public Node(int pData) {
			data = pData;
		}
		
		@Override
		public String toString() {
			return ""+data;
		}
	}
	
	public void printBST(Node root) {
		//
	}
}
