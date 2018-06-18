package general.random.crackingTCI.main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayAndString {
	
	public static void main(String[] args) {
		ArrayAndString cl = new ArrayAndString();
		
		//System.out.println(cl.urlify("Mr John Smith    "));
		System.out.println(cl.basicStringCompression("sdssssssdsdsdaaaaaccccnnn"));
		Integer i = null;
		System.out.println(i+1);
	}
	
	/**********************************************************************************/
	
	/**
	 * Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
	 * cannot use additional data structures?
	 * 
	 * @param str
	 * @return
	 */
	public boolean duplicateCharacter(String str) {
		Set<Character> set = new HashSet<Character>();
		for (char c : str.toCharArray()) {
			if (set.contains(c)) return true;
			set.add(c);
		}
		return false;
	}

	/**
	 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the
	 * other.
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean checkPermutation(String s1, String s2) {
		if (s1 == null || s2 == null) return false;
		if (s1.length() != s2.length()) return false;
		Map<Character, Integer> hash = new HashMap<>();
		for (char c : s1.toCharArray()) hash.put(c, hash.containsKey(c) ? hash.get(c)+1 : 1);
		for (char c : s2.toCharArray()) {
			if (!hash.containsKey(c)) return false;
			else {
				if (hash.get(c) == 1) hash.remove((Character)c);
				else hash.put(c, hash.get(c)-1);
			}
		}
		return hash.isEmpty();
	}
	
	/**
	 * URLify: Write a method to replace all spaces in a string with '%20: You may assume that the string
		has sufficient space at the end to hold the additional characters, and that you are given the "true"
		length of the string. (Note: If implementing in Java, please use a character array so that you can
		perform this operation in place.)
		EXAMPLE
		Input : "Mr John Smith    ", 13
		Output: "Mr%20John%20Smith"
	 */
	public String urlify(String s) {
		char[] arr = s.toCharArray();
		int len = arr.length;
		int j = len-1;
		int index = j;
		while (j>=0 && arr[j] == ' ') j--;
		for (;j>=0 && j<index;) {
			while (j>=0 && arr[j] != ' ') {
				arr[index--] = arr[j];
				arr[j] = ' ';
				j--;
			}
			while (j>=0 && arr[j] == ' ') {
				arr[index--] = '0';
				arr[index--] = '2';
				arr[index--] = '%';
				j--;
			}
		}
		return String.copyValueOf(arr);
	}
	
	/**
	 * Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palin-
		drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation
		is a rearrangement of letters. The palindrom does not need to be limited to just dictionary words.
		
	 * @param str
	 * @return
	 */
	public boolean checkIfPalindromePossible(String str) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			map.put(c, map.containsKey(c) ? map.get(c)+1 : 1);
		}
		boolean oneAllowed = false;
		for (Map.Entry<Character, Integer> e : map.entrySet()) {
			if (e.getValue()%2 != 0) {
				if (oneAllowed) return false;
				else oneAllowed = true;
			}
		}
		return true;		
	}
	
	/**
	 * One Away: There are three types of edits that can be performed on strings: insert a character,
		remove a character, or replace a character. Given two strings, write a function to check if they are
		one edit (or zero edits) away

	 * @param a
	 * @param b
	 * @return {@literal : <code>true</code>} for distance 1 or 0, otherwise false;
	 */
	public boolean editDistanceInTwoStrings(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		if (lenB > lenA) {
			String tmp = a;
			a = b;
			b = tmp;
			lenA = lenB;
			lenB = b.length();
		}
		if (Math.abs(lenA-lenB) > 1) return false;
		boolean possibleEdits = false;
		if (lenA == lenB) {
			int i = 0, j = 0;
			for (; i<lenA; i++,j++) {
				if (a.charAt(i) != b.charAt(j)) {
					if (possibleEdits) return false;
					else possibleEdits = true;
				}
			}
			return true;
		} else {
			for (int i=0, j=0; i<lenA && j<lenB; i++,j++) {
				if (a.charAt(i) != b.charAt(j)) {
					if (a.substring(i+1).equals(b.substring(j))) return true;
					else return false;
				}
			}
			return true;
		}
	}
	
	/**
	 * Given two Strings find if one is subsequence or not.
	 * @param str
	 * @param sub
	 * @return
	 */
	public boolean checkIfSubSequence(String str, String sub) {
		//determine if sub is contained in str.
		int j = 0;
		int i=0;
		for(;i<sub.length() && j<str.length(); ++j) {
			if(sub.charAt(i) == str.charAt(j)) i++;
		}
		return j == str.length();
	}
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public String basicStringCompression(String str) {
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i<str.length()) {
			if (i+1<str.length() && str.charAt(i+1) == str.charAt(i)) {
				int count = 1;
				int j=i+1;
				sb.append(str.charAt(i));
				while (j<str.length() && str.charAt(i) == str.charAt(j)) {
					count++;j++;
				}
				sb.append(count);
				i = j;
			} else {
				sb.append(str.charAt(i));
				sb.append(1);
				i++;
			}
			
		}
		return sb.toString();
	}
	
}
