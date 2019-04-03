/*
 * Selection Sort (Ascending Order)
 * Yoonjin Park
 *
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

		int idx=0,tmp=0;
		for(int i=0;i<N;++i){
			idx =i;
			for(int j=i+1;j<N;++j){
				if(list[idx]>list[j]) idx=j;
			}
			tmp = list[i];
			list[i]=list[idx];
			list[idx]=tmp;
		}

		
		System.out.println();
		System.out.print("Selection-sorted List: ");
		for(int i=0;i<N;++i) System.out.print(list[i]+" ");


	}



}
