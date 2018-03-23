/*
思路：将数分为两部分：一部分是较大的，一部分是较少的；
较大的一部分采用小根堆，较小的一部分采用大根堆；
如果大根堆的size比小根堆的size大2，则将大根堆的堆顶元素弹出，并放入小根堆。
如果小根堆的size比大根堆的size大2，则将小根堆的堆顶元素弹出，并放入大根堆。
*/
public class Problem_数据流的中位数 {

	private Queue<Integer> minHeap = new PriorityQueue<Integer>(new MinHeapComparator());
	private Queue<Integer> maxHeap = new PriorityQueue<Integer>(new MaxHeapComparator());

	public void addNumber(Integer num) {
		if (maxHeap.size() == 0) {
			maxHeap.offer(num);
			return;
		}
		if (maxHeap.peek() >= num) {
			maxHeap.offer(num);
		} else {
			if (minHeap.size() == 0) {
				minHeap.offer(num);
				return;
			}
			if (minHeap.peek() > num) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
		}
		this.modifyTwoHeapsSize();
	}

	public Integer getMedian() {
		long maxHeapSize = this.maxHeap.size();
		long minHeapSize = this.minHeap.size();
		if (maxHeapSize + minHeapSize == 0) {
			return null;
		}
		Integer maxHeapHead = this.maxHeap.peek();
		Integer minHeapHead = this.minHeap.peek();
		//若整个数的个数为偶数
		if ((maxHeapSize + minHeapSize) & 1 == 0) {
			return (this.minHeap.peek() + this.maxHeap.peek()) / 2;
		} else if (maxHeapSize > minHeapSize) {
			return maxHeapHead;
		} else {
			return minHeapHead;
		}
	}

	//调整两个的堆的元素，保证两个堆的数量之差不超过1
	public void modifyTwoHeapsSize() {
		if (maxHeap.size() == minHeap.size() + 2) {
			minHeap.offer(maxHeap.poll());
		}
		if (minHeap.size() == maxHeap.size() + 2) {
			maxHeap.offer(minHeap.poll());
		}
	}

	private class MinHeapComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o2 < o1) {
            	return 1;
	        } else {
	            return -1;
	        }
		}
	}

	private class MaxHeapComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			if (o2 > o1) {
           		return 1;
	        } else {
	            return -1;
	        }
		}
	}


}