/*
자료구조 : 힙 (최대 힙, 최소 힙)
*/

#include<iostream>
using namespace std;

typedef struct Node {	// 노드. 데이터 값만 넣음.
	int data;
}Node;

typedef struct maxHeap {
	Node* arr ;		// 트리(배열로 구현)
	int maxSize;	// 배열의 최대 크기(가변적 배열크기를 위해)
	int rear;		// 트리의 가장 끝 인덱스
	maxHeap(int size=8) {	// 생성자?	초기 사이즈=8, resize시 2배씩 증가
		arr = new Node[size];	// 동적 할당
		maxSize = size - 1;		// 크기8이면 0~7이니깐 maxSize=7 (8-1)
		rear = 1;				// 트리의 시작 인덱스는 1 (관리 편함)
	}
	int findParent(int index) {		// 부모 인덱스 찾기
		return index >> 1;
	}
	int findLeftChild(int index) {	// 왼쪽 자식 인덱스 찾기
		return index * 2;
	}
	int findRightChild(int index) {	// 오른쪽 자식 인덱스 찾기
		return index * 2 + 1;
	}
	bool isRoot(int index) {		// 현재 인덱스가 Root인지 확인
		if (index == 1) return true;
		return false;
	}
	void swap(int index1, int index2) {	// 두 노드 스왑
		Node temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	void reSize() {		// 배열 크기 꽉 차면 크기 증가 (x2)
		Node* newArr = new Node[maxSize<<1];
		for (int i = 1; i < maxSize; i++) {
			newArr[i] = arr[i];
		}
		delete[] arr;
		arr = newArr;
		maxSize <<= 1;
	}
	void add(int data) {			// 노드 추가
		Node newNode = { data };
		int index = rear;
		arr[index] = newNode;		// 트리의 맨 끝에 새로운 노드 추가
		while (!isRoot(index)) {	// 위로 계속 올라간다.
			int parent = findParent(index);	
			if (arr[parent].data < arr[index].data) {	// 부모의 데이터값이 자식보다 작으면
				swap(parent, index);	// 스왑
				index = parent;			// 추가했던 노드 인덱스 변경시켜주기 (올라가자)
			}
			else break;
		}
		rear++;		// 맨 끝 인덱스 +1
		if (rear == maxSize) reSize();	// reSize 할지 결정(배열 max크기보다 초과되는지 확인)
	}
	bool isEmpty() {	// 비어있나?
		if (rear == 1) return true;
		return false;
	}
	int remove() {		// 노드 제거 ( max값 추출 )
		if (isEmpty()) return -9999;
		swap(1, --rear);	// 루트값 맨 뒤로 보내버리기. 맨 뒤랑 스왑. 
		int index = 1;		
		while (true) {		// 맨 위로 올라간 노드 내리기 시작. ( maxHeap 유지 )
			int lChild = findLeftChild(index);
			int rChild = findRightChild(index);
			if (lChild<rear&&arr[lChild].data>arr[index].data) {	// 일단 왼쪽자식이랑 크기 비교 ( 왼쪽 자식이 더 큰가? )
				if (rChild<rear&&arr[rChild].data>arr[lChild].data) {	// 오른쪽 자식과 왼쪽자식 비교 (더 큰애랑 바꿔야됨)
					swap(rChild, index);
					index = rChild;
				}
				else {
					swap(lChild, index);
					index = lChild;
				}
			}
			else if (rChild<rear&&arr[rChild].data>arr[index].data) {	// 오른쪽 자식과 비교
				swap(rChild, index);
				index = rChild;
			}
			else break;	// 자식들이 다 작네. 종료.
		}
		return arr[rear].data;	// 처음에 스왑해놓은 루트값 리턴.
	}


}maxHeap;

typedef struct minHeap {	// maxHeap 반대... maxHeap 이해하면 걍 부등호만 바꿔주면 끝이다..!
	Node* arr;
	int maxSize;
	int rear;
	minHeap(int size = 8) {
		arr = new Node[size];
		maxSize = size - 1;
		rear = 1;
	}
	int findParent(int index) {
		return index >> 1;
	}
	int findLeftChild(int index) {
		return index * 2;
	}
	int findRightChild(int index) {
		return index * 2 + 1;
	}
	bool isRoot(int index) {
		if (index == 1) return true;
		return false;
	}
	void swap(int index1, int index2) {
		Node temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	void reSize() {
		Node* newArr = new Node[maxSize << 1];
		for (int i = 1; i < maxSize; i++) {
			newArr[i] = arr[i];
		}
		delete[] arr;
		arr = newArr;
		maxSize <<= 1;
	}
	void add(int data) {
		Node newNode = { data };
		int index = rear;
		arr[index] = newNode;
		while (!isRoot(index)) {
			int parent = findParent(index);
			if (arr[parent].data > arr[index].data) {
				swap(parent, index);
				index = parent;
			}
			else break;
		}
		rear++;
		if (rear == maxSize) reSize();
	}
	bool isEmpty() {
		if (rear == 1) return true;
		return false;
	}
	int remove() {
		if (isEmpty()) return -9999;
		swap(1, --rear);
		int index = 1;
		while (true) {
			int lChild = findLeftChild(index);
			int rChild = findRightChild(index);
			if (lChild<rear&&arr[lChild].data<arr[index].data) {
				if (rChild<rear&&arr[rChild].data<arr[lChild].data) {
					swap(rChild, index);
					index = rChild;
				}
				else {
					swap(lChild, index);
					index = lChild;
				}
			}
			else if (rChild<rear&&arr[rChild].data<arr[index].data) {
				swap(rChild, index);
				index = rChild;
			}
			else break;
		}
		return arr[rear].data;
	}


}minHeap;

int main() {
	minHeap mheap;
	printf("%d\n", mheap.remove());
	mheap.add(10);
	mheap.add(1);
	mheap.add(4);
	mheap.add(34);
	mheap.add(3);
	mheap.add(2);
	mheap.add(5);
	mheap.add(-1);
	while (!mheap.isEmpty()) {
		printf("%d ", mheap.remove());
	}

	return 0;
}