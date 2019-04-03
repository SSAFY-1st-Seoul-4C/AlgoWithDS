/*
 * Insertion Sort Ascending Order
 * */

import java.util.*;


public class ParkYoonJin{

	public static void main(String[] args){
	
		int N = 10;
		int[] list = new int[10];
		System.out.print("Unordered List: ");
		for(int i=0;i<N;++i){
			list[i] = (int)(Math.random()*100+1); 
			System.out.print(list[i]+" ");
		}

		for(int i=1;i<N;++i){
			int j=i;
			while(j>=1 && list[j]<list[j-1]){
				int tmp=list[j];
				list[j] = list[j-1];
				list[j-1] = tmp;
				j-=1;
			}
		}


		System.out.println();
		System.out.print("Insertion-sorted List: ");
		for(int i=0;i<N;++i) System.out.print(list[i]+" ");

	}

}
