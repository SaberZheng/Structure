package ecut.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;
/**
 * 
 * 选择排序是依次选择数组中无序数中最小的和对应的数交换位置，最小的数和a[0]交换，第二小的和a[1]交换，以此类推。
 * 需要n-1趟完成排序，比较次数是1+2.....+(n-1)即n(n-1)/2 ~  n^2/2次，n-1次交换，时间复杂度是O(n^2)
 *
 */
public class SelectionSort {
	
	private static Scanner sc;

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N - 1; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean less(Comparable v, Comparable w) {

		// v.compareTo(w):v<w 返回负整数 v=w 返回0 v>w 返回正整数
		return v.compareTo(w) < 0;
	}

	@SuppressWarnings("rawtypes")
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	@SuppressWarnings("rawtypes")
	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	@SuppressWarnings("rawtypes")
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String[] a = null;
		List<String> list = new ArrayList<String>();
		while(sc.hasNextLine()){
			list.add(sc.nextLine());
		}
		a=list.toArray(new String[0]);
	    sort(a);
        assert isSorted(a);
        show(a);
		
	}
}
