import java.util.*;

class Huffman {
	public Huffman parent;
	public Huffman left;
	public Huffman right;
	int weight;
}


public class HuffmanCoding {
	
	//返回每个字符出现的词频数
	public static Map<Character, Integer> wordFrequency(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i ++) {
			if (!map.containsKey(ch[i])) {
				map.put(ch[i], 1);
			} else {
				map.put(ch[i], map.get(ch[i]) + 1);
			}
		}
		return map;
	}
	
	//该算法寻找一个数组中最小的2数，假设数组长度大于2
	public static int[] topTwoMin(Huffman[] huffTree, int start, int end) {
		int[] res = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
		int[] index = new int[2];
		for (int i = start; i < end; i ++) {
			if (huffTree[i].parent == null && huffTree[i].weight < res[0]) {
				res[1] = res[0];
				res[0] = huffTree[i].weight;
				index[1] = index[0];
				index[0] = i;
			} else if (huffTree[i].parent == null && huffTree[i].weight < res[1]) {
				res[1] = huffTree[i].weight;
				index[1] = i;
			}
		}
		return index;
	}

	public static ArrayList<String> huff(String s) {
		ArrayList<String> list = new ArrayList<String>();
		Map<Character, Integer> map = wordFrequency(s);
		Huffman[] huffTree = new Huffman[2 * map.size() - 1]; //用数组模拟霍夫曼树
		for (int i = 0; i < huffTree.length; i ++) {
			huffTree[i] = new Huffman();
		}

		Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
		int i = 0;
		while (iterator.hasNext()) {
			Map.Entry entry = (Map.Entry) iterator.next();
			huffTree[i].weight = (int) entry.getValue();
			i ++;
		}

		//建树
		int len = map.size();
		for (int j = len; j < huffTree.length; j ++) {
			int[] mins = topTwoMin(huffTree, 0, len);
			huffTree[j].weight = huffTree[mins[0]].weight + huffTree[mins[1]].weight;
			huffTree[j].left = huffTree[mins[0]];
			huffTree[j].right = huffTree[mins[1]];

			huffTree[mins[0]].parent = huffTree[j];
			huffTree[mins[1]].parent = huffTree[j];
			len ++;
		}

		//编码
		for (int j = 0; j < map.size(); j ++) {
			Huffman temp = huffTree[j];
			StringBuilder sb = new StringBuilder();

			while (temp.parent != null) {
				if (temp.parent.left == temp) {
					sb.append("0");
				} else {
					sb.append("1");
				}
				
				temp = temp.parent;
			}

			list.add(sb.toString());
		}

		return list;
	}

	public static void main(String[] args) {
		String s = "aadabcbacdaebdebcdbebdacaedaacaebcaaaaa";

        System.out.println(huff(s));
	}
}
