package madr.sp.emira.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IBitArray {

	public static void main(String[] args) {
		IBitArray cl = new IBitArray();
		
		/*int[] arr = {1, 34, 3, 98, 9, 76, 45, 4}; //{54, 546, 548, 60}; //{3,5,30,9,34};
		System.out.println(cl.createMaxPossibleNo(arr));*/
		
		/*int[] arr = {1, 34, 3, 98, 9, 76, 45, 4};
		cl.shiftRight(arr, 0, 4);*/
		
		/*int[] arr = {8,6,2,0,7,4,5};//{3,5,4,2};
		System.out.println(maxGap(arr));*/
		
		/*int[] arr = {1,2,3,4,5,6,7,8,9};
		cl.rotateArrByD(arr, 3);
		cl.reverseArray(arr);
		System.out.println(cl.findRotatingPivot(arr, 0, arr.length - 1));
		System.out.println(cl.searchInRotatedArray(arr, arr.length, 4));*/
		
		/*int[] arr = {3, 2, 1};//{8, 3, 1, 2};//{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};//{1, 20, 2, 10};
		System.out.println(cl.maxSum_i_arr_i(arr));*/
		
		/*int[] arr = {-1,-8,-2,-3,-2,-3,-4,-5,2,3};//{-1, 2, -3, 4, 5, 6, -7, 8, 9};
		cl.alternatePositiveNegative(arr);*/
		
		/*int[] arr = {12, 11, -13, -5, 6, -7, 5, -3, -6};
		cl.rearrangePosiiveNegative(arr);*/
		
		/*int[] arr = {-4, 7, 5, 3, 5, -4, 2, -1, -9, -8, -3, 0, 9, -7, -4, -10, -4, 2, 6, 1, -2, -3, -1, -8, 0, -8, -7, -3, 5, -1, -8, -8, 8, -1, -3, 3, 6, 1, -8, -1, 3, -9, 9, -6, 7, 8, -6, 5, 0, 3, -4, 1, -10, 6, 3, -8, 0, 6, -9, -5, -5, -6, -3, 6, -5, -4, -1, 3, 7, -6, 5, -8, -5, 4, -3, 4, -6, -7, 0, -3, -2, 6, 8, -2, -6, -7, 1, 4, 9, 2, -10, 6, -2, 9, 2, -4, -4, 4, 9, 5, 0, 4, 8, -3, -9, 7, -8, 7, 2, 2, 6, -9, -10, -4, -9, -5, -1, -6, 9, -10, -1, 1, 7, 7, 1, -9, 5, -1, -3, -3, 6, 7, 3, -4, -5, -4, -7, 9, -6, -2, 1, 2, -1, -7, 9, 0, -2, -2, 5, -10, -1, 6, -7, 8, -5, -4, 1, -9, 5, 9, -2, -6, -2, -9, 0, 3, -10, 4, -6, -6, 4, -3, 6, -7, 1, -3, -5, 9, 6, 2, 1, 7, -2, 5};
		System.out.println(cl.nobleInteger(arr));*/
		
		/*int[] arr = { 0, 8, 8, 1, 7, 2, 1, 3, 5, 9};
		cl.printArr(cl.plusOne(arr));*/
		
		/*int[] arr1 = {1, 3, -1};
		System.out.println(cl.maxArr(arr1));*/
		
		/*int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(cl.subArrayWithMaxSum(arr));*/
		
		//int[] arr = {389, 299, 65, 518, 361, 103, 342, 406, 24, 79, 192, 181, 178, 205, 38, 298, 218, 143, 446, 324, 82, 41, 312, 166, 252, 59, 91, 6, 248, 395, 157, 332, 352, 57, 106, 246, 506, 261, 16, 470, 224, 228, 286, 121, 193, 241, 203, 36, 264, 234, 386, 471, 225, 466, 81, 58, 253, 468, 31, 197, 15, 282, 334, 171, 358, 209, 213, 158, 355, 243, 75, 411, 43, 485, 291, 270, 25, 100, 194, 476, 70, 402, 403, 109, 322, 421, 313, 239, 327, 238, 257, 433, 254, 328, 163, 436, 520, 437, 392, 199, 63, 482, 222, 500, 454, 84, 265, 508, 416, 141, 447, 258, 384, 138, 47, 156, 172, 319, 137, 62, 85, 154, 97, 18, 360, 244, 272, 93, 263, 262, 266, 290, 369, 357, 176, 317, 383, 333, 204, 56, 521, 502, 326, 353, 469, 455, 190, 393, 453, 314, 480, 189, 77, 129, 439, 139, 441, 443, 351, 528, 182, 101, 501, 425, 126, 231, 445, 155, 432, 418, 95, 375, 376, 60, 271, 74, 11, 419, 488, 486, 54, 460, 321, 341, 174, 408, 131, 115, 107, 134, 448, 532, 292, 289, 320, 14, 323, 61, 481, 371, 151, 385, 325, 472, 44, 335, 431, 187, 51, 88, 105, 145, 215, 122, 162, 458, 52, 496, 277, 362, 374, 26, 211, 452, 130, 346, 10, 315, 459, 92, 531, 467, 309, 34, 281, 478, 477, 136, 519, 196, 240, 12, 288, 302, 119, 356, 503, 527, 22, 27, 55, 343, 490, 127, 444, 308, 354, 278, 497, 191, 294, 117, 1, 396, 125, 148, 285, 509, 208, 382, 297, 405, 245, 5, 330, 311, 133, 274, 275, 118, 463, 504, 39, 99, 442, 337, 169, 140, 104, 373, 221, 499, 413, 124, 510, 159, 465, 80, 276, 83, 329, 524, 255, 387, 259, 397, 491, 517, 23, 4, 230, 48, 349, 412, 142, 114, 487, 381, 164, 35, 67, 498, 73, 440, 108, 226, 96, 132, 144, 207, 235, 33, 69, 128, 236, 364, 198, 475, 173, 493, 150, 90, 515, 111, 68, 232, 340, 112, 526, 492, 512, 495, 429, 146, 336, 17, 350, 251, 7, 184, 76, 380, 359, 293, 19, 49, 345, 227, 212, 430, 89, 474, 279, 201, 398, 347, 273, 37, 185, 177, 102, 304, 295, 422, 94, 426, 514, 116, 183, 180, 494, 42, 305, 152, 390, 30, 247, 451, 32, 388, 331, 78, 424, 368, 394, 188, 306, 449, 8, 214, 120, 179, 280, 511, 409, 338, 153, 507, 370, 461, 217, 161, 483, 147, 242, 86, 417, 268, 71, 462, 420, 167, 513, 379, 307, 522, 435, 113, 296, 457, 525, 45, 529, 423, 427, 2, 438, 64, 316, 46, 40, 13, 516, 367, 233, 110, 318, 250, 283, 216, 186, 310, 237, 377, 365, 175, 479, 378, 66, 414, 473, 165, 210, 50, 348, 372, 363, 339, 20, 168, 284, 415, 505, 206, 53, 223, 434, 202, 123, 399, 400, 135, 269, 428, 219, 456, 28, 464, 267, 489, 98, 391, 195, 366, 300, 484, 533, 229, 213, 149, 160, 256, 303, 530, 301, 29, 404, 344, 401, 220, 287, 9, 407, 170, 450, 523, 249, 72, 410, 3, 21, 200, 260};
		/*int[] arr = cl.createArray(100000);
		arr[2] = 25;
		cl.findMissingNum(arr);*/
		
		/*String str = "11111100000000010101000000001";
		cl.flipBinaryString(str);*/
		
		/*int[] arr = {0, 0, -1, 0};
		cl.printArr(cl.maxset(arr));*/
		
		/*String[] str = {"0.628934", "0.939859", "0.898308"};
		System.out.println(cl.findTripletInRange(str));*/
		
		int[] arr = {417, 929, 845, 462, 675, 175, 73, 867, 14, 201, 777, 407, 80, 882, 785, 563, 209, 261, 776, 362, 730, 74, 649, 465, 353, 801, 503, 154, 998, 286, 520, 692, 68, 805, 835, 210, 819, 341, 564, 215, 984, 643, 381, 793, 726, 213, 866, 706, 97, 538, 308, 797, 883, 59, 328, 743, 694, 607, 729, 821, 32, 672, 130, 13, 76, 724, 384, 444, 884, 192, 917, 75, 551, 96, 418, 840, 235, 433, 290, 954, 549, 950, 21, 711, 781, 132, 296, 44, 439, 164, 401, 505, 923, 136, 317, 548, 787, 224, 23, 185, 6, 350, 822, 457, 489, 133, 31, 830, 386, 671, 999, 255, 222, 944, 952, 637, 523, 494, 916, 95, 734, 908, 90, 541, 470, 941, 876, 264, 880, 761, 535, 738, 128, 772, 39, 553, 656, 603, 868, 292, 117, 966, 259, 619, 836, 818, 493, 592, 380, 500, 599, 839, 268, 67, 591, 126, 773, 635, 800, 842, 536, 668, 896, 260, 664, 506, 280, 435, 618, 398, 533, 647, 373, 713, 745, 478, 129, 844, 640, 886, 972, 62, 636, 79, 600, 263, 52, 719, 665, 376, 351, 623, 276, 66, 316, 813, 663, 831, 160, 237, 567, 928, 543, 508, 638, 487, 234, 997, 307, 480, 620, 890, 216, 147, 271, 989, 872, 994, 488, 291, 331, 8, 769, 481, 924, 166, 89, 824, -4, 590, 416, 17, 814, 728, 18, 673, 662, 410, 727, 667, 631, 660, 625, 683, 33, 436, 930, 91, 141, 948, 138, 113, 253, 56, 432, 744, 302, 211, 262, 968, 945, 396, 240, 594, 684, 958, 343, 879, 155, 395, 288, 550, 482, 557, 826, 598, 795, 914, 892, 690, 964, 981, 150, 179, 515, 205, 265, 823, 799, 190, 236, 24, 498, 229, 420, 753, 936, 191, 366, 935, 434, 311, 920, 167, 817, 220, 219, 741, -2, 674, 330, 909, 162, 443, 412, 974, 294, 864, 971, 760, 225, 681, 689, 608, 931, 427, 687, 466, 894, 303, 390, 242, 339, 252, 20, 218, 499, 232, 184, 490, 4, 957, 597, 477, 354, 677, 691, 25, 580, 897, 542, 186, 359, 346, 409, 655, 979, 853, 411, 344, 358, 559, 765, 383, 484, 181, 82, 514, 582, 593, 77, 228, 921, 348, 453, 274, 449, 106, 657, 783, 782, 811, 333, 305, 784, 581, 746, 858, 249, 479, 652, 270, 429, 614, 903, 102, 378, 575, 119, 196, 12, 990, 356, 277, 169, 70, 518, 282, 676, 137, 622, 616, 357, 913, 161, 3, 589, 327};
		int[] arr1 = {1, 1, 1};
		System.out.println(cl.firstMissingPositive(arr1));
	}
	
	int firstMissingPositive(int[] arr) {
		int maxPositiveNum = Integer.MIN_VALUE;
		long sumOfAllPositiveNum = 0;
		int len = arr.length;
		Set<Integer> set = new HashSet<Integer>();
		for (int i : arr) {
			if (i>0) {
				set.add(i);
				sumOfAllPositiveNum += i;
				if (i > maxPositiveNum) maxPositiveNum = i;
			}
		}
		long posibleSum = (maxPositiveNum*(maxPositiveNum+1))/2;
		if (posibleSum == sumOfAllPositiveNum) {
			return maxPositiveNum+1;
		} else {
			int num = 0;
			int i = 1;
			for (; i<=set.size(); i++) {
				if(!set.contains(i)) {
					num = i;
					break;
				}
			}
			if (num == 0 && i >= 1) {
				num = i;
			}
			return num;
		}
	}
	
	/**
	 * Given an array of real numbers greater than zero in form of strings.
	 * Find if there exists a triplet (a,b,c) such that 1 < a+b+c < 2 .
	 * Return 1 for true or 0 for false.
	 * 
	 * Let us formally define our new ranges. Let A=(0,2/3), B=[2/3,1] and C=(1,2).
	 * 
	 * 1.A, A, A
	 * 2.A, A, B
	 * 3.A, A, C
	 * 4.A, B, B
	 * 5.A, B, C
	 * 
	 * 
	 * 6.A, C, C
	 * 7.B, B, B
	 * 8.B, B, C
	 * 9.B, C, C
	 * 10.C, C, C
	 * 
	 * We can quickly deduce that cases 6, 7, 8, 9, and 10 are not possible (the total sum will always be greater than 2).
	 * That leaves us with cases 1, 2, 3, 4, and 5.
	 * 
	 * @param arr
	 * @return
	 */
	int findTripletInRange(String[] arr) {
		List<Float> listA = new ArrayList<Float>();
		List<Float> listB = new ArrayList<Float>();
		List<Float> listC = new ArrayList<Float>();
		
		float listCmin = Float.MAX_VALUE;
		float listAmax = Float.MIN_VALUE;
		float listBmin = Float.MAX_VALUE;
		float max = 2.0f;
		for (String s : arr) {
			float f = Float.parseFloat(s);
			if (f >= 2f) {
				continue;
			} else if (f >=1) {
				listC.add(f);
				if (listCmin > f) listCmin = f;
			} else if (f < 1f && f >= 2f/3f){
				listB.add(f);
				if (listBmin > f) listBmin = f;
			} else {
				listA.add(f);
				if (listAmax < f) listAmax = f;
			}
		}
		if (listA.isEmpty()) return 0;
		
		//case-1 A A A
		if (listA.size() >= 3) {
			listA.remove(listAmax);
			float nextListAMax = findMaxInList(listA);
			listA.remove(nextListAMax);
			float nextNextListAMax = findMaxInList(listA);
			if (listAmax + nextListAMax + nextNextListAMax > 1) {
				return 1;
			}
			//restoreList
			listA.add(nextNextListAMax);
			listA.add(nextListAMax);
			listA.add(listAmax);
		}
		
		//case-3 AAC and case-5 ABC
		float listAmin = findMinInList(listA);
		if (listC.size() != 0) {
			//case-3
			if (listA.size() >=2) {
				listA.remove(listAmin);
				float nextListAmin = findMinInList(listA);
				if (listAmin + nextListAmin + listCmin < 2) {
					return 1;
				}
				//restoreList
				listA.add(0, listAmin);
			}
			//case-5
			if (listB.size() != 0) {
				if (listCmin + listBmin + listAmin < 2) {
					return 1;
				}
			}
		}
		
		//case-4 ABB
		if (listB.size() >=2) {
			listB.remove(listBmin);
			float nextListBmin = findMinInList(listB);
			if (listBmin + nextListBmin + listAmin < 2) {
				return 1;
			}
		}
		
		//case-2 AAB
		if (listA.size() >=2 && listB.size() != 0) {
			List<Float> listA1 = new ArrayList<Float>();
			List<Float> listA2 = new ArrayList<Float>();
			for (Float f : listA) {
				if (f<1f/2f) {
					listA1.add(f);
				} else {
					listA2.add(f);
				}
			}
			// sub cases =>
			//A1 A2 B, case-2a
			//A1 A1 B, case-2b
			//A2 A2 B, case-2c
			
			//case-2a, case-2c always greater than 1
			if (listA1.size() !=0 ) {
				float minListA1 = findMinInList(listA1);
				float minListA2 = 0;
				if (listA2.size() !=0) {
					minListA2 = findMinInList(listA2);
					if (minListA1 + minListA2 + listBmin < 2) return 1;
				}
				if (listA2.size() >=2 ) {
					listA2.remove(minListA2);
					float nextMinListA2 = findMinInList(listA2);
					if (minListA2 + nextMinListA2 + listBmin < 2) return 1;
					//restore list
					listA2.add(0, minListA2);
				}
			}
			//case-2b A1 A1 B
			if (listA1.size() >=2 ) {
				float maxInListA1 = findMaxInList(listA1);
				listA1.remove(maxInListA1);
				float nextMaxInListA1 = findMaxInList(listA1);
				float maxInListB = findMaxInList(listB);
				if (maxInListA1 + nextMaxInListA1 + maxInListB > 1) return 1;
			}
		}
		return 0;
	}
	
	<T extends Comparable<T>> T findMaxInList(List<T> A) {
		T max = A.get(0);
		int size = A.size();
		for (int i=1; i<size; i++) {
			T temp = A.get(i);
			if (temp.compareTo(max) > 0) {
				max = temp;
			}
		}
		return max;
	}
	
	<T extends Comparable<T>> T findMinInList(List<T> A) {
		T max = A.get(0);
		int size = A.size();
		for (int i=1; i<size; i++) {
			T temp = A.get(i);
			if (temp.compareTo(max) < 0) {
				max = temp;
			}
		}
		return max;
	}
	
	public int[] maxset(int[] A) {
        int len = A.length;
        long globalSum = 0;
        long localSum = 0;
        int indexI = -1; 
        int indexJ = -1; 
        int i = 0, j = 0;
        for (int k=0; k<len; k++) {
            if (A[k] < 0) {
                if (globalSum<localSum) {
                    globalSum = localSum;
                    indexI = i;
                    indexJ = j;
                    localSum = 0;
                } else if (globalSum == localSum) {
                    int diff = j - i;
                    if (diff > (indexJ - indexI)) {
                        indexI = i;
                        indexJ = j;
                    }
                    localSum = 0;
                }
                i = k+1;
                j = i;
            } else {
                localSum += A[k];
                j++;
            }
        }
        if (globalSum<localSum) {
            globalSum = localSum;
            indexI = i;
            indexJ = j;
            localSum = 0;
        } else if (globalSum == localSum) {
            int diff = j - i + 1;
            if (diff > (indexJ - indexI + 1)) {
                indexI = i;
                indexJ = j;
            }
            localSum = 0;
        }
        int[] arr = new int[indexJ - indexI];
        int n=0;
        for (int k=indexI; k<indexJ; k++) {
            arr[n++] = A[k]; 
        }
        return arr;
    }
	
	/**
	 * You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN.
	 * In a single operation, you can choose two indices L and R such that 1 ≤ L ≤ R ≤ N and flip the characters
	 * SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.
	 * 
	 * Your aim is to perform ATMOST one operation such that in final string number of 1s is maximised.
	 * If you don’t want to perform the operation, return an empty array. Else, return an array consisting 
	 * of two elements denoting L and R. 
	 * If there are multiple solutions, return the lexicographically smallest pair of L and R.
	 * 
	 * @param str
	 * @return
	 */
	int[] flipBinaryString(String str) {
		int len = str.length();
		int[] result = null;
		int indexI = -1;
		int indexJ = -1;
		int globalMax = 0;
		int localMax = 0;
		int i = 0, j = 0;
		for (int k=0; k<len; k++) {
			localMax = str.charAt(k) == '0' ? localMax + 1 : localMax -1;
			if (localMax < 0) {
				localMax = 0;
				i = k+1;
				j = k+1; 
			} else {
				j++;
			}
			if (globalMax < localMax) {
				globalMax = localMax;
				indexI = i;
				indexJ = j;
			}
		}
		if (indexI != -1) {
			result = new int[2];
			result[0] = indexI+1;
			result[1] = indexJ;
		} else {
			result = new int[0];
		}
		printArr(result);
		return result;
	}
	/**
	 * You are given a read only array of n integers from 1 to n.
	 * Each integer appears exactly once except A which appears twice and B which is missing.
	 * Return A and B.
	 */
	int[] findMissingNum(int[] arr) {
		long len = arr.length;
		int[] result = new int[2];
		Long a = 0L;
		Long b = 0L;
		long expectedSum = len*(len+1)/2;
		long calculatedSum = 0;
		long expectedSquareSum = ((2*len+1)*expectedSum)/3;
		long calcultedSquareSum = 0;
		for (int i : arr) {
			calculatedSum += i;
			Long temp = new Long(i);
			calcultedSquareSum += temp*temp;
		}
		long b_a = expectedSum - calculatedSum;
		long b2_a2 = expectedSquareSum - calcultedSquareSum;
		/*long b_dividedBy_a = expectedSquareSum/calcultedSquareSum;
		a = (int) (b_a*calcultedSquareSum/(expectedSquareSum - calcultedSquareSum));
		b = (int) (b_a*expectedSquareSum/(expectedSquareSum - calcultedSquareSum));*/
		a = ((b2_a2 - (b_a*b_a))/(2*b_a));
		b = ((b2_a2 + (b_a*b_a))/(2*b_a));
		result[0] = a.intValue();
		result[1] = b.intValue();
		printArr(result);
		return result;
	}
	
	private long factorial(int len) {
		if (len == 1) {
			return 1;
		}
		return len*factorial(len-1);
	}

	/**
	 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
	 * 
	 * DP Solution : {@link IBitArray#maxContiguousSumDP}
	 */
	int subArrayWithMaxSum(int[] arr) {
		int len = arr.length;
		int i = 0;
		int sum = 0;
		//find first +ve num.
		while(i < len && arr[i] < 0) {
			i++;
		}
		//if all numbers are -ve.
		if (i == len) {
			int max = Integer.MIN_VALUE;
			for (int k=0; k<len; k++) {
				max = max > arr[k] ? max : arr[k];
			}
			return max;
		}
		int localSum = 0;
		while (i<len) {
			if (arr[i] < 0) {
				sum = sum > localSum ? sum : localSum;
			}
			localSum += arr[i];
			if (localSum < 0) {
				sum = sum > (localSum - arr[i]) ? sum : (localSum - arr[i]);
				localSum = 0;
				i= i + 1;
			} else {
				i++;
			}
		}
		sum = sum > localSum ? sum : localSum;
		return sum;
	}
	
	public int maxContiguousSumDP(int[] arr) {
		int maxSum = arr[0], sum = 0;
		int len = arr.length;
		for (int i=1; i<len; i++) {
			sum = Math.max(sum+arr[i], arr[i]);
			maxSum = maxSum < sum ? sum : maxSum;
		}
		return maxSum;
	}
	
	/**
	 * You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N. 
	 * f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
	 * 
	 * 1) Find maximum value of arr[i] – i in whole array.
	 * 2) Find minimum value of arr[i] – i in whole array.
	 * 3) Return difference of above two values.
	 * 
	 * @param A
	 * @return
	 */
	public int maxArr(int[] A) {
        int len = A.length;
        int max = Integer.MIN_VALUE;
        /*for(int i=0;i<len;i++) {
            for(int j=i+1;j<len;j++){
                int sum = (A[i]>A[j]?A[i]-A[j]:A[j]-A[i]) + (j-i);
                max = max > sum ? max : sum;
            }
        }*/
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
 
        for (int i = 0; i < A.length; i++)
        {
 
            // Updating max and min variables
            // as described in algorithm.
            max1 = Math.max(max1, A[i] + i);
            min1 = Math.min(min1, A[i] + i);
            max2 = Math.max(max2, A[i] - i);
            min2 = Math.min(min2, A[i] - i);
        }
 
        // Calculating maximum absolute difference.
        return Math.max(max1 - min1, max2 - min2);
    }
	
	/**
	 * Given a non-negative number represented as an array of digits,
	 * add 1 to the number ( increment the number represented by the digits ).
	 * The digits are stored such that the most significant digit is at the head of the list
	 * 
	 * @param A
	 * @return
	 */
	public int[] plusOne(int[] A) {
        int len = A.length;
        int lastdigit = A[len-1] + 1;
        if (lastdigit >= 10) {
        	A[len-1] = 0;
        	int carry = lastdigit - 9; // will always be 1 in this case.
            for (int i=len-2; i > -1; i--) {
                int sum = A[i] + carry;
                if(sum < 10) {
                	A[i] = sum;
                	carry = 0;
                	break;
                }
                A[i] = 0;
            }
            if (carry == 1) {
            	int[] arr = new int[len+1];
            	arr[0] = 1;
            	Arrays.copyOfRange(A, 1, len-1);
            	return arr;
            }
        } else {
        	A[len-1] = lastdigit;
        }
        if (A[0] == 0) {
            int k = 0;
            while (k<len && A[k] == 0) {
                k++;
            }
            int[] arr = new int[len-k];
            arr = Arrays.copyOfRange(A, k, len);
            return arr;
        }
        return A;
    }
	
	/**
	 * Rearrange positive and negative numbers with constant extra space
	 * The order of appearance should be maintained.
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	int[] rearrangePosiiveNegative(int[] arr) {
		printArr(arr);
		int len = arr.length;
		int posL = -1;
		int posR = -1;
		while (posL < len && arr[++posL] < 0);
		posR = posL;
		for(int i=posL+1; i<len; i++) {
			if (arr[i]<0) {
				int temp = arr[i];
				shiftRight(arr, posL, posR);
				arr[posL] = temp;
				posL++;
			}			
			posR++;
		}
		printArr(arr);
		return arr;
	}
	
	/**
	 * Given an integer array, find if an integer p exists in the array 
	 * such that the number of integers greater than p in the array equals to p
	 * 
	 * @param A
	 * @return
	 */
	public int nobleInteger(int[] A) {
        Arrays.sort(A);
        int len = A.length;
        for (int i=0; i<len; i++) {
            int greaterNums = len -1 -i;
            if (A[i] == greaterNums) {
            	if (i+1<len && A[i+1] == A[i]) {
            		//checking duplicate
            		continue;
            	}
                return 1;
            }
        }
        return -1;
    }
	
	/**
	 * Rearrange positive and negative numbers in O(n) time and O(1) extra space
	 * 
	 * @param arr
	 * @return
	 */
	int[] alternatePositiveNegative(int[] arr) {
		int len = arr.length;
		int i = 0, j = len -1;
		while(i < len && arr[i] > 0) {
			i++;
		}
		i = i!=0 ? i-- : i;
		while(j > 0 && arr[j]<0) {
			j--;
		}
		j = j!=len-1 ? j++ : j;
		while (i < j) {
			if (arr[i] < 0) {
				if (arr[j] > 0) {
					swap(arr, i, j);
				}
				j--;
			}
			i++;
		}
		printArr(arr);
		if(arr[0]<0 || arr[1]<0)
			return arr;
		i = 1;
		j = 0;
		while (j<len && arr[j] > 0) {
			j++;
		}
		while (j<len && i<len) {
			if (arr[j] < 0) {
				swap(arr,i,j);
				j++;
			}
			i += 2;
		}
		printArr(arr);
		return arr;
	}
	
	/**
	 * Find maximum value of Sum( i*arr[i]) with only rotations on given array allowed,
	 * S0 = 0*arr[0] + 1*arr[1] + 2*arr[2] + ....... + (n-1)*arr[n-1]
	 * S1 = 0*arr[n-1] + 1*arr[0] + 2*arr[1] + ........ + (n-1)*arr[n-2]
	 * 
	 * S1 - S0 = SumOfArr - n*arr[n-1]
	 * S(k) = S(k-1) + SumOfArr - n*arr[n-k];
	 * 
	 * use this.
	 * 
	 * @return
	 */
	public int maxSum_i_arr_i(int[] arr) {
		int len = arr.length;
		int sumOffArr = 0;
		int maxSum = 0;
		int S_0_ = 0;
		for (int i=0; i<len; i++) {
			sumOffArr += arr[i];
			S_0_ += i*arr[i];
		}
		maxSum = maxSum < S_0_ ? S_0_ : maxSum;
		int S_k_ = 0;
		int S_k_1_ = S_0_;
		for (int k=1; k<len; k++) {
			S_k_ = S_k_1_ + sumOffArr - len*arr[len-k];
			maxSum = maxSum < S_k_ ? S_k_ : maxSum;
			S_k_1_ = S_k_;
		}
		return maxSum;
	}
	
	/**
	 * Allowed complexity is o(log n)
	 * ==::==> find pivot first
	 * @param arr
	 * @param searchNum
	 * @return
	 */
	boolean searchInRotatedArray(int[] arr, int len, int searchNum) {
		int pivotIndex = findRotatingPivot(arr,0,len-1);
		if (pivotIndex == -1) {
			int searchedIndex = binarySearch(arr, searchNum);
			System.out.println(searchedIndex);
			return searchedIndex != -1;
		}
		if (searchNum < arr[pivotIndex] || searchNum > arr[pivotIndex -1]) {
			return false;
		}
		if (searchNum < arr[0]) {
			int searchedIndex = binarySearchUtil(arr, searchNum, pivotIndex, len-1);
			System.out.println(searchedIndex);
			return searchedIndex != -1;
		} else {
			int searchedIndex = binarySearchUtil(arr, searchNum, 0, pivotIndex -1);
			System.out.println(searchedIndex);
			return searchedIndex != -1;
		}
	}
	
	private int findRotatingPivot(int[] arr, int i, int j) {
		if (j == i+1) {
			if (arr[i] > arr[j]) {
				return j;
			}
			return -1;
		}
		int mid =i + (j - i)/2;
		if (arr[i] > arr[mid]) {
			return findRotatingPivot(arr, i, mid);
		} else {
			return findRotatingPivot(arr, mid, j);
		}
	}
	
	/**
	 * Search num in sorted array in o(log n);
	 * Try binary search.
	 * 
	 * @param arr
	 * @param num
	 * @return index of found num or -1
	 */
	int binarySearch(int[] arr, int num) {		
		return binarySearchUtil(arr,num,0,arr.length-1);
	}

	private int binarySearchUtil(int[] arr, int num, int i, int j) {
		if (num > arr[j] || num < arr[i])
			return -1;
		int midIndex = i + (j-i)/2;
		if (num == arr[midIndex])
			return midIndex;
		if (num == arr[midIndex+1])
			return midIndex+1;
		if (num <= arr[midIndex]) {
			return binarySearchUtil(arr, num, i, midIndex);
		} else {
			return binarySearchUtil(arr, num, midIndex, j);
		}
	}

	/**
	 * arr = [3,5,30,9,34]
	 * max = 9534330
	 * 
	 * @param arr
	 * @return
	 */
	public String createMaxPossibleNo(final int[] arr) {
		String[] str = new String[arr.length];
		int j=0;
		for (int a : arr) {
			str[j] = a + "";
			j++;
		}
		Arrays.sort(str,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String o1o2 = o1 + o2;
				String o2o1 = o2 + o1;
				if (Integer.parseInt(o1o2) > Integer.parseInt(o2o1)) {
					return 1;
				} else if (Integer.parseInt(o2o1) > Integer.parseInt(o1o2)) {
					return -1;
				}
				return 0;
			}
		});
		int i = 0;
		while (i < (str.length - 1) && Integer.parseInt(str[i]) == 0) {
		    i++;		    
		}
		StringBuilder result = new StringBuilder();
		for (int k = str.length -1; k >= i; k--)
			result.append(str[k]);
		return result.toString();
	}
	
	/**
	 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
	 * If there is no solution possible, return -1.
	 * 
	 * A : [3 5 4 2]
	 * Output : 2
	 * for the pair (3, 4)
	 * 
	 * @param arr
	 * @return
	 */
	public static int maxGap(int[] arr) {
		int len = arr.length;
		int max = -1;
		int[] leftMax = new int[len];
		int[] rightMax = new int[len];
		
		leftMax[0] = arr[0];
		for(int i=1; i<len; i++)
			leftMax[i] = leftMax[i-1] < arr[i] ? leftMax[i-1] : arr[i];
		
		rightMax[len-1] = arr[len-1];
		for(int i=len-2; i>-1; i--)
			rightMax[i] = rightMax[i+1] > arr[i] ? rightMax[i+1] : arr[i];
		
		int i=0, j=0;
		while (i < len && j < len) {
			if (leftMax[i] < rightMax[j]) {
				max = max > j-i ? max : j-i;
				j++;
			} else {
				i++;
			}
		}
		return max;
	}
	
	/**
	 * 
	 * 
	 * @param arr
	 * @return
	 */
	public int[] rotateArrByD(int[] arr, int d) {
		int len = arr.length;
		for (int i=0; i<d; i++) {
			int j = i;
			int k = i + d;
			while (k < len) {
				swap(arr,j,k);
				j = k;
				k += d;
			}
		}
		return arr;
	}
	
	/**
	 * Reverse the array.
	 * 
	 * @param arr
	 * @return
	 */
	public int[] reverseArray(int[] arr) {
		int i = 0;
		int j = arr.length -1;
		while (i < j) {
			swap(arr,i,j);
			i++;
			j--;
		}
		return arr;
	}

	private void swap(int[] arr, int i, int k) {
		int temp = arr[i];
		arr[i] = arr[k];
		arr[k] = temp;
	}
	
	private void shiftRight(int[] arr, int i, int j) {
		if (i<0 || j>=arr.length-1) {
			throw new IllegalArgumentException("Operation can't be performed");
		}
		int temp = arr[i];
		while (i<=j) {
			int t = arr[i+1];
			arr[i+1] = temp;
			temp = t;
			i++;
		}
	}
	
	int[] createArray(int size) {
		int[] arr = new int[size];
		int i = 0;
		while (i < size) {
			arr[i] = ++i;
		}
		return arr;
	}
	
	void printArr(int[] arr) {
		for (int a : arr)
			System.out.print(a+" ");
		System.out.println();
	}
}
