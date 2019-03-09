package ecut.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;
/**
 * 
 * 归并排序是将两个有序的数组合并到一个数组中。
 * 数组长度为n的数组，比较次数所形成的二叉树有n层，总节点数是N=2^n-1，n=lgN+1 ~ lgN,比较次数最坏是n*2^n次即NlgN,最好是1/2 NlgN次比较。
 * 时间复杂度是O(n log n) 
 */
public class MergeSort {
	
	private static Scanner sc;
	
	@SuppressWarnings("rawtypes")
	private static Comparable[] aux;
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi<=lo) return;
		int mid =lo+ (hi-lo)/2;
		sort(a,lo,mid);
		sort(a,mid+1,hi);
		merge(a,lo,mid,hi);
	}
	
	@SuppressWarnings("rawtypes")
	public static void merge(Comparable[] a,int lo, int mid,int hi){
		int i=lo;
		int j=mid+1;
		for(int k=lo;k<=hi;k++){
			aux[k]=a[k];
		}
		for (int k = lo; k <= hi; k++) {
			if (i > mid) 
				a[k] = aux[j++];
			else if(j>hi)
				a[k] = aux[i++];
			else if(less(aux[j],aux[i]))
				a[k]=aux[j++];
			else
				a[k]=aux[i++];
			
		}
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
