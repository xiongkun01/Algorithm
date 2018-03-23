import java.util.*;

public class RadixSort {

	public static void radixSort(int[] A) {
		//Ê¹ÓÃMapÀ´µ±×öÍ°
		Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i <= 9; i ++) {
            map.put(i, new ArrayList<Integer>());
        }
        
		int max = A[0];        
        for (int i = 1; i < n; i ++) {
            if (max < A[i]) {
                max = A[i];
            }
        }
        //»ñÈ¡×î´óÊý×ÖµÄ³¤¶È
        int maxLength = String.valueOf(max).length();
        
        for (int i = 1; i <= maxLength; i ++) {
            for (int j = 0; j < n; j ++) {
                int digit = getDigit(A[j], i);
                map.get(digit).add(A[j]);
            }
            
            int t = 0;
            for (int k = 0; k <= 9; k ++) {
                int size = map.get(k).size();
                if (size != 0) {
                    for (Integer num : map.get(k)) {
                        A[t++] = num;
                    }
                    map.get(k).clear(); //½«Á´±íÇå¿Õ
                }
            }
        }
	}

	//»ñÈ¡Ò»¸öÊýµÄÏàÓ¦Î»ÖÃµÄÊý£¨d=1±íÊ¾¸öÎ»£©
    public int getDigit(int x, int d) {
        int result = 0;
        for (int i = 1; i <= d; i ++) {
            result = x % 10;
            x /= 10;
        }
        return result;
    }

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
