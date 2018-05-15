package madr.sp.emira.dp;

import java.util.ArrayList;
import java.util.Arrays;

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
		
		System.out.println(cl.maxSquareAreaOf1s(arr));
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
}
