package madr.sp.emira.tree.bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class IBitHeapsAndMap {

	public static void main(String[] args) {
		IBitHeapsAndMap cl = new IBitHeapsAndMap();
		/*ListNode _1 = createLinkedList(1,6);
		ListNode _2 = createLinkedList(4,11,13,14,16,18,29);
		ListNode _3 = createLinkedList(3);
		ArrayList<ListNode> a = new ArrayList<ListNode>();
		a.add(_1);a.add(_2);a.add(_3);
		printLL(cl.mergeKLists(a));*/
		
		LRU cache = cl.new LRU(2);
		System.out.println(cache.get(2));
		cache.set(2, 6);
		cache.get(1);
		cache.set(1, 5);
		cache.set(1, 2);
		cache.get(1);
		cache.get(2);
	}
	
	public ListNode mergeKLists2(ArrayList<ListNode> a) {
		 
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(a.size(), new Comparator<ListNode>() {
	    	public int compare(ListNode a, ListNode b){
	            if(a.val>b.val){
	                return 1;
	            }else if(a.val==b.val){
	                return 0;
	            }else{
	                return -1;
	            }
	        }
		});
	   
		for(ListNode t : a) pq.add(t);
		ListNode newListHead = null;
	    ListNode iterator = newListHead;
	    while(pq.size()!=0){
	    	ListNode temp = pq.poll();
	    	if(newListHead==null){
	    		newListHead = temp;
	    		iterator = newListHead;
	    	} else {
	    		iterator.next = temp;
	    		iterator = iterator.next;
	    	}
	    	if(temp.next!=null){
	    		pq.add(temp.next);
	    	}
	    }
	    return newListHead;
	}
	
	public ListNode mergeKLists(ArrayList<ListNode> a) {
	    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
	    ListNode head = null;
	    if (a == null || a.size() == 0) return null;
	    if (a.size() == 1) return a.get(0);
	    for (int i=0; i<a.size(); i++) {
	        ListNode node = a.get(i);
	        ListNode tmp = node;
	        node = node.next;
	        tmp.next = null;
	        int in = i;
	        if (node == null) in = -1;
	        a.set(i, node);
	        Pair pair = new Pair(tmp,in);
	        pq.add(pair);
	    }
	    Pair p = pq.remove();
	    head = p.node;
	    if (p.index != -1) {
    	    ListNode node = a.get(p.index);
    	    ListNode tmp = node;
            node = node.next;
            tmp.next = null;
            a.set(p.index, node);
            if (node == null) pq.add(new Pair(tmp,-1));
            else pq.add(new Pair(tmp,p.index));
	    }
	    ListNode curr = head;
	    while (pq.size() != 0) {
	        Pair pair = pq.remove();
	        int index = pair.index;
	        curr.next = pair.node;
	        curr = curr.next;
	        if (index == -1) continue;
	        ListNode nxt = a.get(index);
    	    ListNode temp = nxt;
            nxt = nxt.next;
            a.set(index, nxt);
            temp.next = null;
            if (nxt == null) index = -1;
            pq.add(new Pair(temp,index));
	    }
	    curr.next = null;
	    return head;
	}
	
	static class ListNode {
		int val;
		ListNode next;
		public ListNode() {
		}
		public ListNode(int v, ListNode n) {
			val = v;
			next = n;
		}
		@Override
		public String toString() {
			return ""+val+"-->";
		}
	}
	
	public static ListNode createLinkedList(int... dataues) {
		ListNode head = new ListNode(dataues[0], null);
		ListNode prev = head;
		for (int i=1; i<dataues.length; i++) {
			ListNode current = new ListNode();
			current.val = dataues[i];
			prev.next = current;
			prev = current;
		}
		return head;
	}
	
	public static void printLL(ListNode n) {
		while (n !=null) {
			System.out.print(n.val+" ");
			n = n.next;
		}
	}
	
	class Pair implements Comparable<Pair>{
        ListNode node;
        int index;
        public Pair(ListNode n, int in) {
            node = n;
            index = in;
        }
        
        @Override
        public int compareTo(Pair o) {
            return this.node.val - o.node.val;
        }
        
        @Override
        public String toString() {
        	return node.val+": "+index;
        }
    }
	
	class LRU {
		LinkedHashMap<Integer, Integer> lru;
	    int cap;
	    
	    public LRU(int capacity) {
	        cap = capacity;
	        lru = new LinkedHashMap<Integer, Integer>(capacity);
	    }
	    
	    public int get(int key) {
	        Integer v = lru.remove(key);
	        if (v == null) return -1;
	        set(key,v.intValue());
	        return v.intValue();
	    }
	    
	    public void set(int key, int value) {
	        Set<Map.Entry<Integer, Integer>> entrySet = lru.entrySet();
			Iterator<Map.Entry<Integer, Integer>> it = entrySet.iterator();
			if (lru.containsKey(key)) {
				lru.remove(key);
			}
	        if (lru.size() == cap) {
	            it.next();
	            it.remove();
	        }
	        lru.put(key, value);
	    }
	}
}
