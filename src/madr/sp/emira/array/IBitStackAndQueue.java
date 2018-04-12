package madr.sp.emira.array;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class IBitStackAndQueue {

	public static void main(String[] args) {
		IBitStackAndQueue cl = new IBitStackAndQueue();
		
		System.out.println(cl.redundantBraces("(a+(a+b))"));
	}
	
	public int redundantBraces(String str) {
		char start = '(';
        char end = ')';
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
