package madr.sp.emira.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

/**
 * 1. Right Shift :: A >> x is equal to division by pow(2, x). Think why. ==== A >> x == A/2^x; 
 * 2. A << x is equal to multiplication by pow(2, x).
 * 
 * x & (x-1) will clear the lowest set bit of x
 * x & ~(x-1) extracts the lowest set bit of x (all others are clear). Pretty patterns when applied to a linear sequence.
 * x & (x + (1 << n)) = x, with the run of set bits (possibly length 0) starting at bit n cleared.
 * x & ~(x + (1 << n)) = the run of set bits (possibly length 0) in x, starting at bit n.
 * x | (x + 1) = x with the lowest cleared bit set.
 * x | ~(x + 1) = extracts the lowest cleared bit of x (all others are set).
 * x | (x - (1 << n)) = x, with the run of cleared bits (possibly length 0) starting at bit n set.
 * x | ~(x - (1 << n)) = the lowest run of cleared bits (possibly length 0) in x, starting at bit n are the only clear bits.
 * 
 *  
 * 3. Very Important : (x ^ y) == (x | y) - (x & y) >= |y - x|
 * 
 * @author yogeshk
 *
 */
public class IBitBitOpsAndMath {

	public static void main(String[] args) {
		IBitBitOpsAndMath cl = new IBitBitOpsAndMath();
		
		//System.out.println(findBitsOfNum(128));
		
		//System.out.println(reverse(3));
		
		/*System.out.println(sqrtD(2));
		System.out.println(Math.sqrt(2));*/
		
		/*List<Integer> a = new ArrayList<Integer>();
		a.add(2);a.add(4);a.add(6);a.add(2);a.add(3);a.add(5);
		System.out.println(cl.hammingDistance(a));*/
		
		/*System.out.println(cl.isPower(536870912));
		System.out.println(cl.isPower2(536870912));*/
		
		//System.out.println(cl.factorial_x_divide_y(24,1));
		
		/*ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0);l.add(1);l.add(5);
		System.out.println(cl.possibleNums(l, 1, 2));*/
		
		/*System.out.println(cl.trailingZeroes(99));
		Character[] a = {new Character('a'), new Character('b'), new Character('c')};
		Arrays.asList(a).toArray().toString();*/
		
		//System.out.println(cl.uniquePaths(4, 3));
		
		/*List<Integer> l1 = new ArrayList<>();l1.add(-37);l1.add(-9);l1.add(10);l1.add(19);//l1.add(-40);l1.add(-25);l1.add(5);l1.add(10);l1.add(14);l1.add(28);l1.add(29);l1.add(48);
		List<Integer> l2 = new ArrayList<>();l2.add(-29);l2.add(18);l2.add(46);//l2.add(-48);l2.add(-31);l2.add(-15);l2.add(-6);l2.add(1);l2.add(8);
		System.out.println(cl.findMedianSortedArrays(l1, l2));*/
		
		//System.out.println(cl.pow(71045970, 41535484, 64735492));
		
		/*System.out.println(cl.isPrime(2147483647));
		System.out.println(Integer.MAX_VALUE);*/
		
		//System.out.println(cl.gcd(-1, -1));
		
		System.out.println(cl.isPrime(67));
		System.out.println(cl.isPrime(71));
		System.out.println(cl.maxProbability());
		
	}
	
	/**
	 * You have 50 red, 50 blue marbles, and 2 jars. You must place all 100 marbles in the two jars.
	 * Your friend will be randomly grabbing one marble from one of the jars.
	 * How would you maximize the chance of your friend picking a red marble?
	 * 
	 * algo ==>
	 * m = 1/2; choosing jar randomly, one out of two.
	 * placing i red ball and j blue ball in one, and 100- i-j in other.
	 * probability of picking red from first jar is == i/i+j;
	 * probability of picking red frm second jar is == 50-i/100 -i -j;
	 * 
	 * 
	 * wherever you get max > m*( i/i+j + 50-i/100-i-j);
	 * @return
	 */
	public double maxProbability() {
		double max = 0f;
		for (float i=0; i<50; i++)
			for (float j=0; j<50; j++) {
				if (i+j==0) max = Math.max(max, 0.5*((50f-i)/(100f-i-j)));
				else if (i+j==100) max = Math.max(max, 0.5*(i/(i+j)));
				else max = Math.max(max, 0.5*(i/(i+j)+(50f-i)/(100f-i-j)));
			}
		return max;
	}
	
