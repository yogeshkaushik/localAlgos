package madr.sp.emira.tree.bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TrieMainClass {

	public static void main(String[] args) {
		//TRIEImpl trie = new TRIEImpl();
		/*trie.insertKey("amy", 56);
		trie.insertKey("ann", 15);
		trie.insertKey("emma", 30);
		trie.insertKey("rob", 27);
		trie.insertKey("roger", 52);
		
		System.out.println(trie.isMember("emma"));
		System.out.println(trie.isMember("emmam"));
		
		System.out.println(trie.getValue("roger"));
		System.out.println(trie.getValue("rob"));
		System.out.println(trie.getValue("ann"));
		
		trie.insertKey("yogesh", 28);
		System.out.println(trie.getValue("yogesh"));
		System.out.println(trie.isMember("yogesh"));
		
		System.out.println(trie.deleteKey("yogesh"));
		System.out.println(trie.isMember("yogesh"));
		
		trie.insertKey("robo", 29);
		trie.deleteKey("robo");
		System.out.println(trie.getValue("rob"));*/
		
		/*String[] strArr = {"are", "area", "base", "cat", "cater", "children", "basement"};
		trie.buildTrie(strArr);
		System.out.println(trie.isMember("child"));
		System.out.println(longestPrefixMatching(trie, "caterer"));
		System.out.println(longestPrefixMatching(trie, "basemexy"));
		System.out.println(longestPrefixMatching(trie, "basement"));
		System.out.println(longestPrefixMatching(trie, "are"));
		System.out.println(longestPrefixMatching(trie, "arex"));
		System.out.println(longestPrefixMatching(trie, "basemexz"));
		System.out.println(longestPrefixMatching(trie, "child"));*/
		
		/*ArrayList<String> list = new ArrayList<String>();
		list.add("smart_guy");
		list.add("girl_and_boy_play");
		list.add("play_ground");
		System.out.println(solve("play_boy", list));*/
		
		String[] arr = {"zebra", "dog", "duck", "dove"};
		System.out.println(shortestUniquePrefixOrdered(arr));
	}

	/**
	 * Find shortest unique prefix to represent each word in the list.
	 * 
	 *  Input: [zebra, dog, duck, dove]
		Output: {z, dog, du, dov}
		where we can see that
		zebra = z
		dog = dog
		duck = du
		dove = dov
	 * 
	 * @param arr
	 * @return
	 */
	public static ArrayList<String> shortestUniquePrefixOrdered(String[] arr) {
		TRIEImpl trie = new TRIEImpl();
        trie.buildTrie(arr);
        ArrayList<String> ans = new ArrayList<String>();
        for (String s : arr) {
        	ans.add(trie.shortestUniquePrefixFor(s));
        }
        return ans;
	}
	
	/**
	 * Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, 
	 * you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first).
	 * We define the “Goodness Value” of a string as the number of “Good Words” in that string.
	 * 
	 * Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.
	 * 
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static ArrayList<Integer> solve(String A, ArrayList<String> B) {
        String[] strArr = A.split("_");
        TRIEImpl trie = new TRIEImpl();
        trie.buildTrie(strArr);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i=0; i<B.size(); i++) {
            String[] st = B.get(i).split("_");
            int count = 0;
            for (int j=0;j<st.length;j++) if (trie.isMember(st[j])) count++;
            map.put(i,count);
        }
        //MapUtil.sortByValue(map);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        //Collections.reverse(list);
        //for (Map.Entry<Integer, Integer> e : map.entrySet()) ans.add(e.getKey());
        for (int i=list.size()-1; i>=0; i--) {
        	if (i>0 && list.get(i).getValue().intValue() == list.get(i-1).getValue().intValue()) {
        		int j = i;
        		while (j>0 && list.get(j).getValue().intValue() == list.get(j-1).getValue().intValue()) j--;
        		int temp = j;
        		while (j<=i) ans.add(list.get(j++).getKey());
        		i=temp;
        	} else {
        		ans.add(list.get(i).getKey());
        	}
        }
        return ans;
    }
	
	/**
	 * https://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
	 */
	public static String longestPrefixMatching(TRIEImpl tr, String str) {
		return tr.longestPrefixMatching(str);
	}
	
	public static class MapUtil {
	    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
	        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
	        list.sort(Entry.comparingByValue());

	        Map<K, V> result = new LinkedHashMap<>();
	        for (Entry<K, V> entry : list) {
	            result.put(entry.getKey(), entry.getValue());
	        }

	        return result;
	    }
	}
}
