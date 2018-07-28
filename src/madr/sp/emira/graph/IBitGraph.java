package madr.sp.emira.graph;

public class IBitGraph {

	public static void main(String[] args) {
		IBitGraph cl = new IBitGraph();
		
		int[][] arr = {
						{0,0,1,1},
						{0,1,1,0},
						{1,0,0,1},
						{0,0,0,0},
						{0,1,1,0},
						{0,1,1,0},
					  };
		System.out.println(cl.largestConnectedIceland(arr));
	}
	
	/**
	 * you are given a matrix of 0s and 1s, need to Find the largest region of connected 1's.
	 * 
	 * 0  0  1* 1*
	 * 0  1* 1* 0
	 * 1* 0  0  1*   ==> Largest connected Iceland = 6; 
	 * 0  0  0  0
	 * 1  1  1  0
	 * 0  0  1  0
	 * 
	 * 
	 * 
	 * An Application of DFS
	 * 
	 * #DFS
	 * 
	 * if modification of array is not permitted then create a clone of given array and perform ops on that.
	 * or bulid a boolean visited matrix to keep track of visited nodes.
	 * 
	 * otherwise change the visited node in given arr.
	 * -or- change the value in given arr but with some flag and at the end change it back to 1s.
	 * 
	 * @param arr
	 * @return
	 */
	public int largestConnectedIceland(int[][] arr) {
		int maxCount = 0;
		for (int row=0; row<arr.length; row++) {
			for (int column=0; column<arr[0].length; column++) {
				if (arr[row][column] == 1) maxCount = Math.max(maxCount, largestConnectedIcelandUtil(arr,row,column));
			}
		}
		return maxCount;
	}

	private int largestConnectedIcelandUtil(int[][] arr, int row, int column) {
		if (row<0 || row>=arr.length || column<0 || column>=arr[0].length) return 0;
		if (arr[row][column] == 0) return 0;
		/*if (arr[row][column] == -1) return 0;
		arr[row][column] = -1;*/
		arr[row][column] = 0;
		int count = 1;
		for (int r=row-1; r<=row+1; r++) {
			for (int c=column-1; c<=column+1; c++) {
				if (r==row && c==column) continue; 
				count += largestConnectedIcelandUtil(arr, r, c);
			}
		}
		return count;
	}
}
