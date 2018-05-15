package madr.sp.emira.tree.bst;

import java.util.HashMap;
import java.util.List;

public class TRIEImpl {
	int i;
	private Trie<Character, Integer> root;
	private boolean b;
	
	public TRIEImpl() {
		root = new Trie<Character, Integer>();	
	}
	
	public Integer getValue(String keys) {
		if (!isMember(keys)) throw new IllegalArgumentException("this particular word is not present in Trie");
		Trie<Character, Integer> temp = root;
		int i = 0;
		while (i<keys.length() && temp.checkKey(keys.charAt(i))) temp = temp.next(keys.charAt(i++));
		return temp.checkKey(null) ? temp.next(null).getValue() : null;
	}
	
	public void insertKey(String keys, Integer value) {
		Trie<Character, Integer> temp = root;
		int i = 0;
		while (i<keys.length() && temp.checkKey(keys.charAt(i))) temp = temp.next(keys.charAt(i++));

		for (int in=i; in< keys.length(); in++) {
			Character k = keys.charAt(in);
			temp.add(k);
			temp = temp.next(k);
		}
		//add last with isEnd as true and can keep any values as well;
		//as hashMap allows one null key, use that feature.
		//temp.add(null,value,true);
		temp.add(value,true);
	}
	
	public boolean isMember(String keys) {
		Trie<Character, Integer> temp = root;
		int i = 0;
		while (i<keys.length() && temp.checkKey(keys.charAt(i))) temp = temp.next(keys.charAt(i++));
		return i==keys.length() && temp.checkKey(null) && temp.next(null).isEnd();
	}
	
	/**
	 * 
	 * @param keys
	 * @return true if keys exist and false if keys itself are not there
	 */
	public boolean deleteKey(String keys) {
		if (!isMember(keys)) return false;
		deleteHelper(keys, 0, root);
		return true;
	}
	
	private void deleteHelper(String keys,int i, Trie<Character, Integer> root) {
		if (i == keys.length() && root.checkKey(null)) {
			//using hashmap property as it can contain one null as a key
			root.deleteNode(null);
			return;
		}
		deleteHelper(keys, i+1, root.next(keys.charAt(i)));
		if (root.next(keys.charAt(i)).size() == 0) root.deleteNode(keys.charAt(i));
		else return;
	}
	
	@Override
	public String toString() {
		return root.toString();
	}

	/**************************************** Not So specific Impl **********************************************/
	
	public String longestPrefixMatching(String keys) {
		Trie<Character, Integer> temp = root;
		int i = 0;
		String pref = null;
		while (i<keys.length() && temp.checkKey(keys.charAt(i))) {
			temp = temp.next(keys.charAt(i++));
			if(temp.checkKey(null)) pref = keys.substring(0, i);
		}
		/*if (i==keys.length()) return temp.checkKey(null) ? keys : null;
		return i==0 ? null : temp.checkKey(null) ? keys.substring(0, i) : null;*/
		return pref;
	}

	public void buildTrie(String[] strArr) {
		for (String str : strArr) insertKey(str, null);
	}

	public void buildTrie(List<String> strArr) {
		for (String str : strArr) insertKey(str, null);
	}
	
	public void buildTrie(String[] strArr, Integer[] values) {
		if (strArr.length != values.length) throw new IllegalArgumentException("input array length should always be same.");
		for (int i=0; i<strArr.length; i++) insertKey(strArr[i], values[i]);
	}

	public String shortestUniquePrefixFor(String s) {
		i = 0;
		b = true;
		Trie<Character, Integer> temp = root.next(s.charAt(0));
		shortestUniquePrefixForHelper(temp,s,1);
		return s.substring(0, i+1);
	}

	private void shortestUniquePrefixForHelper(Trie<Character, Integer> temp, String s, int i) {
		if (i==s.length()) return;
		shortestUniquePrefixForHelper(temp.next(s.charAt(i)), s, i+1);
		if (temp.size() > 1 && b) {
			this.b = false;
			this.i = i;
		}
	}
}

class Trie<K extends Comparable<K>, V extends Comparable<V>> {
	HashMap<K, Trie<K, V>> children = new HashMap<K, Trie<K, V>>();
	//LinkedHashMap<K, Trie<K, V>> children = new LinkedHashMap<K, Trie<K, V>>();
	private V value;
	private boolean end;
	
	public Trie() {
		value = null;
		end = false;
	}
	
	public Trie<K, V> next(K key) {
		return children.get(key);
	}
	
	public boolean checkKey(K key) {
		return children.containsKey(key);
	}
	
	public int size() {
		return children.size();
	}
	
	public Trie<K, V> deleteNode(K k) {
		return children.remove(k);
	}
	
	public void add(K key) {
		add(key,null,false);
	}
	
	public void add(K key, V val) {
		add(key,val,false);
	}
	
	protected void add(V val, boolean isEnd) {
		Trie<K, V> temp = new Trie<>();
		children.put(null, temp);
		children.get(null).setValue(val);
		children.get(null).setEnd(isEnd);
	}
	
	public void add(K key, V val, boolean end) {
		Trie<K, V> temp = new Trie<>();
		children.put(key, temp);
		setValue(val);
		setEnd(end);
	}
	
	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public boolean isValue() {
		return getValue() != null;
	}
	
	public boolean isEnd() {
		return end;
	}

	public void setEnd(boolean end) {
		this.end = end;
	}
	
	@Override
	public String toString() {
		String s = "";
		if(end) s+="(isEnd-"+end+", value-"+value+")";
		return children.keySet().toString() + s;
	}
}