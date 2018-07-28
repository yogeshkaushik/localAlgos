package madr.sp.emira.dp;

import java.util.ArrayList;
import java.util.List;

import madr.sp.emira.array.BinarySearchClass;

public class IBitGreedy {
	
	public static void main(String[] args) {
		IBitGreedy cl = new IBitGreedy();
		
		//System.out.println(cl.seats(".........x.x"));
		
		int[] gas = {684, 57, 602, 987};//{2,3,4,1,5};
		int[] dist = {909, 535, 190, 976};//{1,5,2,3,4};
		System.out.println(cl.gasStation(BinarySearchClass.createList(gas), BinarySearchClass.createList(dist)));
	}
	
	/**
	 * Gas Station.
	 * @param gas
	 * @param dist
	 * @return
	 */
	public int gasStation(final List<Integer> gas, final List<Integer> dist) {
		if (gas.size()==1) return 0;
        int left = 0;
        int i = 0;
        int count = gas.size()-1;
        int len = gas.size();
        while (i<=count) {
            if (i>=len && left == 0) {
            	return -1;
            }
            if (gas.get(i%len)+left >= dist.get(i%len)) {
                left = gas.get(i%len) + left - dist.get(i%len);
            } else {
                count = i+len;
                left = 0;
            }
            i++;
        }
        return i%len+1;
        //return gasStationUtil(gas,dist,0,0,gas.size()-1);        
    }
    
    private int gasStationUtil(final List<Integer> gas, final List<Integer> dist, int left, int index, int count) {
        if (index==count) return index%gas.size()+1;
        if (index>=gas.size()) return -1;
        int len = gas.size();
        for (int i=index; i<=count; i++) {
            if (gas.get(i%len)+left >= dist.get(i%len)) {
                left = gas.get(i%len) + left - dist.get(i%len);
            } else {
                return gasStationUtil(gas, dist, 0, i+1, i+len);
            }
        }
        return index;
    }
	
	/**
	 * N light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, 
	 * a switch also changes the state of all the bulbs to the right of current bulb. Given an initial state of all bulbs, 
	 * find the minimum number of switches you have to press to turn on all the bulbs. You can press the same switch multiple times.
	 * 
	 * Input : [0 1 0 1]
		Return : 4
		
		Explanation :
			press switch 0 : [1 0 1 0]
			press switch 1 : [1 1 0 1]
			press switch 2 : [1 1 1 0]
			press switch 3 : [1 1 1 1]
			
	 * @param A
	 * @return
	 */
	public int bulbs(ArrayList<Integer> A) {
        int changes = 0;
        for (int i=0; i<A.size(); i++) {
            int val = A.get(i);
            if(changes%2==1) val = val==0 ? 1 : 0;
            if (val==0) changes++;
        }
        return changes;
    }
	
	/**
	 * There is a row of seats. Assume that it contains N seats adjacent to each other. 
	 * There is a group of people who are already seated in that row randomly. i.e. some are sitting together & some are scattered.
	 * An occupied seat is marked with a character 'x' and an unoccupied seat is marked with a dot ('.')
	 * Now your target is to make the whole group sit together i.e. next to each other, without having any 
	 * vacant seat between them in such a way that the total number of hops or jumps to move them should be minimum.
	 * 
	 * @param A
	 * @return
	 */
	public int seats2(String A) {
        int min = Integer.MAX_VALUE;
        for (int i=0; i<A.length(); i++) {
            if (A.charAt(i) == '.') continue;
            int c = 0;
            int skip = 0;
            for (int j=i+1; j<A.length(); j++) {
                if (A.charAt(j) == '.') continue;
                c += j-i-1-skip++;
            }
            skip = 0;
            for (int j=i-1; j>=0; j--) {
                if (A.charAt(j) == '.') continue;
                c += i-j-1-skip++;
            }
            min = min < c ? min : c;
        }
        return min;
    }
	
	public int seats(String A) {
        int min = Integer.MAX_VALUE;
        List<Integer> l = new ArrayList<Integer>();
        for (int i=0; i<A.length(); i++) if (A.charAt(i) == 'x') l.add(i+1);
        int median = 0;
        int len = l.size();
        if ((len&1) == 1) median = l.get(len/2);
        else median = (l.get(len/2) + l.get((len/2)-1))/2;
        int c = 0;
        int skip = 0;
        for (int j=len/2; j<len; j++) {
        	if (l.get(j)!=median) c += l.get(j)-median-1-skip++;
        }
        skip = 0;
        for (int j=len/2-1; j>=0; j--) {
        	if (l.get(j)!=median) c += median-l.get(j)-1-skip++;
        }
        min = min < c ? min : c;
        return min;
    }
}
