/*
 * Heap Sort (Ascending)
 * Min Heap
 * */

import java.util.*;

public class ParkYoonJin{

	final static int N=10;

	private static class Heap{
		int[] list = new int[N+1];
		int cnt=0;

		void push(int x){
			list[++cnt]=x;
			int child = cnt-1;
			int parent = child/2;
			while(parent>=1 && list[parent]>list[child]){
				swap(parent, child);
				child = parent;
				parent = child/2;
			}
		}

		void swap(int x, int y){
			int tmp = list[x];
			list[x] = list[y];
			list[y] = tmp;
		}

		int pop(){
			int result=list[1];
			swap(1, cnt);
			cnt-=1;
			int parent=1;
			int child=parent*2;
			if(child+1<=cnt)child=(list[child]>list[child+1])?child+1:child;

			while(child<=cnt && list[parent]>list[child]){
				swap(parent,child);
				parent=child;
				child=parent*2;
				if(child+1<=cnt) child=(list[child]>list[child+1])?child+1:child;
			}
			return result;
		}
	}

	public static void main(String[] args){
		int N = 10;
		Heap h = new Heap();
		System.out.print("Unordered List: ");
		for(int i=1;i<=N;++i){
			int tmp = (int)(Math.random()*100+1); 
			h.push(tmp);
			System.out.print(tmp+" ");
		}

		System.out.println();
		System.out.print("Heap Sorted List: ");
		for(int i=1;i<=10;++i){
			System.out.print(h.pop()+" ");
		}



		
	}
}
