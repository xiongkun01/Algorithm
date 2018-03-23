import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

/*
首先我们介绍二叉树先序序列化的方式，假设序列化的结果字符串为str，初始时str等于空字符串。
先序遍历二叉树，如果遇到空节点，就在str的末尾加上“#!”，“#”表示这个节点为空，节点值不存在，
当然你也可以用其他的特殊字符，“!”表示一个值的结束。如果遇到不为空的节点，假设节点值为3，
就在str的末尾加上“3!”。

现在请你实现树的先序序列化。
给定树的根结点root，请返回二叉树序列化后的字符串。
*/
public class TreeToString {
    public String toString(TreeNode root) {
        // write code here	
        if (root == null) {
            return null;
        }
        
        return SerialByte(root);
    }
	
	//以递归的方式实现序列化
	public String SerialByte(TreeNode root) {
		if (root == null) {
			return "#!";
		}
		String res = root.val + "!";
		res += SerialByte(root.left);
		res += SerialByte(root.right);
		return res;
	}

	public Node reconByPreString(String preStr) {
		String[] values = preStr.split("!");
		//Queue是Collection的子类，List的实现类有ArrayList,LinkedList（实现了Queue）,Vector;然后Vector的子类为Stack
		Queue<String> queue = new LinkedList<>(); 
		for (int i = 0; i < values.length; i ++) {
			queue.offer(values[i]);
		}
		return reconPreOrder(queue);
	}
    
	public TreeNode reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		TreeNode head = new TreeNode(Integer.valueOf(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}
    
    
}