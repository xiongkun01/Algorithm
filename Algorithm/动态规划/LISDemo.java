import java.util.*;

public class LISDemo {
	
	public static int LIS(int[] A, int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		int result = 0;
		for (int i = 1; i < n; i ++) {
			int max = 0;
			for (int j = 0; j < i; j ++) {
				if (A[j] < A[i] && dp[j] > max) {
					max = dp[j];
				}
			}

			dp[i] = max + 1;
			result = Math.max(result, dp[i]);
		}
		return result;
	}

	public static ArrayList<Integer> LISDetail(int[] A, int n) {
		if (A == null || A.length == 0) {
			return null;
		}
		
		int[] b = new int[n];
        int[] b1 = new int[n];
        b[0] = 1;
        b1[0] = -1;
        int result = 1;
        int index = 0;
        for(int i = 1; i < n; i++) {
            int max = 0;
            boolean flag = false;
            for(int j = 0; j < i; j++) {
                if(A[j] < A[i] && b[j] > max) {
                    flag = true;
                    max = b[j];
                    b1[i] = j;
                }
            }
            if(flag == false) b1[i] = -1;
            b[i] = max + 1;
            if(result < b[i]) {
                result = b[i];
                index = i;
            }
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        //res.add(A[index]);
        while (index >=0) {
			res.add(A[index]);
            index = b1[index];
        }
        Collections.reverse(res);
        return res;
	}
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input the line number:");
		int n = scan.nextInt();

		System.out.println("Please input the array:");
		int[] A = new int[n];
		for (int i = 0; i< n; i ++) {
			A[i] = scan.nextInt();
		}

		ArrayList<Integer> result = LISDetail(A, n);

		System.out.println("The largest increasing subsequence is :" + result);
	}
}
