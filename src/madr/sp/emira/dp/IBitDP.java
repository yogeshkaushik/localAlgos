package madr.sp.emira.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import madr.sp.emira.array.BinarySearchClass;
import madr.sp.emira.array.IBitStackAndQueue;

public class IBitDP {
	
	public static void main(String[] args) {
		IBitDP cl = new IBitDP();
		
		/*int[] arr = {16, 5, 54, 55, 36, 82, 61, 77, 66, 61};//{1, 11, 2, 10, 4, 5, 2, 1};//{3,4,-1,0,6,2,3};//
		System.out.println(cl.longestIncreasingSubsequence(arr));
		System.out.println(cl.longestIncreasingSubsequence2(arr));*/
		
		/*int[][] arr =  {{0, 1, 1, 0, 1}, 
		                {1, 1, 0, 1, 0}, 
		                {0, 1, 1, 1, 0},
		                {1, 1, 1, 1, 0},
		                {0, 0, 0, 0, 0}};
		
		int[][] arr1 =  {
						  {1, 0, 1},
						  {0, 1, 0},
						  {1, 0, 1}
						};
		System.out.println(cl.maxAreaSquare(arr));
		System.out.println(cl.maxAreaRectangle(arr1));
		System.out.println(cl.maxAreaRectangleWithPermutation(arr1));*/
		
		/*int[] a = {2,1,0,3,4,5,5};//{2,3,1,1,2,4,2,0,1,1};//{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(cl.reachEndInMinJump(a));
		System.out.println(cl.reachEndDP(a));*/
		
		//System.out.println(cl.anytwo("abba"));
		
		/*int[][] arr = {{14, 87, 36, 23},{37, 59, 21, 68}};//{{16, 5, 54, 55, 36, 82, 61, 77, 66, 61},{31, 30, 36, 70, 9, 37, 1, 11, 68, 14}};
		System.out.println(cl.adjacentIn2Grid(arr));*/
		
		//System.out.println(cl.decodeWays("3163612911231636129112"));
		
		/*int[] arr = {23, 19, 30, 6, 47, 0, 0, 0, 0, 49, 19, 25, 0, 10, 0, 46, 39, 5, 17, 35, 20, 0, 0, 38, 0, 32, 13, 32, 38, 4, 37, 0, 50, 9, 50, 4, 20, 47, 15, 41, 49, 16, 30, 13, 0, 6, 34, 50, 0, 4, 40, 0, 8, 21, 15, 32, 31, 0, 11, 0, 0, 0, 37, 29, 14, 44, 0, 32, 46, 0, 29, 0, 0, 48, 26, 20, 46, 14, 41, 11, 12, 0, 19, 42, 25, 0, 36, 0, 21, 43, 30, 0, 0, 0, 29, 27, 40, 43, 41, 49, 24, 42, 2, 11, 20, 17, 0, 26, 0, 44, 42, 0, 31, 34, 10, 41, 0, 0, 0, 41, 0, 0, 38, 18, 32, 5, 28, 14, 0, 18, 45, 37, 31, 38, 14, 2, 8, 26, 17, 16, 26, 0, 0, 1, 40, 50, 0, 17, 14, 0, 0, 35, 37, 0, 14, 39, 9, 0, 0, 14, 24, 49, 41, 1, 25, 40, 22, 30, 30, 33, 47, 4, 17, 12, 1, 15, 26, 0, 9, 34, 0, 42, 20, 0, 26, 45, 19, 0, 14, 15, 33, 0, 0, 34, 23, 3, 40, 0, 0, 26, 11, 21, 48, 0, 0, 7, 0, 16, 15, 0, 47, 0, 0, 15, 3, 45, 42, 0, 16, 3, 7, 15, 0, 5, 47, 30, 13, 13, 34, 22, 25, 48, 2, 24, 44, 36, 32, 46, 39, 11, 47, 0, 7, 10, 29, 8, 23, 3, 34, 34, 38, 43, 28, 33, 11, 0, 9, 4, 27, 36, 33, 23, 0, 16, 40, 0, 0, 5, 0, 40, 12, 33, 12, 0, 0, 0, 10, 0, 35, 25, 0, 0, 4, 2, 0, 4, 46, 12, 0, 28, 31, 15, 21, 1, 0, 0, 18, 0, 30, 4, 0, 44, 38, 35, 0, 25, 12, 9, 35, 22, 2, 42, 17, 0, 18, 43, 29, 38, 4, 30, 0, 10, 0, 40, 36, 0, 16, 50, 0, 48, 46, 0, 0, 17, 16, 32, 18, 28, 46, 36, 0, 11, 0, 32, 28, 9, 9, 31, 12, 36, 28, 18, 35, 49, 0, 0, 15, 36, 17, 18, 21, 15, 0, 20, 44, 0, 35, 34, 26, 10, 0, 1, 0, 20, 17, 50, 40, 0, 3, 20, 49, 0, 12, 26, 0, 0, 11, 8, 33, 0, 40, 0, 0, 4, 32, 48, 4, 0, 18, 5, 21, 19, 0, 9, 25, 0, 43, 35, 3, 4, 0, 20, 0, 43, 4, 13, 44, 0, 20, 12, 26, 48, 17, 5, 47, 0, 3, 40, 6, 26, 46, 35, 30, 8, 47, 42, 0, 43, 0, 38, 48, 0, 6, 31, 0, 12, 0, 44, 35, 0, 20, 0, 23, 0, 49, 1, 6, 9, 40, 5, 29, 3, 3, 0, 28, 20, 2, 0, 0, 42, 48, 0, 0, 0, 0, 0, 29, 47, 3, 7, 8, 0, 20, 16, 14, 42, 0, 42, 2, 15, 23, 0, 13, 41, 0, 0, 45, 8, 13, 0, 2, 0, 41, 0, 0, 17, 23, 0, 38, 7, 21, 44, 3, 16, 49, 26, 16, 29, 9, 27, 17, 0, 48, 21, 19, 0, 48, 33, 49, 26, 20, 38, 4, 0, 0, 48, 0, 49, 45, 32, 23, 46, 11, 29, 28, 46, 0, 0, 32, 40, 17, 44, 38, 0, 0, 0, 33, 25, 0, 40, 48, 33, 0, 10, 34, 23, 0, 9, 21, 39, 0, 50, 0, 2, 33, 17, 7, 46, 20, 0, 6, 34, 41, 29, 0, 44, 41, 34, 49, 17, 44, 9, 39, 3, 45, 32, 5, 18, 20, 46, 30, 0, 32, 40, 24, 50, 0, 43, 0, 27, 35, 2, 40, 0, 13, 0, 10, 0, 39, 15, 28, 15, 44, 28, 0, 28, 25, 0, 17, 29, 12, 11, 6, 50, 41, 0, 22, 0, 38, 7, 42, 0, 15, 44, 48, 17, 41, 12, 5, 0, 43, 0, 17, 49, 0, 48};//{1, 3, 2, 1, 0, 5, 2};
		System.out.println(cl.reachEndDP(arr));
		System.out.println(cl.reachEndLinear(arr));*/
		
		int[] arr = {8, 7, 6, 5, 4};
		System.out.println(cl.solve(13, BinarySearchClass.createList(arr)));
	}
	
