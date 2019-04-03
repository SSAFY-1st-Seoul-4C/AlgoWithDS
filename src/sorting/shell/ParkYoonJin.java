/*
 * Shell Sort Ascending Order
 * */

import java.util.*;



public class ParkYoonJin{

	static int N;
	public static void shell_insertion(int[] list, int gap){
	
			for(int i=gap;i<N;i++){
				int j=i;
				while(j-gap>=0 && list[j]<list[j-gap]){
					int tmp=list[j];
					list[j] = list[j-1];
					list[j-gap] = tmp;
					j-=gap;
				}
			}
	}


	public static void main(String[] args){
	
		N = 10;
		int[] list = new int[10];
		System.out.print("Unordered List: ");
		for(int i=0;i<N;++i){
			list[i] = (int)(Math.random()*100+1); 
			System.out.print(list[i]+" ");
		}

		
		for(int gap=N/2;gap>0;gap=gap/2) shell_insertion(list, gap);


		System.out.println();
		System.out.print("Shell-sorted List: ");
		for(int i=0;i<N;++i) System.out.print(list[i]+" ");

	}

}