	/**
	 * power function
	 * 
	 * @param x
	 * @param n
	 * @param d
	 * @return
	 */
	public int pow(int x, int n, int d) {
	    if (x == 0 || x%d == 1) return x;
	    if (x<0 && n == 1) return (x+d)%d;
	    if (n == 0) return 1%d;
	    if (n == 1) return x%d;
	    if (n<0) return 0;
	    x = x%d;
	    return (int)(power(x,n,d)%d);
	    /*long result = x%d;
	    int pow = n;
        while (--pow > 1) {
            result *= result;
            result = result%d;
        }
	    return (int)result%d;*/
	}
	
	long power(int x, int y, int d) {
	    if(y == 0) return 1;
        long temp = power(x, y/2, d);
        if (y%2 == 0) return ((temp)*(temp))%d;
        else {
        	return (((x *temp)%d)*(temp))%d;
        }
    }
	
	/**
	 * Only when size of both the array's are same.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
	    int m = a.size();
	    int n = b.size();
	    if (m == 0) return median(b,0,n-1);
	    if (n == 0) return median(a,0,m-1);
	    if (m == 1 || n == 1) {
	    	List<Integer> temp = null;
	    	int i = 0;
	    	int t = 0;
	    	if (m == 1) {
	    		t = a.get(0);
	    		while (t > b.get(i)) i++;
	    		temp = new ArrayList<Integer>(b);
	    	} else {
	    		t = b.get(0);
	    		while (t > a.get(i)) i++;
	    		temp = new ArrayList<Integer>(a);
	    	}
	    	temp.add(i, t);
    		return median(temp, 0, temp.size()-1);
	    }
	    return findMedianUtil(a,0,m-1,b,0,n-1);
	}
	
	public double findMedianUtil(List<Integer> a, int ax, int ay, List<Integer> b, int bx, int by) {
	    if (ay - ax+1 == 2 && by - bx+1 == 2) {
	        return (Math.max(a.get(ax), b.get(bx)) + Math.min(a.get(ay), b.get(by)))/2;
	    } else {
	        double medianA = median(a,ax,ay);
	        double medianB = median(b,bx,by);
	        if (medianA == medianB) return medianA;
	        if (medianA > medianB) {
	        	int tax = ax, tay = ay, tbx = bx, tby = by;
	        	if (!(ay - ax+1 == 2)) tay = (ay-ax+1)%2 == 0 ? ay-(ay-ax+1)/2 : ay-(ay-ax)/2;
	        	if (!(by - bx+1 == 2)) tbx = (by-bx+1)%2 == 0 ? bx+(by-bx+1)/2 : bx+(by-bx)/2;
	            return findMedianUtil(a,ax,tay,b,tbx,by);
	        } else {
	        	int tax = ax, tay = ay, tbx = bx, tby = by;
	        	if (!(ay - ax+1 == 2)) tax = (ay-ax+1)%2 == 0 ? ax+(ay-ax+1)/2 : ax+(ay-ax)/2;
	        	if (!(by - bx+1 == 2)) tby = (by-bx+1)%2 == 0 ? by-(by-bx+1)/2 : by-(by-bx)/2;
	            return findMedianUtil(a,tax,ay,b,bx,tby);
	        }
	    }
	}
	
	public double median(List<Integer> a, int i, int j) {
	    int size = j-i+1;
	    double median = 0;
	    if (size%2 == 0) {
	        median = (double)(a.get(i+(size/2)) + a.get(i+((size/2)-1)))/2d;
	    } else {
	        median = (double)a.get(i+(size-1)/2);
	    }
	    return median;
	}	
	
	/**
	 * https://www.geeksforgeeks.org/print-all-possible-paths-from-top-left-to-bottom-right-of-a-mxn-matrix/
	 * 
	 * https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
	 * 
	 * https://www.geeksforgeeks.org/unique-paths-in-a-grid-with-obstacles/
	 * 
	 * 
	 * A robot is located at the top-left corner of an A x B grid (marked ‘Start’ in the diagram below).
	 * The robot can only move either down or right at any point in time. The robot is trying to reach 
	 * 	the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).
	 * 
	 * How many possible unique paths are there?
	 * 
	 * 		Input : A = 2, B = 2
			Output : 2
			
			2 possible routes : (0, 0) -> (0, 1) -> (1, 1) 
			              OR  : (0, 0) -> (1, 0) -> (1, 1)
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int uniquePaths(int A, int B) {		
        return uniquePathsUtilDP(A, B);
    }
	
	/**
	 * Exponential growth. Use DP
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int uniquePathsUtil(int A, int B) {
		if (A == 0 || B == 0) return 1;
		return uniquePathsUtil(A-1, B)+uniquePathsUtil(A, B-1);
	}
	
	public int uniquePathsUtilDP(int A, int B) {
		int[][] memo = new int[A][B];
		
		// Count of paths to reach any cell in 
        // first column is 1
        for (int i = 0; i < A; i++)
        	memo[i][0] = 1;
  
        // Count of paths to reach any cell in
        // first column is 1
        for (int j = 0; j < B; j++)
        	memo[0][j] = 1;
		
        for (int i = 1; i < A; i++)
        {
            for (int j = 1; j < B; j++)
  
            // By uncommenting the last part the 
            // code calculates t he total possible paths 
            // if the diagonal Movements are allowed
            memo[i][j] = memo[i-1][j] + memo[i][j-1]; //+ count[i-1][j-1];
  
        }
        return memo[A-1][B-1];
	}
	
	/**
	 * Given an integer n, return the number of trailing zeroes in n!.
	 * 
	 * @param A
	 * @return
	 */
	public int trailingZeroes(int n) {
		long count = 0;
	    for(long i= 5; n/i >= 1; i= i*5){
	        count+= n/i;
	    }
	    return (int)count;
    }
	