	/**
	 * Birthday Bump
	 * @param A
	 * @param B
	 * @return
	 */
	public ArrayList<Integer> solve(int A, List<Integer> B) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int r = A;
        for (int i=0; i<B.size(); i++) {
            while (B.get(i)<=r) {
                temp.add(i);
                r = r-B.get(i);
            }
            for (int j=i+1; j<B.size(); j++) {
                if (r==0) break;
                while (B.get(j)<=r) {
                    temp.add(j);
                    r = r-B.get(j);
                }
            }
            if (temp.size()>ans.size()) {
                ans.clear();
                ans.addAll(temp);
            }
            temp.clear();
            r = A;
        }
        return ans;
    }
	
	/**
	 * Given two String str and sub find in how many ways can we for sub from str.
	 * 
	 * Given two sequences S, T, count number of unique ways in sequence S, to form a subsequence that is identical to the sequence T.

	 * str = rabbbit;
	 * sub = rabbit;
	 * 
	 * ans = 3;
	 * 
	 * rabb_it
	 * rab_bit
	 * ra_bbit
	 * 
	 * 
	 *  As a typical way to implement a dynamic programming algorithm, we construct a matrix dp, where each cell dp[i][j] represents the number of solutions of aligning substring T[0..i] with S[0..j];

		Rule 1). dp[0][j] = 1, since aligning T = “” with any substring of S would have only ONE solution which is to delete all characters in S.
		
		Rule 2). when i > 0, dp[i][j] can be derived by two cases:
		
		case 1). if T[i] != S[j], then the solution would be to ignore the character S[j] and align substring T[0..i] with S[0..(j-1)]. Therefore, dp[i][j] = dp[i][j-1].
		
		case 2). if T[i] == S[j], then first we could adopt the solution in case 1), but also we could match the characters T[i] and S[j] and align the rest of them (i.e. T[0..(i-1)] and S[0..(j-1)]. As a result, dp[i][j] = dp[i][j-1] + d[i-1][j-1]
		
		e.g. T = B, S = ABC
		
		dp[1][2]=1: Align T’=B and S’=AB, only one solution, which is to remove character A in S’.
	 * 
	 * 
	 * 
	 * @param string
	 * @param sub
	 * @return
	 */
	public int noOfwaysToFormSubsequence(String str, String sub) {
		int[][] memo = new int[sub.length()+1][str.length()+1];
        for (int j=0; j<str.length()+1; j++) memo[0][j] = 1;
        
        for (int i=1; i<=sub.length(); i++) {
            for (int j=1; j<=str.length(); j++) {
                if (sub.charAt(i-1) == str.charAt(j-1)) memo[i][j] = memo[i][j-1] + memo[i-1][j-1];
                else memo[i][j] = memo[i][j-1];
            }
        }
        
        return memo[sub.length()][str.length()];
	}
	
	/**
	 * Decode Ways
	 * 
	 * Given a String, find total no of ways it can be decoded.
	 * 
	 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

		'A' -> 1
		'B' -> 2
		...
		'Z' -> 26
		Given an encoded message containing digits, determine the total number of ways to decode it.
		
		Example :
		
		Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
		
		The number of ways decoding "12" is 2.
	 * 
	 * @param A
	 * @return
	 */
	public int decodeWays(String A) {
		int[] memo = new int[A.length()];
        Arrays.fill(memo,-1);
        return decodeWaysUtil(A,0, memo);
    }
    private int decodeWaysUtil(String A, int index, int[] memo) {
        if (index<A.length() && A.charAt(index) == '0') return 0;
        if (index >= A.length()) return 1;
        /*int val = 0;
        if (index+1<A.length()) val = Integer.parseInt(A.substring(index, index+2));
        if (val>=10 && val<=26) return numDecodingsUtil(A,index+1) + numDecodingsUtil(A,index+2);
        return numDecodingsUtil(A,index+1);*/
        if (memo[index] != -1) return memo[index];
        int val = 0;
        if (index+1<A.length()) val = Integer.parseInt(A.substring(index, index+2));
        int count = decodeWaysUtil(A,index+1, memo);
        if (val>=10 && val<=26) count += decodeWaysUtil(A,index+2, memo);
        memo[index] = count;
        return count;
	}
	
    /**
     * Given a 2 * N Grid of numbers, choose numbers such that the sum of the numbers 
     * is maximum and no two chosen numbers are adjacent horizontally, vertically or diagonally, and return it.
     * 
     *  Grid:
			1 2 3 4
			2 3 4 5
		so we will choose
		3 and 5 so sum will be 3 + 5 = 8
     * 
     * Bottom-up Approach
     * 
     * Understanding the logic : first pick max among column values as once you pick one you can choose other. so pick max.
     * Now you are dealing with 1D array, proceed with i+2 or i+3 th element for i.
     * 
     * @param A
     * @return
     */
	int[] memo;
	public int adjacentIn2Grid(int[][] A) {
        int len = A[0].length;
        if (len == 1) return Math.max(A[0][0],A[1][0]);
        int[] pickMax = new int[len];
        for (int i=0; i<len; i++) {
            pickMax[i] = Math.max(A[0][i],A[1][i]);
        }
        if (len == 2) return Math.max(pickMax[0],pickMax[1]);
        memo = new int[len];
        Arrays.fill(memo,-1);
        int max_0 = getMaxFromTree(pickMax,0);
        int max_1 = getMaxFromTree(pickMax,1);
        return Math.max(max_1,max_0);
    }
    
	/*
	 * Bottom-up Approach
	 */
    private int getMaxFromTree(int[] arr, int i) {
        if (i>=arr.length) return 0;
        if (memo[i] != -1) return memo[i];
        else {
            int left = getMaxFromTree(arr,i+2);
            int right = getMaxFromTree(arr,i+3);
            memo[i] = arr[i] + Math.max(left,right);
            return memo[i];
        }
    }
    
    /**
     * Top -down Approach
     * @param a
     * @return
     */
    public int adjacentInGrid2(ArrayList<ArrayList<Integer>> a) {
	    int n = a.get(0).size();
	    if(n==0) return 0;
	    int arr[] = new int[n];
	    arr[0]=Math.max(a.get(0).get(0),a.get(1).get(0));
	    if(n==1) return arr[0];
	    arr[1]=Math.max(a.get(0).get(1),a.get(1).get(1));
	    arr[1]=Math.max(arr[0],arr[1]);
	    if(n==2) return arr[1];
	    for(int i=2;i<n;i++){
	        arr[i]=Math.max(a.get(0).get(i),a.get(1).get(i));
	        arr[i]=Math.max(arr[i-1],arr[i]+arr[i-2]);
	    }
	    return arr[n-1];
	    
	}
	
	/**
	 * Given an array of integers where each element represents the max number of steps that can be made 
	 * forward from that element. Write a function to return the minimum number of jumps to reach the end of the array
	 * (starting from the first element). If an element is 0, then cannot move through that element.
	 * 
	 * Recursive Solution - exponential growth rate
	 * 
	 * @param arr
	 * @return
	 */
	public int reachEndInMinJump(int[] arr) {
		return reachEndHelper(arr, 0, arr.length-1);
	}
	public int reachEndHelper(int[] arr, int low, int high) {
		if (low == high) return 0;
		if (arr[low] == 0) return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i=low+1; i<=high && i<=low+arr[low]; i++) {			
			int localMin = reachEndHelper(arr, i, high)+1;
			min = min < localMin ? min : localMin;
		}
		return min;
	}
	
	/**
	 * DP solution to reach end of array.
	 * Complexity - O(n^2);
	 * 
	 * @param arr
	 * @return
	 */
	public int reachEndDP(int[] arr) {
		int[] dp = new int[arr.length];
		for (int i=1; i<arr.length; i++) {
			for (int j=0; j<i; j++) {
				if (j+arr[j]-i>=0) 
					if (dp[i]==0 || dp[j]+1<dp[i]) dp[i] = dp[j]+1;
			}
			if (dp[i] == 0) return -1;//unreachable
		}				
		return dp[arr.length-1];
	}
	
	/**
	 * Reach end of the array in min step. 
	 * http://www.lifeincode.net/programming/leetcode-jump-game-and-jump-game-ii-java/
	 * 
	 * Linear Soluntion - O(n)
	 * 
	 * To check possibility
	 * 	
	 * 		public boolean canJump(int[] A) {
		        if (A.length <= 1)
		            return true;
		        int maxReach = 0;
		        int step = 1;
		        for (int i = 0; i < A.length; i++) {
		            step--;
		            if (i + A[i] > maxReach) {
		                maxReach = i + A[i];
		                step = A[i];
		            }
		            if (step == 0 && i < A.length - 1)
		                return false;
		            |***
		            if (i+A[i] > maxReach) maxReach = i+A[i];
		            steps--;
		            if (steps<=0) {
		                steps = maxReach - i;
		                if (steps <=0 ) return 0;
		            }**|
		             
		        }
		        return true;
		    }
	 * 
	 * 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9
	 * 
	 * @return
	 */
	public int reachEndLinear(int[] arr) {
		int maxReach = arr[0];
		int step = arr[0];
		int jump = 1;
		for (int i=1; i<arr.length; i++) {
			if (i == arr.length -1) return jump;
			if (i+arr[i]>maxReach) {
				maxReach = i+arr[i];
			}
			step--;
			if (step == 0) {
				jump++;
				step = maxReach-i;
			}
		}
		return jump;
	}
	
	/**
	 * Min Distance -or- Edit Distance.
	 * 
	 * Given two words A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
	 * You have the following 3 operations permitted on a word:
		-Insert a character
		-Delete a character
		-Replace a character

	 * @param A
	 * @param B
	 * @return
	 */
	public int editDistance(String A, String B) {
        int lenA = A.length();
        int lenB = B.length();
        int[][] dp = new int[lenA+1][lenB+1];
        for (int i=0; i<=lenB; i++) dp[0][i] = i;
        for (int i=1; i<=lenA; i++) dp[i][0] = i;
        
        for (int i=1; i<=lenA; i++) {
            for (int j=1; j<=lenB; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        
        return dp[lenA][lenB];
    }
	
	public int editDistRecu(String A, String B) {
		return editDistHelper(A, A.length()-1, B, B.length()-1);
	}
	
	public int editDistHelper(String A, int m, String B, int n) {
		if (m==0) return n;
		if (n==0) return m;
		if (A.charAt(m) == B.charAt(n)) return editDistHelper(A, m-1, B, n-1);
		return 1 + Math.min(editDistHelper(A, m-1, B, n-1), Math.min(editDistHelper(A, m-1, B, n),editDistHelper(A, m, B, n-1)));
	}
	
	/**
	 * Largest area of rectangle with permutationsBookmark Suggest Edit
	 * 
	 * Given a binary grid i.e. a 2D grid only consisting of 0’s and 1’s, find the area of the largest rectangle inside the grid such that 
	 * all the cells inside the chosen rectangle should have 1 in them. You are allowed to permutate the columns matrix i.e. you can 
	 * arrange each of the column in any order in the final grid. Please follow the below example for more clarity.
	 * 
	 * Similar to {@link #maxAreaRectangle(int[][])}
	 * only sort the array of {@link #getMaxAreaOfRow(int[])} method, to get the max in permutation.
	 * 
	 * @param arr
	 * @return
	 */
	public int maxAreaRectangleWithPermutation(int[][] arr) {
		int max = getMaxInPermutedRow(arr[0]);
		for (int row=1; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				if (arr[row][col] == 1) arr[row][col] += arr[row-1][col];
			}
			max = Math.max(max, getMaxInPermutedRow(arr[row]));
		}
		return max;
	}
	private int getMaxInPermutedRow(int[] is) {
		int[] row = Arrays.copyOf(is, is.length);
		Arrays.sort(row);
		return getMaxAreaOfRow(row);
	}

	/**
	 *  Maximum size rectangle binary sub-matrix with all 1s
	 *  
		Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
		
		Input :   0 1 1 0
		          1 1 1 1
		          1 1 1 1
		          1 1 0 0
		
		Output :  1 1 1 1
		          1 1 1 1
	 * 
	 * https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public int maxAreaRectangle(int[][] arr) {
		int max = getMaxAreaOfRow(arr[0]);
		for (int row=1; row<arr.length; row++) {
			for (int col=0; col<arr[row].length; col++) {
				if (arr[row][col] == 1) arr[row][col] += arr[row-1][col];
			}
			max = Math.max(max, getMaxAreaOfRow(arr[row]));
		}
		return max;
	}
	/**
	 * This is an implementation of {@link IBitStackAndQueue#largestRectangleArea(int[])}
	 * @param row
	 * @return
	 */
	private int getMaxAreaOfRow(int[] row) {
		int globalMax = 0;
		Stack<Integer> st = new Stack<Integer>();
		int i=0;
		for (; i<row.length; i++) {
			while (!st.isEmpty() && row[i]<row[st.peek()]) {
				int in = st.pop();
				if (st.isEmpty()) globalMax = Math.max(globalMax, row[in]*i);
				else globalMax = Math.max(globalMax, row[in]*(i-1-st.peek()));
			}
			st.push(i);
		}
		while (!st.isEmpty()) {
			int in = st.pop();
			if (st.isEmpty()) globalMax = Math.max(globalMax, row[in]*i);
			else globalMax = Math.max(globalMax, row[in]*(i-1-st.peek()));
		}
		return globalMax;
	}

	/**
	 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
	 * 
	 * @param arr
	 * @return
	 */
	public int maxAreaSquare(int[][] arr){
		int[][] dp = new int[arr.length][arr[0].length];
		//populate the first row and column
		for (int i=0;i<arr[0].length;i++) dp[0][i] = arr[0][i];
		for (int i=1;i<arr.length;i++) dp[i][0] = arr[i][0];
		int max = 0;
		for (int i=1;i<arr.length;i++) 
			for (int j=1; j<arr[0].length;j++) 
				if (arr[i][j]==1) max = max > (dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]), dp[i-1][j-1])+1) ? max : dp[i][j];
		return max*max;
	}
	
	/**
	 * Longest Bitonic subsequence;
	 * Given an array of integers, find the length of longest subsequence which is first increasing then decreasing
	 * @param arr
	 * @return
	 */
	public int longestBiotonicLength(final int[] arr) {
		int[] inc = new int[arr.length];
		int[] dec = new int[arr.length];
		Arrays.fill(inc, 1);
		Arrays.fill(dec, 1);
		for (int i=1; i<arr.length; i++)
			for (int j=0; j<i; j++) 
				if (arr[i] > arr[j] && inc[i] <= inc[j])
					inc[i] = inc[j]+1;
		for (int i=arr.length-2; i>=0; i--)
			for (int j=arr.length-1; j>i; j--) 
				if (arr[i] > arr[j] && dec[i] <= dec[j])
					dec[i] = dec[j]+1;
		int max = inc[0]+dec[0]-1;
		int local = 0;
		for (int i=1; i<arr.length; i++) max = max > (local = inc[i]+dec[i]-1) ? max : local;
		return max;
	}
	
	/**
	 * Longest Increasing subsequence.
	 * @param arr
	 * @return
	 */
	public int longestIncreasingSubsequence(int[] arr) {
		Integer[] memo = new Integer[arr.length];
		Arrays.fill(memo, 1);
		ArrayList<Integer> l = null;
		for (int i=1; i<arr.length; i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int j=0; j<i; j++) {
				if (arr[i]>arr[j] && memo[i] <= memo[j]) {
					tmp.add(arr[j]);
					memo[i] = memo[j]+1;
				}
			}
			tmp.add(arr[i]);
			if (l==null || tmp.size()>l.size()) l = tmp;
		}
		System.out.println(l);
		return l.size();//Collections.max(Arrays.asList(memo));
	}
	
	public int longestIncreasingSubsequence2(int[] arr) {
		int[] memo = new int[arr.length];
		Arrays.fill(memo, 1);
		for (int i=0; i<arr.length; i++)
			for (int j = i+1; j<arr.length; j++)
				if (arr[i] < arr[j] && memo[j]<=memo[i]) memo[j] = memo[i]+1;
		int max = memo[0];
		for (int in : memo) max = max > in ? max : in;
		return max;
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public int anytwo(String a) {
		HashMap<Character,Integer> hash = new HashMap<Character, Integer>();
		for (int i=0; i<a.length(); i++) {
		    char c = a.charAt(i);
		    hash.put(c,hash.getOrDefault(c,0)+1);
		    if (hash.get(c)>3) return 1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<a.length();i++) if (hash.get(a.charAt(i))>1) sb.append(a.charAt(i));
		if (isPalin(sb)) {
			//special case, "AAA" where length is odd and mid one is equal to previous one
			if ((sb.length() & 1) == 1) {
	            return sb.charAt(sb.length()/2) == sb.charAt(sb.length()/2 - 1) ? 1 : 0;
	        }
		    return 0;
		} else return 1;
    }
    
    boolean isPalin(StringBuilder sb) {
        String s = sb.toString();
        if (s.equals(sb.reverse().toString())) return true;
        return false;
    }
}
