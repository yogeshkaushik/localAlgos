package madr.sp.emira.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Substring   : A pattern P is called a substring of Text T if the pattern appears in the Text in a continuous fashion.
 * Subsequence : A pattern P is called a subsequence of Text T if the pattern preserves the relative ordering of 
 * 				 characters within the text T and it might not appear in a continuous fashion. 
 * 
 * 
 * @author yogeshk
 *
 */
public class IBitString {

	public static void main(String[] args) {
		IBitString cl = new IBitString();
		
		/*String s = "A man, a plan, a canal: Panama";
		System.out.println(clazz.isPalindrome(s));*/
		
		/*final String s = "fwbpudnbrozzifml osdt ulc jsx kxorifrhubk ouhsuhf sswz qfho dqmy sn myq igjgip iwfcqq";
		System.out.println(clazz.reverseWords(s));
		if (s.charAt(2) == 'b') {
			System.out.println("true");
		}*/
		
		//Permutation of a string with and without duplicates.
		/*ArrayList<Character> arr = new ArrayList<Character>();
		arr.add('A');arr.add('A');arr.add('B');arr.add('B');
		cl.allPermutation(arr,true);*/
		
		/*String a = "stackoverflow";
		String b = "rove";
		System.out.println(clazz.containsAnagramOfAnotherString(a, b));*/
		
		//System.out.println(clazz.findRank2("view"));
		
		//System.out.println(clazz.titleToNumber("ZA"));
		//System.out.println(clazz.convertToTitle(943566));
		
		/*String[] str = {"abcd", "abcd", "efgh"};
		List<String> list = BinarySearchClass.createListWrapper(str);
		System.out.println(cl.longestCommonPrefix(list));*/
		
		//System.out.println(cl.countAndSay(8));
		
		//System.out.println(cl.lengthOfLastWord("dadsdad asdasd ad asd as das  ddasdad  "));
		
		//System.out.println(cl.charReuiredForPalindrome("babb"));
		
		System.out.println(cl.buildString('M', 3));
	}
	
