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
从二叉树的节点A出发，可以向上或者向下走，但沿途的节点只能经过一次，
当到达节点B时，路径上的节点数叫作A到B的距离。对于给定的一棵二叉树，
求整棵树上节点间的最大距离。

给定一个二叉树的头结点root，请返回最大距离。保证点数大于等于2小于等于500.

求解：
一个以h为头的树上，最大距离只可能来自一下三种情况：
情况一：h的左子树上的最大距离。
情况二：h的右孩子上的最大距离。
情况三：h左子树上离h左孩子最远的距离，加上h自身这个节点，再加上
h右子树上离h右孩子的最远距离，也就是两个节点分别来自h两侧子树的情况。

所以三个值中最大的那个就是以h为头的整棵树上最远的距离。

注意：对于二叉树相关的题型，首先要想到三种遍历方式的改写，怎么去改写
递归过程，以及如何返回多个信息（可以通过使用全局变量的方式和返回数组的方式来实现）。
*/
public class LongestDistance {

    private int longestDis = 0;

    public int findLongest(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        } 
        
        int depth = findDist(root);
        return longestDis;
    }

    public int findDist(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = findDist(root.left);
        int right = findDist(root.right);

        longestDis = Math.max(left + right + 1, longestDis);
        return Math.max(left, right) + 1;
    }

    //获取树的深度
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.max(left, right) + 1;
    }
}