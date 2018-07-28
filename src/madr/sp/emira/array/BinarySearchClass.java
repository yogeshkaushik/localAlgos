package madr.sp.emira.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearchClass {
	
	public static void main(String[] args) {
		BinarySearchClass cl = new BinarySearchClass();
		
		/*int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		System.out.println(cl.searchRange(a, 10));*/
		
		/*int[] a = {180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202, 203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33, 36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72, 73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127, 129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162, 163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177};//{101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 };
		List<Integer> l = cl.createList(a);
		System.out.println(cl.searchInRotatedArray(l, 3));*/
		
		/*int[] a = {12, 34, 67, 90};
		List<Integer> l = cl.createList(a);
		System.out.println(cl.books((ArrayList)l, 2));*/
		
		System.out.println(-1%20);
	}
	
	/**
	 * https://www.geeksforgeeks.org/allocate-minimum-number-pages/
	 * 
	 * 
	 * N number of books are given. 
		The ith book has Pi number of pages. 
		You have to allocate books to M number of students so that maximum number of pages alloted to a student is minimum. A book will be allocated to exactly one student. Each student has to be allocated at least one book. Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
		
		NOTE: Return -1 if a valid assignment is not possible
		
		Input:
		
		List of Books
		M number of students
		Your function should return an integer corresponding to the minimum number.
		
		Example:
		
		P : [12, 34, 67, 90]
		M : 2
		
		Output : 113
		
		There are 2 number of students. Books can be distributed in following fashion : 
		  1) [12] and [34, 67, 90]
		      Max number of pages is allocated to student 2 with 34 + 67 + 90 = 191 pages
		  2) [12, 34] and [67, 90]
		      Max number of pages is allocated to student 2 with 67 + 90 = 157 pages 
		  3) [12, 34, 67] and [90]
		      Max number of pages is allocated to student 1 with 12 + 34 + 67 = 113 pages
		
		Of the 3 cases, Option 3 has the minimum pages = 113.
	 * @param A
	 * @param B
	 * @return
	 */
	public int books(ArrayList<Integer> A, int B) {
        int l = A.size();
        if (l<B) return -1;
        int max = -1;
        int sum = 0;
        for (Integer a : A) {
            max = max > a ? max : a;
            sum += a;
        }
        int low = max;
        int high = sum;
        int result = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (isPossible(A,l,B,mid)) {
                result = Math.min(result,mid);
                high = mid - 1;
            }
            else low = mid+1;
        }
        return result;
    }
    
    boolean isPossible(ArrayList<Integer> arr, int n, int m, int curr_min) {
        int studentsRequired = 1;
        int curr_sum = 0;
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > curr_min) return false;
            if (curr_sum + arr.get(i) > curr_min) {
                studentsRequired++;
                curr_sum = arr.get(i);
                if (studentsRequired > m)
                    return false;
            }
            else
                curr_sum += arr.get(i);
        }
        return true;
    }
	
	/**
	 * You have to paint N boards of length {A0, A1, A2, A3 … AN-1}. There are K painters available and you are also given 
	 * how much time a painter takes to paint 1 unit of board. 
	 * You have to get this job done as soon as possible under the constraints that any painter will only paint contiguous sections of board.
	 * 
	 * 
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	public int paint(int A, int B, ArrayList<Integer> C) {
        int size = C.size();
        long sum = 0;
        long maxNum = 0;
        for (Integer in : C) {
            sum += in;
            maxNum = maxNum > in ? maxNum : in;
        }
        long lo = maxNum;
        long hi = sum;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long requiredPainters = numberOfPainters(C, size, mid);
            if (requiredPainters <= A) hi = mid;
            else lo = mid + 1;
        }
        return (int)((lo*B)%10000003);
    }
    
    long numberOfPainters(ArrayList<Integer> arr, int n, long maxLen) {
        long total = 0, numPainters = 1;
        for (int i = 0; i < n; i++) {
            total += arr.get(i);
            if (total > maxLen) {
                total = arr.get(i);
                numPainters++;
            }
        }
        return numPainters;
    }
	
	/**
	 * Search Element in rotated array.
	 * @param a
	 * @param b
	 * @return
	 */
	public int searchInRotatedArray(final List<Integer> a, int b) {
	    int lo = 0;
	    int hi = a.size()-1;
	    int pivot = -1;
	    while (lo <= hi) {
	        int mid = lo + (hi-lo)/2;
	        if (mid-1 > 0 && a.get(mid) < a.get(mid-1)) {
	            pivot = mid;
	            break;
	        } else if (a.get(mid) > a.get(hi)) lo = mid+1;
	        else hi = mid;
	    }	
	    if (pivot == -1) return Collections.binarySearch(a,b);
	    int in = -1;
	    return (in = binarySearch(a,0,pivot-1,b)) < 0 ? 
	                        binarySearch(a,pivot,a.size()-1,b) : in;
	}
	
	int binarySearch(List<Integer> l, int i, int j, int x) {
	    while(i<=j) {
	        int mid = i + (j-i)/2;
	        if (l.get(mid) == x) return mid;
	        else if (l.get(mid) > x) j = mid -1;
	        else i = mid +1;
	    }
	    return -1;
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public ArrayList<Integer> searchRange(final int[] a, int b) {
	    int l = a.length;
	    int index = Arrays.binarySearch(a,b);
	    ArrayList<Integer> ans = new ArrayList<Integer>();
	    if (index < 0) {
	        ans.add(-1);
	        ans.add(-1);
	        return ans;
	    } else {
	        int j = index;
	        int in = binarySearch(a,0,j,b);
	        while (in >= 0 && --j >= 0) {
	            in = binarySearch(a,0,j,b);
	        }
	        
	        int i = index;
	        in = binarySearch(a,i,l-1,b);
	        while (in >= 0 && ++i<l) {
	            in = binarySearch(a,i,l-1,b);
	        }
	        
	        /*int i = Collections.binarySearch(a,b-1);
	        int j = Collections.binarySearch(a,b+1);
	        i = i<0 ? -1*i : i;
	        j = j<0 ? -1*j : j;
	        int j = index;Collections.binarySearch(a,b);
	        while (j+1<l && a.get(j) == a.get(j+1)) j++;
	        while (index-1>=0 && a.get(index) == a.get(index-1)) index--;*/
	        ans.add(j+1);
	        ans.add(i-1);
	        return ans;
	    }
	}

	int binarySearch(int[] arr, int i, int j, int num) {
	    while (i <= j) {
	        int mid = i + (j-i)/2;
	        if (arr[mid] == num) return mid;
	        else if (arr[mid] > num) j = mid-1;
	        else i = mid+1;
	    }
	    return -1*i;
	}
	
	public static List<Integer> createList(int... arr) {
		List<Integer> l = new ArrayList<Integer>();
		for (int a : arr) l.add(a);
		return l;
	}
	
	public static <T> List<T> createListWrapper(T... arr) {
		List<T> l = new ArrayList<T>();
		for (T a : arr) l.add(a);
		return l;
	}
}
