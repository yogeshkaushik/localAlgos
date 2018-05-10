package madr.sp.emira.tree.bst;

public class TrieMainClass {

	public static void main(String[] args) {
		TRIEImpl trie = new TRIEImpl();
		trie.insertKey("amy", 56);
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
		System.out.println(trie.getValue("rob"));
		
	}
}
