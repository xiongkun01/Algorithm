import java.util.*;

/*
请把纸条竖着放在桌子上，然后从纸条的下边向上对折，压出折痕后再展开。此时有1条折痕，
突起的方向指向纸条的背面，这条折痕叫做“下”折痕 ；突起的方向指向纸条正面的折痕叫做“上”折痕。
如果每次都从下边向上方对折，对折N次。请从上到下计算出所有折痕的方向。

给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
*/
public class FoldPaper {

    public String[] foldPaper(int n) {
        // write code here
        if (n <= 0) {
			return null;
        }

		List<String> list = new ArrayList<>();
		fold(1, n, true, list);

		String[] res = new String[list.size()];
		int i = 0;
		for (String str : list) {
			res[i++] = str;
		}
		return res;
    }
	
	//先右后中再左遍历，根节点为down
	public void fold(int i, int n, boolean down, List<String> list) {
		if (i > n) {
			return;
		}
		fold(i + 1, n, true, list);
		list.add(down == true ? "down" : "up");
		fold(i + 1, n, false, list);
	}
}