package Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

import madr.sp.emira.array.IBitArray;
import madr.sp.emira.array.IBitBitOpsAndMath;
import madr.sp.emira.array.IBitStackAndQueue;
import madr.sp.emira.array.TwoPointers;
import madr.sp.emira.dp.IBitDP;
import madr.sp.emira.dp.MainDPClass;
import madr.sp.emira.linked.list.MainClass.Node;
import madr.sp.emira.string.IBitString;

 /*
  * Famous Reads:
  * 
  * B-Tree : 
  * 	https://www.cs.cornell.edu/courses/cs3110/2012sp/recitations/rec25-B-trees/rec25.html
  * 	https://www.youtube.com/watch?v=TOb1tuEZ2X4
  * 	https://stackoverflow.com/questions/870218/differences-between-b-trees-and-b-trees
  * 	https://www.educative.io/page/5689413791121408/80001
  * 
  * A* Algo :
  * 	http://theory.stanford.edu/~amitp/GameProgramming/AStarComparison.html
  * 
  * 
  */

/**
 * Tricky Question List
 * 
 * 0. *** {@link IBitArray#_contiguousSubArrSum_equals_k_includesNegative(int[], int)} - One of the best algo.
 * 1. **{@link IBitString#KthPermutation(int, String)}
 * 1. {@link IBitString#rankPermUsingFactoradicBase(String)}
 * 2. {@link IBitString#rankPerm(String)}
 * 3. {@link IBitArray#getMaximumSuccesiveGap2(int[])} - Pigeonhole Principle
 * 4. {@link IBitArray#getMaximumSuccesiveGap(int[])}
 * 5. {@link IBitArray#repeatedNumber_n_divideBy_k_times(List)
 * 6. **{@link #repeatedMoreThanN_By_3_times(int[])}
 * 7. {@link IBitArray#maxArr(int[])}
 * 8. {@link TwoPointers#minimize(List, List, List)}
 * 9. ***{@link IBitArray#numOfEvenSubArray(int[])}
 * 10. ***{@link IBitArray#rearrangeArray(ArrayList)} {@link IBitArray#arrange_arr_i_At_arr_arr_i(ArrayList)}
 * 11. **{@link IBitArray#stepsRequiredNoRecurr}
 * 12. {@link IBitArray#getKthRowOfPascal(int)}
 * 13. {@link IBitArray#maxSum_i_arr_i(int[])}
 * 
 * 14. {@link IBitBitOpsAndMath#allPrimeTill_N(int)}
 * 15. {@link IBitBitOpsAndMath#maxProbability()}
 * 
 * 16. {@link IBitString#charReuiredForPalindrome(String)}
 * 
 * 
 * 
 * Left to Right || Right to Left , build Array Trick
 * 1. {@link IBitStackAndQueue#slidingWindowMaximum(List, int)} ==another variant => {@link IBitStackAndQueue#slidingWindowMaximumDeque(List, int)}
 * 			{@link IBitStackAndQueue#firstNegativeInWindowK(int[], int)}
 * 2. {@link IBitArray#maxGap(int[])} \
 * 3. {@link GenericAlgorithms#maxDiffInArrLargerAfterSmaller(int[])} https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 * 4. {@link IBitStackAndQueue#trappedWater2(List)}
 * 5. {@link IBitStackAndQueue#stockSpanProblem(int[])}
 * 
 * Famous Question List
 * 0. {@link IBitArray#kthSmallestMedianOfMedian(int[], int, int, int)} {@link IBitArray#kthSmallestQuickSort(int[], int, int, int)} {@link IBitArray#kthsmallestWithHeap(int[], int)}
 * 1. {@link IBitArray#repeatedAndMissingNumber(int[])}
 * 2. {@link IBitArray#nextGreaterElement(int[])} 
 * 			{@link IBitStackAndQueue#stockSpanProblem(int[])} 
 * 					{@link IBitStackAndQueue#largestRectangleArea(int[])}
 * 3. {@link IBitArray#repeatedAndMissingNumber(int[])}
 * 4. {@link IBitArray#reapeatedNum(List)}
 * 5. {@link GenericAlgorithms#majorityElement(int[])}
 * 6. {@link IBitArray#maxContiguousSumDP(int[])}
 * 7. {@link IBitArray#pairsWithSum_k(int[])}
 * 8. {@link IBitArray#tripletSum(int[])}
 * 9. {@link IBitArray#continuousSubSequenceSum_zero(List)}
 * 10. ****{@link IBitArray#contiguousSubArrSum_equals_k(int[], int)}
 * 11. *******{@link IBitArray#contiguousSubArrSum_equals_k_includesNegative(int[], int)}
 * 12. ** {@link IBitArray#searchInRotatedArray}
 * 13. {@link IBitString#firstNonRepeatingCharacterInStream()}
 * 14. {@link #searchInSRA(int[], int)} {@link #minInSRA(int[])}
 * 15. {@link #getLinkedListSortedInGivenOreder(int[], Node)}***********************
 * 16. {@link #medianInStream}
 *
 * 
 * 
 * 13. {@link IBitBitOpsAndMath#reverse(long)}
 * 14. {@link IBitBitOpsAndMath#power(int, int, int)}
 * 15. {@link #occurranceOfTargetInSortedArray(int[], int, int, int)}
 * 
 * 15. {@link IBitStackAndQueue#largestRectangleArea(int[])}
 * 
 * Dynamic Programming:
 * 
 * 1. {@link MainDPClass#LCS(String, String)} //Longest common subsequence.
 * 2. {@link IBitDP#editDistance(String, String)}
 * 3. //DO READ ==> Longest Palindromic Substring
 * 
 * Read and Implement List
 * 
 * 1. https://www.geeksforgeeks.org/count-smaller-elements-on-right-side/  :: Self Balancing Binary Tree :: http://www.zrzahid.com/count-smaller-elements-on-the-right/
 * 
 * 
 * @author yogeshk
 *
 */
