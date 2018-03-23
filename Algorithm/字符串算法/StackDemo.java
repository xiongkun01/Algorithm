import java.util.Stack;

public class StackDemo {


	public void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);

		if (!s.empty()) {
			System.out.println("栈顶元素为：" + s.peek());

			int a = s.pop(); //将栈顶元素弹出

			int index = s.search(2); //返回对象在堆中的位置，以1开始

		} else {
			System.out.println("栈为空！");
		}
	}


}
