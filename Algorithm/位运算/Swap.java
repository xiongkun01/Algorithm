import java.util.*;

/*
请编写一个算法，不用任何额外变量交换两个整数的值。

给定一个数组num，其中包含两个值，请不用任何额外变量交换这两个值，并将交换后的数组返回。
a = a ^ b; //a异或b
b = a ^ b;
a = a ^ b;
*/
public class Swap {
    public int[] getSwap(int[] num) {
        // write code here
        if (num == null) {
            return null;
        }
        
		num[0] = num[0] ^ num[1];
		num[1] = num[0] ^ num[1];
		num[0] = num[0] ^ num[1];
		return num;
    }
}