public class GenericAlgorithms {
	
	
	public static void main(String[] args) throws IOException {
		GenericAlgorithms cl = new GenericAlgorithms();
		
		/*String str = "BCAD";
		System.out.println(cl.allPermutations(str));*/
		
		/*String str = "₹A";
		char[] ch = str.toCharArray();
		System.out.println((int)ch[0]);*/
		
		/*int[] arr = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		System.out.println(cl.maxDiffInArrLargerAfterSmaller(arr));
		System.out.println(cl.maxDiffInArrLargerAfterSmaller2(arr));*/
		
		/*int[] arr = {3, 3, 4, 2, 4, 4, 2, 4};
		System.out.println(cl.majorityElement(arr));*/
		
		/*int[] arr = {-2,3,4,-2,0,3,6};
		System.out.println(cl.maxproductSubarray(arr));*/
		
		/*int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4,5,5,5,5,6,6,6,6,6,7,7,7,7,7,7,7,8,8,8,8,8,8,8,8,8,9,9,9,9,9,9};
		System.out.println(cl.occurranceOfTargetInSortedArray(arr, 3, 0, arr.length-1));
		System.out.println(cl.occurranceOfTargetInSortedArray2(arr, 3, 0, arr.length-1));
		System.out.println(cl.occurranceOfTargetInSortedArray3(arr, 3, 0, arr.length-1));*/
		
		/*int[] arr = {4,3};
		System.out.println(cl.minInSRA(arr));*/
		
		//cl.medianInRunningStream();
	}

	/**
	 * Find the running median of stream at any point in O(1);
	 * 
	 * https://stackoverflow.com/questions/10657503/find-running-median-from-a-stream-of-integers
	 * 
	 */
	public void medianInRunningStream() throws IOException {
		@SuppressWarnings("resource")
		Scanner is = new Scanner(System.in);
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		for (;;) {
			int in = is.nextInt();
			System.out.println("Read : "+in);
			System.out.println("Medium is : " + getTheMedium(in,min,max));
			if (in == 12725) break;
		}
	}
	
	
	private int getTheMedium(int in, PriorityQueue<Integer> min, PriorityQueue<Integer> max) {
		// handle base case, when only two elements are there, maximum one in Min Heap and min one in MaxHeap
		if (min.size() == 0 || max.size() == 0) {
			if (min.size() != 0) {
				if (min.peek() < in) {
					int t = min.remove();
					min.add(in);
					in  = t;
				}
				max.add(in);
				return (min.peek()+max.peek())/2;
			} else {
				min.add(in);
				return in;
			}
		}
		
		//adding element
		if (in < max.peek()) max.add(in);
		else min.add(in);
		
		//balancing;
		if (min.size() !=  max.size()) {
			if (min.size()>max.size()) max.add(min.poll());
			else min.add(max.poll());
		}
		
		//return Median
		if (min.size() != max.size()) return min.size() > max.size() ? min.peek() : max.peek();			
		else return (min.peek()+max.peek())/2;
	}

