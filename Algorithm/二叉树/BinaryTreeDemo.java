import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeDemo {
	
	public static void preOrderRecur(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		preOrderRecur(root.left);
		preOrderRecur(root.right);
	}
	
	//递归方式实现先序遍历
	public static void preOrderRecur(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.println(root.val);
		preOrderRecur(root.left);
		preOrderRecur(root.left);
	}
	
	//以非递归的方式实现先序遍历
	public static List<Integer> void preOrderRecur2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		stack.push(root);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			list.add(cur.val);

			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		return list;
	}
	
	//递归方式实现中序遍历
	public static void inOrderRecur(TreeNode root) {
		if (root == null) {
			return;
		}
		inOrderRecur(root.left);
		System.out.println(root.val);
		inOrderRecur(root.right);
	}
	
	//以非递归方式实现中序遍历
	public static List<Integer> inOrderRecur2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		stack.push(root);

		while (!stack.isEmpty()) {
			while (cur.left != null) {
				cur = cur.left;
				if (cur != null) {
					stack.push(cur);
				}
			}

			cur = stack.pop();
			list.add(cur.val);
			if (cur.right != null) {
				stack.push(cur.right);
			}
		}
		
		return list;
	}
	
	//递归方式实现后序遍历
	public static void postOrderRecur(TreeNode root) {
		if (root == null) {
			return;
		}
		postOrderRecur(root.left);
		postOrderRecur(root.right);
		System.our.println(root.val);
	}
	
	//以非递归方式实现后序遍历
	public static List<Integer> postOrderRecur2(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>(); 

		TreeNode cur = root;
		stack1.push(root);
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
			list.add(stack2.pop().val);
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
