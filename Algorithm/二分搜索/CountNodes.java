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
给定一棵完全二叉树的根节点root，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。

给定树的根结点root，请返回树的大小。
*/
public class CountNodes {
    public int count(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        //1、先找到完全二叉树的左子树最左边节点的层数。然后再找出右子树的左节点能到达的层数
		//2、看左右子树的左节点能到达的层数相等，则左子树必定是一颗满二叉树。那使用满二叉树的性质求出左子树的节点数，
		//右子树的节点数使用递归方式求出。 
		//3、如果左右子树的左节点能到达的层数不相等，则右子树必定是一颗少一层的满二叉树。然后左子树使用递归的方法求出节点数。
        return bs(node, 1, mostLeftLevel(root, 1));
    }
    
	//start表示从头节点开始位置，height表示左子树左节点能到达的层数
	public int bs(TreeNode node, int start, int height) {
		if (start == height) {
			return 1;//只有一个头结点
		}
		//说明左子树是一颗满二叉树:start+1是因为右子树没包含根节点
		if (mostLeftLevel(node.right, start + 1) == height) {
			return (1 << (height - start)) + bs(node.right, start + 1, height);
		} else { //说明右子树是比层数少一的满二叉树
			return (1 << (height - start - 1)) + bs(node.left, start+ 1, height);
		}
	}

	public int mostLeftLevel(TreeNode node, int level) {
		while (node != null) {
			level ++; //包括了头结点
			node = node.left;
		}
		return level - 1;
	}
    
    
}