	/**
	 * Find Max product subarray.
	 * 
	 * https://www.youtube.com/watch?v=vtJvbRlHqTA
	 * 
	 * @param arr
	 * @return
	 */
	public int maxproductSubarray(int[] arr) {
		int prevMax = arr[0];
		int prevMin = arr[0];
		int ans = arr[0];
		for (int i=1; i<arr.length; i++) {
			int currMax = Math.max(prevMax*arr[i], Math.max(prevMin*arr[i], arr[i]));
			int currMin = Math.min(prevMax*arr[i], Math.min(prevMin*arr[i], arr[i]));
			ans = Math.max(currMax, ans);
			prevMax = currMax;
			prevMin = currMin;
		}
		return ans;
	}
	
	
	/**
	 * Minimum number of increment-other operations to make all array elements equal.
	 * 
	 * 1. We are given an array consisting of n elements. At each operation you can select any one element and increase rest of n-1 elements by 1. 
			 * You have to make all elements equal performing such operation as many times you wish. Find the minimum number of operations needed for this.
			 * 
			 * https://www.geeksforgeeks.org/minimum-number-increment-operations-make-array-elements-equal/
			 * 
			 * Brute Force - its like holding the largest element and increasing all other, till all become same - O(n*n)
			 * 
			 * Trick - Increasing all other elements but 1 is same to decreasing that element only. so decrease all elements to minimum of the array, that will give you the same result
			 * 			for all i, noOfOps += a[i]-min;
			 * 			totalOps = a[0]-min + a[1] - min + a[2] - min ... a[n-1] - min;
			 * 			totalOps = a[0]+a[1]+a[2]+a[3]..... - n*min;
			 * 			totalOps = sumOfArray - n*min;
			 * 			Complexity = O(n)
	 * 
	 * 2. Given an array with n positive integers. We need to find the minimum number of operation to make all elements equal. We can perform addition, 
	 * multiplication, subtraction or division with any element on an array element. 
	 * 
	 * https://www.geeksforgeeks.org/minimum-operation-make-elements-equal-array/
	 * 
	 * -For making all elements equal you can select a target value and then you can make all elements equal to that.
	 * -you can achieve your task in maximum of n operations but you have to minimize this number of operation
	 * -if you select a target whose frequency in array is x then you have to perform only n-x more operations as you have already x elements equal to your target value.
	 * -So, finally our task is reduced to finding element with maximum frequency
	 * 
	 * 3. https://www.geeksforgeeks.org/make-array-elements-equal-in-minimum-steps/
	 * 
	 * 4. https://www.geeksforgeeks.org/make-array-elements-equal-minimum-cost/
	 * 
	 * 5. https://www.geeksforgeeks.org/count-minimum-steps-get-given-desired-array/
	 * 
	 * *6. https://stackoverflow.com/questions/35380226/minimize-the-number-of-operation-to-make-all-elements-of-array-equal
	 * 
	 */
	public int minOperationToMakeArrayEqual(int[] arr) {
		return 0;
	}
	
	
	/**
	 * https://www.youtube.com/watch?v=LPFhl65R7ww&t=1167s
	 * 
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int medianOf2UnequalArr(int[] arr1, int[] arr2) {
		return 0;
	}
	
	/**
	 * 
	 * {@link IBitBitOpsAndMath#findMedianSortedArrays}
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int medianOf2EqualArr(int[] arr1, int[] arr2) {
		return 0;
	}
	
	/**
	 * Median of row wise sorted matrix.
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int medianOfMatrix(int[] arr1, int[] arr2) {
		return 0;
	}
	
	/**
	 *  Binary Search, return position of key or negative index for place where it can be inserted.
	 * @param a
	 * @param key
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	public int binarySearch(int[] a, int key, int fromIndex, int toIndex) {
		int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
	}
	
	
	/**
	 * This Method returns all permutations of a given String,
	 * 
	 * Permutation of a given String of length n is == n!;
	 * 
	 * - Repeated chars allowed: 
	 * 	 In case of repeated chars, permutation will be
	 * 			==> (n!)/(x!*y!*Z!*.....) ==> where x!, y! and so on are the repeated char counts from the String.
	 * 
	 * https://www.youtube.com/watch?v=nYFd7VHKyWQ
	 * 
	 * For lexicographically sorted order, you just sort the input String if it is not sorted already.
	 * 
	 * Other Implementations - {@link IBitString#allPermutationNoDup(String)} 
	 * 						   {@link IBitString#allPermutation(ArrayList, boolean)}
	 * 						   {@link IBitString#KthPermutation(int, String)}
	 * 						   {@link IBitString#nextPermutation(ArrayList)}
	 * 						   {@link IBitString#nextPermutation2(String)}
	 * 						   {@link IBitString#rankPerm(String)}
	 * 						   {@link IBitString#rankPermUsingFactoradicBase(String)}
	 * 
	 * @param str
	 * @return
	 */
	public List<String> allPermutations(String str) {
		List<String> list = new ArrayList<String>();
		Pair[] charCounts = getCharCounts(str); // this step gives you sorted chars.
		allPermutationUtil(charCounts, new char[str.length()], 0, list);
		return list;
	}

