 package madr.sp.emira.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * no of permutations of an array == n! {@link IBitBacktracking.Permutation#permute}
 * no of subsets of an array = 2^n; {@link IBitBacktracking#subsetsWithDup}
 * no of subsequences = 2^n - 1; (-1 if null is not considered) {@link IBitBacktracking#subsetsWithDup}
 * no of subarrays = n*(n+1)/2 (should be contiguous); {@link IBitBacktracking#subArrays}
 * 
 * @author yogeshk
 *
 */
public class IBitBacktracking {
	
	int pos = 0;
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(3,Collections.reverseOrder());
		pq.add(1);
		pq.add(6);
		pq.add(3);
		pq.add(0);
		pq.add(7);
		pq.add(2);
		IBitBacktracking cl = new IBitBacktracking();
		
		//int[] arr = {1,2,3};
		//print2DArary(cl.subArrays(arr));
		//print2DArary(cl.subsets(arr));
		
		//System.out.println(cl.combine(10, 10));
		
		/*int[] arr = { 8, 10, 6, 11, 16, 8};
		System.out.println(cl.combinationSum(BinarySearchClass.createList(arr), 28));*/

		/*int[] arr = { 15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17};
		System.out.println(cl.combinationSumWithoutDuplicate(BinarySearchClass.createList(arr), 3));*/
		
		//DO LOOK INTO THIS.
		/*Solution sol = cl.new Solution();
		String s = "ccccsassssascaaaacsscaabbbaaabbbzz";
		long t = System.currentTimeMillis()/1000;
		System.out.println(cl.partition(s).size());
		System.out.println("DONE!!! Time taken : "+((System.currentTimeMillis()/1000)-t));
		long tt = System.currentTimeMillis()/1000;
		System.out.println(sol.partition(s).size());
		System.out.println("DONE!!! Time taken : "+((System.currentTimeMillis()/1000)-tt));*/
		
		//System.out.println(cl.solveNQueens(4));
		
		ArrayList<ArrayList<Character>> sudoku = builtSudoku();
		cl.solveSudoku(sudoku);
		System.out.println(sudoku);
	}
	
	private static ArrayList<ArrayList<Character>> builtSudoku() {
		ArrayList<ArrayList<Character>> ans = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> c1 = new ArrayList<Character>();
		c1.add((char) (5+'0'));c1.add((char) (3+'0'));c1.add('.');c1.add('.');c1.add((char) (7+'0'));c1.add('.');c1.add('.');c1.add('.');c1.add('.');
		ans.add(new ArrayList<Character>(c1));
		c1.clear();
		c1.add((char) (6+'0'));c1.add('.');c1.add('.');c1.add((char) (1+'0'));c1.add((char) (9+'0'));c1.add((char) (5+'0'));c1.add('.');c1.add('.');c1.add('.');
		ans.add(new ArrayList<Character>(c1));
		c1.clear();
		ans.add(buildCharacterArray(".98....6."));
		ans.add(buildCharacterArray("8...6...3"));
		ans.add(buildCharacterArray("4..8.3..1"));
		ans.add(buildCharacterArray("7...2...6"));
		ans.add(buildCharacterArray(".6....28."));
		ans.add(buildCharacterArray("...419..5"));
		ans.add(buildCharacterArray("....8..79"));
		return ans;
	}
	
	static ArrayList<Character> buildCharacterArray(String s) {
		char[] c = s.toCharArray();
		ArrayList<Character> arr = new ArrayList<Character>();
		for (char ch : c) arr.add(ch);
		return arr;
	}

	/**
	 * Solve Sudoku
	 * 
	 * @param a
	 */
	ArrayList<ArrayList<Character>> main;
	public void solveSudoku(ArrayList<ArrayList<Character>> a) {
		/*solveSudokuUtil(a,0,0,1);
		int i = 0;
		for (ArrayList<Character> array : main) {
			a.set(i++,new ArrayList<Character>(array));
		}*/
		solveSudokuUtil2(0, 0, a);
		return;
	}
	
	private boolean solveSudokuUtil2(int row, int col, ArrayList<ArrayList<Character>> partial) {
		if (row == partial.size()) {
	        row = 0;
	        if (++col == partial.get(row).size()) {
	            // Whole matrix is filled, we have a solution
	            return true;
	        }
	    }
	    
	    // Skip non-empty cells
	    if (partial.get(row).get(col) != '.') {
	        return solveSudokuUtil2(row + 1, col, partial);
	    }
	    
	    // Try each value from 1 to row size
	    for (int val = 1; val <= partial.size(); val++) {
	        char c = Character.forDigit(val, 10);
	        if (ifNumPossible(partial, val, row, col)) {
	            partial.get(row).set(col, c);
	            // If valid, we want to continue until we find the solution
	            if (solveSudokuUtil2(row + 1, col, partial)) return true;
	        }
	    }
	    
	    // Undo assignment and return false for this value
	    partial.get(row).set(col, '.');
	    return false;
	}
	
	
	private void solveSudokuUtil(ArrayList<ArrayList<Character>> a, int row, int column, int num) {
		if (row<a.size()) {
			ArrayList<Character> arr = a.get(row);
			int n = a.get(0).size();
			for (int i=column; i<n;i++) {
				if (arr.get(i) == '.') {
					if (ifNumPossible(a,num,row,i)) {
						//Integer in = nums.remove(0);
						arr.set(i, (char) ('0'+num));
						solveSudokuUtil(a, row, i+1, 1);
						//if (!arr.contains('.')) return;
						arr.set(i, '.');
						num++;
						if (num>9) return;
						i--;
					} else {
						/*Integer in = nums.remove(0);
						nums.add(in);*/
						num++;
						if (num>9) return;
						i--;
					}
				}
			}
			solveSudokuUtil(a, row+1, 0, 1);
		} else {
			main = new ArrayList<ArrayList<Character>>();
			for (ArrayList<Character> array : a) {
				main.add(new ArrayList<Character>(array));
			}
			return;
		}
	}

	private boolean ifNumPossible(ArrayList<ArrayList<Character>> a, int num, int row, int column) {
		int m = a.size();
		int n = a.get(0).size();
		//check the row.
		ArrayList<Character> rowValues = a.get(row);
		if (rowValues.contains((char)('0'+num))) return false;
		//check that column.
		for (int i=0; i<m; i++) {
			if (a.get(i).get(column) == (char)('0'+num)) return false;
		}
		//check the m*n box
		int x = (int) Math.sqrt(m);
		int y = (int) Math.sqrt(n);
		int rowX = 0, rowY = x;
		int columnX = 0, columnY = y;
		while (row >= rowY) {
			rowY += x;
			rowX += x;
		}
		while (column >= columnY) {
			columnY += y;
			columnX += y;
		}
		while (rowX < rowY) {
			ArrayList<Character> arrC = a.get(rowX);
			int col = columnX;
			while (col < columnY) {
				if (arrC.get(col) == (char)('0'+num)) return false;
				col++;
			}
			rowX++;
		}
		return true;
	}

	/**
	 * NQueens Problem
	 * 
	 * @param a
	 * @return
	 */
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
	    ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
	    if (a == 2 || a == 0 || a == 3) return ans;
	    if (a == 1) {
	        ArrayList<String> s = new ArrayList<String>();
	        s.add("Q");
	        ans.add(s);
	        return ans;
	    }
	    int[][] board = new int[a][a];
	    solveNQueensUtil(board,ans,0,1, new ArrayList<Integer>());
	    return ans;
	}
	
	void solveNQueensUtil(int[][] board, ArrayList<ArrayList<String>> ans, int column, int num, ArrayList<Integer> temp) {
	    if (column < board.length) {
	        for (int row=0; row<board.length; row++) {
	            if (board[row][column] == 0) {
	                board[row][column] = num;
	                temp.add(row);
	                temp.add(column);
	                fillCheck(board,row,column,num,0);
	                solveNQueensUtil(board,ans,column+1,num+1,temp);
	                fillCheck(board,row,column,0,num);
	                temp.remove(temp.size()-1);
	                temp.remove(temp.size()-1);
	            }
	        }
	    } else {
	    	ArrayList<String> strArr = new ArrayList<String>(Collections.nCopies(board.length, null));
	    	for (int i=0; i<temp.size(); i=i+2) {
	    		int index = temp.get(i);
	    		int qPos = temp.get(i+1);
	    		StringBuilder sb = new StringBuilder();
	    		int j=0;
	    		while (j<board.length) {
	    			if (j==qPos) sb.append('Q');
	    			else sb.append('.');
	    			j++;
	    		}
	    		strArr.set(index, sb.toString());
	    	}
	    	ans.add(strArr);
	    }
	}

	void fillCheck(int[][] board, int row, int column, int num, int replace) {
	    for (int i=0; i<board.length; i++) {
	        if (board[row][i] == replace) board[row][i] = num;
	        if (board[i][column] == replace) board[i][column]= num;
	    }
	    int i = row, j = column;
	    i--;j--;
	    while (i>=0 && j>=0) {
	    	if (board[i][j] == replace) board[i][j] = num;
	    	i--;j--;
	    }
	    i = row;
	    j = column;
	    i++;j++;
	    while (i<board.length && j<board.length) {
	    	if (board[i][j] == replace) board[i][j] = num;
	    	i++;j++;
	    }
	    i = row;
	    j = column;
	    i--;j++;
	    while (i>=0 && j<board.length) {
	    	if (board[i][j] == replace) board[i][j] = num;
	    	i--;j++;
	    }
	    i = row;
	    j = column;
	    i++;j--;
	    while (i<board.length && j>=0) {
	    	if (board[i][j] == replace) board[i][j] = num;
	    	i++;j--;
	    }
	}
	
	/**
	 * MUST :: https://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/
	 * 
	 * https://www.geeksforgeeks.org/print-palindromic-partitions-string/
	 * 
	 * Given a string s, partition s such that every string of the partition is a palindrome.

		Return all possible palindrome partitioning of s.
		
		For example, given s = "aab",
		Return
		
		  [
		    ["a","a","b"]
		    ["aa","b"],
		  ]
	 * 
	 * @param a
	 * @return
	 */
	public ArrayList<ArrayList<String>> partition(String a) {
	    ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
	    if (a == null || a.length()==0) {
	        ans.add(new ArrayList<String>());
	        return ans;
	    }
	    partitionUtil(a,ans,0,new ArrayList<String>());
	    return ans;
	}
	
	void partitionUtil(String s, ArrayList<ArrayList<String>> v, int index, ArrayList<String> temp) {
	    int len = s.length();
        String str = "";
        ArrayList<String> current = new ArrayList<String>(temp);
         
        if (index == 0)
            temp.clear();
         
        // Iterate over the string
        for (int i = index; i < len; ++i)
        {
            str = str + s.charAt(i);
             
            // check whether the substring is 
            // palindromic or not
            if (isPalindrome(str))
            {
                // if palindrome add it to temp list
                temp.add(str);
                 
                if (i + 1 < len)
                {    
                    // recurr to get all the palindromic
                    // partitions for the substrings
                    partitionUtil(s,v,i+1,temp);
                }
                else
                {
                    // if end of the string is reached 
                    // add temp to v
                    v.add(temp);
                }
                 
                // temp is reinitialize with the 
                // current i.
                temp = new ArrayList<>(current);
            }
        }
	}
	
	boolean isPalindrome(String s) {
	    if (s.length() == 1) return true;
	    StringBuilder sb = new StringBuilder(s);
	    return s.equals(sb.reverse().toString());
	}
	
	public class Solution {
	    
	    int[][] isPalin;
	    
		public ArrayList<ArrayList<String>> partition(String a) {
		    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		    ArrayList<String> temp = new ArrayList<String>();
		    
		    isPalin = new int[a.length()][a.length()];
		    
		    for(int[] x: isPalin){
		        Arrays.fill(x, -1);
		    }
		    
		    combo(a, temp, res, 0);
		    
		    return res;
		}
		
		public boolean isPalindrome(String s, int startT, int endT){
		    
		    if(isPalin[startT][endT] != -1){
		        return isPalin[startT][endT] == 1;
		    }
		    
		    int start = startT, end = endT;
		    
		    while(start < end){
		        if(s.charAt(start) != s.charAt(end)){
		            isPalin[startT][endT] = 0;
		            return false;
		        }
		        start++;
		        end--;
		    }
		    
		    isPalin[startT][endT] = 1;
		    return true;
		}
		
		public void combo(String a, ArrayList<String> temp, ArrayList<ArrayList<String>> res, int aIndex){
		    if(aIndex == a.length()){
		        res.add(new ArrayList<String>(temp));
		        return;
		    }
		    
		    for(int i = aIndex; i < a.length(); i++){
		        String subStr = a.substring(aIndex, i + 1);
		        if(isPalindrome(a, aIndex, i)){
		            temp.add(subStr);
		            combo(a, temp, res, i + 1);
		            temp.remove(temp.size()-1);
		        }
		    }
		}
	}
	
	
	
	/**
	 * Given a collection of candidate numbers (C) and a target number (T), 
	 * find all unique combinations in C where the candidate numbers sums to T.
	 * Each number in C may only be used once in the combination.
	 * @param a
	 * @param b
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> combinationSumWithoutDuplicate(List<Integer> a, int b) {
	    Collections.sort(a);
	    int len = a.size();
	    int j = len-1;
	    while(j>0 && a.get(j)>=b) a.remove(j--);
	    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	    if(a.size() == 0) return ans;
	    combinationSumUtilNoDup(a,b,ans,0,0, new ArrayList<Integer>());
	    return ans;
	}
	
	void combinationSumUtilNoDup(List<Integer> arr, int target, ArrayList<ArrayList<Integer>> ans, int index, int sum, ArrayList<Integer> temp) {
	    for (int i=index; i<arr.size(); i++) {
	        Integer t = arr.get(i);
	        if (sum+t < target) {
	            temp.add(t);
	            combinationSumUtilNoDup(arr,target,ans,i+1,sum+t,temp);
	            temp.remove(t);
	        }
	        else if (sum+t == target) {
	            temp.add(t);
	            if(!ans.contains(temp)) ans.add(new ArrayList<Integer>(temp));
	            temp.remove(t);
	            combinationSumUtilNoDup(arr,target,ans,i+1,sum,temp);
	        } else return;
	    }
	}
	
	/**
	 * 
	 * @param A
	 * @return
	 */
	public ArrayList<String> letterCombinations(String A) {
        Map<Character, String> map = new HashMap<Character, String>();
        map.put(new Character('0'),"0");
        map.put(new Character('1'),"1");
        map.put(new Character('2'),"abc");
        map.put(new Character('3'),"def");
        map.put(new Character('4'),"ghi");
        map.put(new Character('5'),"jkl");
        map.put(new Character('6'),"mno");
        map.put(new Character('7'),"pqrs");
        map.put(new Character('8'),"tuv");
        map.put(new Character('9'),"wxyz");
        ArrayList<String> arr = new ArrayList<String>();
        if (A == null || A.length() == 0) return arr;
        letterCombination(new StringBuilder(), arr,map,A, 0);
        return arr;
    }
    
    public void letterCombination(StringBuilder sb, ArrayList<String> arr, Map<Character, String> map, String str, int index) {
        if (index == str.length()) {
            arr.add(sb.toString());
            return;
        } 
        Character c = str.charAt(index);
        String temp = map.get(c);
        for (int j=0; j<temp.length(); j++) {
            sb.append(temp.charAt(j));
            letterCombination(sb,arr,map,str,index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
	
	/**
	 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
	 * The same repeated number may be chosen from C unlimited number of times.
	 * 
	 * 
	 * Example, 
		Given candidate set 2,3,6,7 and target 7,
		A solution set is:
		
		[2, 2, 3]
		[7]
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> combinationSum(List<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (A == null) return ans;
        //remove duplicates
        Set<Integer> set = new HashSet<Integer>(A);
        A = new ArrayList<Integer>(set);
        if (A.size() == 1 && A.get(0) != B) return ans;
        Collections.sort(A);
        if (B < A.get(0)) return ans;
        combinationSumUtil(A,ans,B,new ArrayList<Integer>(),0,0);
        return ans;
    }
    
    public void combinationSumUtil(List<Integer> arr, ArrayList<ArrayList<Integer>> ans, int k, ArrayList<Integer> temp, int index, int sum) {
        while (index < arr.size()) {
            combinationSumUtilUtil(arr, ans, k, temp, index, sum);
            temp.clear();
            sum = 0;
            index++;
        }
    }

	private void combinationSumUtilUtil(List<Integer> arr, ArrayList<ArrayList<Integer>> ans, int k,
			ArrayList<Integer> temp, int index, int sum) {
		if (index >= arr.size()) return;
		Integer t = arr.get(index);
		if (t>k) return;
		if (sum+t < k) {
		    sum += t;
		    temp.add(t);
		    if (sum+t<=k) combinationSumUtilUtil(arr,ans,k,new ArrayList<Integer>(temp),index,sum);
		    else combinationSumUtilUtil(arr,ans,k,new ArrayList<Integer>(temp),index+1,sum);
		} else if (sum+t > k) {
		    Integer last = temp.remove(temp.size()-1);
		    sum = sum -last;
		    combinationSumUtilUtil(arr,ans,k,new ArrayList<Integer>(temp),index,sum);
		} else {
			sum = sum+t;
			temp.add(t);
			if (!ans.contains(temp)) ans.add(new ArrayList<Integer>(temp));
		}
	}
	
	/**
	 * Find All Permutation
	 */
	class Permutation {
		public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
	        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	        if (A == null) return ans;
	        int size = A.size();
	        ans.add(new ArrayList<Integer>(A));
	        if (size == 1) return ans;
	        int len = factorial(size);
	        int i = 1;
	        while (i<len) {
	            nextPerm(A);
	            ans.add(new ArrayList<Integer>(A));
	            i++;
	        }
	        return ans;
	    }
	    
	    int factorial(int n) {
	        if (n==1) return 1;
	        return n*factorial(n-1);
	    }
	    
	    public void nextPerm(ArrayList<Integer> arr) {
	        int size = arr.size();
	        int k = -1, l = -1;
	        
	        for (int i=0; i<size-1; i++) {
	            if (arr.get(i) < arr.get(i+1)) {
	                k = k > i ? k : i;
	            }
	        }
	        
	        if(k == -1) {
	            reverse(arr,0,size-1);
	            return;
	        }
	        
	        Integer t = arr.get(k);
	        for (int i=k+1; i<size; i++) {
	            if (arr.get(i)>t) {
	                l = l>i ? l : i;
	            }
	        }
	        arr.set(k, arr.get(l));
	        arr.set(l,t);
	        reverse(arr,k+1,size-1);
	    }
	    
	    public void reverse(ArrayList<Integer> arr, int i, int j) {
	        if (i<0 || j>= arr.size()) return;
	        while (i<j) {
	            Integer temp = arr.get(i);
	            arr.set(i,arr.get(j));
	            arr.set(j,temp);
	            i++;j--;
	        }
	    }
	}
	
	/**
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.
	 * Make sure the combinations are sorted.
	 * @param A
	 * @param B
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (B==0) return ans;
        if (B>A) return ans;
        combineUtil(A,B,ans,new ArrayList<Integer>(),1);
        return ans;
    }
    
    public void combineUtil(int num, int k, ArrayList<ArrayList<Integer>> ans, 
        ArrayList<Integer> temp, Integer start) {        
        if (k == 1) {
            while (start<=num) {
                temp.add(start);
                ans.add(new ArrayList<Integer>(temp));
                temp.remove(start);
                start++;
            }
            return;
        }
        while (start<=num) {
        	temp.add(start);
        	combineUtil(num,k-1,ans,new ArrayList<Integer>(temp),start+1);
        	temp.remove(start);
        	start++;
        }
    }
    
    /**
     * Find all subset with duplicate elements.
     * 
     * @param A
     * @return
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        ans.add(new ArrayList<Integer>());
        if (A == null || A.size()==0) return ans;
        Collections.sort(A);
        subsetsWithDupUtil(A,ans,0,new ArrayList<Integer>());
        return ans;
    }
    
    void subsetsWithDupUtil(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans, int index, ArrayList<Integer> temp) {        
        for (int i=index; i<arr.size(); i++) {
            Integer t = arr.get(i);
            temp.add(t);
            if (!ans.contains(temp)) ans.add(new ArrayList<Integer>(temp));
            subsetsWithDupUtil(arr,ans,i+1,temp);
            temp.remove(t);
        }
    }
	
	public int[][] subsets(int[] arr) {
		if (arr == null) return null;
		int len = arr.length;
		int totalSubsetPossible = (int)Math.pow(2, len);
		int[][] ans = new int[totalSubsetPossible][];
		ans[0] = new int[0];
		if (len == 0) return ans;
		/*if (len > 0) {
			ans[1] = new int[1];
			ans[1][0] = arr[0];
		}
		populateSubset(arr, ans, 1);*/
		populateSubset2(arr,ans,0,ans[0]);
		return ans;
	}

	/**
	 * Lexographical order
	 * @param arr
	 * @param ans
	 * @param index
	 * @param append
	 */
	private void populateSubset2(int[] arr, int[][] ans, int index, int[] append) {
		++pos;
		for (int i = index; i<arr.length; i++) {
			//int pos = (int)Math.pow(2, i);
			ans[pos] = new int[append.length+1];
			System.arraycopy(append, 0, ans[pos], 0, append.length);
			ans[pos][ans[pos].length-1] = arr[i];
			populateSubset2(arr, ans, i+1, ans[pos]);
		}
	}

	public void populateSubset(int[] arr, int[][] ans, int index) {
		if (index == arr.length) return;
		int len = (int)Math.pow(2,index);
		int  i = 0;
		int k = len;
		while (i < len) {
			ans[k] = new int[ans[k-len].length+1];
			System.arraycopy(ans[k-len], 0, ans[k], 0, ans[k-len].length);
			ans[k][ans[k].length-1] = arr[index];
			i++;
			k++;
		}
		populateSubset(arr, ans, index+1);
	}
	
	/**
	 * Find Sub arrays of a array;
	 * @param arr
	 * @return
	 */
	public int[][] subArrays(int[] arr) {
		int len = arr.length;
		int subArrLen = len*(len+1)/2;
		int[][] answer = new int[subArrLen][];
		int index = 0;
		for (int i=0; i<len; i++) {
			int k = 1;
			for (int j=i; j<len; j++) {
				answer[index] = new int[k];
				System.arraycopy(arr, i, answer[index], 0, k);
				k++;
				index++;
			}
		}
		return answer;		
	}
	
	public static void print2DArary(int[][] arr) {
		int len = arr.length;
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append("\n");
		for (int i = 0; i<len; i++) {
			sb.append("[");
			int[] _1D_Arr = arr[i];
			int l = _1D_Arr.length;
			for (int j=0; j<l; j++) sb.append(j!=l-1?_1D_Arr[j]+",":_1D_Arr[j]);
			sb.append("]");
			sb.append("\n");
		}
		sb.append("]");
		
		System.out.println(sb.toString());
	}
	
}
