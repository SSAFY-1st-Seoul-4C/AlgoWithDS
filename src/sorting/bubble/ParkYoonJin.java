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
		boolean isSwapped;

		// Ascending Order
		for(int i=0;i<N;++i){
			isSwapped=false;
			for(int j=N-1;j>i;--j){
				if(list[j]<list[j-1]){
					//swap
					int tmp=list[j-1];
					list[j-1] = list[j];
					list[j] = tmp;
					isSwapped=true;
				}
			}
			// if there is no swapping, it is all in a order
			if(isSwapped==false) break;
		}

		System.out.println();
		System.out.print("Bubble-sorted List: ");
		for(int i=0;i<N;++i) System.out.print(list[i]+" ");


	



	}

}
