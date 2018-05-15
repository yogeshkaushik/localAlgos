package madr.sp.emira.tree.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class IBitTree {
	
	public static void main(String[] args) {
		IBitTree cl = new IBitTree();
		//TreeNode root = createTree();
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
		
		//cl.flattenBTRec(root);
		
		/*ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);arr.add(2);arr.add(3);arr.add(6);arr.add(5);arr.add(7);arr.add(8);arr.add(4);
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(1);arr1.add(3);arr1.add(6);arr1.add(2);arr1.add(7);arr1.add(4);arr1.add(8);arr1.add(5);
		//cl.buildTree(arr);
		cl.buildTree(arr, arr1);*/
		
		TreeNode t = new TreeNode(92);
		t.left = new TreeNode(82);
		t.left.left = new TreeNode(81);
		t.left.left.left = new TreeNode(70);
		t.left.right = new TreeNode(83);
		t.right = new TreeNode(85);
		t.right.right = new TreeNode(88);
		t.right.right.left = new TreeNode(86);
		t.right.right.right = new TreeNode(84);
		
		//System.out.println(cl.kthsmallest(t, 5));
		//System.out.println(cl.pairSumEqualsKLogNSpace(t, 1250));
		
		//System.out.println(cl.recoverTree(t));
		
		System.out.println(cl.widthOfTree(t));
	}
	
	/*########################################### Diameter, Width #######################################################*/
	
	/**
	 * The diameter of a tree T is the largest of the following quantities:

		* the diameter of T’s left subtree
		* the diameter of T’s right subtree
		* the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)

	 * @param root
	 * @return
	 */
	public int diameterOfTree(TreeNode root) {
		return 0;
	}
	
	
	/**
	 * Some Say : WRONG UNDERSTANDING (In this case they just consider null also as valid node.) The width of a tree is the maximum width among all levels {@link IBitTree#widthOfTree(TreeNode)}
	 * 			  -The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the 
	 * 			   level, where the null nodes between the end-nodes are also counted into the length calculation.
	 * Some Say : The width of a binary tree is the maximum number of elements on one level of the tree. {@link IBitTree#widthOfTree2(TreeNode)}
	 * 
	 * @param root
	 * @return
	 */
	public int minD,maxD;
	public int widthOfTree(TreeNode root) {
		recusrsivelyFindWidth(root,0);
		return maxD-minD;
	}
	
	private void recusrsivelyFindWidth(TreeNode root, int dist) {
		if (root == null) return;
		recusrsivelyFindWidth(root.left,dist-1);
		minD = minD < dist ? minD : dist;
		recusrsivelyFindWidth(root.right, dist+1);
		maxD = maxD > dist ? maxD : dist;
	}
	
	public int widthOfTree2(TreeNode root) {
		int h = heightOfATree(root);
		int max = 0;
		int local = 0;
		for (int i=0; i<h; i++) max = max > (local=recusrsivelyFindWidth2(root,i)) ? max : local;
		return max;
	}
	
	public int heightOfATree(TreeNode root) {
		if (root == null) return 0;
		return Math.max(heightOfATree(root.left), heightOfATree(root.right))+1;
	}

	private int recusrsivelyFindWidth2(TreeNode root, int depth) {
		if (root == null) return 0;
		if (depth == 0) return 1;
		return recusrsivelyFindWidth2(root.left, depth-1) + recusrsivelyFindWidth2(root.right, depth-1);
	}
	
	/*########################################### Search in Tree #######################################################*/

	/**
	 * IMPORTANT : LEARN RECURSIVE APPROACH
	 * 
	 * Two elements of a binary search tree (BST) are swapped by mistake.
	 * Tell us the 2 values swapping which the tree will be restored.
	 * 
	 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
	 * Two Situation - when nearBy got swapped, when distant one got swapped
	 * 
	 * 
	 * @param A
	 * @return
	 */
	TreeNode start,end;
	TreeNode prev;
	public ArrayList<Integer> recoverTree(TreeNode A) {
		recoverTreeRec(A);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(start.val);
		if (end!=null) ans.add(end.val);
		else ans.add(prev.val);
		Collections.sort(ans);
		return ans;
	}
	
	void recoverTreeRec(TreeNode root) {
		if (root == null) return;
		recoverTreeRec(root.left);
		if (prev!=null && prev.val > root.val) {
			if (start == null) start = prev;
			end = root;
		}
		prev = root;
		recoverTreeRec(root.right);
	}
	
	public ArrayList<Integer> recoverTreeWithO_N_space(TreeNode A) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        inorder(A,arr);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int i = 1;
        int j = 0;
        while (i<arr.size()) {
            if (arr.get(i)<arr.get(i-1)) {
                ans.add(arr.get(i-1));
                j = i;
                break;
            }
            i++;
        }
        i++;
        while (i<arr.size()) {
            if (arr.get(i)<arr.get(i-1)) {
                ans.add(arr.get(i));
                break;
            }
            i++;
        }
        i++;
        if (ans.size()==1) ans.add(arr.get(j));
        Collections.sort(ans);
        return ans;
    }
    
    void inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root==null) return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
	
	
	/**
	 * Given a binary search tree T, where each node contains a positive integer, and an integer K, 
	 * you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.
	 * 
	 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
	 * 
	 * Log(N) space worst case;
	 * 
	 */
	public int pairSumEqualsKLogNSpace(TreeNode A, int B) {
		Stack<TreeNode> left = new Stack<>();
		Stack<TreeNode> right = new Stack<>();
		TreeNode root = A;
		while (root != null) {
			left.push(root);
			root = root.left;
		}
		root = A;
		while (root != null) {
			right.push(root);
			root = root.right;
		}
		while(!left.isEmpty() && !right.isEmpty() && left.peek() != right.peek()){
			TreeNode min = left.peek();
			TreeNode max = right.peek();
			if (min.val + max.val == B) return 0;		
			if (min.val + max.val <B) {
				left.pop();
				if (min.right != null) {
					min = min.right;
					while (min != null) {
						left.push(min);
						min = min.left;
					}
				}
			} else {
				right.pop();
				if (max.left != null) {
					max = max.left;
					while (max != null) {
						right.push(max);
						max = max.right;
					}
				}
			}
		}
		return 0;
    }
	
	/**
	 * Given a binary search tree T, where each node contains a positive integer, and an integer K, 
	 * you have to find whether or not there exist two different nodes A and B such that A.value + B.value = K.
	 * 
	 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
	 */
	boolean bool = false;
    public int pairSumEqualsK(TreeNode A, int B) {
        t2SumUtil(A,B,new HashSet<Integer>());
        return bool ? 1 : 0;
    }
    
    public void t2SumUtil(TreeNode root, Integer sum, Set<Integer> hash) {
        if (root == null) return;
        t2SumUtil(root.left, sum, hash);
        if (hash.contains(sum-root.val)) {
            bool = true;return;
        } else {
            hash.add((Integer)root.val);
        }
        t2SumUtil(root.right, sum, hash);
    }
	/**
	 * Given a binary search tree, write a function to find the kth smallest element in the tree.
	 * @param A
	 * @param B
	 * @return
	 */
	int val;
	boolean b = true;
	private int count;
	public int kthsmallest(TreeNode A, int B) {
        /*Stack<TreeNode> st = new Stack<TreeNode>();
        int count = 0;
        int val = 0;
        TreeNode tmp = A;
        for (;;) {
            if (tmp != null) {
                st.push(tmp);
                tmp = tmp.left;
            } else {
            	if (st.isEmpty()) break;
                count++;
                tmp = st.pop();
                if (count == B) return tmp.val;
                tmp = tmp.right;
            }
        }*/
		kthRecursive(A, B);
        return val;
    }
	
	void kthRecursive(TreeNode root, int k) {
        if (root == null) return;
        kthRecursive(root.left, k);
        count++;
        if (bool && count == k) bool = (val = root.val) == -1;
        kthRecursive(root.right, k);
    }
	
	/*########################################### Tree Construction #######################################################*/
	
	/**
	 * Non Recursive solution,
	 * DO it Yourself.
	 * @param in
	 * @param pre
	 * @return
	 */
	public TreeNode buildTreeInPreNonRecu(ArrayList<Integer> in, ArrayList<Integer> pre) {
		return null;
	}
	
	/**
	 * InOrder PreOrder given, Construct Tree
	 * @param in
	 * @param pre
	 * @return
	 */
	int preIndex;
	public TreeNode buildTreeInPre(ArrayList<Integer> in, ArrayList<Integer> pre) {
		preIndex = 0;
		return buildTreeInPreHelper(in,pre,0,in.size()-1);
	}
	
	private TreeNode buildTreeInPreHelper(ArrayList<Integer> in, ArrayList<Integer> pre, int i, int j) {
		if (i>j) return null;
		Integer val = pre.get(preIndex++);
		TreeNode root = new TreeNode(val);
		if (i==j) return root;
		int ind = indexOf(in, val);
		if (ind == -1) return null;
		root.left = buildTreeInPreHelper(in, pre, i, ind-1);
		root.right = buildTreeInPreHelper(in, pre, ind+1, j);
		return root;
	}

	/**
	 * InOrder PostOrder given, Construct Tree
	 * @param A
	 * @param B
	 * @return
	 */
	int index;
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        index = B.size()-1;
        return buildTreeFromPoIn(A,B,0,B.size()-1);
    }
    
    TreeNode buildTreeFromPoIn(ArrayList<Integer> a, ArrayList<Integer> b, int i, int j) {
        if (i>j) return null;
        Integer val = b.get(index--);
        TreeNode root = new TreeNode(val);
        if (i==j) return root;
        int in = indexOf(a, val);
        if (in == -1) return null;
        root.right = buildTreeFromPoIn(a,b,in+1,j);
        root.left = buildTreeFromPoIn(a,b,i,in-1);
        return root;
    }
    
    /*
     * public TreeNode buildTreeHelper(ArrayList<Integer> preorder, int i, int j, ArrayList<Integer> inorder, int a, int b) {

        if(i>j || i>=preorder.size() || j>=preorder.size() || i<0 || j<0) return null;

        if(a>b || a>=inorder.size() || b>=inorder.size() || a<0 || b<0) return null;

        int ele = preorder.get(j);
        int inIndex = -1;

        for(int m=a; m<=b; m++) {
            if(inorder.get(m)==ele) {
                inIndex = m;
                break;
            }
        }

        int preIndex = j-(b-inIndex);
        TreeNode node = new TreeNode(ele);
        node.left = buildTreeHelper(preorder, i, preIndex-1, inorder, a, inIndex-1);
        node.right = buildTreeHelper(preorder, preIndex, j-1, inorder, inIndex+1,b );
        return node;
    }
     */
    
    int indexOf(ArrayList<Integer> arr, Integer in) {
        for (int i=0; i<arr.size(); i++) {
            if (arr.get(i).equals(in)) return i;
        }
        return -1;
    }
	
	/**
	 * Sorted Array is given, build height balanced tree.
	 * @param a
	 * @return
	 */
	public TreeNode sortedArrayToBST(final List<Integer> a) {
	    return sortedArrayToBSTUtil(a,0,a.size()-1);
	}
	
	TreeNode sortedArrayToBSTUtil(List<Integer> a, int i, int j) {
	    if (i>j || i<0 || j<0 || i>=a.size() || j>=a.size()) return null;
	    int mid = i+((j-i+1)/2);
	    TreeNode root = new TreeNode(a.get(mid));
    	root.left = sortedArrayToBSTUtil(a,i,mid-1);
    	root.right = sortedArrayToBSTUtil(a,mid+1,j);
	    return root;
	}
	
	/**
	 * Given an inorder traversal of a cartesian tree, construct the tree.
	 * 
	 * Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.
	 * 
	 * @param A
	 * @return
	 */
	public TreeNode buildTree(ArrayList<Integer> A) {
        TreeNode root = null;
        if (A == null || A.size()==0) return root;
        int in = indexForMax(A,0,A.size()-1);
        return buildTreeUtil(A,0,in,A.size()-1);
    }
    
    TreeNode buildTreeUtil(ArrayList<Integer> arr, int iLeft, int mid, int jRyt) {
        if (mid == -1) return null;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = buildTreeUtil(arr,iLeft,indexForMax(arr,iLeft,mid-1),mid-1);
        root.right = buildTreeUtil(arr,mid+1,indexForMax(arr,mid+1,jRyt),jRyt);
        return root;
    }
    
    int indexForMax(ArrayList<Integer> A, int i, int j) {
        if (i>j || i<0 || j<0 || i>=A.size() || j>=A.size()) return -1;
        int index = i;
        int max = A.get(i);
        for (int k=i+1; k<=j; k++) {
            if (A.get(k) > max) {
                max = A.get(k);
                index = k;
            }
        }
        return index;
    }
	
	/*########################################### Flatten Tree #######################################################*/
	
	/**
	 * Flatten Binary Tree to Linked List
	 * 
	 * @param root
	 * @return
	 */
	//Didn't find any good reccursive method, chk IBit
	public TreeNode flattenBTRec(TreeNode root) {
		flattenBinaryHelper(root);
		return root;
	}
	
	/*
	 * if (curr == null) return curr;
		TreeNode tmp = curr.right;
		curr.right = flattenBinaryHelper(curr.left);
		curr.left = null;
		if (curr.right != null) curr = curr.right;
		curr.right = flattenBinaryHelper(tmp);
		curr.left = null;
		if (curr.right != null) curr = curr.right;
		return curr;
	 */
	//Doesn't Work
	public TreeNode flattenBinaryHelper(TreeNode curr) {
		if (curr == null) return curr;
		TreeNode lft = flattenBinaryHelper(curr.left);
		TreeNode ryt = flattenBinaryHelper(curr.right);
		if (lft != null) {
			TreeNode temp = lft;
			while (lft.right!=null) lft = lft.right;
			lft.right = ryt;
			lft.left = null;
			lft = temp;
		}
		curr.right = lft;
		curr.left = null;
		return curr;
	}
	
	public TreeNode flattenBTNoRecur(TreeNode root) {
		if (root == null) return root;
		TreeNode prev = root;
		Stack<TreeNode> st = new Stack<TreeNode>();
		if (prev.right != null) st.push(prev.right);
		if (prev.left != null) st.push(prev.left);
		while (!st.isEmpty()) {
			TreeNode curr = st.pop();
			prev.right = curr;
			prev.left = null;
			if (curr.right != null) st.push(curr.right);
			if (curr.left != null) st.push(curr.left);
			prev = prev.right;
		}
		return root;
	}
	
	/*########################################### Invert Tree #######################################################*/
	
	public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
	
	/*########################################### If Node present #######################################################*/
	
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
    
public class BSTIterator {
	    
		Stack<TreeNode> stack;
	    
	    public BSTIterator(TreeNode root) {
	        stack = new Stack<TreeNode>();
	        populateStack(root);
	    }
	    
	    private void populateStack(TreeNode curr) {
	        while (curr!=null) {
	            stack.push(curr);
	            curr = curr.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() throws Exception{
	    	if (!hasNext()) throw new Exception("No element is present.");
	        TreeNode tmp = stack.pop();
	        populateStack(tmp.right);
	        return tmp.val;
	    }
	}
	
    
    public static TreeNode createTree() {
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