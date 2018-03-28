public class Problem_printTopKAndRank {

	//出现次数的top k问题
	public static void printTopKAndRank(String[] arr, int topK) {
		if (arr == null || topK < 1) {
			return;
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}

		Node[] heap = new Node[topK];
		int index = 0;
		Set<Map.Entry<String, Integer>> entrys = map.entrySet();
		for (Map.Entry<String, Integer> entry : entrys) {
			String str = entry.getKey();
			int times = entry.getValue();
			Node node = new Node(str, times);
			if (index < topK) {
				heap[index++] = node;
			} else if (index == topK) {
				buildHeap(heap);
				if (heap[0].times < times) {
					heap[0] = node;
					adjustHeap(heap, 0, topK);
				}
			} else {
				if (heap[0].times < times) {
					heap[0] = node;
					adjustHeap(heap, 0, topK);
				}
			}
		}
		//将小根堆排序
		for (int i = topK - 1; i >= 0; i--) {
			swap(heap, 0, i);
			adjustHeap(heap, 0, i);
		}
		for (int i = 0; i < topK; i++) {
			System.out.print("No." + (i + 1) + ":");
			System.out.println(heap[i].str + ", times:" + heap[i].times);
		}

	}

	public static void buildHeap(Node[] arr) {
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, arr.length);
		}
	}

	public static void adjustHeap(Node[] arr, int i, int length) {
		int temp = arr[i];
		for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
			if (k + 1 < length && arr[k + 1].times < arr[k].times) {
				k++;
			}
			if (arr[k].times < temp.times) {
				arr[i] = arr[k];
				i = k;
			} else {
				break;
			}
		}
		arr[i] = temp;
	}

	public static void swap(Node[] arr, int i, int j) {
		Node temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	class Node {
		public String str;
		public int times;
		public Node(String str, int times) {
			this.str = str;
			this.times = times;
		}
	}

}