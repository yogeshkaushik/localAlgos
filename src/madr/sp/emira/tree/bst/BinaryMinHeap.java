package madr.sp.emira.tree.bst;

import java.util.Arrays;

public class BinaryMinHeap<K extends Comparable<K>> {
	
	private static final int CAPACITY = 2;
	private int size;     // Number of elements in heap
	private K[] heap;     // The heap array
	
	public BinaryMinHeap() {
		size = -1;
		heap = (K[]) new Comparable[CAPACITY];
	}
	
	public BinaryMinHeap(K[] array) {
		size = array.length-1;
		heap = (K[]) new Comparable[array.length];
		System.arraycopy(array, 0, heap, 0, array.length);
		createHeapBottomUp();
	}
	
	/*public BinaryMinHeap(K[] array, boolean topToDown) {
		size = array.length-1;
		heap = (K[]) new Comparable[array.length];
		System.arraycopy(array, 0, heap, 0, array.length);
		if (topToDown) {
			createHeapTopDown();
		} else {
			createHeapBottomUp();
		}
	}
	
	//CRAP
	private void createHeapTopDown() {
		for (int k = 0; k <= size/2; k++) {
			percolateDown(k);
		}
	}*/

	/**
	 * This is DP
	 * confusion in nomenclature
	 * Complexity of this percolation is o(n) and not o(nlog(n))
	 */
	public void createHeapBottomUp() {
		for (int i=(size+1)/2; i>0; i--) {
			bottumUpDPHeapify(i-1/*As our starting index is 0*/);
		}
	}
	
	/**
	 * Percolate Down (Top-Down Approach.)
	 * Recursive Approach
	 * @param i
	 */
	private void percolateDown(int i) {
		if (2*i<size) {
			int leftChild = 2*i+1;			
			int minIndex = leftChild != size && heap[leftChild].compareTo(heap[leftChild + 1]) > 0 ? leftChild+1 : leftChild;
			if (heap[i].compareTo(heap[minIndex]) > 0) {
				K tmp = heap[i];
				heap[i] = heap[minIndex];
				heap[minIndex] = tmp;
				percolateDown(minIndex);
			} else {
				return;
			}
		}		
	}
	
	/**
	 * Percolate-Down (Top-Down approach)
	 * confusion in nomenclature (if it is top-down or bottom-up)
	 * Non-Recursive
	 * @param i
	 */
	private void bottumUpDPHeapify(int i) {
		K temp = heap[i];
		int child = -1;
		for (; 2*i<size;) {
			child = 2*i+1;
			if(child != size && heap[child].compareTo(heap[child+1]) > 0) {
				child = child + 1; // second child.
			}
			if (temp.compareTo(heap[child]) > 0) {
				heap[i] = heap[child];
			} else {
				break;
			}
			i = child;
		}
		heap[i] = temp;
	}
	
	public K peekMin() throws Exception {
		if (heap.length == 0) {
			throw new Exception("trying peeking an empty Heap.");
		}
		return heap[0];
	}
	
	/**
	 * Gives result in o(log n)
	 * @return
	 */
	public K deleteMin() {
		K min = heap[0];
		heap[0] = heap[size];
		heap[size] = min;
		size = size-1;
		percolateDown(0); //Both will work==> bottumUpDPHeapify(0);
		
		return min;		
	}

	/**
	 * The worst-case runtime of the algorithm is o(log n), 
	 * since we need at most one swap on each level of a 
	 * heap on the path from the inserted node to the root.
	 * 
	 * As we know that having 'n' nodes in heap, it's height can't 
	 * be more than 'lon n', so that many worst case swap might be needed.
	 * 
	 * Percolate UP (bottom-Up approach.)
	 * 
	 * 
	 * @param data
	 */
	public void insertNode(K data) {
		if (size == heap.length-1) doubleSize();
		int newNode = ++size;
		for (;newNode>0 && data.compareTo(heap[(newNode-1)/2]) < 0; newNode = (newNode-1)/2) {
			heap[newNode] = heap[(newNode-1)/2];
		}
		heap[newNode] = data;
	}
	
	public boolean isEmpty() {
		return size == -1;
	}
	
	private void doubleSize() {
		K[] temp = heap;
		heap = (K[]) new Comparable[heap.length*2];
		System.arraycopy(temp, 0, heap, 0, size+1);
 	}

	public static void main(String[] args) {
		BinaryMinHeap<Integer> heap = new BinaryMinHeap<Integer>();
		
		heap.insertNode(7);
		heap.insertNode(8);
		heap.insertNode(12);
		heap.insertNode(3);
		heap.insertNode(13);
		heap.insertNode(9);
		heap.insertNode(5);
		heap.insertNode(11);
		heap.insertNode(2);
		
		System.out.println("Heap Top-down : " + Arrays.toString(heap.heap));

		Integer[] arr = {7,8,12,3,13,9,5,11,2};
		BinaryMinHeap<Integer> heap_bottom_up = new BinaryMinHeap<Integer>(arr);
		System.out.println("Heap bottom-up : " + Arrays.toString(heap_bottom_up.heap));
		
		BinaryMinHeap<Integer> heapTopDown = new BinaryMinHeap<Integer>(arr);
		heapTopDown.percolateDown(1);
		heapTopDown.percolateDown(2);
		System.out.println("Heap Top-down : " + Arrays.toString(heapTopDown.heap));
		
		Integer min = heap_bottom_up.deleteMin();
		System.out.println("Min : " + min);
		System.out.println("After delete : " + Arrays.toString(heap_bottom_up.heap));
		heap_bottom_up.deleteMin();
		heap_bottom_up.deleteMin();
		heap_bottom_up.deleteMin();
		heap_bottom_up.deleteMin();
		heap_bottom_up.deleteMin();
		heap_bottom_up.deleteMin();
		heap_bottom_up.deleteMin();
		heap_bottom_up.deleteMin();
		System.out.println("After delete : " + Arrays.toString(heap_bottom_up.heap));
	}
}
