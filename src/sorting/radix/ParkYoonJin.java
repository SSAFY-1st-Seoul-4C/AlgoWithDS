/*
 * Radix Sort
 * Ascending Order
 * LSD
 * */

public class ParkYoonJin{

	static class Node{
		int val;
		Node nxt;

		Node(int val){
			this.val = val;
		}
	}

	static class LinkedList{
		Node head=null;
		Node tail=null;

		public LinkedList(){
		}

		public LinkedList(Node x){
			if(head==null){
				head=x;
				tail=x;
			}
		}

		public void pushBack(Node x){
			if(head==null){
				head=x;
				tail=x;
				tail.nxt = null;
				return;
			}

			tail.nxt = x;
			tail = x;
			tail.nxt = null;
			return;
		}

		public int popFront(){
			if(isEmpty()==true) return -1;
			int result = head.val;
			head = head.nxt;
			if(head==null) tail=null;
			return result;
		}
		
		public boolean isEmpty(){
			if(head==null) return true;
			return false;
		}
	}


	public static void main(String[] args){

		int N = 10;
		int[] list = new int[10];
		System.out.print("Unordered List: ");
		list[0] = 1;
		list[1] = 1;
		list[2] = 1;
		for(int i=3;i<N;++i){
			list[i] = (int)(Math.random()*100+1); 
			System.out.print(list[i]+" ");
		}

		LinkedList[] digits = new LinkedList[10];
		for(int j=0;j<10;++j) digits[j]= new LinkedList();

		for(int i=10,d=1;i<=1000;i*=10,d*=10){

			for(int j=0;j<N;++j){
				int r = (list[j]%i)/d;
				digits[r].pushBack(new Node(list[j]));
			}

			int idx=0;
			for(int j=0;j<10;++j){
				while(!digits[j].isEmpty()) list[idx++]=digits[j].popFront();
			}
		}

		System.out.println();
		System.out.print("Radix-sorted List: ");
		for(int i=0;i<N;++i) System.out.print(list[i]+" ");


	}
}
