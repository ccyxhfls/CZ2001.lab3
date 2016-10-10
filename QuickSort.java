package lab3;

import java.lang.management.*;

public class QuickSort {
	
	private static int ARRAYSIZE;
	public static int[] ranArray = {1,2,3,4};
	public static int counter = 0;
	
	public static void main(String[] args){
		ARRAYSIZE = ranArray.length;
		System.out.println("DEBUG: BEFORE");
		printArray();
		
		
		long start = getCpuTime();
		quicksort(0, ARRAYSIZE-1);
		long exeTime = getCpuTime() - start;
		
		System.out.println("DEBUG: AFTER");
		printArray();
		
		System.out.println("counter " + counter);
		System.out.println("exeTime " + exeTime);
		
		
		
	}
	
	public static long getCpuTime( ) {
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
	    return bean.isCurrentThreadCpuTimeSupported( ) ?
	        bean.getCurrentThreadCpuTime( ) : 0L;
	}
	
	public static void quicksort(int n, int m){
		int pivot_pos;
		if( n >= m){
			return;
		}
		pivot_pos = partition (n,m);
		//printArray();
		quicksort(n, pivot_pos -1);
		quicksort(pivot_pos+1, m);
	}
	
	public static int partition (int low, int high){
		int i, last_small, pivot;
		int mid = (low+high) /2;
		swap (low, mid);
		pivot = ranArray[low];
		last_small = low;
		
		for (i = low+1; i <= high; i++){
			counter ++;
			if (ranArray[i] < pivot){
				swap(++last_small, i);
			}
		}
		swap (low, last_small);
		
		return last_small;
	}
	
	public static void swap(int a, int b){
		int temp = ranArray[a];
		ranArray[a] = ranArray[b];
		ranArray[b] = temp;
	}
	
	
	public static void printArray(){
		for (int i = 0; i< ARRAYSIZE; i++)
			System.out.print(ranArray[i] + " ");
		System.out.println();
	}
}
