/*
 * Merge Sort (Ascending Order)
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

		mergeSort(list, 0, N-1);
		
		System.out.println();
		System.out.print("Merge-sorted List: ");
		for(int i=0;i<N;++i) System.out.print(list[i]+" ");


	}

	static void mergeSort(int[] list, int left, int right){
		
		if(right>left){
			int mid=(left+right)/2;
			mergeSort(list,left, mid); 
			mergeSort(list,mid+1, right); 
			merge(list, left, mid, right);
		}
	}

	static void merge(int[] list, int left, int mid, int right){
		int[] sorted = new int[(right-left)+1];
		int i=left;
		int j=mid+1;
		int s=0,k;
		
		while(i<=mid && j<=right){
			if(list[i]>list[j])	sorted[s++]=list[j++];
			else sorted[s++]=list[i++];
		}
		
		while(i<=mid) sorted[s++]=list[i++];
		while(j<=right) sorted[s++]=list[j++];

		for(k=left,s=0;k<=right;++k,++s) list[k]=sorted[s];
	}

}
