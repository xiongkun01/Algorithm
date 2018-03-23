import java.util.*;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


public class Palindrome {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(1);

		head.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		System.out.println(isPalindrome(head));
	}

    public static boolean isPalindrome(ListNode pHead) {
        // write code here
        if (pHead == null || pHead.next == null) {
            return false;
        }
        
        ListNode left = pHead;
        ListNode right = pHead;
        //找到中间节点
        while (right.next != null && right.next.next != null) {
            left = left.next;
            right = right.next.next;
        }
        
        right = left.next; //右边的第一个节点
        left.next = null;
        
        ListNode pre = null;
        ListNode cur = right;
        ListNode q = null;
        while (cur != null) { //将右边部分反转
            q = cur.next;
            cur.next = pre;
            pre = cur;
            cur = q;
        }
        
		boolean res = true;
        ListNode rightTail = pre; //右边部分的尾节点
        ListNode leftHead = pHead;
        //开始比较两边部分的值是否相等
        while (leftHead != null && rightTail != null) {
            if (leftHead.val != rightTail.val) {
                res = false;
				break;
            } else {
                leftHead = leftHead.next;
                rightTail = rightTail.next;
            }
        }
        
        //将右边部分恢复
        cur = pre;
		pre = null;
        while (cur != null) {
            q = cur.next;
            cur.next = pre;
            pre = cur;
            cur = q;
        }
        left.next = pre;
        
        return res;
    }
    
    
    
}