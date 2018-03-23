package com.xk.testdemo;

public class  TestDemo21 {
	public static void main(String[] args) 
	{
		int[] a = new int[] {2, 8, 1, 5, 6};
		int n = a.length;
		for (int i = 0; i < n - 1; i ++) {
			for (int j = 0; j < n - i - 1; j ++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
				
			}
		}

		for (int i = 0; i < n; i ++) {
			System.out.print(a[i] + "  ");
		}
		
	}
}
