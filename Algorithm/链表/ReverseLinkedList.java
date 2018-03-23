class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }
 
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = null;

        ListNode newHead = reverseBetween(head, 1, 2);
        // System.out.println(newHead.val);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m > n || m == n) {
            return head;
        }
        
        int count = 1;
        ListNode cur = head;
         //左边链表的结尾部分
        ListNode left = null;
        while (count < m) {
            count ++;
            left = cur;
            cur = cur.next;
        }
       
        //中间链表的开始部分
        ListNode start = cur;
        cur = start.next;
        count = m + 1;
        ListNode q = null;
        ListNode pre = start;
        while (count <= n) {
            q = cur.next;
            cur.next = pre;
            pre = cur;
            cur = q;
            count ++;
        }
        
        ListNode right = cur;
        if (m == 1) {
            start.next = right;
            return pre;
        } else {
        	left.next = pre;
        	start.next = right;
            return head;
        }
        
    }
    
    
    
    
    
    
    
    
}






