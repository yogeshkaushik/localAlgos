package madr.sp.emira.dp;

import java.util.HashMap;
import java.util.Map;

public class MainDPClass {

	Map<Integer, Long> map = new HashMap<Integer, Long>();
	int[] memo;
	public static void main(String[] args) {
		MainDPClass clazz = new MainDPClass();
				
		//compareFibonacciAlgos(clazz);		
		//clazz.LCS("ABCBDAB", "BDCABA");
		
		int[] a = {-2,-3,2,5,3,-2,1,-1,4,5,2,-2,7,-5,8,-10,11,-3,9,-5,2};
		int[] b = {-2,11,-4,13,-5,2};
		int[] a1 = {1,-3,4,-2,-1,6};
		int[] b1 = {-2,-3,4,-1,-9,10,5,-3};
		int[] res = b1;
//		System.out.println(clazz.maxContiguosSubsequence(res));
//		System.out.println(clazz.maxContiguosSubsequenceOwnAlgo(res));
//		System.out.println(clazz.maxContiguousSumFromBook(res));
		System.out.println(clazz.maxContiguousSumDP(res));
		
		/*int n = 21;
		clazz.memo = new int[n+1];
		clazz.memo[0] = 1;
		System.out.println(clazz.catalanNumberDP(n));*/
	}
	
	/**
	 * Get maximum value contiguous subsequence
	 * 	-Brute Force :
	 * 		1)if all numbers are positive - return sum of all
	 * 		2)Get all contiguous subsequence from the array
	 * 			[a] - a = 1
	 * 			[a,b] - a,ab,b = 3
	 * 			[a,b,c] - a,ab,abc,b,bc,c = 6
	 * 			[a,b,c,d] - a,ab,abc,abcd,... = 10
	 * 			[a,b....n] - a,ab,...... = n*(n+1)/2
	 * 		So brute force here shouold give the solution in o(n^2);
	 * 	 Our Complexity = o (m*n), where m = +ve num;
	 * 
	 * 	-DP approach : {@link MainDPClass#maxContiguosSubsequenceDP}
	 * @param arr
	 * @return
	 */
	public long maxContiguosSubsequence(int[] arr) {
		int len = arr.length;
		long max = 0;//random lowest number
		int indexS = -1, indexE = -1;
		for (int i=0; i<len; i++) {
			long currSum = 0;
			if(arr[i]<0) continue; // this skips evaluation of -ve num in starting of subsequence
								  // coz that is going to lessen the total sum only
			for (int j=i; j<len; j++) {
				currSum += arr[j];
				if (max<currSum) {
					max = currSum;
					indexS = i;
					indexE = j;
				}
			}
		}
		System.out.println("Subsequence is from [" + arr[indexS] + " : " + arr[indexE] + "]");
		return max;
	}
	
	/**
	 * If all numbers are negative, it won't work
	 * atleast one number should be +ve;
	 * 
	 * this gives you the indexes as well
	 * @param arr
	 * @return
	 */
	public int maxContiguosSubsequenceOwnAlgo(int[] arr) {
		int len = arr.length;
		int sum = 0;
		int max = 0;
		int globalMax = max;
		int m = -1, n = -1;//pointers
		int indexS = -1, indexE = -1;
		for (int i=0; i<len; i++) {
			sum += arr[i];
			//int localSum = max<0 ? max : 0;//in case all eentries are negative.
			if (sum < max) {
				if (globalMax < sum - arr[i]) {
					indexS = m;
					indexE = n;
					globalMax = sum - arr[i];
				}
			}
			if (sum > 0 /*localSum*/ ) {
				/*if (localSum < 0 && sum > 0) {
					m = n = i;
					sum = arr[i];
					max = sum;
					continue;
				}*/
				if (m == -1) {
					m = n = i;
				} else {
					n=i;
				}
				max = sum;
			} else {
				if (globalMax < sum - arr[i]) {
					indexS = m;
					indexE = n;
					globalMax = sum - arr[i];
				}
				m = n = -1;
				sum = 0;
			}
		}
		if (max > globalMax) {
			globalMax = max;
			indexS = m;
			indexE = n;
		}
		System.out.println("Subsequence is from [" + arr[indexS] + " : " + arr[indexE] + "]");
		return globalMax;
	}
	
