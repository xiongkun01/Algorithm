public class Practise01 {

	//二分查找
	public boolean halfSort(int[] arr, int key) {
		if (arr == null || arr.length == 0) {
			return false;
		}
		int left = 0, right = arr.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == key) {
				return true;
			} else if (arr[mid] > key) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

	public void quickSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("The array is null!!");
		}
		quickSortCore(arr, 0, arr.length - 1);
	}

	public void quickSortCore(int[] arr, int left, int right) {
		if (left < right) {
			int mid = partition(arr, left, right);
			quickSortCore(arr, left, mid - 1);
			quickSortCore(arr, mid + 1, right);
		}
	}

	public int partition(int[] arr, int left, int right) {
		int temp = arr[left];
		while (left < right) {
			while (left < right && arr[right] >= temp) {
				right--;
			}
			arr[left] = arr[right];
			while (left < right && arr[left] <= temp) {
				left++;
			}
			arr[right] = arr[left];
		}
		arr[left] = temp;
		return left;
	}


	//堆排序
	public void heapSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) {
			adjustHeap(arr, i, n);
		}
		for (int j = n - 1; j >= 0; j--) {
			swap(arr, 0, j);
			adjustHeap(arr, 0, j);
		}
	}

	public void adjustHeap(int[] arr, int i, int length) {
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

	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	//归并排序
	public void mergeSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("the array is null!!");
		}
		mergeSortCore(arr, 0, arr.length - 1);
	}

	public void mergeSortCore(int[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2;
			mergeSortCore(arr, left, mid);
			mergeSortCore(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	public void merge(int[] arr, int left, int mid, int right) {
		int low = left, high = mid + 1;
		int[] temp = new int[right - left + 1];
		int k = 0;
		while (low <= mid && high <= right) {
			if (arr[low] < arr[high]) {
				temp[k++] = arr[low++];
			} else {
				temp[k++] = arr[high++];
			}
		}
		while (low <= mid) {
			temp[k++] = arr[low++];
		}
		while (high <= right) {
			temp[k++] = arr[high++];
		}
		k = 0;
		low = left;
		while (low <= right) {
			arr[low++] = temp[k++];
		}
	}

	public void preOrder2(TreeNode head) {
		if (head == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = head;
		stack.push(head);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			System.out.println(cur.val);
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}

	public void inOrder2(TreeNode head) {
		if (head == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode cur = head;
		stack.push(head);
		while (!stack.isEmpty()) {
			while (cur.left != null) {
				stack.push(cur.left);
				cur = cur.left;
			}
			cur = stack.pop();
			System.out.println(cur.val);
			if (cur.right != null) {
				stack.push(cur.right);
			}
		}
	}

	public void postOrder2(TreeNode head) {
		if (head == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		TreeNode cur = head;
		stack.push(head);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			stack2.push(cur);
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			}
		}

		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop().val);
		}
	}

	public int getTreeHeight(TreeNode head) {
		if (head == null) {
			return 0;
		}
		return 1 + Math.max(getTreeHeight(head.left), getTreeHeight(head.right));
	}

	//判断是否为平衡二叉树
	public boolean chkBalance(TreeNode head)  {
		if (head == null) {
			return false;
		}
		boolean[] isBanlance = {true};
		getHeight(head, 1, isBanlance);
		return isBanlance[0];
	}

	public int getHeight(TreeNode head, int level, boolean[] isBanlance) {
		if (head == null) {
			return level;
		}
		int lH = getHeight(head.left, level + 1, isBanlance);
		if (!isBanlance[0]) {
			return level;
		}
		int rH = getHeight(head.right, level + 1, isBanlance);
		if (!isBanlance[0]) {
			return level;
		}
		if (Math.abs(lH - rH) > 1) {
			isBanlance[0] = false;
		}
		return Math.max(lH, rH);
	}

	//判断是否为完全二叉树
	public boolean chkCompletion(TreeNode head) {

	}

}