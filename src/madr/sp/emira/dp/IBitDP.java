package madr.sp.emira.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IBitDP {
	
	public static void main(String[] args) {
		IBitDP cl = new IBitDP();
		//int[] arr = {3,4,-1,0,6,2,3};//{1, 11, 2, 10, 4, 5, 2, 1};
		//System.out.println(cl.longestIncreasingSubsequence(arr));
		
		int[][] arr =  {{0, 1, 1, 0, 1}, 
		                {1, 1, 0, 1, 0}, 
		                {0, 1, 1, 1, 0},
		                {1, 1, 1, 1, 0},
		                {0, 0, 0, 0, 0}};
		
		//System.out.println(cl.maxSquareAreaOf1s(arr));
		int[] a = {2,1,0,3,4,5,5};//{2,3,1,1,2,4,2,0,1,1};//{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(cl.reachEndInMinJump(a));
		System.out.println(cl.reachEndDP(a));
		System.out.println(cl.anytwo("abba"));
	}
	
	/**
	 * Given an array of integers where each element represents the max number of steps that can be made 
	 * forward from that element. Write a function to return the minimum number of jumps to reach the end of the array
	 * (starting from the first element). If an element is 0, then cannot move through that element.
	 * 
	 * @param arr
	 * @return
	 */
	public int reachEndInMinJump(int[] arr) {
		return reachEndHelper(arr, 0, arr.length-1);
	}
	
	public int reachEndDP(int[] arr) {
		int[] dp = new int[arr.length];
		for (int i=1; i<arr.length; i++) 
			for (int j=0; j<i; j++) 
				if (j+arr[j]-i>=0) 
					if (dp[i]==0 || dp[j]+1<dp[i]) dp[i] = dp[j]+1;
				
		return dp[arr.length-1];
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
	 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
	 * 
	 * @param arr
	 * @return
	 */
	public int maxSquareAreaOf1s(int[][] arr){
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