	public int gcd(int A, int B) {
		/*if(a == 0) return b;
	    return gcd(b%a, a);*/
        if (A == B) return A;
        if (A == 0) return B;
        else if (B == 0) return A;
        else return gcd(B%A,A%B);
    }
	
	public int gcd2(int a, int b) {
		if (a == 0) return b;
		else return gcd2(b>a?b-a:a-b,a);
	}
	/**
	 * Given a set of digits (A) in sorted order, find how many numbers 
	 * of length B are possible whose value is less than number C.
	 * 
	 * Input:
		  3 0 1 5  
		  1  
		  2  
		Output:  
		  2 (0 and 1 are possible)  
	
		Input:
		  4 0 1 2 5  
		  2  
		  21  
		Output:
		  5 (10, 11, 12, 15, 20 are possible)
	 * 
	 * @param A
	 * @param B
	 * @param C
	 * @return
	 */
	public int possibleNums(ArrayList<Integer> A, int B, int C) {
		if ((C+"").length() > B) {
            if (A.size() == 1) return 1;
            else if (A.get(0) == 0) return (int)(factorial_x_divide_y(A.size(),A.size()-B+1)*(A.size()-1));
            else return (int)(factorial_x_divide_y(A.size(),A.size()-B+1)*A.size());
        } else if ((C+"").length() < B) {
            return 0;
        } else {
            int leftMostDigit = C/(int)Math.pow(10,B-1);
            int index = binarySearchNumlessorEqual(A,leftMostDigit);
            if (A.get(index) == leftMostDigit) {
                return 0;
            } else {
                if (A.size() == 1) return 1;
                else if (A.get(0) == 0 && B>1) return (int)(factorial_x_divide_y(A.size(),A.size()-B+1)*(index+1-1));
                else return (int)(factorial_x_divide_y(A.size(),A.size()-B+1)*(index+1));
            }
        }
    }
	
