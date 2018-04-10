public class MaxDistance {

	//二叉树节点间的最大距离
	public int maxDistance(Node head) {
		int[] record = new int[1];
		return posOrder(head, record);
	}

	//后序遍历
	public int posOrder(Node head, int[] record) {
		if (head == null) {
			record[0] = 0;
			return 0;
		}
		int lMax = posOrder(head.left, record);
		int maxfromLeft = record[0];
		int rMax = posOrder(head.right, record);
		int maxfromRight = record[0];
		int curNodeMax = maxfromLeft + maxfromRight + 1;
		//表示h树上距离h最远的距离
		record[0] = Math.max(maxfromLeft, maxfromRight) + 1;
		return Math.max(Math.max(lMax, rMax), curNodeMax);
	}

}