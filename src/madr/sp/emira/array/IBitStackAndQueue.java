package madr.sp.emira.array;

import java.util.ArrayList;
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
		int[] a = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(cl.trappedWater3(BinarySearchClass.createList(a)));
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
	 * Amazon;
	 * A long array A[] is given to you. There is a sliding window of size w which is moving from the very 
	 * left of the array to the very right. You can only see the w numbers in the window. 
	 * Each time the sliding window moves rightwards by one position.
	 * You have to find the maximum for each window. The following example will give you more clarity.
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public ArrayList<Integer> slidingWindowMaximum2(final List<Integer> A, int B) {
		return null;
	}
	
	/**
	 * Amazon;
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