	public long factorial_x_divide_y(int num, int baseCase) {
		if (num < baseCase) return 0;
        if (num == baseCase) return 1;
        return num*factorial_x_divide_y(num-1,baseCase);
    }
	
	public int recursiveAbove(ArrayList<Integer> A, int digits, int num, int sum) {
		if (digits == 0) return sum;
		int leftMost = num % 10;
		num = num/10;
		int index = binarySearchNumlessorEqual(A, leftMost);
		if (leftMost == A.get(index)) {
			
		}
		if (A.get(0) == 0) {
			
		}
		return 0;
	}
	
	public int binarySearchNumlessorEqual(ArrayList<Integer> a, int leftMost) {
		int index = -1;
		int low = 0;
        int high = a.size()-1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            Integer midVal = a.get(mid);
            int cmp = midVal.compareTo(leftMost);
            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else {
                index = mid; // key found
                break;
            }
            
        }
        if (index == -1) {
            int local = -1;
            int mid = (a.size()-1)/2;
            Integer midVal = a.get(mid);
            int cmp = midVal.compareTo(leftMost);
            if (cmp < 0) {
                local = mid;
                while (local+1<a.size() && a.get(local+1).compareTo(leftMost) < 0) {
                	local++;
                }
            }                	
            else if (cmp > 0) {
            	local = mid;
            	while (local-1>-1 && a.get(local-1).compareTo(leftMost) > 0) {
                	local--;
                }
            }
            return local;
        } else {
        	return index;
        }
	}

	/**
	 * Given a positive integer which fits in a 32 bit signed integer, 
	 * find if it can be expressed as A^P where P > 1 and A > 0. 
	 * A and P both should be integers.
	 * 
	 * @param n
	 * @return
	 */
	public boolean isPower(int A) {
		if (A == 1) return true;
        int sqrt = (int)Math.sqrt(A);
        for (int x = 2; x <= sqrt; x++) {
            long p = x;
            while (p <= A) {
                p = p * x;
                if (p == A)
                    return true;
            }
        }
        return false;
	}
	
	/**
	 * A = x^y;
	 * log A = y * log x;
	 * y = log A/log x;
	 * find a x such that y comes out as an int.
	 * 
	 * @param A
	 * @return
	 */
	public boolean isPower2(int A) {
		if (A == 1) return true;
        int sqrt = (int)Math.sqrt(A);
        double logA = Math.log(A);
        for (int x = 2; x <= sqrt; x++) {
        	double logX = Math.log(x); 
        	float d = (float)(logA/logX);
        	if (Math.floor(d) == Math.ceil(d)) return true;
        }
        return false;
	}
	
	/**
	 * Given a number N, find all prime numbers upto N ( N included ).
	 * 
	 * This is called "Sieve method"
	 * 
	 * @param A
	 * @return
	 */
	public ArrayList<Integer> allPrimeTill_N(int A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] arr = new int[A+1];
        for (int i=2; i<A+1; i++) arr[i] = 1;
        
        int sqrt = (int)Math.sqrt(A);
        for (int i=2; i<=sqrt; i++) {
            if (arr[i] == 1) {
                for (int j=2; i*j<=A; j++) {
                    arr[i*j] = 0;
                }
            }
        }
        for (int i=2; i<=A; i++) {
            if (arr[i] == 1) res.add(i);
        }
        return res;
    }
	
	/**
	 * Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.

		For example,
		
		HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).
		
		Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
		Return the answer modulo 1000000007.
		
		Example
		
		Let f(x, y) be the hamming distance defined above.
		
		A=[2, 4, 6]
		
		We return,
		f(2, 2) + f(2, 4) + f(2, 6) + 
		f(4, 2) + f(4, 4) + f(4, 6) +
		f(6, 2) + f(6, 4) + f(6, 6) = 
		
		0 + 2 + 1
		2 + 0 + 1
		1 + 1 + 0 = 8
		
	 * @param A
	 * @return
	 */
	public int hammingDistance2(final List<Integer> A) {
		/*Set<Integer> set = new HashSet<Integer>();
        for (Integer a : A) {
            set.add(a);
        }
        List<Integer> list = new ArrayList<Integer>(set);*/
		Map<Integer,Integer> hash = new HashMap<Integer, Integer>();
		int size = A.size();
		int sum = 0;
		for(int i=0; i<size-1; i++) {
			int localSum = 0;
			Integer a_i = A.get(i);
			if (hash.containsKey(a_i)) {
				localSum = hash.get(a_i)-i;				
			} else {
				for(int j=i+1;j<size;j++) {
					Integer a_j = A.get(j);
					if (!a_i.equals(a_j)) {
						int xor = a_i^a_j;
						localSum += Integer.bitCount(xor);
					}
					/*String bits = Integer.toBinaryString(xor);
					sum += sumStringofBits(bits);*/				
				}
				//hash.put(a_i, localSum);
			}
			sum += localSum;
		}
		return (2*sum)%1000000007;        
    }
	
	public int hammingDistance(final List<Integer> A) {
		long size = A.size();
		long sum = 0;
		Integer max = getMaxInList(A);
		int maxBitSize = Integer.toBinaryString(max).length();
		for (int i=maxBitSize-1; i>=0; i--) {
			long _0s = 0, _1s = 0;
			for(int j=0; j<size; j++) {
				Integer a = A.get(j);
				String bits = Integer.toBinaryString(a);
				int offset = maxBitSize - bits.length();
				if (i-offset<0 || bits.charAt(i-offset) == '0') _0s++;
			}
			_1s = size - _0s;
			sum += 2*_0s*_1s;
		}
		return (int)(sum%1000000007l);
	}
	
	private int getMaxInList(List<Integer> a) {
		Integer max = Integer.MIN_VALUE;
		for (Integer i : a) {
			max = i > max ? i : max;
		}
		return max;
	}

	public int sumStringofBits(String bits) {
		int _1s = 0;
		for (int i=0; i<bits.length(); i++) {
			if (bits.charAt(i) == '1') {
				_1s++;
			}
		}
		return _1s;
	}

	public boolean isPrime(int A) {
        if (A < 2) return false;
        if (A == 2) return true;
        int sqrt = (int) Math.sqrt(A);
        for (int i=2; i<=sqrt; i++) {
            if (A%i == 0) return false;
        }
        return true;
    }
	
	/**
	 * Find Binary Representation.
	 * @param A
	 * @return
	 */
	public String findDigitsInBinary(int A) {
        StringBuilder sb = new StringBuilder();
        int rem = A%2;
        int q = A/2;
        sb.append(rem);
        while (q != 0) {
            rem = q%2;
            q = q/2;
            sb.append(rem);
        }
        return sb.reverse().toString();
    }
	
	/**
	 * Given a number N, find all factors of N.
	 * 
	 * @param A
	 * @return
	 */
	public ArrayList<Integer> allFactors(int A) {
        int sqrt = (int)Math.sqrt(A);
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> big = new ArrayList<Integer>();
        list.add(1);
        int i = 2;
        while (i<=sqrt) {
            if (A%i == 0) {
                list.add(i);
                if (i!=A/i) big.add(A/i);
            }
            i++;
        }
        int len = big.size();
        for (int k=len-1;k>=0;k--) {
            list.add(big.get(k));
        }
        if (A != 1) list.add(A);
        return list;
    }
	
	/**
	 * SQRT of a num.
	 * @param a
	 * @return
	 */
	public static int sqrt(int a) {
	    if (a == 0 || a == 1 ) return a;
	    if (a == 2 || a == 3 ) return 1;
	    long min = 0, max = a, ans = 0;
	    while (min <= max) {
	        long mid = (min + max)/2;
	        if (mid*mid == a) return (int)mid;
	        else if (mid*mid > a) max = mid-1;
	        else {
	            min = mid+1;
	            ans = mid;
	        }
	    }
	    return (int)ans;
	}
	
	public static double sqrtD(int n) {
		Double d = new Double(n+"");
		double x = d.doubleValue(), y = 1d;
		double e = 0.0000001d;
		while (x - y > e) {
		    x = (x + y)/2;
		    y = n/x;
		}
		return x;
	}
	
	/**
	 * 
	 * @param a
	 * @return
	 */
	public static long reverse(long a) {
	    String bits = Long.toBinaryString(a);
	    int len = 32 - bits.length();
	    StringBuilder rev = new StringBuilder();
	    while (len !=0 ){
	        rev.append("0");
	        len--;
	    }
	    rev.append(bits);
	    String reverse = rev.reverse().toString();
	    long ans = 0l;
	    int j = 0;
	    for (int i = 31; i>=0; i--) {
	        ans += Math.pow(2, i) * (reverse.charAt(j++) == '0' ? 0 : 1);
	    }
	    return ans;
	}
	
	public long reverse2(long A) {
	    long rev = 0;
	    for (int i = 0; i < 32; i++) {
	        rev <<= 1;
	        if ((A & (1 << i)) != 0)
	            rev |= 1;
	    }	    
	    return rev;	    
	}
	
	/**
	 * Given an array of N integers, 
	 * find the pair of integers in the array which have minimum XOR value. 
	 * Report the minimum XOR value.
	 * 
	 * Very Important : (x ^ y) == (x | y) - (x & y) >= |y - x|
	 * 
	 * https://www.geeksforgeeks.org/minimum-xor-value-pair/
	 * https://stackoverflow.com/questions/9524828/finding-pairs-with-smallest-xor-values-from-a-list
	 * 
	 * 
	 * @param A
	 * @return
	 */
	public int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int minXor = Integer.MAX_VALUE;
        int val = 0;
        for(int i=0;i<A.size()-1;i++) {
            val = A.get(i)^A.get(i+1);
            minXor = Math.min(minXor, val);
        }
        return minXor;
    }
	
	public int divide(int A, int B) {
        int dividend = A;
        int divisor = B;
        boolean negative = false;
        if ((dividend & (1 << 31)) == (1 << 31)) { // Check for signed bit
            negative = !negative;
            dividend = add(~dividend, 1);  // Negation
        }
        if ((divisor & (1 << 31)) == (1 << 31)) {
            negative = !negative;
            divisor = add(~divisor, 1);  // Negation
        }
        int quotient = 0;
        long r;
        for (int i = 30; i >= 0; i = subtract(i, 1)) {
            r = (divisor << i);
           // Left shift divisor until it's smaller than dividend
            if (r < Integer.MAX_VALUE && r >= 0) { // Avoid cases where comparison between long and int doesn't make sense
                if (r <= dividend) { 
                    quotient |= (1 << i);    
                    dividend = subtract(dividend, (int) r);
                }
            }
        }
        if (negative) {
            quotient = add(~quotient, 1);
        }
        return quotient;
    }
    
    int subtract(int a, int b) {
        return add(a, add(~b, 1));
    }
    
    int add(int a, int b) {
        int partialSum, carry;
        do {
            partialSum = a ^ b;
            carry = (a & b) << 1;
            a = partialSum;
            b = carry;
        } while (carry != 0);
        return partialSum;
    }
	
	static <T extends Number> String findBitsOfNum(T n) {
		if (n instanceof Integer) return Integer.toBinaryString((Integer)n);
		if (n instanceof Long) return Long.toBinaryString((Long)n);
		return null;
	}
}
