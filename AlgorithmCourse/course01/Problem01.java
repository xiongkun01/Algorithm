/*
1、已知一个字符串都是由左括号(和右括号)组成，判断该字符串是否是有效的括号组合。

例子：
有效的括号组合:()(),(()),(()())
无效的括号组合:(,()),((),()(()


2、题目进阶：
已知一个字符串都是由左括号(和右括号)组成，返回最长有效括号子串的长度。

*/
public class Problem01 {
	
	public static boolean isValid(String str) {
		if (str == null || str.equals("")) {
			return false;
		}

		int num = 0;
		char[] arr = str.toCharArray();
		for (int i = 0; i < arr.length; i ++) {
			if (arr[i] != '(' && arr[i] != ')') {
				return false;
			}
			
			if (arr[i] == '(') {
				num ++;
			} else if (arr[i] == ')') {
				num --;
			}
		}

		return num == 0;	
	}

	

}