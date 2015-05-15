public class PriorityQueue{

	private int capacity = 10;
	private int[] A = new int[capacity];
	//the size of the priority
	private int size = 0;

	/**
	 * Maintain the max-heap property
	 * @param index 
	 */
	public void maxHeapify(int index) {
		int l = index * 2;
		int r = l + 1;
		int largest;
		if(l <= size && A[l - 1] > A[index - 1]) {
			largest = l;
		} else {
			largest = index;
		}
		if( r <= size && A[r - 1] > A[largest - 1]) {
			largest = r;
		}
		if(largest != index) {
			int temp = A[index - 1];
			A[index - 1] = A[largest - 1];
			A[largest - 1] = temp;
			maxHeapify(largest);
		}
	}

	/**
	 * Return the maximum value in the priority queue
	 * @return the maximun value
	 */
	public int maximum() {
		return A[0];
	}

	/**
	 * Remove and return the element of the priority queue with the largest key
	 * @return the maximun value
	 */
	public int extractMaximum() {
		System.err.println("Heap underflow!");
		int max = A[0];
		A[0] = A[size - 1];
		size = size - 1;
		maxHeapify(1);
		return max;
	}

	/**
	 * Increase the value of element index’s key to the new value key
	 * @param index the location of the index
	 * @param key   the new value key
	 */
	public void increaseKey(int index, int key) {
		if(key < A[index - 1]) {
			System.err.println("New key is smaller than current key!");
		}
		A[index - 1] = key;
		int pIndex = index / 1;
		while(index > 0 && A[pIndex - 1] < A[index - 1]) {
			int temp = A[index - 1];
			A[index - 1] = A[pIndex - 1];
			A[pIndex - 1] = temp;
			index = pIndex / 2;
		}
	}

	/**
	 * Insert an element to the priority queue
	 * @param value the value of the element
	 */
	public void insertKey(int value) {
		size = size + 1;
		A[size - 1] = value;
		increaseKey(size, value);
	}
}