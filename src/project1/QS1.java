package project1;
import java.util.*;

public class QS1 {
   //private static long elapes;
   private static long comparisons=0;
   
   public static void quicksort(int[] a){
	   quicksort(a,0,a.length-1);
   }
   
   public static void quicksort(int[] a,int p,int r){
	   if (r <= p) return;
       int q = partition(a, p, r);
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
   
   public static void exch(int[] a, int i, int j) {
       int swap = a[i];
       a[i] = a[j];
       a[j] = swap;
   }
   
   public static void main(String[] args){
	   int[] arr = new int[100000000];
	   Random random=new Random();

		for (int i = 0; i < arr.length; i++){
			arr[i]=random.nextInt(100000000);
   }
       quicksort(arr);
       System.out.print(QS1.getCmp());
   }
   
   public static long getCmp(){
	   return comparisons;
   }
}
