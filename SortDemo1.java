public class SortDemo1 {

	//1、插入排序----直接插入排序
	public static void insertSort(int[] a, int n) {
		for (int i = 1; i < n; i ++)
		{
			if (a[i] < a[i - 1])
			{
				int j = i - 1;
				int x = a[i];
				while (x < a[j])
				{
					a[j + 1] = a[j];
					j --;
				}

				a[j + 1] = x;
			}
		}
	}

	
	public static void shellInsertSort(int[] a, int n, int dk) {
		
		
	}

	public static void main(String[] args) {

		int[] a = new int[] {1, 5, 3, 2, 6, 4};
		insertSort(a, a.length);

		for (int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " ");
		}
		
	}
}
