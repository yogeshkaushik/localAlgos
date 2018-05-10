package madr.sp.emira.tree.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class IBitTree {
	
	public static void main(String[] args) {
		IBitTree cl = new IBitTree();
		TreeNode root = createTree();
		
		//System.out.println(cl.verticalOrderTraversal2(t));
		//System.out.println(cl.isValidBSTRec(root));
		/*System.out.println(cl.hasPathSum(root, 19));
		System.out.println(cl.pathSum(root, 16));*/
		//System.out.println(cl.minDepth(root));
		//System.out.println(cl.sumNumbers(root));
		//System.out.println(cl.isBalanced(root));
		//System.out.println(cl.isSameTreeNode(new TreeNode(3), new TreeNode(3)));		
		
		//System.out.println(cl.lca3(root, 4, 7));
		
		//System.out.println(cl.isNodeValPresent(root, 0));
	}
	
	public boolean isNodeValPresent(TreeNode root, int val) {
		if (root == null) return false;
		if (root.val == val) return true;
		return isNodeValPresent(root.left, val) || isNodeValPresent(root.right, val);
	}
	
	/*########################################### LCA #######################################################*/

	public int lca3(TreeNode root, int b, int c) {
		if (root == null) return -1;
		if (root.val == b) return b;
		if (root.val == c) return c;
		int left = lca3(root.left, b, c);
		int right = lca3(root.right, b, c);
		
		if (left!=-1 && right!=-1) return root.val;
		if (left == -1) return right;
		if (right == -1) return left;
		return -1;
    }

	public int lca2(TreeNode A, int B, int C) {
        LinkedList<TreeNode> nodeB = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nodeC = new LinkedList<TreeNode>();
        getPathToNode2(A,nodeB,nodeC,new ArrayList<TreeNode>(),B,C);
        if (nodeB.size() == 0 || nodeC.size()==0) return -1;
        if (nodeC.size() == 0) return -1;
        int i = 0;
        int len = Math.min(nodeB.size(),nodeC.size());
        TreeNode temp = null;
        while (i<len && nodeB.get(i) == nodeC.get(i)) {
            temp = nodeB.get(i);
            i++;
        }
        return temp.val;
    }
    
    void getPathToNode2(TreeNode root, LinkedList<TreeNode> llB, LinkedList<TreeNode> llC, ArrayList<TreeNode> temp, int b, int c) {
        if (root == null) return;
        if (root.val == b) {
        	temp.add(root);
        	llB.addAll(temp);
        	temp.remove(temp.size()-1);
        }
        if (root.val == c) {
        	temp.add(root);
        	llC.addAll(temp);
        	temp.remove(temp.size()-1);
        }
        temp.add(root);
        getPathToNode2(root.left,llB,llC,temp,b,c);
        getPathToNode2(root.right,llB,llC,temp,b,c);
        temp.remove(temp.size()-1);
    }
    
	public int lca(TreeNode A, int B, int C) {
        LinkedList<TreeNode> nodeB = new LinkedList<TreeNode>();
        getPathToNode(A,nodeB,new ArrayList<TreeNode>(),B);
        if (nodeB.size() == 0) return -1;
        LinkedList<TreeNode> nodeC = new LinkedList<TreeNode>();
        getPathToNode(A,nodeC,new ArrayList<TreeNode>(),C);
        if (nodeC.size() == 0) return -1;
        int i = 0;
        int len = Math.min(nodeB.size(),nodeC.size());
        TreeNode temp = null;
        while (i<len && nodeB.get(i) == nodeC.get(i)) {
            temp = nodeB.get(i);
            i++;
        }
        return temp.val;
    }
    
    void getPathToNode(TreeNode root, LinkedList<TreeNode> ll, ArrayList<TreeNode> temp, int target) {
        if (root == null) return;
        if (root.val == target) {
        	temp.add(root);
        	ll.addAll(temp);
        	temp.remove(ll.size()-1);
        	return;
        }
        temp.add(root);
        getPathToNode(root.left,ll,temp,target);
        getPathToNode(root.right,ll,temp,target);
        temp.remove(temp.size()-1);
    }
	
	
	/*########################################### Identical and Symmetric Trees #######################################################*/
	
	/**
	 * Given two binary trees, write a function to check if they are equal or not.
	 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean isSameTreeNode(TreeNode a, TreeNode b) {
        /*if ((a == null || b == null) && (a == null && b == null)) return true;
        if (!(a!=null && b!=null) && !((a == null || b == null) && (a == null && b == null))) return false;*/ //think y will the following work.
		if (a==null && b==null) return true;
		if (a==null || b==null) return false;
        
        if (a.val == b.val) {
            return isSameTreeNode(a.left,b.left) && isSameTreeNode(a.right,b.right);
        } else {
            return false;
        }
    }
	
	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 * 
	 * @param A
	 * @return
	 */
	public int isSymmetric(TreeNode A) {
        if (A == null) return 1;
        if (A.left == null && A.right == null) return 1;
        return isSameSubTree(A.left,A.right) ? 1 : 0;
    }
    
    public boolean isSameSubTree(TreeNode a, TreeNode b) {
        if ((a == null || b == null) && (a == null && b == null)) return true;
        if (!(a!=null && b!=null) && !((a == null || b == null) && (a == null && b == null))) return false;
        if (a.val == b.val) return isSameSubTree(a.left,b.right) && isSameSubTree(a.right,b.left);
        else return false;
    }
	
	/*########################################### Height-balanced binary tree #######################################################*/
	
	/**
	 * Given a binary tree, determine if it is height-balanced.
	 * Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees 
	 * 		of every node never differ by more than 1
	 * @param root
	 * @return
	 */
	boolean is = true; /**alternative to this global variable is {@link IBitTree#getHeight} -or- {@link IBitTree#depth}*/
    public boolean isBalanced(TreeNode A) {
        is = true;
        isBalancedUtil(A);
        return is;
    }
    
    public int getHeight(TreeNode a) {
        if(a == null) return 0;
        
        int left = getHeight(a.left);
        if(left < 0) return -1;
        
        int right = getHeight(a.right);
        if(right<0) return -1;
        
        if(Math.abs(left-right) > 1) return -1;
        
        return Math.max(left, right)+1;
    }
    
    public Integer depth(TreeNode a) {
        if (a == null) return 0;        
        
        Integer left = depth(a.left);
        Integer right = depth(a.right);
        
        if (left == null || right == null) return null;
        
        if (Math.abs(left - right) > 1) return null;
        
        return Math.max(left, right) + 1;
	}
    
    public int isBalancedUtil(TreeNode A) {
        if (A == null) return 0;
        int left = isBalancedUtil(A.left)+1;
        int right = isBalancedUtil(A.right)+1;
        if (Math.abs(left-right)>1 && is) {
            is = false;
        }
        return Math.max(left,right);
    }
	
    /*########################################### Sum Numbers from root-to-leaf #######################################################*/
	/**
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
	 * Find the total sum of all root-to-leaf numbers % 1003.
	 * @param A
	 * @return
	 */
	public int sumNumbers(TreeNode A) {
        ArrayList<String> sums = new ArrayList<String>();
        generateNumArrays(A,sums,new StringBuilder());
        long sum = 0;
        for (String s : sums) {
            sum += Long.parseLong(s)%1003;
            sum = sum%1003;
        }
        return (int)sum;
    }
    
    void generateNumArrays(TreeNode root, ArrayList<String> sums, StringBuilder sb) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (sb.length() > 3 && Integer.parseInt(sb.toString()) > 1003) sb = new StringBuilder(Integer.parseInt(sb.toString())%1003+"");
            sb.append(root.val);
            sums.add(sb.toString());
            sb.deleteCharAt(sb.length()-1);
        }
        if (sb.length() > 3 && Integer.parseInt(sb.toString()) > 1003) sb = new StringBuilder(Integer.parseInt(sb.toString())%1003+"");
        sb.append(root.val);
        generateNumArrays(root.left,sums,sb);
        generateNumArrays(root.right,sums,sb);
        sb.deleteCharAt(sb.length()-1);
    }
	
	/*########################################### Min & Max Depth #######################################################*/
	
	/**
	 * Given a binary tree, find its maximum depth.
	 * The maximum depth of a binary tree is the number of nodes along the longest path from the root node down to the farthest leaf node.
	 * @param root
	 * @return
	 */
	public int maxDeph(TreeNode root) {
		if (root == null) return 0;
		int leftSize = maxDeph(root.left)+1;
		int rightSize = maxDeph(root.right)+1;
		return leftSize > rightSize ? leftSize : rightSize;
		
	}
	
	/**
	 * Min Depth.
	 * @param A
	 * @return
	 */
	public int minDepth(TreeNode A) {
        if (A == null) return 0;
        if (A.left == null) return minDepth(A.right)+1;
        if (A.right == null) return minDepth(A.left)+1;
        return Math.min(minDepth(A.left),minDepth(A.right))+1;
    }

	/*########################################### root-to-leaf path sum #######################################################*/
	
	/**
	 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
	 * adding up all the values along the path equals the given sum.
	 * @param root
	 * @param target
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int target) {
		if (root == null) return false;
		if (root.val == target && root.left == null && root.right == null) return true;
		return hasPathSum(root.left, target-root.val) ||
				hasPathSum(root.right, target-root.val);
	}
	
	/**
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        pathSumUtil(A,B,ans,new ArrayList<Integer>());
        return ans;
    }

	private void pathSumUtil(TreeNode root, int target, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> tmp) {
		if (root == null) return;
		if (root.val == target && root.left == null && root.right == null) {
			tmp.add(root.val);
			ans.add(new ArrayList<Integer>(tmp));
			tmp.remove(tmp.size()-1);
			return;
		}
		tmp.add(root.val);
		pathSumUtil(root.left, target-root.val, ans, tmp);
		pathSumUtil(root.right, target-root.val, ans, tmp);
		tmp.remove(tmp.size()-1);
	}
	
	/*########################################### Valid BST #######################################################*/

	private int x = Integer.MIN_VALUE;
	
	/**
	 * Check if BST is valid or not.
	 * Another way to check  is do inOrder traversal and see if it is sorted
	 * 
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
        if (root.val > maxInLeft(root.left) && root.val < minInRight(root.right)) {
            return isValidBST(root.left) && isValidBST(root.right);
        } else return false;
	}
	
	int maxInLeft(TreeNode root) {
		if (root == null) return Integer.MIN_VALUE;
		while (root.right != null) root = root.right;
		return root.val;
	}
	
	int minInRight(TreeNode root) {
		if (root == null) return Integer.MAX_VALUE;
		while (root.left != null) root = root.left;
		return root.val;
	}
	
	public boolean isValidBSTInOrder(TreeNode root) {
		Stack<TreeNode> st = new Stack<TreeNode>();
		TreeNode temp = root;
		int x = Integer.MIN_VALUE;
		for (;;) {
			if (temp != null) {
				st.push(temp);
				temp = temp.left;
			} else {
				if (st.isEmpty()) break;
				temp = st.pop();
				if (x > temp.val) return false;
				x = temp.val;
				temp = temp.right;
			}
		}
		return true;
	}
	
	public boolean isValidBSTRec(TreeNode root) {
		if (root == null) return true;
		boolean bool = isValidBSTRec(root.left);
		if (x > root.val) return false;
		x = root.val;
		return bool && isValidBSTRec(root.right);
	}
	
	/*########################################### InOrder Successor in BST #######################################################*/
	
	/**
	 * Inorder Successor of a given Node of BST in BST
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public TreeNode getSuccessor(TreeNode a, int b) {
	    List<TreeNode> lefts = new LinkedList<TreeNode>();
	    TreeNode curr = a;
	    while (curr.val != b) {
	        if (b < curr.val) {
	            lefts.add(curr);
	            curr = curr.left;
	        } else {
	            curr = curr.right;
	        }
	    }
	    if (curr.right != null) {
	        curr = curr.right;
	        while (curr.left != null) curr = curr.left;
	        return curr;
	    } else {
	        if (lefts.size() == 0) return null;
	        return lefts.get(lefts.size()-1);
	    }
	}
	
	public TreeNode getSuccessor2(TreeNode root, int data) {
		if( root == null ) return null;
	    TreeNode temp = null ;
	    while( root != null ){
	        if(data < root.val)
	        {
	            temp = root;
	            root = root.left;
	        }
	        else root = root.right;
	    }
	    return temp;
	}
	
	/*########################################### ZigZag printing #######################################################*/
	
	/**
	 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. 
	 * 	(ie, from left to right, then right to left for the next level and alternate between).
	 * @param A
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (A == null) return ans;
        q.offer(A);
        boolean reverse = false;
        while (!q.isEmpty()) {
            ArrayList<Integer> t = new ArrayList<Integer>();
            int size = q.size();
            while (size-- > 0) {
                TreeNode tmp = q.poll();
                t.add(tmp.val);
                if (tmp.left != null) q.add(tmp.left);
                if (tmp.right != null) q.add(tmp.right);
            }
            if (reverse) Collections.reverse(t);
            ans.add(t);
            reverse = !reverse;
        }
        return ans;
    }
	
	/*########################################### Vertical Order Traversal #######################################################*/
	/**
	 * 
	 * @param A
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal2(TreeNode A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (A == null) return ans;
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Integer leftMax = traverseTree2(A,map);
        int count = 0;
        for (Integer i=leftMax; count<map.size(); i++,count++) {
        	ans.add(map.get(i));
        }
        return ans;
	}
	
	int traverseTree2(TreeNode root, Map<Integer, ArrayList<Integer>> map) {
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	Map<TreeNode, Integer> hash = new HashMap<TreeNode, Integer>();
    	hash.put(root, 0);
    	int leftMax = 0;
    	while (!q.isEmpty()) {
    		TreeNode temp = q.poll();
    		Integer index = hash.get(temp)-1;
    		leftMax = leftMax < index ? leftMax : index; 
			if (map.containsKey(index)) {
        		ArrayList<Integer> tmp = map.get(index);
        		tmp.add(temp.val);
        	} else {
        		ArrayList<Integer> tmp = new ArrayList<Integer>();
        		tmp.add(temp.val);
        		map.put(index, tmp);
        	}
			
    		if (temp.left != null) {
    			hash.put(temp.left, hash.get(temp)-1);
    			q.add(temp.left);
    		}
            if (temp.right != null) {
            	hash.put(temp.right, hash.get(temp)+1);
            	q.add(temp.right);
            }
    	}
    	return leftMax;
    }
	
	/**
	 * Vertical Traversing
	 * @param A
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (A == null) return ans;
        Map<TreeNode, Integer> distanceMap = new LinkedHashMap<TreeNode, Integer>();
        distanceMap.put(A,0);
        traverseTree(A,distanceMap);
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Integer leftMax = 0;
        for (Map.Entry<TreeNode, Integer> e : distanceMap.entrySet()) {
        	Integer index = e.getValue();
        	leftMax = leftMax < index ? leftMax : index;
        	if (map.containsKey(index)) {
        		ArrayList<Integer> tmp = map.get(index);
        		tmp.add(e.getKey().val);
        	} else {
        		ArrayList<Integer> tmp = new ArrayList<Integer>();
        		tmp.add(e.getKey().val);
        		map.put(index, tmp);
        	}
        }
        int count = 0;
        for (Integer i=leftMax; count<map.size(); i++,count++) {
        	ans.add(map.get(i));
        }
        return ans;
    }
    
    void traverseTree(TreeNode root, Map<TreeNode, Integer> map) {
    	Queue<TreeNode> q = new LinkedList<TreeNode>();
    	q.add(root);
    	while (!q.isEmpty()) {
    		TreeNode temp = q.poll();
    		if (temp.left != null) {
    			map.put(temp.left,map.get(temp)-1);
    			q.add(temp.left);
    		}
            if (temp.right != null) {
            	map.put(temp.right,map.get(temp)+1);
            	q.add(temp.right);
            }
    	}
    	/*if (root == null) return;
        if (root.left != null) map.put(root.left,map.get(root)-1);
        if (root.right != null) map.put(root.right,map.get(root)+1);
        traverseTree(root.left, map);
        traverseTree(root.right, map);*/
    }
    
    private static TreeNode createTree() {
		TreeNode t = new TreeNode(5);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(8);
		t.left = l;
		t.right = r;
		t.left.left = new TreeNode(1);
		t.left.right = new TreeNode(6);
		t.left.right.left = new TreeNode(3);
		t.right.left = new TreeNode(7);
		t.right.right = new TreeNode(4);
		return t;
	}
}

/*########################################### Node Class #######################################################*/

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int v) {
		val = v;
	}
	
	@Override
	public String toString() {
		Integer l = left!=null?left.val:null;
		Integer r = right!=null?right.val:null;
		return val + " : [ " + l + ", " + r + " ]";
	}
	//equals
	//compareTo
	//hashCode
}