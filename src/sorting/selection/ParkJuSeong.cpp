/*
선택정렬
시간복잡도 O(n^2)
*/
#include<iostream>
using namespace std;

void print(int* arr, int n) {	// 배열 출력 함수
	for (int i = 0; i < n; i++) printf("%d ", arr[i]);
	printf("\n");
}

void selectionSort(int* arr, int n) {
	for (int i = 0; i < n; i++) {
		int min = arr[i];
		int index = i;
		for (int j = i + 1; j < n; j++) {
			if (arr[j] < min) {
				min = arr[j];
				index = j;
			}
		}
		int temp = arr[i];
		arr[i] = arr[index];
		arr[index] = temp;
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
	selectionSort(arr, n);
	printf("변경 후 : ");
	print(arr, n);

	return 0;
}