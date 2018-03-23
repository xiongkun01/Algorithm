public class SelectionSort {
	
	//简单选择排序,每次从后面选一个最小的,　简单选择排序是不稳定的排序,
	//时间复杂度：T(n)=O(n2)。
	public static void selectionSort(int[] A) {
		int n = A.length;
		if (A == null || n == 0) {
			return;
		}
		
		for (int i = 0; i < n - 1; i ++) {
			int index = i;
			int min = A[i];
			for (int j = i + 1; j < n; j ++) {
				if (min > A[j]) {
					index = j;
					min = A[j];
				}
			}

			//交换两者的值
			if (index != i) {
				A[index] = A[i];
				A[i] = min;
			}
		}
		
	}
	
	//堆排序，不稳定
	//堆排序的最坏时间复杂度为O(nlogn)。堆序的平均性能较接近于最坏性能。
	//由于建初始堆所需的比较次数较多，所以堆排序不适宜于记录数较少的文件。
	public static void selectiontSort2(int[] A) {
		int n = A.length;
		if (A == null || n == 0) {
			return;
		}
		//循环建堆  
		for (int i = 0; i < n - 1; i ++) {
			//建堆
			buildMaxHeap(A, n - i - 1);
			//交换堆顶和最后一个元素
			swap(A, 0, n - 1 - i);
		}
	}

	//对data数组从0到lastIndex建立大根堆
	public static void buildMaxHeap(int[] data, int lastIndex) {
		for (int i = (lastIndex - 1) / 2; i >= 0; i --) {
			//k保存正在判断的节点
			int k = i;
			//如果当前k节点的子节点存在  
			while (k * 2 + 1 <= lastIndex) {
				//k节点的左子节点的索引
				int biggerIndex = 2 * k + 1;
				//如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if (biggerIndex < lastIndex) {
					//如果右子节点的值较大
					if (data[biggerIndex] < data[biggerIndex + 1]) {
						//biggerIndex总是记录较大子节点的索引 
						biggerIndex ++;
					}
				}

				//如果k节点的值小于其较大的子节点的值  
				if (data[k] < data[biggerIndex]) {
					//交换两者的值
					swap(data, k, biggerIndex);
					
					//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}

	public static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void main(String[] args) {
		int[] A = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
		selectiontSort2(A);

		for (int i = 0; i < A.length; i ++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
	}
}
