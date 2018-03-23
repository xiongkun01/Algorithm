import java.util.*;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class KInverse {
	
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode cur = head;
		for (int i = 1; i < 8; i ++) {
			cur.next = new ListNode(i);
			cur = cur.next;
		}

		ListNode newHead = inverse(head, 2);
		cur = newHead;
		for (int i = 0; i < 8; i ++) {
			System.out.println(cur.val);
			cur = cur.next;
		}
	}

    public static ListNode inverse(ListNode head, int k) {
        // write code here
        if (head == null) {
            return null;
        }
        
        if (k < 2) { //若k<2，直接返回head
            return head;
        }
        
        int count = 0; //结点的总数
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            count ++;
            cur = cur.next;
        }
        
        //如果结点个数小于k，则直接返回head
        if (count < k) {
            return head;
        }
        
        ListNode newHead = null;
        ListNode newTail = null;
        pre = cur = head;
        Stack<ListNode> stack = new Stack<ListNode>();
        int n = count / k; //总共有几个逆序操作
        for (int i = 0; i < n; i ++) {
            int j = 0;
            while (j < k) {
                stack.push(cur);
            	cur = cur.next;
                j ++;
            }
            
            //出栈
            while (j > 0) {
                if (i == 0) {
                    if (newHead == null) {
                        newHead = newTail = stack.pop();
                    } else {
                        newTail.next = stack.pop();
                        newTail = newTail.next;
                    }
                } else {
                    newTail.next = stack.pop();
                    newTail = newTail.next;
                }
                newTail.next = null;
                j --;
            }
        }
        
        int restNum = count % k; //剩下的结点数
        if (restNum > 0) {
            newTail.next = cur;
        }
        
        return newHead;
    }
    
    
    
    
    
}