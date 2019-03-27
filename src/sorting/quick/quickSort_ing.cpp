/*
퀵 정렬
시간복잡도 평균 nlogn 최악 n^2
*/
#include<iostream>
using namespace std;

void print(int* arr, int n) {	// 배열 출력 함수
	for (int i = 0; i < n; i++) printf("%d ", arr[i]);
	printf("\n");
}

int searchPivot(int* arr, int start, int end) {
	int pivot = arr[start];
	int left = start + 1;
	int right = end;
	while (left<right) {
		for (int i = start; i <= end; i++) printf("%d ", arr[i]);
		printf("\n");
		while (left<=end && arr[left] <= arr[pivot]) left++;
		while (right > pivot + 1 &&arr[right] > arr[pivot]) right--;
		if (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	if (pivot > arr[right]) {
		arr[start] = arr[right];
		arr[right] = pivot;
	}
	return right;
}

void quickSort(int* arr, int start, int end) {
	printf("A\n");
	if (start >= end) return;
	int pivot = searchPivot(arr, start, end);
	quickSort(arr, start, pivot - 1);
	quickSort(arr, pivot + 1, end);
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
	quickSort(arr, 0, n-1);
	printf("변경 후 : ");
	print(arr, n);

	return 0;
}