/*
 * Quick Sorting
 * Ascending Order
 * */

public class ParkYoonJin{

	public static void main(String[] args){

		int N = 10;
		int[] list = new int[10];
		System.out.print("Unordered List: ");
		for(int i=0;i<N;++i){
			list[i] = (int)(Math.random()*100+1); 
			System.out.print(list[i]+" ");
		}

		quickSort(list, 0, N-1);

		System.out.println();
		System.out.print("Quick-sorted List: ");
		for(int i=0;i<N;++i) System.out.print(list[i]+" ");
	}

	static void quickSort(int[] list, int left, int right){
		if(left>=right) return;

		int mid = partition(list, left, right);

		quickSort(list, left, mid);
		quickSort(list, mid+1, right);

	}


	static int partition(int[] list, int left, int right){
		int pivotIdx = left;
		int storingIdx = pivotIdx +1;
		for(int i=pivotIdx+1;i<=right;++i){
			if(list[i]<list[pivotIdx]) swap(list, storingIdx++, i);
		}
		swap(list, storingIdx-1, pivotIdx);

		return storingIdx-1;
	}

	static void swap(int[] list, int x, int y){
		int tmp = list[x];
		list[x] = list[y];
		list[y] = tmp;
	}




}
