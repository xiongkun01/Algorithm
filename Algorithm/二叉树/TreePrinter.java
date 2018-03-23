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
有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。

给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，
所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
*/
public class TreePrinter {
	
	//使用队列结构来实现层次遍历
    public int[][] printTree(TreeNode root) {
        // write code here
        if (root == null) {
            return null;
        }
        
        List<List<TreeNode>> result = new ArrayList<>();
		List<TreeNode> level = new ArrayList<>();
		List<TreeNode> queue = new LinkedList<>();

		TreeNode temp = root;
		TreeNode last = root;
		TreeNode nlast = null;
		
		queue.add(root);

		while (!queue.empty()) {
			temp = queue.poll();
			level.add(temp);

			if (temp.left != null) {
				queue.add(temp.left);
				nlast = temp.left;
			}

			if (temp.right != null) {
				queue.add(temp.right);
				nlast = temp.right;
			}

			if (temp == last) {
				last = nlast;
				result.add(level);
				level = new ArrayList<>();
			}
		}

		int[][] arr = new int[result.size()][];
		for (int i = 0; i < result.size(); i ++) {
			arr[i] = new int[result.get(i).size()];
			for (int j = 0; j < arr[i].length; j ++) {
				arr[i][j] = result.get(i).get(j).val;
			}
		}

		return arr;
    }

    public static void heapSort(int[] arr) {
    	if (arr == null || arr.length == 0) {
    		throw new IllegalArgumentException("The array is null!!");
    	}
    	int n = arr.length;
    	for (int i = n / 2 - 1; i >= 0; i--) {
    		adjustHeap(arr, i, n);
    	}
    	for (int j = n - 1; j >= 0; j--) {
    		swap(arr, 0, j);
    		adjustHeap(arr, 0, j);
    	}
    }

    public static void adjustHeap(int[] arr, int i, int length) {
    	int temp = arr[i];
    	for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
    		if (k + 1 < length && arr[k] < arr[k + 1]) {
    			k++;
    		}
    		if (arr[k] > temp) {
    			arr[i] = arr[k];
    			i = k;
    		} else {
    			break;
    		}
    	}
    	arr[i] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
    	int temp = arr[i];
    	int arr[i] = arr[j];
    	arr[j] = temp;
    }

    public static boolean halfSort(int[] arr, int key) {
    	if (arr == null || arr.length <= 0) {
    		throw new IllegalArgumentException("The arr is null");
    	}
    	int left = 0, right = arr.length - 1;
    	int mid;
    	while (left < right) {
    		mid = left + (right - left) / 2;
    		if (arr[mid] == key) {
    			return true;
    		} else if (arr[mid] > key) {
    			right = mid - 1;
    		} else {
    			left = mid + 1;
    		}
    	}
    	return false;
    }

    public static void quickSort(int[] arr) {
    	if (arr == null || arr.length <= 0) {
    		throw new IllegalArgumentException("The array is null!!");
    	}
    	quickSortCore(arr, 0, arr.length - 1);
    }

    public static void quickSortCore(int[] arr, int left, int right) {
    	if (left < right) {
    		int mid = partition(arr, left, right);
    		quickSortCore(arr, left, mid - 1);
    		quickSortCore(arr, mid + 1, right);
    	}
    }

    public static int partition(int[] arr, int left, int right) {
    	int temp = arr[left];
    	while (left < right) {
    		while (left < right && arr[right] >= temp) {
    			right--;
    		}
    		arr[left] = arr[right];
    		while (left < right && arr[left] <= temp) {
    			left++;
    		}
    		arr[right] = arr[left];
    	}
    	arr[left] = temp;
    	return left;
    }

    public static TreeNode hasCircle(TreeNode head) {
        if (head == null) {
            return null;
        }
        TreeNode slow = head;
        TreeNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void preOrder2(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = head;
        stack.push(head);
        while (!stack.isEmpty())
    }

    public static void inOrder2(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        TreeNode cur = head;
        stack.push(head);
        while (!stack.isEmpty()) {
            while (cur.left != null) {
                stack.push(cur.left);
                cur = cur.left;
            }
            cur = stack.pop();
            System.out.println(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
    }

    public static void postOrder2(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode cur = head;
        stack.push(head);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            stack2.push(cur);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val);
        }
    }
    
    public static void levelOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode cur = head;
        queue.offer(head);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }
    
    public static ArrayList<ArrayList<Integer>> levelOrder2(TreeNode head) {
        if (head == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        TreeNode cur = head, last = head, nLast = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            level.add(cur.val);
            if (cur.left != null) {
                nLast = cur.left;
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                nLast = cur.right;
                queue.offer(cur.right);
            }
            if (cur == last) {
                last = nLast;
                result.add(level);
                level = new ArrayList<Integer>();
            }
        }
        return result;
    }

    //求树的高度
    public int getHeight(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(head.left), getHeight(head.right));
    }

    //判断是否为平衡二叉树
    public boolean isBlance(TreeNode head) {
        if (head == null) {
            return false;
        }
        boolean[] result = new boolean[] {true};
        getHeight2(head, 1, result);
        return result[0];
    }

    public int getHeight2(TreeNode head, int level, boolean[] result) {
        if (head == null) {
            return level;
        }
        int lH = getHeight2(head.left, level + 1, result);
        if (!result[0]) {
            return level;
        }
        int rH = getHeight2(head.right, level + 1, result);
        if (!result[0]) {
            return level;
        }
        if (Math.abs(lH - rH) > 1) {
            result[0] = false;
        }
        return Math.max(lH, rH);
    }

    //判断是否为完全二叉树
    public boolean chkCompletion(TreeNode head) {
        if (head == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode cur = head;
        queue.push(head);
        boolean isLeaf = false;

        while (!queue.isEmpty()) {
            cur = queue.poll();
            while ((cur.left == null && cur.right != null)
                    || (isLeaf && (cur.left != null || cur.right != null))) {
                return false;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            } else {
                isLeaf = false;
            }
        }
        return true;
    }

    


}