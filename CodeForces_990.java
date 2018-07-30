import java.util.Scanner;
import java.util.Arrays;
public class CodeForces_990 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		/*int len = in.nextInt();
		String str = in.next();
		System.out.println(getMinimumBinaryNum(str,len));*/
		
		/*long n = in.nextLong();
		long m = in.nextLong();
		long k = in.nextLong();
		laraCraftGame(n, m, k);*/
		
		/*long n = in.nextLong();
		long m = in.nextLong();
		int a = in.nextInt();
		int b = in.nextInt();
		minExpense(n, m, a, b);*/
		int len = in.nextInt();
		int K = in.nextInt();
		in.nextLine();
		int[] arr = new int[len];
		for (int i=0; i<len; i++) {
			arr[i] = in.nextInt();
		}
		minBacteria(K,arr);
	}
	
	/**
	 * http://codeforces.com/contest/990/problem/B
	 * @param k
	 * @param arr
	 */
	private static void minBacteria(int K, int[] arr) {
		int count = arr.length;
		Arrays.sort(arr);
		int j = 0;
		for(;j<arr.length-1;j++) {
			int sum = 0;
			if (arr[j+1] == arr[j]) {
				while (j<arr.length-1 && arr[j+1]==arr[j]) {
					sum++;
					j++;
				}
				if (j == arr.length-1) break;
			}
			if (arr[j+1]<=arr[j]+K) count = count-sum-1;
		}
		System.out.println(count);
	}
	
	/**
	 * http://codeforces.com/contest/990/problem/A
	 * @return
	 */
	public static void minExpense(long n, long m, int a, int b) {
		long remaining = n%m;
		long needed = m - remaining;
		long demolishCharge = remaining*b;
		long buildingCharge = needed*a;
		System.out.println(demolishCharge < buildingCharge ? demolishCharge : buildingCharge);
	}

	/**
	*https://ashprakasanblog.wordpress.com/2017/02/16/find-lexicographically-nth-permutation-of-an-ordered-string/
	*/
	public String KthPermutation(int k, String str) {
		String factoradicRepresentation = getFactoradicRep(k);
		StringBuilder sb = new StringBuilder(str);
		StringBuilder ans = new StringBuilder();
		for (int i=0; i<factoradicRepresentation.length(); i++) {
			int index = Integer.valueOf(factoradicRepresentation.charAt(i));
			char c = sb.deleteCharAt(index);
			ans.append(c);
		}
		return ans.toString();
	}

	public static String getFactoradicRep(int num) {
		int dividend = 1;
		StringBuilder sb = new StringBuilder();
		while (num != 0) {
			sb.append(""+num%dividend);
			num /= dividend++;
		}
		return sb.reverse().toString();
	}
}
