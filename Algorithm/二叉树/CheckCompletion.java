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
有一棵二叉树,请设计一个算法判断它是否是完全二叉树。

给定二叉树的根结点root，请返回一个bool值代表它是否为完全二叉树。树的结点个数小于等于500。
*/
public class CheckCompletion {
    public boolean chk(TreeNode root) {
        // write code here
		if (root == null) {
			return false;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode cur = root;
		queue.offer(cur);
		
		boolean leaf = false;

		while (!queue.isEmpty()) {
			cur = queue.poll();
            //如果该节点只有右孩子没有左孩子，或者该节点应该为叶子节点，但是依旧有左孩子或右孩子
			if ((cur.left == null && cur.right != null) || (leaf && (cur.left != null || cur.right != null))) {
				return false;
			} 
			
			if (cur.left != null) {
				queue.offer(cur.left);
			}

			if (cur.right != null) { 
				queue.offer(cur.right);
			} else  { //若该节点没有右孩子，则剩下的节点都应该是叶子节点
				leaf = true;
			}
		}
		return true;
    }
    
    
}