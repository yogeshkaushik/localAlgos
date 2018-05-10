package general.random.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		/*int len = in.nextInt();
		String str = in.next();
		System.out.println(getMinimumBinaryNum(str,len));*/
		
		long n = in.nextLong();
		long m = in.nextLong();
		long k = in.nextLong();
		laraCraftGame(n, m, k);
	}
	
	/**
	 * http://codeforces.com/contest/976/problem/B
	 * 
	 * @param n
	 * @param m
	 * @param k
	 */
	public static void laraCraftGame(long n, long m, long k) {
		if (k == 0L) {
			System.out.println(1+" "+1);
			return;
		}
		if (k == (n*m-1)) {
			System.out.println(1+" "+2);
			return;
		}
		
		if (k < n) {
			System.out.println((k+1)+" "+1);
			return;
		} else {
			
			k = k - (n-1); // reached bottom left
			if (k < m) {
				System.out.println(n+" "+(k+1));
				return;
			} else {
				k = k - (m-1);
				long indexI = n, indexJ = m;
				
				long t = k/(m-1);
				long rem = k%(m-1);
				indexI-=t;
				if (t%2 == 1) {
					indexJ = 2;
					if(rem != 0) {
						indexI-=1;
						indexJ+=rem-1;
					}
				} else {
					indexJ = m;
					if(rem != 0) {
						indexI-=1;
						indexJ-=rem-1;
					}
				}
				System.out.println(indexI+" "+indexJ);
			}
		}
	}
	
	/*static class Pair<T> {
		public T x;
		public T y;
		public Pair(T i, T j) {
			x = i;
			y = j;
		}
		
		@Override
		public String toString() {
			return x.toString() + " " + y.toString();
		}
	}*/
	
	/**
	 * http://codeforces.com/contest/976/problem/A
	 * 11110000
	 * @return
	 */
	public static String getMinimumBinaryNum(String str, int len) {
		if (len < 1) return "";
		if (len == 1) return str;
		int count = 0;
		for (int i=1; i<len; i++) {
			if (str.charAt(i) == '0') count++;
		}
		char[] c = new char[count+1];
		Arrays.fill(c, '0');
		c[0] = '1';
		return String.copyValueOf(c);
	}
}
