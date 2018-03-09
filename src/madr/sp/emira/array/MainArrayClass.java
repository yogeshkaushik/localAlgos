package madr.sp.emira.array;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Map;

public class MainArrayClass {
	
	static int max = Integer.MIN_VALUE;
	
	/**
	1 1 1 0 0 0
	0 8 0 0 0 0
	1 1 1 0 0 0
	0 9 2 -4 -4 0
	0 0 0 -2 0 0
	0 0 -1 -2 -4 0
	 * 
	 * 
	 * 
	 * 
	 * @param args
	 */
    public static void main(String[] args) {
    	//glassHourMain();
    	//arrayManipulation();
    	getMaxOccurence();
    }

	private static void getMaxOccurence() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = 0;
        Map<String, Integer> map = new HashMap<String, Integer>();
        while(!in.hasNextInt()) {
            String str = in.next();
            if (map.containsKey(str)) {
                map.put(str,map.get(str)+1);                
            } else {
            	map.put(str,1);
            }
        }
        m = in.nextInt();
        while(in.hasNext()) {
            Integer i = 0;
            System.out.println((i = map.get(in.next())) != null ?  i : 0);
        }
	}

	private static void arrayManipulation() {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for(int a0 = 0; a0 < m; a0++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            arr = process(arr,a-1,b-1,k);
        }
        System.out.println(max);
        in.close();
	}
	
	public static int[] process(int[] arr, int i, int j, int k) {
        for(;i<=j;i++) {
            arr[i] =+ k;
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return arr;
    }

	private static void glassHourMain() {
		Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int arr_i=0; arr_i < 6; arr_i++){
            for(int arr_j=0; arr_j < 6; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }
        getMaxHourGlass(arr);
        getMaxHourGlass2nd(arr);
	}

	private static void getMaxHourGlass2nd(int[][] array) {
		int maxHourglass = getHourglass(array, 1,1);
        for (int y=1; y<5; y++){
            for (int x=1; x<5; x++){
                int hourres = getHourglass(array, x, y);
                if (hourres > maxHourglass){
                    maxHourglass = hourres;
                }
            }
        }
        System.out.println(maxHourglass);
	}
	
	private static int getHourglass(int[][] array, int x, int y) {
        return array[x][y] + array[x-1][y-1] + array[x][y-1] + array[x+1][y-1] + array[x-1][y+1]
            + array[x][y+1] + array[x+1][y+1];
    }

	private static void getMaxHourGlass(int[][] arr) {
		int noOfHourGlass = getPossibleNoOfHourGlass(arr);
        int hg[][] = new int[3][3];
        int sumArr[] = new int[noOfHourGlass];
        int index = 0;
        int m = 0;
        int n = 0;
        int i=0;
        int j=0;
        int maxN = 2;
        int maxM = 2;
        while (maxM < 6) {
            while (maxN < 6) {                
                hg[i][j] = arr[m][n];
                j++;
                n++;
                if (j > 2) {
                    j = 0;
                    if ( n > maxN) {
                        n = maxN - 2;
                    }
                    break;
                }               
            }
            i++;
            m++;
            if (i > 2) {
                i = 0;
                m = maxM - 2;
                n++;
                maxN++;
                sumArr[index++] = getSumOfHourGlass(hg);
                if (maxN == 6) {
                    m++;
                    maxM++;
                    n = 0;
                    maxN = 2;
                }                
            }
        }
        System.out.println("Total : " + noOfHourGlass + ", arr[3][3] : " + arr[3][3]);
        System.out.println("Max is: " + getMaxInArray(sumArr));
	}

	private static int getMaxInArray(int[] sumArr) {
		int max = Integer.MIN_VALUE;
		for (int i : sumArr) {
			if (i > max) {
				max = i;
			}
		}
		return max;
	}

	private static int getPossibleNoOfHourGlass(int[][] arr) {
		int width = arr.length;
		int height = arr[0].length;
		/* HourGlass with and height is 3*3 */
		return ((width-3)+1)*((height-3)+1);
	}
	
	private static int getSumOfHourGlass(int[][] hg) {
        int sum = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (i==1 && (j==0 || j==2)) {
                    continue;
                }
                sum = sum + hg[i][j];
            }
        }
        return sum;
    }
}