	private void allPermutationUtil(Pair[] charCounts, char[] result, int len, List<String> list) {
		if (len == result.length) {
			list.add(String.valueOf(result));
			return;
		}
		for (int i=0; i<charCounts.length; i++) {
			Pair p = charCounts[i];
			if (p.count > 0) {
				p.decr();
				result[len] = p.ch;
				allPermutationUtil(charCounts, result, len+1, list);
				p.incr();
			}
		}
	}

	private Pair[] getCharCounts(String str) {
		Pair[] counts = new Pair[256];
		int unique = 0;
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if (counts[c] == null) {
				unique++;
				counts[c] = new Pair(c);
			} else counts[c].incr();
		}
		Pair[] compressed = new Pair[unique];
		int k = 0;
		for (Pair p : counts) if (p!=null) compressed[k++] = p;
		return compressed;
	}
	
	/**
	 * Maximum difference between two elements such that larger element appears after the smaller number
	 * 
	 * https://www.geeksforgeeks.org/maximum-difference-between-two-elements/
	 * 		
	 * 		Similar Question - https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
	 * 							(https://www.geeksforgeeks.org/find-a-partition-point-in-array/)
	 * 
	 * TimeComplexity = O(n);
	 * Space = O(n)
	 * 
	 * @param arr
	 * @return
	 */
	public int maxDiffInArrLargerAfterSmaller(int[] arr) {
		int max = Integer.MIN_VALUE;
		int len = arr.length;
		
		int[] l2rDecreasing = new int[len]; l2rDecreasing[0] = arr[0];
		int[] r2lIncreasing = new int[len]; r2lIncreasing[len-1] = arr[len-1];
		for (int i=1; i<len; i++) l2rDecreasing[i] = Math.min(l2rDecreasing[i-1], arr[i]);
		for (int i=len-2; i>=0; i--) r2lIncreasing[i] = Math.max(r2lIncreasing[i+1], arr[i]);
		
		for (int i=0; i<len; i++) max = Math.max(max, r2lIncreasing[i]-l2rDecreasing[i]);
		return max;
	}
	
	/**
	 * Maintain two pointer, one which carries max diff seen so far, another which carries min seen so far.
	 * {@link #maxDiffInArrLargerAfterSmaller(int[])}
	 */
	public int maxDiffInArrLargerAfterSmaller2(int[] arr) {
		int max = arr[1] - arr[0];
		int min = arr[0];
		for (int i=0; i<arr.length; i++) {
			min = Math.min(min, arr[i]);
			max = Math.max(arr[i]-min, max);
		}
		return max;
	}
	
	/**
	 * Majority Element, one which occurs more than n/2 times. it will be median as well.
	 * 
	 * Boyer-Moore Voting Algo
	 * 
	 * https://stackoverflow.com/questions/278488/find-the-most-common-entry-in-an-array
	 *
	 * http://www.cs.utexas.edu/users/moore/best-ideas/mjrty/index.html
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public int majorityElement(int[] arr) {
		int major = -1;
		int count = 0;
		for (int e : arr) {
			if (count == 0) {
				major = e;
				count = 1;
			} else {
				if (major == e) count++;
				else count--;
			}
			/*
			if (count == 0) major = e;
			if (major == e) count++;
			else count--;
			 */
		}
		return major;
	}
	
	/**
	 * Given a target, find its frequency in the sorted array in (log n) time.
	 * 
	 * In this method eventually you are counting the number. so worst case it will be O(n) ==> {3,3,3,3,3,3,3,3,3,3,3,3,3};
	 * 
	 * @param arr
	 * @param target
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int occurranceOfTargetInSortedArray(int[] arr, int target, int lo, int hi) {
		if (lo > hi) return 0;
		int mid = lo + (hi-lo)/2;
		if (arr[mid] == target) return 1 + 
				occurranceOfTargetInSortedArray(arr, target, lo, mid-1) + 
				occurranceOfTargetInSortedArray(arr, target, mid+1, hi); 
		else if (arr[mid] < target) return occurranceOfTargetInSortedArray(arr, target, mid+1, hi);
		else return occurranceOfTargetInSortedArray(arr, target, lo, mid-1);
	}
	
	/**
	 * Slightly better;
	 * @param arr
	 * @param target
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int occurranceOfTargetInSortedArray2(int[] arr, int target, int lo, int hi) {
		if (lo > hi) return 0;
		if (arr[lo] == target && arr[hi] == target) return hi-lo+1;
		int mid = lo + (hi-lo)/2;
		if (arr[mid] == target) return 1 + 
				occurranceOfTargetInSortedArray(arr, target, lo, mid-1) + 
				occurranceOfTargetInSortedArray(arr, target, mid+1, hi); 
		else if (arr[mid] < target) return occurranceOfTargetInSortedArray(arr, target, mid+1, hi);
		else return occurranceOfTargetInSortedArray(arr, target, lo, mid-1);
	}
	
	/**
	 * This is actual O(log n) solution.
	 * @param arr
	 * @param target
	 * @param lo
	 * @param hi
	 * @return
	 */
	public int occurranceOfTargetInSortedArray3(int[] arr, int target, int lo, int hi) {
		//commented code is correct as well, its just another way.
		/*int index = Arrays.binarySearch(arr, target);
		if (index < 0) return 0;
		int r = rightIndex(arr, target, index+1, arr.length);
		int l = leftIndex(arr, target, 0, index-1);
		return r-l+1;*/
		int r = rightIndex(arr, target, 0, arr.length-1);
		int l = leftIndex(arr, target, 0, arr.length-1);
		return r - l + 1;
	}
	
	private int leftIndex(int[] arr, int target, int lo, int hi) {
		/*if (lo>hi) return hi+1;
		int mid = lo + (hi-lo)/2;
		if (arr[mid] == target) return leftIndex(arr, target, lo, mid-1);
		else return leftIndex(arr, target, mid+1, hi);*/
		if (lo>hi) return -1;
		int mid = lo + (hi-lo)/2;
		if ((mid == 0 || arr[mid-1]<target) && arr[mid]==target) return mid;
		else if (arr[mid]<target) return leftIndex(arr, target, mid+1, hi);
		else return leftIndex(arr, target, lo, mid-1);
	}
	
	private int rightIndex(int[] arr, int target, int lo, int hi) {
		/*if (lo>hi) return lo-1;
		int mid = lo + (hi-lo)/2;
		if (arr[mid] == target) return rightIndex(arr, target, mid+1, hi);
		else return rightIndex(arr, target, lo, mid-1);*/
		if (lo>hi) return -1;
		int mid = lo + (hi-lo)/2;
		if ((mid == arr.length-1 || arr[mid+1]>target) && arr[mid]==target) return mid;
		else if (arr[mid]>target) return rightIndex(arr, target, lo, mid-1);
		else return rightIndex(arr, target, mid+1, hi);
	}
		
	
	/**
	 * You’re given a read only array of n integers. Find out if any integer 
	 * occurs more than n/3 times in the array in linear time and constant additional space.
	 * 
	 * {@link IBitArray#repeatedNumber_n_divideBy_k_times(List)}
	 * 
	 * https://stackoverflow.com/questions/14955634/number-which-appears-more-than-n-3-times-in-an-array
	 * 
	 * @param arr
	 * @return
	 */
	public int repeatedMoreThanN_By_3_times(int[] arr) {
		int len = arr.length;
		int count1 = 0;
        int major1 = Integer.MIN_VALUE;
        int count2 = 0;
        int major2 = Integer.MIN_VALUE;
        for (int in : arr) {
            if (major1 == in || major2 == in) {
                if (major1 == in) count1++;
                else count2++;
            } else {
                if (count1 == 0) {
                    major1 = in;
                    count1 = 1;
                } else if (count2 == 0) {
                    major2 = in;
                    count2 = 1;
                } else {
                    count1--;
                    count2--;
                }
            }
        }
        count1 = 0;
        count2 = 0;
        for (Integer in : arr) {
            if (in == major1) count1++;
            if (in == major2) count2++;
        }
        return (count1 > len/3) ? major1 : (count2 > len/3 ? major2 : -1);
	}
	
	/**
	 * ----Sorted and Rotated Array (SRA)----
	 * find min in SRA, which is pivot;
	 * 
	 * catch -- repeated, only one element.
	 * @param arr
	 * @return
	 */
	public int minInSRA(int[] arr) {
		int len = arr.length;
		if (len == 1) return arr[0];
		if (arr[0]<arr[len-1]) return arr[0];
		int lo = 0, hi = len-1;
		while (lo<=hi) {
			int mid = lo + (hi-lo)/2;
			if (mid>0 && arr[mid] < arr[mid-1]) return arr[mid];
			else if (arr[mid] > arr[hi]) lo = mid+1;
			else hi = mid-1;
		}
		return arr[0];
	}
	
	/**
	 * Search in sorted rotated array in one scan only.
	 * 
	 * alternate approach is find pivot point of rotation and then search in one of the two halves.
	 * 
	 * https://stackoverflow.com/questions/4773807/searching-in-an-sorted-and-rotated-array
	 * 
	 * @param arr
	 * @param key
	 * @return
	 */
	public int searchInSRA(int[] arr, int key) {
		if (arr[0] < arr[arr.length-1]) return Arrays.binarySearch(arr, key); //in case array is not rotated.
		int hi = arr.length;
		int lo = 0;
		while (lo<=hi) {
			int mid = lo + (hi-lo)/2;
			if (arr[mid] == key) return mid;
			if (arr[lo] <= arr[mid]) {
				if (key >= arr[lo] && key <= arr[mid]) hi = mid-1;
				else lo = mid+1;
			} else {
				if (key >= arr[mid] && key <= arr[hi]) lo = mid+1;
				else hi = mid-1;
			}
		}
		return -(lo+1);
	}
	
	/**
	 * Given an array {5,1,3,2,8}
	 * Sort the linked list in that order. LL contains elements from array, duplicate possible.
	 * 
	 * @param arr
	 * @return
	 */
	public static Node getLinkedListSortedInGivenOreder(int[] arr, Node node) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i=0;
		int len = arr.length;
		for (;i<len;i++) map.put(arr[i], i);
//		Node curr = node;
//		Node head = node;
		while (node != null && node.next != null) {
			
		}
		return node;
	}

	static class Pair {
		char ch;
		int count = 1;
		public Pair(char ch) {
			this.ch = ch;
		}
		public void incr() {
			count++;
		}
		public void decr() {
			count--;
		}
		
		@Override
		public String toString() {
			return "{"+ch+","+count+"}";
		}
	}
}
