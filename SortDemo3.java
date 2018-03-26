import java.util.Random;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class SortDemo3 {

	public static void main(String[] args) {
		int[] arr = genRandomArray(10);
		System.out.println("Befort sort");
		printArr(arr);
		//bubbleSort(arr);
		//quickSort(arr, 0, arr.length - 1);
		//insertSort(arr);
		//shellSort(arr);
		//selectSort(arr);
		//mergeSort(arr, 0, arr.length - 1);
		//heapSort(arr);
		radixSort(arr);
		System.out.println("After sort");
		printArr(arr);
	}

	//********************交换排序**************************
	//冒泡排序，稳定的排序算法，平均时间复杂度O(n2)，空间复杂度为O(1)
	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}

	//快速排序，##不稳定##，平均时间复杂度O(nlgn)，空间复杂度O(nlgn)用于方法栈
	public static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = partition(arr, left, right);
			quickSort(arr, left, mid - 1);
			quickSort(arr, mid + 1, right);
		}
	}

	public static int partition(int[] arr, int low, int high) {
		int temp = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= temp) {
				high--;
			}
			arr[low] = arr[high];
			while (low < high && arr[low] <= temp) {
				low++;
			}
			arr[high] = arr[low];
		}
		arr[low] = temp;
		return low;
	}

	//********************插入排序************************
	//直接插入排序，稳定的
	public static void insertSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			int j = 0;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > temp) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = temp;
		}
	}

	//希尔排序，##不稳定的##
	public static void shellSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int len = arr.length;
		//增量从len/2到1
		int gap = len / 2;
		while (gap >= 1) {
			//每次分为gap组
			for (int x = 0; x < gap; x++) {
				//组内进行插入排序
				for (int i = x + gap; i < len; i += gap) {
					int temp = arr[i];
					int j;
					for (j = i - gap; j >= 0; j -= gap) {
						if (arr[j] > temp) {
							arr[j + gap] = arr[j];
						} else {
							break;
						}
					}
					arr[j + gap] = temp;
				}
			}
		
			gap /= 2;
		}
	}

	//************************选择排序************************
	//直接选择排序，##不稳定##，平均时间复杂度为O(n2)，空间复杂度为O(1)
	public static void selectSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int temp = arr[i];
			int index = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < temp) {
					temp = arr[j];
					index = j;
				}
			}
			if (index != i) {
				swap(arr, i, index);
			}
		}
	}

	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	//堆排序，###不稳定###，最坏，最好，平均的时间复杂度都为O(nlogn)
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int n = arr.length;
		//构建大根堆，从最后一个非叶子结点开始（arr.length / 2 - 1）
		for (int i = n / 2 - 1; i >= 0; i--){
			adjustHeap(arr, i, n);
		}
		//调整堆结构+交换堆顶元素与末尾元素
		for (int j = n - 1; j >= 0; j--) {
			//交换堆顶元素与末尾元素
			swap(arr, 0, j);
			//重新对堆进行调整
			adjustHeap(arr, 0, j);
		}

	}

	//调整堆
	public static void adjustHeap(int[] arr, int i, int length) {
		int temp = arr[i];
		for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
			if (k + 1 < length && arr[k] < arr[k + 1]) {
				k++;
			}
			if (arr[k] > temp) {
				arr[i] = arr[k];
				i = k;	
			} else {
				break;
			}
		}
		arr[i] = temp;
	}


	//***********************归并排序*********************
	//稳定的，平均时间复杂度O(nlog2n)，空间复杂度O(n)
	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	public static void merge(int[] arr, int low, int mid, int high) {
		int[] temp = new int[high - low + 1];
		int left = low;
		int right = mid + 1;
		int k = 0;
		while (left <= mid && right <= high) {
			if (arr[left] < arr[right]) {
				temp[k++] = arr[left++];
			} else {
				temp[k++] = arr[right++];
			}
		}

		while (left <= mid) {
			temp[k++] = arr[left++];
		}

		while (right <= high) {
			temp[k++] = arr[right++];
		}
		k = 0;
		while (low <= high) {
			arr[low++] = temp[k++];
		}
	}

	//*******************基数排序*******************
	//稳定的，时间复杂度为O(d(r+n))，空间复杂度为O(dr+n)
	public static void radixSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i <= 9; i++) {
			map.put(i, new ArrayList<Integer>());
		}

		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			max = max > arr[i] ? max : arr[i];
		}

		int maxLength = String.valueOf(max).length();
		for (int i = 1; i <= maxLength; i++) {
			for (int j = 0; j < arr.length; j++) {
				int digit = getDigit(arr[j], i);
				map.get(digit).add(arr[j]);
			}

			int t = 0;
			for (int k = 0; k <= 9; k++) {
				int size = map.get(k).size();
				if (size != 0) {
					for (Integer num : map.get(k)) {
						arr[t++] = num;
					}
					map.get(k).clear();
				}
			}
		}
	}

	public static int getDigit(int x, int d) {
		int result = 0;
		for (int i = 1; i <= d; i++) {
			result = x % 10;
			x /= 10;
		}
		return result;
	} 

	public static int[] genRandomArray(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("the length of array is illegal!");
		}
		int[] arr = new int[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			arr[i] = random.nextInt(100) + 1;
		}
		return arr;
	}

	public static void printArr(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	

	static long min(int[] from, int[] to) {
		if (from == null || to == null || from.length <= 0 || to.length <= 0) {
		   return 0;     
		}

		int len1 = from.length, len2 = to.length;
		int[][] dp = new int[len1][len2];
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}


    }

}