public class  SortDemo2 {


	public static int selectMinKey(int[] a, int n, int i) {
		int k = i;
		for (int j = i + 1; j < n; j ++) {
			if (a[k] > a[j]) {
				k = j;
			}
		}
		return k;
	}
	

	//3、选择排序----简单选择排序
	public static void selectSort(int[] a, int n) {
		int key, tmp;
		for (int i = 0; i < n; i ++)
		{
			key = selectMinKey(a, n, i);
			if (key != i)
			{
				tmp = a[i];
				a[i] = a[key];
				a[key] = tmp;
			}
		}
	}

	//简单选择排序的改进-----二元选择排序
	public static void selectSort2(int[] a, int n) {
		int min, max, tmp;
		for (int i = 0; i <= n / 2; i ++)
		{
			min = i;
			max = n - i - 1;
			for (int j = i + 1; j < n - i; j ++)
			{
				if (a[j] > a[max])
				{
					max = j;
					continue;
				}

				if (a[j] < a[min])
				{
					min = j;
				}
			}

			tmp = a[i]; a[i] = a[min]; a[min] = tmp;
			tmp = a[n - i - 1]; a[n - i - 1] = a[max]; a[max] = tmp;
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] {3, 5, 3, 2, 6, 4};
		selectSort2(a, a.length);

		for (int i = 0; i < a.length; i ++) {
			System.out.print(a[i] + " ");
		}
	}
}
