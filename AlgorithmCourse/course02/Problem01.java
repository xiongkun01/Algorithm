import java.util.*;

/*
将一个栈依次压人1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。
将这个栈转置后，从栈顶到栈底为1、2、3、4、5，也就是实现栈中元素的逆序，
但是只能使用递归函数来实现，不能使用其他数据结构。
*/
public class Problem01 {
	
	//移除栈底元素并返回
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}

		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}

	
}