	public int maxContiguousSumFromBook(int[] arr) {
		int sumSoFar = 0, sumEndingHere = 0;
		int len = arr.length;
		for (int i=0; i<len; i++) {
			sumEndingHere += arr[i];
			if (sumEndingHere < 0) {
				sumEndingHere = 0;
				continue;
			}
			if (sumSoFar < sumEndingHere) {
				sumSoFar = sumEndingHere;
			}
		}
		return sumSoFar;
	}
	
	public int maxContiguousSumDP(int[] arr) {
		int maxSum = arr[0], sum = 0;
		int len = arr.length;
		for (int i=1; i<len; i++) {
			sum = Math.max(sum+arr[i], arr[i]);
			maxSum = maxSum < sum ? sum : maxSum;
		}
		return maxSum;
	}
	
	public int catalanNumberDP(int n) {
		if(memo[n] != 0) return memo[n];
		for (int i=1; i<=n; i++) {
			memo[n] += catalanNumberDP(i-1)*catalanNumberDP(n-i); 
		}
		return memo[n];
	}

	private int getMaxInArr(int[] sumArr) {
		int max = Integer.MIN_VALUE;
		for (int i : sumArr)
			max = max < i ? i : max;
		return max;
	}

	private int[] getSumArr(int[] arr) {
		int len = arr.length;
		int[] sum = new int[len];
		sum[0] = arr[0];
		for(int i=1; i<len; i++) {
			sum[i] = sum[i-1] + arr[i];
		}
		return sum;
	}

	/**
	 * Find Longest common subsequence -
	 * 	-Brute Force : Below
	 * 		First get all subsequences from string X (operation = 2^m)
	 * 		iterate over the subsequences of X and see if that is present in Y
	 * 	    total = o (n*2^m);
	 *  -DP : Below
	 *   
	 * @param strX - length m
	 * @param strY - length n
	 * @return
	 */
	public String[] LCS(String strX, String strY) {
		int x = strX.length(), y = strY.length();
		int[][] matrix = new int[x+1][y+1];
		for (int i=1; i<=x; i++) {
			for (int j=1; j<=y; j++) {
				if (strX.charAt(i-1) == strY.charAt(j-1)) {
					matrix[i][j] = matrix[i-1][j-1] + 1;
				} else {
					matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
				}
			}
		}
		System.out.println("Max Substring lenght : " + matrix[x][y]);
		printMatrix(matrix);
		String lcs = findLCSString(matrix,strX,strY);
		System.out.println(lcs);
		return null;
	}

	private String findLCSString(int[][] matrix, String strX, String strY) {
		int x = strX.length();
		int y = strY.length();
		StringBuffer sb = new StringBuffer();
		while (x!=0 && y!=0) {
			if (matrix[x][y] == matrix[x-1][y]) {
				x--;
			} else if (matrix[x][y] == matrix[x][y-1]) {
				y--;
			} else {
				if (strX.charAt(x-1) == strY.charAt(y-1)) {
					sb.append(strX.charAt(x-1));
					x--;
					y--;
				}
			}
		}
		return sb.reverse().toString();
	}
	
	public long fibonacciRecursiveOnly(int n) {
		if (n<=2) {
			return 1;
		} else return fibonacciRecursiveOnly(n-1) + fibonacciRecursiveOnly(n-2);
	}
	
	public int fibonacciDPWay(int n) {
		if (memo[n] != 0L)
			return memo[n];
		// n<=2 : map is already populated;
		int f = fibonacciDPWay(n-1) + fibonacciDPWay(n-2);
		memo[n] = f;
		return f;
	}

	private void printMatrix(int[][] matrix) {
		int i=0;
		int x=matrix.length;
		int y=matrix[0].length;
		for(;i<x;i++) {
			for(int j=0;j<y;j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void compareFibonacciAlgos(MainDPClass clazz) {		
		clazz.map.put(1, 1L);
		clazz.map.put(2, 1L);
		clazz.memo[1] = 1;
		clazz.memo[2] = 1;
		
		long startTimeDP = System.currentTimeMillis();
		System.out.println(clazz.fibonacciDPWay(90) + " -> DP");
		System.out.println((System.currentTimeMillis() - startTimeDP)/1000);
		
		long startTime = System.currentTimeMillis();
		System.out.println(clazz.fibonacciRecursiveOnly(90) + " -> Recursive");
		System.out.println((System.currentTimeMillis() - startTime)/1000);
	}
}
