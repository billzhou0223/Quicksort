package project1;
import java.util.*;

public class QS2 {
	   //private static long elapes;
	   private static long comparisons=0;
	   static Random random=new Random();
	   
	   public static void quicksort(int[] a){
		   quicksort(a,0,a.length-1);
	   }
	   
	   public static void quicksort(int[] a,int p,int r){
		   if (r <= p) return;
	       int q = randomizedPartition(a, p, r);
	       quicksort(a, p, q-1);
	       quicksort(a, q+1, r);
	   }
	   
	   public static int partition(int[] a,int p,int r){
		   int x=a[r];
		   int i=p-1;
		   for(int j=p;j<r;j++){
			   if(a[j]<=x){
				   comparisons++;
				   i=i+1;
				   exch(a,i,j);
			   }
		   }
		   exch(a,i+1,r);
		   return i+1;
	   }
	   
	   public static int randomizedPartition(int[] a,int p,int r){
		   int pivot=random.nextInt(r-p+1)+p;
		   exch(a,pivot,r);
		   return partition(a,p,r);
	   }
	   
	   public static void exch(int[] a, int i, int j) {
	       int swap = a[i];
	       a[i] = a[j];
	       a[j] = swap;
	   }
	   
	   public static void main(String[] args){
		   int[] arr = { 1, 3, 2, 4, 6, 5, 8, 7, 9, 0, 12, 11, 10, 15, 13 };
			quicksort(arr);

			for (int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
	   }
	   
	   public static long getCmp(){
		   return comparisons;
	   }
}
