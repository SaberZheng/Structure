package ecut.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;
/**
 * 
 * 插入排序是将数组中无序数中依次和有序数进行比较，直到插入到正确的位置。
 * 需要n趟完成排序，比较次数最坏是1+2.....+(n-1)即n(n-1)/2 ~ n^2/2次,最好是n-1次比较。
 * 交换次数最坏是1+2.....+(n-1)即n(n-1)/2 ~ n^2/2次,最好是0次交换。时间复杂度是O(n^2)。
 */
public class InsertionSort {
	
	private static Scanner sc;

	/*@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			int k = i;
			for (int j = i - 1; j >= 0; j--) {
				if (less(a[k], a[j])) {
					exch(a, k, j);//k=i,j=i-1 ===> k=j+1
					k--;
				}else{
					break;
				}
			}
		}
	}*/
	
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i < N; i++) {
			for (int j = i - 1; j >= 0 && less(a[j + 1], a[j]); j--) {
				exch(a, j + 1, j);
			}
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
		/*Integer[] a={6,3,9,7,1,5};*/
	    sort(a);
        assert isSorted(a);
        show(a);
		
	}
}
