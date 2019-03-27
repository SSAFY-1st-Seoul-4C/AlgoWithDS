/*
버블정렬
시간복잡도 O(n^2)
*/
#include<iostream>
using namespace std;

void print(int* arr, int n) {	// 배열 출력 함수
	for (int i = 0; i < n; i++) printf("%d ", arr[i]);
	printf("\n");
}

void bubbleSort(int* arr, int n) {
	for (int i = n; i > 0; i--) {	// n-1번 반복 수행하면 정렬 완료
		for (int j = 0; j < i - 1; j++) {	// 한 번 수행 시 0~n-2 원소까지 반복
			if (arr[j] > arr[j + 1]) {	// 앞 원소의 값이 뒤 원소의 값 보다 크면
				// Swap
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	}
}

int main() {
	printf("배열의 개수 N 입력하고 배열 원소 입력하세욤\n");
	int n;
	scanf("%d", &n);
	int* arr = new int[n];
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	printf("변경 전 : ");
	print(arr, n);
	bubbleSort(arr, n);
	printf("변경 후 : ");
	print(arr, n);

	return 0;
}