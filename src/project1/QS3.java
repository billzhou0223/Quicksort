package project1;

import java.util.*;

public class QS3 {
	   //private static long elapes;
	   private static long comparisons=0;
	   static Random random=new Random();
	   
	   public static void quicksort(int[] a){
		   quicksort(a,0,a.length-1);
	   }
	   
	   public static void quicksort(int[] a,int p,int r){
		   if (r <= p) return;
	       int q = medianPartition(a, p, r);
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
	   
	   public static int medianPartition(int[] a,int p,int r){
		   int pivot=medianOfMedians(a,p,r);
		   exch(a,pivot,r);
		   return partition(a,p,r);
	   }
	   
	   public static int randomizedPartition(int[] a,int p,int r){
		   int pivot=random.nextInt(r-p+1)+p;
		   exch(a,pivot,r);
		   return partition(a,p,r);
	   }
	   
	   public static int randomizedSelect(int[] a,int p,int r,int i){  
	        if(p==r){  
	            return p;  
	        }  
	        int q=randomizedPartition(a,p,r);  
	        int k=q-p+1;  
	        if(i==k){  
	            return q;  
	        }
	        else if(i<k){  
	            return randomizedSelect(a,p,q-1,i);  
	        }
	        else{  
	            return randomizedSelect(a,q+1,r,i-k);  
	        }  
	   }
	   
	   public static int medianOfMedians(int[] a,int p,int r){
		    int numMedians=(int)Math.ceil((r-p+1)/5.0);
		    for(int i=0;i<numMedians;i++){
		    	int subLeft=p+i*5;
		    	int subRight=subLeft+4;
		    	if(subRight>r) {subRight=r;}
		    	int medianInx=selectMedian(a,subLeft,subRight);
		    	exch(a,p+i,medianInx);
		    }
		    return randomizedSelect(a,p,(p+numMedians-1),(int)Math.ceil(numMedians/2.0));
	   }
	   
	   public static int selectMedian(int[] a,int p,int r){
		   for(int i=p;i<=(int)Math.floor((p+r)/2.0);i++){
			    for(int j=i+1;j<=r;j++){
			    	if(a[j]<a[i]){
			    		//comparisons++;
			    		exch(a,i,j);
			    	}
			    }
		   }
		   return (int)Math.floor((p+r)/2.0);
	   }
	   
	   public static void exch(int[] a, int i, int j) {
	       int swap = a[i];
	       a[i] = a[j];
	       a[j] = swap;
	   }
	   /**
	   public static void main(String[] args){
		   int[] a = new int[10000000];
		   for(int j=0;j<10000000;j++){
				a[j]=new Random().nextInt(10000000);
				//b[j]=a[j];
				//c[j]=a[j];
			}
		   quicksort(a);
		   for (int i = 0; i < a.length; i++)
				System.out.print(QS3.comparisons + " ");
	   }
	   **/
	   public static long getCmp(){
		   return comparisons;
	   }
}
