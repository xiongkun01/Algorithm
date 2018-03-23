import java.util.*;

public class StringProblem1 {

	public static String leftShifting(String s, int k) {
		char[] ch = s.toCharArray();
		k %= s.length();
		
		reverse(ch, 0, k -1);
		reverse(ch, k, s.length() -1);
		reverse(ch, 0, s.length() -1);

		return new String(ch, 0, ch.length);
	}

	public static void reverse(char[] ch, int m, int n) {
		int i = m, j = n;
		while (i < j) {
			char c = ch[i];
			ch[i++] = ch[j];
			ch[j--] = c;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input a String:");
		String str = scan.nextLine();

		System.out.println("Please input k:");
		int k = scan.nextInt();
		
		
		System.out.println(leftShifting(str, k));
	}
}
