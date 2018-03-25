public class Trie {

	class TrieNode {
		public int path;
		public int end;
		public TrieNode[] map;

		public TrieNode() {
			path = 0;
			end = 0;
			map = new TrieNode[26];
		}
	}

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		if (word == null) {
			return;
		}
		char[] chs = word.toCharArray();
		TrieNode node = root;
		int index = 0;
		for (int i = 0; i < chs.length; i++) {
			index = chs[i] - 'a';
			if (node.map[index] == null) {
				node.map[index] = new TrieNode();
			}
			node = node.map[index];
			node.path++;
		}
		node.end++;
	}

	public void delete(String word) {
		if (search(word)) {
			char[] chs = word.toCharArray();
			TrieNode node = root;
			int index = 0;
			for (int i = 0; i < chs.length; i++) {
				index = chas[i] - 'a';
				if (node.map[index].path == 1) {
					node.map[index].path--;
					node.map[index] = null;
					return;
				}
				node = node.map[index];
			}
			node.end--;
		}
	}

	public boolean search(String word) {
		if (word == null) {
			return false;
		}
		char[] chs = word.toCharArray();
		TrieNode node = root;
		int index = 0;
		for (int i = 0; i < chs.length; i++) {
			index = chs[i] - 'a';
			if (node.map[index] == null) {
				return false;
			}
			node = node.map[index];
		}
		return node.end != 0;
	}

	public int prefixNumber(String pre) {
		if (word == null) {
			return 0;
		}
		char[] chs = pre.toCharArray();
		TrieNode node = root;
		int index = 0;
		for (int i = 0; i < chs.length; i++) {
			index = chs[i] - 'a';
			if (node.map[index] == null) {
				return 0;
			}
			node = node.map[index];
		}
		return node.path;
	}

	public void printPrime(int n) {
		if (n < 2) {
			return;
		}
		if (n == 2) {
			System.out.print(2 + " ");
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					break;
				}
			}
			if (j > Math.sqrt(i)) {
				System.out.print(i + " ");
			}
		}
	}


	public int f(int n) {
		if (n == 1) {
			return 1;
		}
		return n * f(n - 1);
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode cur = head, nextNode = head.next, pre = newHead;
		while (cur != null) {
			nextNode = cur.next;
			newHead.next = nextNode;
			cur.next = pre;
			pre = cur;
			cur = nextNode;
		}
		head.next = null;
		return pre;
	}

	public int lowerBound(int[] arr, int key) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException("The Array is Null");
		}
		if (key > arr[arr.length - 1]) {
			return arr.length - 1;
		}
		int left = 0, right = arr.length - 1, mid;
		int pos = 0;
		while (left < right) {
			mid = left + (right - left) / 2;
			if (arr[mid] < key) {
				fisrt = mid + 1;
				pos = first;
			} else {
				right = mid;
				pos = right;
			}
		}
		return pos;
	}
}