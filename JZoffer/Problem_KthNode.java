public class Problem_KthNode {

	private int index = 0;
	private TreeNode node = null;

	public TreeNode KthNode(TreeNode root, int k) {
		if (root == null || k < 0) {	
			return null;
		}
		inOrder(root, k);
		return node;
	}

	public void inOrder(TreeNode root, int k) {
		if (root == null) {
			return;
		}
		inOrder(root.left, k);
		index++;
		if (index == k) {
			node = root;
			return;
		}
		inOrder(root.right, k);
	}

}