	String buildString(char c, int n) {
	    char[] arr = new char[n];
	    Arrays.fill(arr, c);
	    return new String(arr);
	}

	
	int value(char r) {
        if (r == 'I') return 1;
        if (r == 'V') return 5;
        if (r == 'X') return 10;
        if (r == 'L') return 50;
        if (r == 'C') return 100;
        if (r == 'D') return 500;
        if (r == 'M') return 1000;
        return -1;
    }
    public int romanToInt(String str) {
        int res = 0;
        for (int i=0; i<str.length(); i++) {
            // Getting value of symbol s[i]
            int s1 = value(str.charAt(i));
            // Getting value of symbol s[i+1]
            if (i+1 <str.length()) {
                int s2 = value(str.charAt(i+1));
                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol is greater
                    // or equalto the next symbol
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++; // Value of current symbol is
                    // less than the next symbol
                }
            } else {
                res = res + s1;
                i++;
            }
        }
        return res;
    }
	
	/**
	 * Find Needle in haystack. Pattern Matching. KMP algo, Robin Karp.
	 * 
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int strStr(final String A, final String B) {
	    if (A.isEmpty() || B.isEmpty()){
	      return -1;
	    }
	    int lengthOfNeedle = B.length();
	    int hashOfNeedle = B.hashCode();

	    for (int i = 0; i <= A.length()-lengthOfNeedle; i++){
	      int hashOfSubstring = (A.substring(i,i + lengthOfNeedle)).hashCode();
	      if (hashOfNeedle  == hashOfSubstring){
	        return i;
	      }
	    }
	    return -1;
	    
	    /**
	     * for (int i = 0; i <= A.length()-lengthOfNeedle; i++){
		      int hashOfSubstring = (A.substring(i,i + lengthOfNeedle)).hashCode();
		      if (hashOfNeedle  == hashOfSubstring){
		        return i;
		      }
		    }
	     */
	}
	
	public int strStr2(final String A, final String B) {
        if (A == null || B == null) return -1;
        if (B.length() > A.length()) return -1;
        int j = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(j)) {
                int ans = i;
                i++;j++;
                while (i<A.length() && j<B.length() && A.charAt(i) == B.charAt(j)) {
                    i++;
                    j++;
                }
                if (j==B.length()) return ans;
                else {
                    i = ans;
                    j = 0;
                }
            }
        }
        return -1;
    }
	
	/**
	 * Find the Rank of the string, repeated chars might be there.
	 * 
	 * 
	 * @param perm
	 * @return
	 */
	public static long rankPerm(String perm) {
	    long rank = 1;
	    long suffixPermCount = 1;
	    java.util.Map<Character, Integer> charCounts =
	        new java.util.HashMap<Character, Integer>();
	    for (int i = perm.length() - 1; i > -1; i--) {
	        char x = perm.charAt(i);
	        int xCount = charCounts.containsKey(x) ? charCounts.get(x) + 1 : 1;
	        charCounts.put(x, xCount);
	        for (java.util.Map.Entry<Character, Integer> e : charCounts.entrySet()) {
	            if (e.getKey() < x) {
	                rank += suffixPermCount * e.getValue() / xCount;
	            }
	        }
	        suffixPermCount *= perm.length() - i;
	        suffixPermCount /= xCount;
	    }
	    return rank;
	}
	
	/**
	 * 
	 * You are given a string. The only operation allowed is to insert characters in the beginning of the string. 
	 * How many minimum characters are needed to be inserted to make the string a palindrome string

		Example:
		Input: ABC
		Output: 2
		Input: AACECAAAA
		Output: 2
	 * 
	 * 
	 * 
     * Each index of LPS array contains the longest prefix which is also a suffix. 
     * Now take the string and reverse of a string and combine them with a sentinal 
     * character in between them and compute the LPS array of this combined string. 
     * Now take the last value of the LPS array and subtract it with the length of the 
     * original string, This will give us the minimum number of insertions required 
     * in the begining of the string .
     *
     */
    public int charReuiredForPalindrome(String A) {
        StringBuilder sb = new StringBuilder(A);
        StringBuilder newSB = new StringBuilder(A);
        newSB.append("$");
        newSB.append(sb.reverse().toString());
        int len = A.length();
        int[] lps = computeLPSArray(newSB.toString());
        int last = lps[lps.length-1];
        return Math.abs(last-len);
    }
    
    int[] computeLPSArray(String pat) {
        int[] lps = new int[pat.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar 
                // to search step.
                if (len != 0) {
                    len = lps[len-1];
 
                    // Also, note that we do not increment
                    // i here
                } else {
                    // if (len == 0)
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }
	
	
	public int lengthOfLastWord(final String A) {
        int i = A.length()-1;
        while(i>=0 && A.charAt(i) == ' ') i--;
        int count = 0;
        while (i>=0 && A.charAt(i--) != ' ') count++;
        return count;
    }
	
	public String countAndSay(int n) {
        if (n == 1) return 1+"";
        StringBuilder sb = new StringBuilder(1+"");
        while (n-- > 1) {
        	StringBuilder temp = new StringBuilder();
            for (int i=0; i<sb.length();i++) {
            	int count = 1;
            	char c = sb.charAt(i);
            	while (i<sb.length()-1 && c == sb.charAt(i+1)) {
            		count++;i++;
            	}
            	temp.append(count);
            	temp.append(c);
            }
            sb = temp;
        }
        return sb.toString();
    }
	
	
	public String longestCommonPrefix(List<String> A) {
        String comparator = A.get(0);
        int maxLim = comparator.length();
        for(int i=1; i<A.size(); i++) {
            String str = A.get(i);
            int index = 0;
            while(index < maxLim && index < str.length() && comparator.charAt(index) == str.charAt(index)) index++;
            maxLim = Math.min(index,maxLim);
        }
        return comparator.substring(0, maxLim);
    }
	
	/**
	 * A -> 1, B -> 2 ...... Z -> 26;
	 * 
	 * AA -> 27;
	 * 
	 * 
	 * @param A
	 * @return
	 */
	public int titleToNumber(String A) {
        HashMap<Character,Integer> hash = new HashMap<Character, Integer>();
        int len = A.length();
        Character c = 'A';
        int n = 1;
        while(n<=26) hash.put(c++,n++);
        int column = 0;
        for (int i=len-1; i>=0; i--) {
            column += Math.pow(26, len-i-1)*hash.get(A.charAt(i));
        }
        return column;
    }
	
	public String convertToTitle(int A) {
        HashMap<Integer, Character> hash = new HashMap<Integer, Character>();
        Character c = 'A';
        int n = 1;
        while(n<=26) hash.put(n++,c++);
        StringBuilder str = new StringBuilder();
        while (A != 0) {
            int mod = A%26;
            if (mod == 0) {
            	str.append('Z');
            	A = (A-26)/26;
            } else {
	            str.append(hash.get(mod));
	            A = A/26;
            }
        }
        return str.reverse().toString();
    }
	
	/**
	 * Given a string, find the rank of the string amongst its permutations sorted lexicographically. 
		Assume that no characters are repeated.
		
		Input : 'acb'
		Output : 2
		
	 * @param A
	 * @return
	 */
	public int findRank(String A) {
        char[] arr = A.toCharArray();
        Arrays.sort(arr);
        String str = new String(arr);
        int count = 1;
        while (!str.equals(A)) {
            count++;
            str = nextPermutation2(str);
        }
        return count%1000003;
    }
    
	/**
	 * https://math.stackexchange.com/questions/1857204/what-is-the-rank-of-cochin/2024704#2024704
	 * 
	 * 
	 * 
	 * @param str
	 * @return
	 */
    public String nextPermutation2(String str) {
        StringBuilder a = new StringBuilder(str);
	    int size = a.length();
	    int indexK = -1;
	    int indexL = 0;
	    for (int i=0; i<size-1; i++) {
	        if (a.charAt(i) < a.charAt(i+1)) {
	            indexK = indexK > i ? indexK : i;
	        }
	    }
	    if (indexK == -1) {
	        return a.reverse().toString();
	    }
	    char t = a.charAt(indexK);
	    for (int j=indexK+1; j<size; j++) {
	        if (a.charAt(j) > t) {
	            indexL = indexL > j ? indexL : j;
	        }
	    }
	    a.setCharAt(indexK,a.charAt(indexL));
	    a.setCharAt(indexL,t);
	    StringBuilder temp = new StringBuilder(a.substring(indexK+1));
	    a.replace(indexK+1,size,temp.reverse().toString());
	    return a.toString();
	}
    
    public int findRank2(String A) {
        /*char[] arr = A.toCharArray();
        int len = arr.length;
        Arrays.sort(arr);
        long count = 1;
        for (int i=0; i<len; i++) {
            int index = Arrays.binarySearch(arr, A.charAt(i));
            count += factorial(len-i-1)*index;
        }
        */return ((int)0)%1000003;
    }
	
	/**
	 * Find all possible permutation of a String.
	 * @param arr
	 * @param duplicate
	 */
	public <T extends Comparable<T>> void allPermutation(ArrayList<T> arr, boolean duplicate) {
		System.out.println("1 is " + arr);
		long size = factorial(arr.size());
		if (duplicate) {
			Map<T, Integer> m = new HashMap<T, Integer>();
			for (T t : arr) {
				m.put(t, m.containsKey(t) ? m.get(t) + 1 : 1);
			}
			long fact = 1;
			for (Map.Entry<T, Integer> e : m.entrySet()) {
				if (e.getValue() > 1) {
					fact *= factorial(e.getValue());
				}
			}
			size = size/fact;
		}
		for (int i=1; i<size; i++) {
			nextPermutation(arr);
			System.out.format("%d is %s%n", i+1, arr);
		}
	}
	
	/**
	 * Next Permutation is a library method itself in C++
	 * 
	 * {@link https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order}
	 * {@link https://stackoverflow.com/questions/352203/generating-permutations-lazily}
	 * @param a
	 */	
	public <T extends Comparable<T>> void nextPermutation(ArrayList<T> a) {
	    int size = a.size();
	    int indexK = -1;
	    int indexL = 0;
	    for (int i=0; i<size-1; i++) {
	        if (a.get(i).compareTo(a.get(i+1)) < 0) {
	            indexK = indexK > i ? indexK : i;
	        }
	    }
	    if (indexK == -1) {
	        reverse(a,0,size-1);
	        return;
	    }
	    T t = a.get(indexK);
	    for (int j=indexK+1; j<size; j++) {
	        if (a.get(j).compareTo(t) > 0) {
	            indexL = indexL > j ? indexL : j;
	        }
	    }
	    a.set(indexK,a.get(indexL));
	    a.set(indexL,t);
	    reverse(a,indexK+1,size-1);
	    return;
	}
	
	/**
	 * Reverse an Array.
	 * 
	 * @param l
	 * @param i
	 * @param j
	 * @return
	 */
	public <T extends Comparable<T>> ArrayList<T> reverse(ArrayList<T> l, int i, int j) {
	    if (j > l.size()-1 || i < 0) return l;
	    while (i<j) {
	        T temp = l.get(i);
	        l.set(i,l.get(j));
	        l.set(j,temp);
	        i++;
	        j--;
	    }
	    return l;
	}
	
	/**
	 * Finds Factorial of a number
	 * @param len
	 * @return
	 */
	public long factorial(int len) {
		if (len == 0 || len == 1) {
			return 1;
		}
		return len*factorial(len-1);
	}
	
	/**
	 * 
	 * check if a string contains an anagram of another string?
	 * 
	 * @param strA
	 * @param strB
	 * @return
	 */
	public List<Integer> containsAnagramOfAnotherString(String strA, String strB) {
		List<Integer> res = new ArrayList<Integer>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int len = strB.length();
		for (int i=0; i<len; i++) {
			char c = strB.charAt(i);
			map.put(c, map.containsKey(c) ? map.get(c)+1 : 1);
		}
		int indexI = 0, indexJ = indexI + len-1;
		for (int i = indexI; i<=indexJ; i++) {
			char c = strA.charAt(i);
			if (map.containsKey(c)) {
				if (map.get(c) == 1) {
					map.remove(c);
				} else {
					map.put(c, map.get(c)-1);
				}
			} else {
				map.put(c, -1);
			}
		}
		if (map.size() == 0) {
			res.add(indexI);
		}
		indexI++;
		indexJ++;
		while (indexI < strA.length() - len + 1) {
			char cI = strA.charAt(indexI-1);
			map.put(cI, map.containsKey(cI) ? map.get(cI)+1 : 1);
			if (map.get(cI) == 0) {
				map.remove(cI);
			}
			char cJ = strA.charAt(indexJ);
			if (map.containsKey(cJ)) {
				if (map.get(cJ) == 1) {
					map.remove(cJ);
				} else {
					map.put(cJ, map.get(cJ)-1);
				}
			} else {
				map.put(cJ, -1);
			}
			
			if (map.size() == 0) {
				res.add(indexI);
			}
			
			indexI++;
			indexJ++;
		}
		return res;
	}
	
	/**
	 * Reverse string by words.
	 * Given an input string, reverse the string word by word.
	 * Example:
	 * 
	 * Given s = "the sky is blue",
	 * return "blue is sky the".
	 * 
	 * @param a
	 * @return
	 */
	public String reverseWords(String a) {
	    StringBuilder sb = new StringBuilder();
	    int j = a.length() -1;
	    while (j>=0) {
	        int i = j;
	        while (j > 0 && a.charAt(j) != ' '){
	            j--;
	        }
	        if ( j==0 ) sb.append(' ');
	        sb.append(a.substring(j, i+1));
	        j--;
	    }
	    return sb.toString().trim();
	}
	
	public int isPalindrome(String A) {
        int i = 0;
        int j = A.length() - 1;
        A = A.toLowerCase();
        while (i<=j) {
            if (!isAlpha(A.charAt(i))) {
            	i++;
            } else if (!isAlpha(A.charAt(j))) {
            	j--;
            } else if (i<=j && A.charAt(i) != A.charAt(j)) {
            	return -1;
            } else {
            	i++;
            	j--;
            }
        }
        return 0;
    }
    
    boolean isAlpha(char c) {
        return c >= 97 && c <=122;
    }
}
