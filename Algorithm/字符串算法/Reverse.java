public class Reverse {

	//对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。

    //给定一个原字符串A和他的长度，请返回逆序后的字符串。
	
	public static void main(String[] args) {
		String A = "dog loves pig";
		String B = reverseSentence(A, A.length());

		System.out.println(B);
	}

    public static String reverseSentence(String A, int n) {
        // write code here
        if (A == null || n == 0) {
            return null;
        }
        char[] arr = A.toCharArray();
        //首先全部逆序
        reverse(arr, 0, n - 1);
        
        int l = 0;
        int r = 0;
        while (r < n && l < n) {
            while (l < n && arr[l] == ' ') {
                l ++;
            }
            r = l;
            while (r < n && arr[r] != ' ') {
                r ++;
            }
            
            if (l != r) {
                reverse(arr, l, r - 1);
                l = r;
            }
        }
        return new String(arr);
    }
    
    public static void reverse(char[] arr, int start, int end) {
        char temp = 0;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++;
            end --;
        }
    }
}