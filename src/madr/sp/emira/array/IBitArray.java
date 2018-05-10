package madr.sp.emira.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class IBitArray {
	
	static int stackCount = 0;

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
		
		/*int[] arr = {417, 929, 845, 462, 675, 175, 73, 867, 14, 201, 777, 407, 80, 882, 785, 563, 209, 261, 776, 362, 730, 74, 649, 465, 353, 801, 503, 154, 998, 286, 520, 692, 68, 805, 835, 210, 819, 341, 564, 215, 984, 643, 381, 793, 726, 213, 866, 706, 97, 538, 308, 797, 883, 59, 328, 743, 694, 607, 729, 821, 32, 672, 130, 13, 76, 724, 384, 444, 884, 192, 917, 75, 551, 96, 418, 840, 235, 433, 290, 954, 549, 950, 21, 711, 781, 132, 296, 44, 439, 164, 401, 505, 923, 136, 317, 548, 787, 224, 23, 185, 6, 350, 822, 457, 489, 133, 31, 830, 386, 671, 999, 255, 222, 944, 952, 637, 523, 494, 916, 95, 734, 908, 90, 541, 470, 941, 876, 264, 880, 761, 535, 738, 128, 772, 39, 553, 656, 603, 868, 292, 117, 966, 259, 619, 836, 818, 493, 592, 380, 500, 599, 839, 268, 67, 591, 126, 773, 635, 800, 842, 536, 668, 896, 260, 664, 506, 280, 435, 618, 398, 533, 647, 373, 713, 745, 478, 129, 844, 640, 886, 972, 62, 636, 79, 600, 263, 52, 719, 665, 376, 351, 623, 276, 66, 316, 813, 663, 831, 160, 237, 567, 928, 543, 508, 638, 487, 234, 997, 307, 480, 620, 890, 216, 147, 271, 989, 872, 994, 488, 291, 331, 8, 769, 481, 924, 166, 89, 824, -4, 590, 416, 17, 814, 728, 18, 673, 662, 410, 727, 667, 631, 660, 625, 683, 33, 436, 930, 91, 141, 948, 138, 113, 253, 56, 432, 744, 302, 211, 262, 968, 945, 396, 240, 594, 684, 958, 343, 879, 155, 395, 288, 550, 482, 557, 826, 598, 795, 914, 892, 690, 964, 981, 150, 179, 515, 205, 265, 823, 799, 190, 236, 24, 498, 229, 420, 753, 936, 191, 366, 935, 434, 311, 920, 167, 817, 220, 219, 741, -2, 674, 330, 909, 162, 443, 412, 974, 294, 864, 971, 760, 225, 681, 689, 608, 931, 427, 687, 466, 894, 303, 390, 242, 339, 252, 20, 218, 499, 232, 184, 490, 4, 957, 597, 477, 354, 677, 691, 25, 580, 897, 542, 186, 359, 346, 409, 655, 979, 853, 411, 344, 358, 559, 765, 383, 484, 181, 82, 514, 582, 593, 77, 228, 921, 348, 453, 274, 449, 106, 657, 783, 782, 811, 333, 305, 784, 581, 746, 858, 249, 479, 652, 270, 429, 614, 903, 102, 378, 575, 119, 196, 12, 990, 356, 277, 169, 70, 518, 282, 676, 137, 622, 616, 357, 913, 161, 3, 589, 327};
		int[] arr1 = {1, 1, 1};
		System.out.println(cl.firstMissingPositive(arr1));*/
		
		/*int num = 10; {1, 1, 2, 3, 3, 4, 8, 9, 11, 9, 11, 12, 12, 11, 9, 14, 19, 20, 20}
		cl.generatePascalTriangle(num);*/
		
		/*int[] arr = {1, 1, 2, 3, 3, 4, 8, 9, 11, 9, 11, 12, 12, 11, 9, 14, 19, 20, 20};
		cl.printArr(cl.subUnsort(arr));*/
		
		/*int[] arr = {1,10,5};//{83564666, 2976674, 46591497, 24720696, 16376995, 63209921, 25486800, 49369261, 20465079, 64068560, 7453256, 14180682, 65396173, 45808477, 10172062, 28790225, 82942061, 88180229, 62446590, 77573854, 79342753, 2472968, 74250054, 17223599, 47790265, 24757250, 40512339, 24505824, 30067250, 82972321, 32482714, 76111054, 74399050, 65518880, 94248755, 76948016, 76621901, 46454881, 40376566, 13867770, 76060951, 71404732, 21608002, 26893621, 27370182, 35088766, 64827587, 67610608, 90182899, 66469061, 67277958, 92926221, 58156218, 44648845, 37817595, 46518269, 44972058, 27607545, 99404748, 39262620, 98825772, 89950732, 69937719, 78068362, 78924300, 91679939, 52530444, 71773429, 57678430, 75699274, 5835797, 74160501, 51193131, 47950620, 4572042, 85251576, 49493188, 77502342, 3244395, 51211050, 44229120, 2135351, 47258209, 77312779, 37416880, 59038338, 96069936, 20766025, 35497532, 67316276, 38312269, 38357645, 41600875, 58590177, 99257528, 99136750, 4796996, 84369137, 54237155, 64368327, 94789440, 40718847, 12226041, 80504660, 8177227, 85151842, 36165763, 72764013, 36326808, 80969323, 22947547, 76322099, 7536094, 18346503, 65759149, 45879388, 53114170, 92521723, 15492250, 42479923, 20668783, 64053151, 68778592, 3669297, 73903133, 28973293, 73195487, 64588362, 62227726, 17909010, 70683505, 86982984, 64191987, 71505285, 45949516, 28244755, 33863602, 18256044, 25110337, 23997763, 81020611, 10135495, 925679, 98158797, 73400633, 27282156, 45863518, 49288993, 52471826, 30553639, 76174500, 28828417, 41628693, 80019078, 64260962, 5577578, 50920883, 16864714, 54950300, 9267396, 56454292, 40872286, 33819401, 75369837, 6552946, 26963596, 22368984, 43723768, 39227673, 98188566, 1054037, 28292455, 18763814, 72776850, 47192134, 58393410, 14487674, 4852891, 44100801, 9755253, 37231060, 42836447, 38104756, 77865902, 67635663, 43494238, 76484257, 80555820, 8632145, 3925993, 81317956, 12645616, 23438120, 48241610, 20578077, 75133501, 46214776, 35621790, 15258257, 20145132, 32680983, 94521866, 43456056, 19341117, 29693292, 38935734, 62721977, 31340268, 91841822, 22303667, 96935307, 29160182, 61869130, 33436979, 32438444, 87945655, 43629909, 88918708, 85650550, 4201421, 11958347, 74203607, 37964292, 56174257, 20894491, 33858970, 45292153, 22249182, 77695201, 34240048, 36320401, 64890030, 81514017, 58983774, 88785054, 93832841, 12338671, 46297822, 26489779, 85959340};
		System.out.println(cl.getMaximumSuccesiveGap2(arr));*/
		
		/*int[] x = {-4, 1, -4, 8, -11, -12, -13, -3, -4, -4, -14, 7, -2, -2, -5, 5, -1, 0};
		int[] y = {-8, -15, -4, 3, 11, 8, -15, 4, 1, 7, 3, 9, -9, -9, -13, 10, -14, -8};
		System.out.println(cl.coverPoints(x, y));*/
		
		//int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		//cl.diagonal(arr);
		/*ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		row.add(0,1); row.add(1,0); //row.add(2,3);
		list.add(0,row);
		ArrayList<Integer> row1 = new ArrayList<Integer>();
		row1.add(0,1); row1.add(1,0); //row1.add(2,6);
		list.add(1,row1);
		//ArrayList<Integer> row2 = new ArrayList<Integer>();
		//row2.add(0,7); row2.add(1,8); row2.add(2,9);
		//list.add(2,row2);
		//cl.rotate2DArrayBy90Degree(list);
		cl.setZeroes(list);
		System.out.println(list);*/
		
		/*ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(3);arr.add(0);arr.add(1);arr.add(4);arr.add(2); //4,3,0,2,1
		cl.arrange_arr_i_At_arr_arr_i(arr);
		System.out.println(arr);*/
		
		/*int[] arr = {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
		System.out.println(cl.kthsmallestWithHeap(arr, 9));*/
		
		/*int[] a = {4, 7, 7, 7, 8, 10, 10};
		System.out.println(cl.findCount(a, 7));*/
		
		
		
		/*List<Integer> l1 = new ArrayList<Integer>();
		l1.add(10000000);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(10000000);
		System.out.println(cl.intersect(l1, l2));*/
		/*stackCount = 0;
		int n = 7;
		System.out.println(cl.stepsRequired(n));
		System.out.println(cl.stepsRequiredNoRecurr(n));
		System.out.println(stackCount);*/
		
		
		//Permutation of a string with and without duplicates.
		/*ArrayList<Character> arr = new ArrayList<Character>();
		arr.add('A');arr.add('A');arr.add('B');arr.add('B');
		cl.allPermutation(arr,true);*/
		
		/*int[] a = {1,2,4,1,7,8,9,11,6,2};
		System.out.println(cl.contiguousSubArrSum_equals_k(a, 8));*/
		
		/*int[] A = {13, 14, 36, 19, 44, 1, 45, 4, 48, 23, 32, 16, 37, 44, 47, 28, 8, 47, 4, 31, 25, 48, 49, 12, 7, 8};
		int[] B = {28, 27, 61, 34, 73, 18, 50, 5, 86, 28, 34, 32, 75, 45, 68, 65, 35, 91, 13, 76, 60, 90, 67, 22, 51, 53};
		int C = 23;*/
		//System.out.println(cl.hotel(A, B, C));
		
		//int[] arr = {80, 97, 78, 45, 23, 38, 38, 93, 83, 16, 91, 69, 18, 82, 60, 50, 61, 70, 15, 6, 52, 90};//{10, 5, 1, 0, 2};
		//System.out.println(cl.sumInRange(arr, 99, 269));
		
		/*int[] a = {-3,1,2,-4,-1,7,8,-9,11,-6,3};
		System.out.println(cl.contiguousSubArrSum_equals_k_includesNegative(a, 5));
		System.out.println(cl.recursive_777LineUtil(a, 5));*/
		
		int[] a = {1,2,2,3,4,1};//{-3,1,2,-4,-1,7,8,-9,11,-6,3};
		System.out.println(cl.numOfEvenSubArray(a));
	}
	
	/**
	 * Find subarrays whose sum is even.
	 *
	 * @param arr
	 * @return
	 */
	public int numOfEvenSubArray(int[] arr) {
		int evenSumCount = 1; //because even a single even item will generate one array
		int oddSumCount = 0;
		int sum = 0;
		for (int i : arr) {
			sum = ((sum+i)%2 + 2)%2; //handle negative cases;
			evenSumCount = (sum == 0) ? evenSumCount+1 : evenSumCount+(oddSumCount++)*0;
		}
		return (evenSumCount*(evenSumCount-1)/2) + (oddSumCount*(oddSumCount-1)/2);
	}
	
	/**
	 * MUST SEE	
	 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
	 * All elements in the array are in the range [0, N-1]
	 * 
	 * Input : [1, 0]
	 * Return : [0, 1]
	 * 
	 * @param a
	 */
	public void rearrangeArray(ArrayList<Integer> a) {
	    int n = a.size();
	    for (int i=0; i<n; i++) {
	        int num = a.get(i) + (a.get(a.get(i))%n)*n;
	        a.set(i,num);
	    }
	    for (int i=0; i<n; i++) {
	        a.set(i,a.get(i)/n);
	    }
	}
	
	/**
	 * A hotel manager has to process N advance bookings of rooms for the next season. 
	 * His hotel has K rooms. Bookings contain an arrival date and a departure date. 
	 * He wants to find out whether there are enough rooms in the hotel to satisfy the demand. 
	 * Write a program that solves this problem in time O(N log N).
	 * 
	 * couldn't Solve
	 * 
	 * @param arrive
	 * @param depart
	 * @param K
	 * @return
	 */
	/*public boolean hotel(int[] arrive, int[] depart, int K) {
        int len = depart.length;
        List<Pair> list = new ArrayList<Pair>();
        for (int i=0; i<len; i++) {
            list.add(new Pair(arrive[i],depart[i]));
        }
        Collections.sort(list);
        int count = 1;
        Stack<Pair> stack = new Stack<Pair>();
		stack.push(list.get(0));
		for (int i=1; i<list.size(); i++) {
		    Pair in = list.get(i);
			Pair stIn = stack.peek();
			if (in.arrive < stIn.depart) {
			    count++;
				if (in.depart > stIn.depart) stIn.depart = in.depart;
			} else {
				stack.push(in);
			}
		}
		if (count>K) return false;
		else return true;
    }    
    public class Pair implements Comparable<Pair> {
        Integer arrive;
        Integer depart;
        
        public Pair(Integer a, Integer d) {
            arrive = a;
            depart = d;
        }
        
        @Override
    	public String toString() {
    		return "{ " + arrive.toString() + " : " + depart.toString() + " }"; 
    	}
        
        @Override
    	public int compareTo(Pair o) {
    		return this.arrive.compareTo(o.arrive);
    	}
    }*/
	
	
	/**
	 * Given a collection of intervals, merge all overlapping intervals.
	 * Might not be sorted
	 * @param intervals
	 * @return
	 */
	public ArrayList<Interval> mergeOverlappingIntervals(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		Stack<Interval> stack = new Stack<Interval>();
		stack.push(intervals.get(0));
		for (int i=1; i<intervals.size(); i++) {
			Interval in = intervals.get(i);
			Interval stIn = stack.peek();
			if (in.start <= stIn.end) {
				if (in.end > stIn.end) stIn.end = in.end;
			} else {
				stack.push(in);
			}
		}
		intervals.clear();
		for (int i=0; i<stack.size(); i++) {
			intervals.add(stack.get(i));
		}
		return intervals;
    }
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	/**
	 * There are 3 approaches to this solution:
	 * 
	 * Let the sum be T and n be the size of array
	 * 
	 * Approach 1: The naive way to do this would be to check all combinations (n choose 2). This exhaustive search is O(n2).
	 * Approach 2: A better way would be to sort the array. This takes O(n log n), 
	 * 			   Then for each x in array A, use binary search to look for T-x. This will take O(nlogn).
	 * 			   (or keep two pointer and converge to middle)
	 * 			   So, overall search is  O(n log n)
	 * Approach 3 : The best way would be to insert every element into a hash table (without sorting).
	 * 				This takes O(n) as constant time insertion.
	 * 				Then for every x, we can just look up its complement, T-x, which is O(1).
	 * 				Overall the run time of this approach is O(n).
	 * {@link https://stackoverflow.com/questions/2070359/finding-three-elements-in-an-array-whose-sum-is-closest-to-a-given-number}
	 * 
	 * @param arr
	 * @return
	 */
	public int[][] pairsWithSum_k(int[] arr) {
		return null;
	}
	/**
	 * sort the array O(n^2)
	 * for each arr[i] iterate using two pointers in between i+1 & n-1;
	 * 
	 * 
	 * 
	 * {@link https://stackoverflow.com/a/34382390/6517886 
	 * 		  https://stackoverflow.com/questions/2070359/finding-three-elements-in-an-array-whose-sum-is-closest-to-a-given-number
	 * 		  https://stackoverflow.com/a/8926458/6517886
	 * 		  https://stackoverflow.com/questions/8916539/sum-subset-with-a-fixed-subset-size
	 * 		  https://en.wikipedia.org/wiki/Subset_sum_problem}
	 * 
	 * 
	 * @param arr
	 * @return
	 * 
	 * O(nlogn) as claimed by this ans, is not possible. It's a known problem which takes O(n^2) minimum. https://en.wikipedia.org/wiki/3SUM
	 */
	public boolean tripletSum(int[] arr) {
		/*
		 * def triplet_sum(alist, total):
		    alist.sort() #modifies the list in place - more efficient than sorted() but not great if we need the list unmodified
		    left, right = 0, len(alist) - 1
		    while right > left:
		        elem = total - alist[left] - alist[right]
		        mid = binary_search(alist, elem, left, right)
		        if mid >= 0: #found
		            return (alist[left], alist[mid], alist[right])
		        elif mid == -10: #terminated left 
		            right -= 1
		        elif mid == -20: #terminated right
		            left += 1
		    return None
		 */
		return false;
	}

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
	 * Given a target position on infinite number line, i.e -infinity to +infinity. 
	 * Starting form 0 you have to reach the target by moving as described : 
	 * 			In ith move you can take i steps forward or backward. 
	 * 
	 * Find the minimum number of moves require to reach the target
	 * 
	 * @param n
	 * @return
	 */
	public int stepsRequiredOnInfiniteLine(int n) {
		return stepsRequiredUtil(0,0,Math.abs(n));
	}
	
	/**
	 * after x steps if sumX == n, return x;
	 * if sumX > n :
	 * 		reverse any i-th move then sumX-2i = n;
	 * 		sumX - n = 2i;
	 * 		1) if (sumX - n) is even, return x; that will be answer, and i-th move we need to reverse;
	 * 		2) if (sumX - n) is odd, add x+1, check again, add x+2, this will do. (break it more).
	 * 				think again //a) if x is odd, meaning x is even, then adding n+2 only will help, so that is the answer.
	 * 				think again //b) if x is even, meaning x is odd, then adding n+1 is sufficient, so n+1 is answer.
	 * 				
	 * @param n
	 * @return
	 */
	public int stepsRequiredNoRecurr(int dest_n) {
		int steps_x = 0, reach_sumX = 0;
		while (reach_sumX < dest_n || (reach_sumX - dest_n)%2 !=0 ) {
			steps_x++;
			reach_sumX += steps_x;
		}
		return steps_x;
	}
	
	private int stepsRequiredUtil(int start, int steps, int n) {
		if (start == n) return steps;
		if (Math.abs(start) > n) return Integer.MAX_VALUE;
		stackCount++;
		int pos = stepsRequiredUtil(start + steps + 1, steps + 1, n);
		int neg = stepsRequiredUtil(start - steps - 1, steps + 1, n);
		return pos < neg ? pos : neg;
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
	 * Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation
	 *  of first n positive integer that satisfy the given input string.
	 *  D means the next number is smaller, while I means the next number is greater.
	 *  
	 *  Notes:
	 *  	Length of given string s will always equal to n - 1
	 *  	Your solution should run in linear time and space.
	 *  
	 * @param A
	 * @param B
	 * @return
	 */
	public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        int max = B;
        int min = 1;
        for (int i=0; i<B-1; i++) {
            if (A.charAt(i) == 'D') {
                l.add(max);
                max--;
            } else {
                l.add(min);
                min++;
            }
        }
        if (min == 0) {
            l.add(max);
        } else {
            l.add(min);
        }
        return l;
    }
	
	/**
	 * Kth Row of pascal triangle;
	 * 
	 * @param A
	 * @return
	 */
	public ArrayList<Integer> getRow(int A) {
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.add(1);
        int x = 1; 
        for (int a = A, b = 1; b <= A; --a, ++b) {
            x = (x * a) / b;
            l.add(x);
        }
        return l;
    }
	
	/**
	 * Intersection of two sets;
	 * 
	 * 1) This approach optimizes when one array is much bigger than the other
	 * otherwise -
	 * 2) Simple solution is iterate over both together O(m+n);

		  while (i < m && j < n) {
	       	if(arr1[i] < arr2[j]) i++;          		
	        else if(arr1[i] > arr2[j]) j++;          
	        else {
	          list.add(arr1[i]);
	          i++;j++;
	        }
	      }
	      
	 * 3) use Hashing for unsorted array, use HashSet - Iterate through the first array and put every element of the first array in the set S.
	 * 													For every element x of the second array, do the following :
	 * 														Search x in the set hs. If x is present, then print it.
	 * @param A
	 * @param B
	 * @return
	 */
	public ArrayList<Integer> intersection(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int lenA = A.size();
        int lenB = B.size();
        Integer minA = A.get(0);
        Integer maxA = A.get(lenA-1);
        Integer minB = B.get(0);
        Integer maxB = B.get(lenB-1);
        if (minA > maxB || minB > maxA || lenA == 0 || lenB == 0) return list;
        if (lenB <= lenA) {
            int index = -1;
            for (int i=0; i<lenB && B.get(i)<=maxA; i++) {
                Integer temp = B.get(i);
                int in = binarySearch(A,index+1,lenA-1,temp);
                if (in != -1) {
                    list.add(temp);
                    index = in;
                }
                if (index == lenA-1) break;
            }
        } else {
            int index = -1;
            for (int i=0; i<lenA && A.get(i)<=maxB; i++) {
                Integer temp = A.get(i);
                int in = binarySearch(B,index+1,lenB-1,temp);
                if (in != -1) {
                    list.add(temp);
                    index = in;
                }
                if (index == lenB-1) break;
            }
        }
        return list;
    }
    
    int binarySearch(List<Integer> list, int start, int end, Integer num) {
        while (start<=end) {
            int mid = start + (end-start)/2;
            if (list.get(mid).intValue() == num.intValue()) return mid;
            else if (num<list.get(mid)) end = mid -1;
            else start = mid+1;
        }
        return -1;
    }
	
    /**
     * Given a read only array of n + 1 integers between 1 and n, 
     * find one number that repeats in linear time using 
     * less than O(n) space and traversing the stream sequentially O(1) times
     * 
     * {@link https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/}
     * 
     * 1) XOR
     * 2) While traversing, use absolute value of every element as index and make the value at this index as negative to mark it visited. 
     * 	  If something is already marked negative then this is the repeating element. 
     * 	  To find missing, traverse the array again and look for a positive value. CANT BE USED IF MODIFYING ARRAY IS NOT PERMITTED.
     * 3) Make two equations {@link IBitArray#repeatedAndMissingNumber}
     * 4) Use O(n) space. temp Array. or count array
     * 
     * 
     * 
     * @param a
     * @return
     */
    public int reapeatedNum(List<Integer> a) {
    	final int n = a.size() - 1;
	    int x = 0;
	    for (int i = 1; i <= n; i++) {
	        x = x ^ i; // take xor of numbers from 1 to n;
	    }
	    for (int e : a) {
	        x = x ^ e;
	    }
	    if (x == 0) return -1;
	    else return x;
	    
	    // -or- not working
	    /*for (int e : a) {
	        x = x ^ e;
	        if (x == 0) {
	        	return e;
	        }
	    }
	    return -1;*/
    }
    
	/**
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int findCount(final int[] A, int B) {
        int len = A.length;
        int index = binarySearch(A,B,0,len-1);
        if (index == -1) return 0;
        int neg = index;
        int count = 1;
        neg--;
        index++;
        while (neg>=0 || index<len) {
            if (neg != -1 && A[neg] == B) {
                count++;
                neg--;
            } else {
                neg = -1;
            }
            if (index < len && A[index] == B) {
                count++;
                index++;
            } else {
                index = len;
            }
        }
        return count;
    }
    
    private int binarySearch(int[] A, int num, int indexI, int indexJ) {
        if (A[indexI] == num) {
            return indexI;
        } else if (A[indexJ] == num) {
            return indexJ;
        } else if (indexJ == indexI) {
            return A[indexI] == num ? indexI : -1;
        } else {
            int mid = (indexI + indexJ)/2;
            if (A[mid] >= num) {
                return binarySearch(A,num,indexI,mid);
            } else {
                return binarySearch(A,num,mid+1,indexJ);
            }
        }
        
        
    }
    
	/**
	 * 
	 * Given an array of non negative integers A, and a range (B, C),
	 * find the number of continuous subsequences in the array which have sum S in the range [B, C] or B <= S <= C
	 * Continuous subsequence is defined as all the numbers A[i], A[i + 1], .... A[j]
	 * where 0 <= i <= j < size(A)
	 * 
	 * https://www.quora.com/Given-an-array-having-positive-integers-how-do-I-find-a-continuous-subarray-which-sums-to-a-given-number
	 * http://www.zrzahid.com/contiguous-subarray-with-sum-in-a-range/
	 *  
	 *  
	 * A : [10, 5, 1, 0, 2]
	 * (B, C) : (6, 8)
	 * 
	 * 
	 * @param arr
	 * @param x
	 * @param y
	 * @return
	 */
	public int sumInRange(int[] arr, int x, int y) {
		int len = arr.length;
		int count = 0;
		int indexI = 0, indexJ = -1;
		long sum = arr[0];
		for (int i = 1; i<len; i++) {
			if (sum >= x && sum <=y) {
				indexJ = i-1;
				count++;
				break;
			} else if (sum > y) {
				indexI = i;
				indexJ = -1;
				sum = 0;
			}
			sum += arr[i];
		}
		if (indexJ == -1) return 0;
		indexJ++;
		while (indexJ < len-1 && indexI < len-1) {
			long s = sum+arr[indexJ];
			if (s >= x && s <= y) {
				count++;
				for (int i=indexI+1; i<indexJ; i++) {
					if (s-arr[i] >= x && s-arr[i] <= y) {
						count++;
					}
				}
				sum = s;
				indexJ++;
			} else if (s > y) {
				sum -= arr[indexI];
				indexI++;
				indexJ--;
			} else {
				sum = s;
				indexJ++;
			}
		}
		return count;
	}
	
	/**
	 * Given an array of integers eg [1, 2, -3, 1] find whether there is a continuous sub-sequence that sums to 0 
	 * and return it (eg [1, 2, -3] or [2, -3, 1]).
	 * 
	 * https://stackoverflow.com/questions/14865688/subsequence-sum
	 * 
	 * 1)
	 * Make a new array with each element equal to the sum of the previous elements plus that one.
	 * Then look for elements that match in the resulting array.
	 * Since these represent locations where the overall change in the function is zero, 
	 * 		you will find that if their position is i and k then the subsequence (i+1, k) 
	 * 		is a zero-sum subsequence. (In this case, [2:6]).
	 * Additionally, any zeros in the table indicate that the subsequence (0, k) is a zero-sum subsequence. For the lookup, 
	 * 		a hash table or other fast collision locator makes this O(N) to perform
	 * 
	 * 2)
	 * Do a running sum, storing sum values in a hash table along with array index
	 * 	If you ever get a sum value you’ve already seen, return 1+the index in the hash table, 
	 * 	and the current index. This solution is O(n) time complexity.
	 * 	No need for a new array. Space complexity is O(N) because of the hash.
	 * 
	 * @param arr
	 * @return
	 */
	public List<Integer> continuousSubSequenceSum_zero(List<Integer> A) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> dup = new ArrayList<Integer>(A);
        map.put(0,-1);
        int indexI = -1, indexJ = -1;
        int sum = 0;
        for (int i=0; i<A.size(); i++) {
        	sum += A.get(i);
            if (map.containsKey(sum)) {
                if (indexJ == -1) {
                    indexI = map.get(sum) + 1;
                    indexJ = i;
                } else if (indexJ - indexI < i - map.get(sum) -1) {
                    indexI = map.get(sum) + 1;
                    indexJ = i;
                }
            } else {
            	map.put(sum,i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (indexI == -1 || indexJ == -1) return ans;
        while (indexI<=indexJ) {
        	ans.add(dup.get(indexI++));
        }
        return ans;
	}
	
	/**
	 * Given an array having positive integers, how do I find a continuous subarray which sums to a given number?
	 * 
	 * https://www.quora.com/Given-an-array-having-positive-integers-how-do-I-find-a-continuous-subarray-which-sums-to-a-given-number
	 * http://www.zrzahid.com/contiguous-subarray-with-sum-in-a-range/
	 * http://blog.gainlo.co/index.php/2016/06/01/subarray-with-given-sum/?utm_campaign=quora&utm_medium=Given+an+array+having+positive+integers%2C+how+do+I+find+a+continuous+subarray+which+sums+to+a+given+number%3F&utm_source=quora
	 * 
	 * @param arr
	 * @return
	 */
	public List<madr.sp.emira.array.Pair<Integer>> contiguousSubArrSum_equals_k(int[] arr, int target) {
		int N = arr.length;
		List<madr.sp.emira.array.Pair<Integer>> ans = new ArrayList<madr.sp.emira.array.Pair<Integer>>();
		for(int i = 0, j = 0, sum = 0; i < N; i++) {
			  for(; j < N && sum < target; j++) sum += arr[j];
			  if(sum == target) ans.add(new madr.sp.emira.array.Pair<Integer>(i, j-1));
			  sum -= arr[i];
			}
		return ans;
	}
	
	/**
	 * Given an array having any kind of integers, how do I find a continuous subarray which sums to a given number?
	 * 
	 * https://www.quora.com/Given-an-array-having-positive-integers-how-do-I-find-a-continuous-subarray-which-sums-to-a-given-number
	 * http://www.zrzahid.com/contiguous-subarray-with-sum-in-a-range/
	 * http://blog.gainlo.co/index.php/2016/06/01/subarray-with-given-sum/?utm_campaign=quora&utm_medium=Given+an+array+having+positive+integers%2C+how+do+I+find+a+continuous+subarray+which+sums+to+a+given+number%3F&utm_source=quora
	 * 
	 * 
	 *  map<int, vector<int> > S_pos;
		S_pos[0].push_back(0);
		for(int i = 1, S = 0; i <= N; i++) {
		  S += A[i - 1];
		  const vector<int>& V = S_pos[S - target];
		  for(int j = 0; j < V.size(); j++) {
		    output(V[j], i);
		  }
		  S_pos[S].push_back(i);
		}
	 * 
	 * @param arr
	 * @return
	 */
	public List<Pair<Integer>> contiguousSubArrSum_equals_k_includesNegative(int[] arr, int target) {
		int N = arr.length;
		List<Pair<Integer>> ans = new ArrayList<Pair<Integer>>();
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		map.put(0, list);
		int sum = 0;
		for (int i=1; i< N; i++) {
			sum += arr[i-1];
			List<Integer> l = map.get(sum-target);
			if (l != null) {
				for (int j=0; j<l.size(); j++) {
					ans.add(new Pair<Integer>(l.get(j), i-1));
				}
			}
			if (map.get(sum) == null) {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				map.put(sum, temp);
			} else {
				map.get(sum).add(i);
			}
		}
		return ans;
	}
	
	public List<Pair<Integer>> recursive_777LineUtil(int[] arr, int target){
		List<Pair<Integer>> ans = new ArrayList<Pair<Integer>>();
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		map.put(0, list);
		int sum = 0;
		recursive_777Line(ans, target, sum, 1, arr, map);
		return ans;
	}
	
	public void recursive_777Line(List<Pair<Integer>> ans, int target, int sum_j, int j, int[] arr, Map<Integer,List<Integer>> hash) {
		if (j >= arr.length) return;
		sum_j += arr[j-1];
		if (hash.containsKey(sum_j - target)) {
			List<Integer> l = hash.get(sum_j-target);
			for (Integer in : l) {
				ans.add(new Pair<Integer>(in, j-1));
			}
		}
		if (hash.get(sum_j) == null) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(j);
			hash.put(sum_j, temp);
		} else {
			hash.get(sum_j).add(j);
		}
		recursive_777Line(ans, target, sum_j, j+1, arr, hash);
	}
	
	/**
	 * O(k*n)
	 * O(k+(n-k)logk) -- > {@link IBitArray#kthsmallestWithHeap}
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int kthsmallest(final int[] A, int B) {
        int len = A.length;
        int[] small = new int[B];
        int pointer = 0;
        int smallest = Integer.MAX_VALUE;
        int count = 0;
        int n =0;
        while (n<B) {
            for(int i=0; i<len; i++) {
                int m = A[i];
                if (m<smallest && m > pointer){
                    smallest = m;
                    count = 1;
                } else if (m == smallest) {
                    count++;
                }
            }
            while (count != 0 && n<B) {
                small[n] = smallest;
                n++;
                count--;
            }
            pointer = smallest;
            smallest = Integer.MAX_VALUE;
        }
        return small[B-1];
    }
	
	/**
	 * MUST READ
	 * 
	 * https://www.geeksforgeeks.org/k-largestor-smallest-elements-in-an-array/
	 * {@link https://www.quora.com/What-is-the-most-efficient-algorithm-to-find-the-kth-smallest-element-in-an-array-having-n-unordered-elements}
	 * {@link https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/}
	 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/
	 * https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/
	 * https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-introduction-to-algorithms-sma-5503-fall-2005/video-lectures/lecture-6-order-statistics-median/
	 * http://staff.ustc.edu.cn/~csli/graduate/algorithms/book6/chap10.htm
	 * https://www.cs.rit.edu/~ib/Classes/CS515_Spring12-13/Slides/022-SelectMasterThm.pdf
	 * http://www.ics.uci.edu/~eppstein/161/960125.html
	 * http://www.cse.ust.hk/~dekai/271/notes/L05/L05.pdf
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int kthsmallestWithHeap(final int[] A, int B) {
		int len = A.length;
		BinaryMaxHeap m = new IBitArray.BinaryMaxHeap(Arrays.copyOfRange(A, 0, B));
		for (int i=B; i<len; i++) {
			if (A[i] < m.peekMax()) {
				m.heap[0] = A[i];
				m.percolateDown(0);
			}
		}
		return m.heap[0];		
	}

	/**
	 * 
	 * @param a
	 */
	public void arrange_arr_i_At_arr_arr_i(ArrayList<Integer> a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int index = 0;
	    int indexValue = 0;
	    int i = 0;
	    map.put(i, a.get(i));
	    int j = 0;
	    while (j<a.size()) {
	    	index = a.get(i);
	    	if (map.containsKey(index)) {
	    		indexValue = map.get(index);
	    	} else {
	    		indexValue = a.get(index);
	    	}
	        a.set(i,indexValue);
	        i = index;
	        j++;
	    }
	}
	
	/**
	 * Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.
	 * 
	 * @param a
	 */
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int columnSize = a.get(0).size();
		ArrayList<Integer> zerosInRow = new ArrayList<Integer>();
		for (int i=0; i<a.size(); i++) {
			if (a.get(i).contains(0)) {
				zerosInRow.add(i);
			}
		}
		ArrayList<Integer> zeros = new ArrayList<Integer>();
		for (int i=0; i<a.size(); i++) {
			if (zerosInRow.contains(i)) {
				for (int j=0; j<columnSize; j++) {
					if (!zeros.contains(j) && a.get(i).get(j) == 0) {
						zeros.add(j);
						setZerosInColumn(a, j);
					}
				}
			}
		}
		for (Integer x : zerosInRow) {
			setZerosInRow(a, x);
		}
	}
	
	private void setZerosInRow(ArrayList<ArrayList<Integer>> a, int x) {
		int column = a.get(x).size();
		for (int i=0; i<column; i++) {
			a.get(x).set(i, 0);
		}
	}
	
	private void setZerosInColumn(ArrayList<ArrayList<Integer>> a, int y) {
		int row = a.size();
		for (int i=0; i<row; i++) {
			a.get(i).set(y, 0);
		}
	}

	/**
	 * You are given an n x n 2D matrix representing an image.
	 * Rotate the image by 90 degrees (clockwise).
	 * You need to do this in place.
	 * 
	 * Note that if you end up using an additional array, you will only receive partial score.
	 * 
	 * @param a
	 */
	public void rotate2DArrayBy90Degree(ArrayList<ArrayList<Integer>> a) {
		for (ArrayList<Integer> arr : a) {
			Collections.reverse(arr);
		}
		int size = a.size();
		int start = size - 1;
		int i = 0;
		while (start > 0) {
			int k = size-1;
			ArrayList<Integer> arr = a.get(i++);
			for (int j=0; j<start; j++) {
				Integer temp = arr.get(j);
				arr.set(j, a.get(k).get(start));
				a.get(k).set(start, temp);
				k--;
			}
			start--;
		}
	}
	
	/**
	 * Give a N*N square matrix, return an array of its anti-diagonals. Look at the example for more details.
	 * 
	 * @param A
	 * @return
	 */
	public int[][] diagonal(int[][] A) {
        int len = A.length;
        int[][] res = new int[2*len-1][];
        int k=0, size = 0;
        int j= 0;
        for (int i=0; i<len; i++) {
            while (j!=-1 && j!=len) {
                res[k++] = new int[++size];
                int x = i-1, y = j+1;
                int n = 0;
                while (x+1<len && y-1>-1) {
                    x++;
                    y--;
                    res[k-1][n++] = A[x][y];
                }
                if (j<len) {
                	j++;
                } else {
                	j--;
                }
            }
            j = len -1;
            size-=2;
        }
        return res;
    }
	
	/**
	 * Print 2D array in spiral manner.
	 * 
	 * @param A
	 * @return
	 */
	public int[] spiralOrder(final int[][] A) {
        int lenRow = A.length;
        int lenColumn = A[0].length;
        int[] res = new int[lenRow*lenColumn];
        int k = 0;
        int T=0, B = lenRow -1, L = 0, R = lenColumn -1;
        int dir = 0;
        while (T<=B && L<=R) {
            if (dir == 0) {
                for (int i=L; i<=R; i++) {
                    res[k++] = A[T][i];
                }
                T++;
            } else if (dir == 1) {
                for (int i=T; i<=B; i++) {
                    res[k++] = A[i][R];
                }
                R--;
            } else if (dir == 2) {
                for (int i=R; i>=L; i--) {
                    res[k++] = A[B][i];
                }
                B--;
            } else if (dir == 3) {
                for (int i=B; i>=T; i--) {
                    res[k++] = A[i][L];
                }
                L++;
            }
            dir = (dir+1)%4;
        }
        return res;
    }
	
	/**
	 * 
	 * You are in an infinite 2D grid where you can move in any of the 8 directions 
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int coverPoints(int[] A, int[] B) {
        int len = A.length;// length of both will be same.
        int startx = A[0];
        int starty = B[0];
        int shortestPath = 0;
        for (int i=1; i<len; i++) {
        	/*int x = Math.abs(startx - A[i]);
            int y = Math.abs(starty - B[i]);
            startx = A[i];
            starty = B[i];
            shortestPath += Math.max(x,y);*/
            shortestPath += getShortestBetween(startx,starty,A[i],B[i]);
            startx = A[i];
            starty = B[i];
        }
        return shortestPath;
    }
    
    private int getShortestBetween(int x1, int y1, int x2, int y2) {
        if (Math.abs(x1-x2) <=1 && Math.abs(y1-y2) <=1) {
        	if(Math.abs(x1-x2) == 0 && Math.abs(y1-y2) == 0) return 0;
            return 1;
        } else {
            int diffX = Math.abs(x1-x2);
            int diffY = Math.abs(y1-y2);
            if (diffX == diffY) {
                return diffX;
            } else {
                return diffX > diffY ? diffX : diffY;
            }
        }
    }
    
    /**
     * MUST READ - https://www.geeksforgeeks.org/?p=2457
     * 
     * You are given a read only array of n integers from 1 to n.
     * Each integer appears exactly once except A which appears twice and B which is missing.
     * 
     * Check this link
     * {@link https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number}
     * 
     * 1) XOR - VERY TRICKY, MUST READ - https://www.geeksforgeeks.org/?p=2457
     * 2) While traversing, use absolute value of every element as index and make the value at this index as negative to mark it visited. 
     * 	  If something is already marked negative then this is the repeating element. 
     * 	  To find missing, traverse the array again and look for a positive value.
     * 3) Make two equations {@link IBitArray#repeatedAndMissingNumber}
     * 4) Use O(n) space. temp Array.
     * 
     */
    public int[] repeatedAndMissingNumber(final int[] A) {
        int[] arr = A;
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
		return result;
    }
	
	/**
	 * You’re given a read only array of n integers. Find out if any integer occurs 
	 * more than n/3 times in the array in linear time and constant additional space.
	 * 
	 * https://www.quora.com/Given-an-array-of-n-elements-what-is-a-linear-time-algorithm-that-finds-all-elements-that-appear-more-than-n-3-times
	 * 
	 * https://www.sciencedirect.com/science/article/pii/0167642382900120#
	 * 
	 * https://stackoverflow.com/questions/14955634/number-which-appears-more-than-n-3-times-in-an-array
	 * 
	 * @param a
	 * @return
	 */
	@SuppressWarnings("unlikely-arg-type")
	public int repeatedNumber_n_divideBy_k_times(final List<Integer> a) {
		int len = a.size();
	    Map<Integer, Integer> map = new HashMap<Integer, Integer>(3);
	    for (Integer i : a) {
	    	map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
	    	if (map.size() == 3) {
	    		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
	    			if (e.getValue() == 1) {
	    				map.remove(e);
	    			}
	    		}
	    	}
	    }
	    if (map.isEmpty()) {
	    	return -1;
	    }
	    Map<Integer, Integer> count = new HashMap<Integer, Integer>(3);
	    for (Integer i : a) {
	    	if (map.containsKey(i)) {
	    		count.put(i, count.containsKey(i) ? count.get(i) + 1 : 1);
	    	}
	    }
	    for (Map.Entry<Integer, Integer> e : count.entrySet()) {
	    	if (e.getValue() > len/3) {
	    		return e.getKey();
	    	}
	    }
	    return -1;
	}
	
	/**
	 * 
	 * Now, first try to think if you were already given the minimum value MIN and maximum value MAX in the array of size N, under what circumstances would the max gap be minimum and maximum ?
	 * Obviously, maximum gap will be maximum when all elements are either MIN or MAX making maxgap = MAX - MIN.
	 * Maximum gap will be minimum when all the elements are equally spaced apart between MIN and MAX. Lets say the spacing between them is gap.
	 * So, they are arranged as
	 * MIN, MIN + gap, MIN + 2*gap, MIN + 3*gap, ... MIN + (N-1)*gap
	 * where
	 * MIN + (N-1)*gap = MAX
	 * => gap = (MAX - MIN) / (N - 1).
	 * So, we know now that our answer will lie in the range [gap, MAX - MIN].
	 * Now, if we know the answer is more than gap, what we do is create buckets of size gap for ranges
	 * [MIN, MIN + gap), [Min + gap, `MIN` + 2* gap) ... and so on
	 * There will only be (N-1) such buckets. We place the numbers in these buckets based on their value.
	 * If you pick any 2 numbers from a single bucket, their difference will be less than gap, and hence they would never 
	 * contribute to maxgap ( Remember maxgap >= gap ). We only need to store the largest number and the smallest number in each bucket, 
	 * and we only look at the numbers across bucket.
	 * Now, we just need to go through the bucket sequentially ( they are already sorted by value ), 
	 * and get the difference of min_value with max_value of previous bucket with at least one value. We take maximum of all such values.
	 * 
	 * try link ::  {@link http://cgm.cs.mcgill.ca/~godfried/teaching/dm-reading-assignments/Maximum-Gap-Problem.pdf}
	 * 
	 * @param arr
	 * @return
	 */
	int getMaximumSuccesiveGap2(int[] arr) {
		int len = arr.length;
		if (len<2) {
            return 0;
        }
		int min = findMinInArray(arr, 0, len-1);
		int max = findMaxInArray(arr, 0, len-1);
		int gap = (int) Math.ceil((float)(max-min)/(float)(len-1));
		if (gap == 0) return 0;
		int[][] buckets = new int[len+1][2];
		for(int i=0; i<len+1;i++) {
			buckets[i][0] = Integer.MAX_VALUE;
			buckets[i][1] = Integer.MIN_VALUE;
		}
		for (int i=0;i<len;i++) {
			int k = (int)Math.ceil((float)(arr[i]-min)/(float)gap);
			if (buckets[k][0] > arr[i]) buckets[k][0] = arr[i];
			if (buckets[k][1] < arr[i]) buckets[k][1] = arr[i];
		}
		int globalMax = 0;
		int localMax = 0;
		int j = 1;
		for (int i=0; i<len && j<len;) {
			if (buckets[i][0] == Integer.MAX_VALUE) {
				i = j;
				j++;
			} else if (buckets[j][0] == Integer.MAX_VALUE) {
				j++;
			} else {
				localMax = buckets[j][0] - buckets[i][1];
				globalMax = globalMax > localMax ? globalMax : localMax;
				i = j;
				j++;
			}
		}
		return globalMax;
	}
	
	/**
	 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
	 * 
	 * @param arr
	 * @return
	 */
	int getMaximumSuccesiveGap(int[] arr) {
		int len = arr.length;
		if (len<2) {
            return 0;
        }
		int min = findMinInArray(arr, 0, len-1);
		int max = findMaxInArray(arr, 0, len-1);
		int possibleLength = max-min+1;
		int[] space = new int[possibleLength];
		for (int i=0; i < len; i++) {
			space[arr[i]-min] = 1;
		}
		int maxSubLength = Integer.MIN_VALUE;
		int localMax = 0;
		int indexI = 0;
		int indexJ = -1;
		while(indexI < possibleLength) {
			if (space[indexI] == 1) break;
			indexI++;
		}
		int i = indexI;
		for (int j=indexI+1; j<possibleLength; j++) {
			if (space[j] == 1) {
				if (maxSubLength < localMax) {
					maxSubLength = localMax;
					indexJ = j;
					indexI = i;
				}
				localMax = 0;
				i = j;
			} else {
				localMax++;
			}
		}
		return indexJ-indexI;
	}
	
	/**
	 * You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
	 * Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) 
	 * that sub array, then the whole array should get sorted.
	 * If A is already sorted, output -1.
	 * 
	 * 
	 * Solution
	 * make 3 arrays
	 * 
	 *0 - (l-1), l - r, r - N; 
	 * 
	 * @param A
	 * @return
	 */
	public int[] subUnsort(int[] A) {
		int len = A.length;
		int l = -1;
		int i = 1;
		while (i < len) {
			if (A[i-1] > A[i]) {
				l = i-1;
				break;
			}
			i++;
		}
		if (l == -1) {
			return new int[] {-1};
		}
		int r = -1;
		for (int j=len-1; j>=0; j--) {
			if (A[j] < A[j-1]) {
				r = j-1;
				break;
			}
		}
		//sortedArrayFrom(A, l+1);
		int min = 0;
		int max = 0;
		if (r == -1) {
			min = max = A[l];
			r=l;
		} else {
			min = findMinInArray(A, l, r);
			max = findMaxInArray(A, l, r);
		}
		int[] result = new int[2];
		
		if (!(l>0 && r< len-1 && min>=A[l-1] && max <= A[r+1])) {
			//find num > max in rightSide array
			if (r < len-1) {
				for (int k=r+1;k<len;k++) {
					if (A[k]>=max) {
						r = k-1;
						break;
					}
					if (k == len -1) {
						r = len-1;
					}
				}
			}
			min = findMinInArray(A, l, r);
			if (l > 0) {
				for (int k=l-1;k>=0;k--) {
					if (A[k]<=min) {
						l = k+1;
						break;
					}
					if (k == 0) {
						l = 0;
					}
				}
			}
		}
		result[0] = l;
		result[1] = r;
		return result;
    }
	
	private int findMinInArray(int[] a, int l, int r) {
		if (l<0 || r>a.length-1) return -1;
		int min = Integer.MAX_VALUE;
		while (l <= r) {
			min = min < a[l] ? min : a[l];
			l++;
		}
		return min;
	}

	private int findMaxInArray(int[] a, int l, int r) {
		if (l<0 || r>a.length-1) return -1;
		int max = Integer.MIN_VALUE;
		while (l <= r) {
			max = max > a[l] ? max : a[l];
			l++;
		}
		return max;
	}
	
	int sortedArrayFrom(int[] arr, int index) {
		int len = arr.length;
		while (index < len -1) {
			if (arr[index+1] < arr[index]) {
				int i = sortedArrayFrom(arr, index+1);
				if (i == -1) {
					return index;
				}
			}
			index++;
		}
		return -1;
	}
	
	/**
	 * Formula for generating k_th row without the help of (k-1)th row ==> x=1,a=row_num,b=1; x = x*a/b; a--; b++;
	 * @param A
	 * @return
	 */
	public int[][] generatePascalTriangle(int A) {
		if (A < 1) {
			return new int[0][];
		}
		int[][] arr = new int[A][];
		arr[0] = new int[1];
		arr[0][0] = 1;
		for (int i=1; i<A; i++) {
			arr[i] = new int[i+1];
			arr[i][0] = 1;//first
			arr[i][i] = 1;//last
			for (int j=1; j<i; j++) {				
				arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
			}
		}
		return arr;
    }
	
	int firstMissingPositive(int[] arr) {
		int maxPositiveNum = Integer.MIN_VALUE;
		long sumOfAllPositiveNum = 0;
		//int len = arr.length;
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
		//float max = 2.0f;
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
	
	public long factorial(int len) {
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
//        int len = A.length;
//        int max = Integer.MIN_VALUE;
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
	
	public static class BinaryMaxHeap {
		int size;
		int[] heap;
		
		public BinaryMaxHeap(int n) {
			size = n;
		}
		
		public BinaryMaxHeap(int[] arr) {
			size = arr.length - 1;
			heap = new int[arr.length];
			System.arraycopy(arr, 0, heap, 0, arr.length);
			buildHeap();
		}

		/**
		 * https://stackoverflow.com/questions/9755721/how-can-building-a-heap-be-on-time-complexity
		 * http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
		 * 
		 */
		private void buildHeap() {
			percolateUp();
		}
		
		public void insertNode(int k) {
			if (size == heap.length-1) doubleSize();
			int pos = ++size;
			for (;pos > 0 && heap[(pos - 1)/2] < k;) {
				heap [pos] = heap[(pos - 1)/2];
				pos = (pos - 1)/2;
			}
			heap[pos] = k;
		}

		private void percolateUp() {
			for (int i = (size+1)/2; i>0; i--) {
				bottomUp(i-1);
			}
		}
		
		public int peekMax() {
			return heap[0];
		}

		private void bottomUp(int i) {
			int temp = heap[i];
			int childIndex = -1;
			while (2*i<size) {
				childIndex = 2*i+1;
				if (childIndex < size && heap[childIndex] < heap[childIndex+1]) {
					childIndex = childIndex + 1;
				}
				
				if (temp < heap[childIndex]) {
					heap[i] = heap[childIndex];
				} else break;
				
				i = childIndex;
			}
			heap[i] = temp;
		}
		
		public void percolateDown(int i) {
			if (2*i<size) {
				int index = (2*i+1)<size && heap[2*i + 1] < heap[2*i+2] ? 2*i+2 : 2*i + 1;
				if (heap[i] < heap[index]) {
					int temp = heap[i];
					heap[i] = heap[index];
					heap[index] = temp;
					percolateDown(index);
				} else return;
			}
		}

		private void doubleSize() {
			int[] temp = heap;
			heap = new int[heap.length*2];
			System.arraycopy(temp, 0, heap, 0, size+1);
		}
		
		public int deleteMax() {
			int res = heap[0];
			heap[0] = heap[size--];
			bottomUp(0);
			return res;
		}
	}
}
