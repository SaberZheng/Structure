package ecut.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
/**
 * 
 * 快速排序是将数组切分使左侧小于a[j],右侧大于a[j]。
 * 时间复杂度是O(n log n) 
 * 
 */
public class QuickSort {
	
	private static Scanner sc;
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);//清楚对输入的依赖
		sort(a,0,a.length-1);
	}
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;
		int j=partition(a,lo,hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
		
		
	}
	
	@SuppressWarnings("rawtypes")
	public static int partition(Comparable[] a,int lo,int hi){
		Comparable v = a[0];
		int i = lo;
		int j = hi+1;
		while(true){
			while(less(a[++i],v)){
				if(i==hi){
					break;
				}
			}
			while(less(v,a[--j])){
				if(j==lo){
					break;
				}
			}
			if(i>=j){
				break;
			}
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean less(Comparable v, Comparable w) {
		// v.compareTo(w):v<w 返回负整数 v=w 返回0 v>w 返回正整数
		return v.compareTo(w) < 0;
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
