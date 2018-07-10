package Utilities;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) throws UnknownHostException {
		//test();
		System.out.println(InetAddress.getByName("172.69.123.232"));
	}

	public static void test() {
		int[] arr = {1,2,2,2,4};
		int[] maxes = {-1};
		int[] result = new int[1];
		for (int i=0; i<maxes.length; i++) {
			int count = binarySearch(arr, maxes[i])+1;
			result[i] = count<0?count*-1:count;			
		}
		System.out.println(result[0]);
	}
	
	static int binarySearch(int[] arr, int target) {
		int low = 0;
		int high = arr.length-1;
		while (low<=high) {
			int mid = low + (high-low)/2;
			int midVal = arr[mid];
			if (midVal<target) low = mid+1;
			else if (midVal>target) high = mid - 1;
			else return mid;
		}
		return -(low+1);
	}
}
