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
一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，使得这棵二叉树不再是搜索二叉树，
请找到这两个错误节点并返回他们的值。保证二叉树中结点的值各不相同。

给定一棵树的根结点，请返回两个调换了位置的值，其中小的值在前。

求解：
1、如果对二叉树进行中序遍历，依次出现的节点会一直升序，如果两个节点值错了，会出现降序。
2、如果在中序遍历时节点值出现了两次降序，第一个错误的节点为第一次降序时较大的节点，第二个
错误的节点为第二次降序时较小的节点。
3、如果在中序遍历时节点值只出现了一次降序，第一个错误的节点为这次降序时较大的节点，第二个
错误的节点为这次降序时较小的节点。

4、所以第一个错误的节点为第一次降序时较大的节点，第二个错误的节点为最后一次降序时较小的节点。
5、依然是改写一个基本的二叉树中序遍历。
*/
public class FindErrorNode {
    public int[] findError(TreeNode root) {
        // write code here
        if (root == null) {
            return null;
        }
        
        List<Integer> list = inOrderRecur(root);
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            arr[i] = list.get(i);
        }

        int[] res = new int[2];
        for (int i = 1; i < arr.length; i ++) {
            if (arr[i - 1] > arr[i]) {
                res[1] = arr[i - 1];
                break;
            }
        }

        for (int i = arr.length - 1; i > 0; i --) {
            if (arr[i - 1] > arr[i]) {
                res[0] = arr[i];
                break;
            }
        }
        return res;
    }
    
    
    public List<Integer> inOrderRecur(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (cur != null) {
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
    
}