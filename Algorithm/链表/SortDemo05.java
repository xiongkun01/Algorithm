public class SortDemo05 {

	public static void main(String[] args) {

	}

	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || s.length() <= 0 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0, mi = 0;
		int[] next = getNextArray(ms);
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {
				si++;
				mi++;
			} else if (next[mi] == -1) {
				si++;
			} else {
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	public static int getNextArray(char[] ms) {
		if (ms.length == 1) {
			return next int[] {-1};
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2, cn = 0;
		while (pos < ms.length) {
			if (ms[pos - 1] == ms[cn]) {
				ms[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("The array is null");
		}
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i++) {
			adjustHeap(arr, i, n);
		}
		for (int j = n - 1; j >= 0; j++) {
			swap(arr, 0, j);
			adjustHeap(arr, 0, j);
		}
	}

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

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void preOrder(TreeNode head) {
		if (head == null) {
			return;
		}
		System.out.println(head.val);
		preOrder(head.left);
		preOrder(head.right);
	}

	public static void preOrder2(TreeNode head) {
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

	public static void inOrder(TreeNode head) {
		if (head == null) {
			return;
		}
		inOrder(head.left);
		System.out.println(head.val);
		inOrder(head.right);
	}

	public static void inOrder2(TreeNode head) {
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

	public static void postOrder(TreeNode head) {
		if (head == null) {
			return;
		}
		postOrder(head.left);
		postOrder(head.right);
		System.out.println(head.val);
	}

	public static void postOrder2(TreeNode head) {
		if (head == null) {
			return;
		}
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		TreeNode cur = head;
		stack1.push(head);
		while (!stack1.isEmpty()) {
			cur = stack1.pop();
			stack2.push(cur);
			if (cur.left != null) {
				stack1.push(cur.left);
			}
			if (cur.right != null) {
				stack1.push(cur.right);
			}
		}
		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop().val);
		}
	}

	//判断二叉树是否为平衡二叉树
	public static boolean isBalance(TreeNode head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}

	public static int getHeight(TreeNode head, int level, boolean[] res) {
		if (head == null) {
			return level;
		}
		int lH = getHeight(head.left, level + 1, res);
		if (!res[0]) {
			return level;
		}
		int rH = getHeight(head.right, level + 1, res);
		if (!res[0]) {
			return level;
		}
		if (Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}

}