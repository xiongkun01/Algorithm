class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

/*有一个整数val，如何在节点值有序的环形链表中插入一个节点值为val的节点，并且保证这个环形单链表依然有序。

给定链表的信息，及元素的值A及对应的nxt指向的元素编号同时给定val，请构造出这个环形链表，并插入该值。

测试样例：
[1,3,4,5,7],[1,2,3,4,0],2
返回：{1,2,3,4,5,7}
*/
public class InsertValue {
	
	public static void main(String[] args) {
		int[] A = new int[] {4, 8, 9};
		int[] nxt = new int[] {1, 2, 0};
		int val = 4;
		ListNode head = insert(A, nxt, val);
		
		ListNode p = head;
		
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}
	

    public static ListNode insert(int[] A, int[] nxt, int val) {
        // write code here
        if (A == null || nxt == null) {
            return null;
        }
        
        //根据数组A构造环形链表
		int len = A.length;
        ListNode head = new ListNode(A[nxt[len - 1]]);
        ListNode p = head;
        ListNode q = head;
        
        //当链表只有一个节点时
        if (len == 1) { 
            ListNode node = new ListNode(val);
            head.next = node;
            node.next = head;
            if (A[0] >= val) {
                return node;
            } else {
                return head;
            }
            
        } else {
            for (int i = 0; i < len - 1; i ++) {
                q.next = new ListNode(A[nxt[i]]);
                q = q.next;
            }
            q.next = null;
        }
        
        ListNode tail = q;
        ListNode node = new ListNode(val);
        if (head.val >= val) {
			System.out.println("******************");
			
            node.next = head;
            //tail.next = node;
            return node;
        }
        
       
        p = q = head;
        while (q != null) {
            if (q.val < val) {
                p = q;
                q = q.next;
            } else {
				
                p.next = node;
                node.next = q;
                //tail.next = head;
                return head;
            }
        }
        
        p.next = node;
        //node.next = head;
        return head;
    }
    
    
    
    
}