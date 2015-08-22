package project1;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		Random random=new Random();
		System.out.println("           "+"comparisons"+"        "+"total time");
		for(int i=100000;i<=100000000;i=i*10){
			int[] a=new int[i];
			int[] b=new int[i];
			int[] c=new int[i];
			for(int j=0;j<i;j++){
				a[j]=random.nextInt(1000);
				b[j]=a[j];
				c[j]=a[j];
			}
			long start = System.currentTimeMillis();
			QS1.quicksort(a);
			long stop = System.currentTimeMillis();
			double elapsed =(stop - start) / 1000.0;
			System.out.println(i+"  QS1  "+QS1.getCmp()+"          "+elapsed);
			
			long start1 = System.currentTimeMillis();
			QS2.quicksort(a);
			long stop1 = System.currentTimeMillis();
			double elapsed1 =(stop1 - start1) / 1000.0;
			System.out.println(i+"  QS2  "+QS2.getCmp()+"          "+elapsed1);
			
			long start2 = System.currentTimeMillis();
			QS3.quicksort(c);
			long stop2 = System.currentTimeMillis();
			double elapsed2 =(stop2 - start2) / 1000.0;
			System.out.println(i+"  QS3  "+QS3.getCmp()+"          "+elapsed2);
			System.out.println();
			
		}

	}

}
