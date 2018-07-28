package madr.sp.emira.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class IBitStackAndQueue {

	public static void main(String[] args) {
		IBitStackAndQueue cl = new IBitStackAndQueue();
		
		//System.out.println(cl.redundantBraces("(a+(a+b))"));
		
		//System.out.println(cl.simplifyPath("/home//foo/"));
		
		/*String[] arr = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
		System.out.println(cl.evalRPN(arr));
		System.out.println(cl.evalRPN(BinarySearchClass.createListWrapper(arr)));*/
		
		/*int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(cl.trappedWater3(BinarySearchClass.createList(a)));*/
		
		/*int[] arr = {120,8,5,10,7,9,4,15,12,90,13};
		System.out.println(cl.slidingWindowMaximum(BinarySearchClass.createList(arr), 1));
		System.out.println(cl.slidingWindowMaximumDeque(BinarySearchClass.createList(arr), 1));*/
		
		/*int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
		cl.firstNegativeInWindowK(arr, 3);*/
		
		/*int[] arr = {100, 80, 60, 70, 60, 75, 85};
		cl.stockSpanProblem(arr);*/
		
		int[] arr = {6,2,5,4,5,1,6};//{2,1,2,3,1};//{10, 8, 6, 7, 6, 7, 8};
		System.out.println(cl.largestRectangleArea(arr));
	}
	
	/**
	 * Largest Rectangle Area
	 * 
	 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	 * 
	 * Approach: 
	 * 		1. We can use Divide and Conquer to solve this in O(nLogn) time. The idea is to find the minimum value in the given array.
	 * 		   Once we have index of the minimum value, the max area is maximum of following three values.
				a) Maximum area in left side of minimum value (Not including the min value)
				b) Maximum area in right side of minimum value (Not including the min value)
				c) Number of bars multiplied by minimum value.
			  The areas in left and right of minimum value bar can be calculated recursively. If we use linear search to find the minimum value, 
			  then the worst case time complexity of this algorithm becomes O(n^2).
			  How to find the minimum efficiently? Range Minimum Query using Segment Tree can be used for this. 
			  We build segment tree of the given histogram heights. Once the segment tree is built, all range minimum queries take O(Logn) time. 
			  So over all complexity of the algorithm becomes O(nLogn)
			
			2.Stack Base Solution. https://www.youtube.com/watch?v=ZmnqCZp9bBs&t=647s
	 * 
	 * @param arr
	 * @return
	 */
	public int largestRectangleArea(int[] arr) {
		Stack<Integer> st = new Stack<Integer>();
		int maxArea = -1;
		int i=0;
		for (; i< arr.length; i++) {
			while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
				int in = st.pop();
				if (st.isEmpty()) maxArea = Math.max(maxArea, arr[in]*i);
				else maxArea = Math.max(maxArea, arr[in]*(i-1-st.peek()));
			}
			st.push(i);
		}
		while (!st.isEmpty()) {
			int in = st.pop();
			if (st.isEmpty()) maxArea = Math.max(maxArea, arr[in]*i);
			else maxArea = Math.max(maxArea, arr[in]*(i-1-st.peek()));
		}
		return maxArea;
	}
	
	/**
	 * Stock Span Problem.
	 * https://www.geeksforgeeks.org/the-stock-span-problem/
	 * 
	 * 		//Another Approach.
	 * 		while (!st.empty() && price[st.peek()] <= price[i]) {
                st.pop();
            }
     
            // If stack becomes empty, then price[i] is greater than all elements
            // on left of it, i.e., price[0], price[1],..price[i-1]. Else price[i]
            // is greater than elements after top of stack
            ans[i] = (st.empty())? (i + 1) : (i - st.peek());
	 * 
	 * @param arr
	 * @return
	 */
	public int[] stockSpanProblem(int[] arr) {
		int[] ans = new int[arr.length];
		Arrays.fill(ans, 1);
		Stack<Integer> st = new Stack<Integer>();
		for (int i=0;i<arr.length;i++) {
			while (!st.isEmpty() && arr[i]>=arr[st.peek()]) {
				ans[i] += ans[st.pop()];
			}
			st.push(i);
		}
		return ans;
	}
	
	/**
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
	 * compute how much water it is able to trap after raining.

		Example :
		
		Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	 * 
	 * @param A
	 * @return
	 */
	public int trappedWater(final List<Integer> A) {
        int size = A.size();
        int volume = 0;
        int i = 0;
        while(A.get(i)==0) i++;
        int j = 0;
        while (i<size && j<size) {
            Integer max = A.get(i);
            Stack<Integer> st = new Stack<Integer>();
            j = i+1;
            while (j<size && A.get(j)<max) {
                st.push(A.get(j));
                j++;
            }
            if (j == size && !st.empty()) {
                int maxIndex = j;
                Integer min = st.pop();
                maxIndex--;
                while (min<st.peek()) {
                   min = st.pop();
                   maxIndex--;
                }
                max = min;
                int width = maxIndex - i - 1;
                int vol = max*width;
                if (vol != 0) {
                    while (!st.empty()) {
                        vol -= st.pop();
                    }
                }
                return volume+vol;
            }
            int width = j-i-1;
            int vol = width*max;
            if (vol != 0) {
                while (!st.empty()) {
                    vol -= st.pop();
                }
            }
            volume += vol;
            i = j;
        }
        return volume;
    }
	
	public int trappedWater2(final List<Integer> A) {
		int n = A.size();
		int left[] = new int[n];
	      
        // Right [i] contains height of tallest bar to
        // the right of ith bar including itself
        int right[] = new int[n];
      
        // Initialize result
        int water = 0;
      
        // Fill left array
        left[0] = A.get(0);
        for (int i = 1; i < n; i++)
           left[i] = Math.max(left[i-1], A.get(i));
      
        // Fill right array
        right[n-1] = A.get(n-1);
        for (int i = n-2; i >= 0; i--)
           right[i] = Math.max(right[i+1], A.get(i));
      
        // Calculate the accumulated water element by element
        // consider the amount of water on i'th bar, the
        // amount of water accumulated on this particular
        // bar will be equal to min(left[i], right[i]) - arr[i] .
        for (int i = 0; i < n; i++)
           water += Math.min(left[i],right[i]) - A.get(i);
      
        return water;
	}
	
	public int trappedWater3(final List<Integer> A) {
		int a=0;
	    int b=A.size()-1;
	    int max=0;
	    int leftmax=0;
	    int rightmax=0;
	    while(a<=b){
	        leftmax=Math.max(leftmax,A.get(a));
	        rightmax=Math.max(rightmax,A.get(b));
	        if(leftmax<rightmax){
	            max+=(leftmax-A.get(a));       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
	            a++;
	        }
	        else{
	            max+=(rightmax-A.get(b));
	            b--;
	        }
	    }
	    return max;

	}
	
	/**
	 * Given an array and a positive integer k, find the first negative integer for each and every window(contiguous subarray) of size k. 
	 * If a window does not contain a negative interger, then print 0 for that window.
	 * 
	 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
	 * @param arr
	 * @return
	 */
	public int[] firstNegativeInWindowK(int[] arr, int k) {
		if (arr.length<=k) {
			//return first -ve
			int j = 0;
			while (j<arr.length && arr[j]>=0) j++;
			return new int[] {j == arr.length ? 0 : arr[j]};
		}
		Deque<Integer> dq = new LinkedList<>();
		int[] ans = new int[arr.length-k+1];
		int in=0;
		while (in<k) if (arr[in++] < 0) dq.addLast(in-1);
		for (int i=0; in<arr.length; i++,in++) {
			ans[i] = dq.isEmpty() ? 0 : arr[dq.getFirst()];
			if (i==dq.getFirst()) dq.removeFirst();
			if (arr[in]<0) dq.addLast(in);
		}
		return ans;
	}
	
	/**
	 * Amazon :: USING QUEUE
	 * A long array A[] is given to you. There is a sliding window of size w which is moving from the very 
	 * left of the array to the very right. You can only see the w numbers in the window. 
	 * Each time the sliding window moves rightwards by one position.
	 * You have to find the maximum for each window. The following example will give you more clarity.
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public ArrayList<Integer> slidingWindowMaximumDeque(final List<Integer> A, int B) {
		ArrayList<Integer> answer = new ArrayList<>();
		Deque<Integer> dq = new LinkedList<Integer>();
		dq.add(0);
		int i=1;
		while (i < B) {
			while (!dq.isEmpty() && A.get(dq.peekLast()) < A.get(i)) dq.pollLast();
			dq.addLast(i++);
		}
		answer.add(A.get(dq.peekFirst()));
		int j = 0;
		while (i<A.size()) {
			if (j++ == dq.peekFirst()) dq.removeFirst();
			while (!dq.isEmpty() && A.get(dq.peekLast()) < A.get(i)) dq.pollLast();
			dq.addLast(i++);
			answer.add(A.get(dq.peekFirst()));
		}
		return answer;
	}
	
	/**
	 * https://stackoverflow.com/questions/8031939/finding-maximum-for-every-window-of-size-k-in-an-array
	 * 
	 * Amazon :: USING TRICK -> L2R max in k gaps, R2L max in k gaps, max of 0 and k-1
	 * A long array A[] is given to you. There is a sliding window of size w which is moving from the very 
	 * left of the array to the very right. You can only see the w numbers in the window. 
	 * Each time the sliding window moves rightwards by one position.
	 * You have to find the maximum for each window. The following example will give you more clarity.
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public ArrayList<Integer> slidingWindowMaximum(final List<Integer> A, int B) {
		if (B <=1) return new ArrayList<Integer>(A);
        if (B >= A.size()) return maxInList(A);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int size = A.size();
        Integer[] lMax = new Integer[size];
        Integer[] rMax = new Integer[size];
        int i = 0;
        while (i<size) {
            if (i%B == 0) lMax[i] = A.get(i);
            else lMax[i] = Math.max(lMax[i-1],A.get(i));
            i++;
        }
        int j = 0;
        while (j<size && j+B-1 < size) {
            int k = j + B -1;
            rMax[k] = A.get(k);
            k--;
            while (k>=j) {
                rMax[k] = Math.max(rMax[k+1],A.get(k));
                k--;
            }
            j += B;
        }
        if (j != size) {
            int k = size-1;
            rMax[k] = A.get(k);
            k--;
            while (k>=j) {
                rMax[k] = Math.max(rMax[k+1],A.get(k));
                k--;
            }
        }
        int w = B-1;
        int k = 0;
        while(w<size) {
            ans.add(Math.max(rMax[k++],lMax[w++]));
        }
        return ans;
    }
    
    ArrayList<Integer> maxInList(final List<Integer> list) {
        Integer max = Integer.MIN_VALUE;
        for (Integer i : list) {
            max = max > i ? max : i;
        }
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(max);
        return l;
    }
	
	public int evalRPN(String[] A) {
        //Stack<String> st = new Stack<String>();
		List<Integer> list = new LinkedList<Integer>();
        Set<String> hash = new HashSet<String>();
        hash.add("+");hash.add("-");hash.add("*");hash.add("/");
        for (String s : A) {
            if (hash.contains(s)) {
                //if (st.size() < 2) continue;
                int a2 = list.remove(list.size()-1);
                int a1 = list.remove(list.size()-1);
                if (s == "+") {
                    list.add((a1+a2));
                } else if (s == "-") {
                    list.add((a1-a2));
                } else if (s == "*") {
                    list.add((a1*a2));
                } else if (s == "/") {
                    list.add((a1/a2));
                }
            } else {
                list.add(Integer.parseInt(s));
            }
        }
        return list.get(0);
    }
	
	/**
	 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

		Valid operators are +, -, *, /. Each operand may be an integer or another expression.
		
		Examples:
		
		  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
		  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 * 
	 * @param A
	 * @return
	 */
	public int evalRPN(List<String> A) {
        Stack<String> st = new Stack<String>();
        Set<String> hash = new HashSet<String>();
        hash.add("+");hash.add("-");hash.add("*");hash.add("/");
        for (String s : A) {
            if (hash.contains(s)) {
                //if (st.size() < 2) continue;
                int a2 = Integer.parseInt(st.pop());
                int a1 = Integer.parseInt(st.pop());
                if (s == "+") st.push((a1+a2)+"");
                if (s == "-") st.push((a1-a2)+"");
                if (s == "*") st.push((a1*a2)+"");
                if (s == "/") st.push((a1/a2)+"");
            } else {
                st.push(s);
            }
        }
        int ans = Integer.parseInt(st.pop());
        return ans;
    }
	
	/**
	 * Simplify Linux style directory Paths ==>  /a/./b/../c == /a/c
	 * @param A
	 * @return
	 */
	public String simplifyPath(String A) {
        Stack<String> st = new Stack<String>();
        for (int i=1;i<A.length();i++) {
            int end = i;
            while(end < A.length() && A.charAt(end) != '/') end++;
            String sub = A.substring(i, end);
            i=end;
            if (sub.equals(".")) continue;
            if (sub.equals("..") && !st.isEmpty()) st.pop();
            else if (!sub.equals("..") && sub.trim().length() != 0)st.push(sub);
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < st.size()) {
            sb.append("/" + st.get(i));
            i++;
        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }
	
	/**
	 * Remove Redundant Braces. If there are any.
	 * 
	 * @param str
	 * @return
	 */
	public int redundantBraces(String str) {
        Set<Character> hash = new HashSet<Character>();
        hash.add('+');hash.add('*');hash.add('-');hash.add('/');
		Stack<Character> st = new Stack<Character>();
		int i = 0;
		while (i<str.length()) {
			if (str.charAt(i) == ')') {
	            char top = st.pop();
	            // If immediate pop have open parenthesis '('
	            // duplicate brackets found
	            boolean flag = true;
	 
	            while (top != '(') {	 
	                // Check for operators in expression
	                if (hash.contains(top)) flag = false;
	                // Fetch top element of stack
	                top = st.pop();
	            }	 
	            // If operators not found
	            if (flag) return 1;
	        }	 
	        else st.push(str.charAt(i));
			i++;
		}
		return 0;
	}
}
