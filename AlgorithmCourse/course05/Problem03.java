/*
在本题中，单链表可能有环，也可能无环。
给定两个单链表的头结点head1和head2，这两个链表可能相交，也可能不相交。
请实现一个函数，如果两个链表相交，请返回相交的第一个节点；如果不相交，
返回null即可。
要求：如果链表1的长度为N，链表2的长度为M，时间复杂度请达到O(N+M),
额外空间复杂度请达到O(1)
*/
public class Problem03 {

	class Node {
		public int value;
		public Node next;
		public Node(int value) {
			this.value = value;
		}
	}

	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}

		Node slow = head.next;
		Node fast = head.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return slow;
		}
		return null;
	}

	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}

		Node cur1 = head1;
		Node cur2 = head2;
		int length1 = 0;
		int length2 = 0;
		while (cur1.next != null) {
			cur1 = cur1.next;
			length1++;
		}
		length1++;

		while (cur2.next != null) {
			cur2 = cur2.next;
			length2++;
		}
		length2++;

		if (cur1 != cur2) {
			return null;
		}

		Node loopNode1 = getLoopNode(head1);
		Node loopNode2 = getLoopNode(head2);
		//一个有环，一个无环
		if ((loopNode1 == null && loopNode2 != null) || (loopNode1 != null && loopNode2 == null)) {
			return null;
		}
		//两个都无环
		if (loopNode1 == null && loopNode2 == null) {
			if (length1 > length2) {
				cur1 = head1;
				cur2 = head2;
			} else {
				cur1 = head2;
				cur2 = head1;
			}
			int k = Math.abs(length1 - length2);
			while (k != 0) {
				cur1 = cur1.next;
				k--;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			reurn cur1;
		}
		//两个都有环
		if (loopNode1 == loopNode2) {

		} else {

		}

	}

	public static void main(String[] args) {

	}

}