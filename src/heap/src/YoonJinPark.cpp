/*
 * Description: Minimum Heap
 * Author: Yoonjin Park
 * Date: 2019 03 22
 * */
#include <iostream>

#define HEAP_SIZE 100

using namespace std;

int heap[HEAP_SIZE];
int heapCnt=0;

void swap(int a, int b){
	int tmp = heap[a];
	heap[a]=heap[b];
	heap[b]=tmp;
	return;
}

//returns the index
int push(int x){
	heap[++heapCnt] = x;

	int parent = heapCnt/2;
	int child = heapCnt;
	int tmp;
	while(heap[child]<heap[parent]){
		swap(child, parent);
		tmp = child;
	        child = parent;
       		parent= child/2;	       
	}

	return child;
}


int pop(){
	int result = heap[heapCnt];
	
	swap(1, heapCnt);
	heapCnt-=1;

	int parent = 1;
	int child = parent*2;
	if(child+1<=heapCnt) child =(heap[child]<heap[child+1])?child:child+1;

	while(child <=heap_count && heap[parent]<heap[child]){
		swap(parent, child);
		parent = child;
		child = parent*2;
		if(child+1<=heapCnt) child =(heap[child]<heap[child+1])?child:child+1;
	}	
	return result;

}

int main(){

	return 1;
}
