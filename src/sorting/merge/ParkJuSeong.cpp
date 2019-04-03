/*
병합정렬
시간복잡도 O(nlogn)
분할 -> 병합(정복)
*/
#include<iostream>
using namespace std;

void print(int* arr, int n) {	// 배열 출력 함수
	for (int i = 0; i < n; i++) printf("%d ", arr[i]);
	printf("\n");
}

void merge(int* arr, int left, int mid, int right) {
	int lptr = left;
	int rptr = mid + 1;
	int* tarr = new int[right - left + 1];
	int tptr = 0;
	while (lptr <= mid && rptr <= right) {
		tarr[tptr++] = arr[lptr] <= arr[rptr] ? arr[lptr++] : arr[rptr++];
	}
	if (lptr > mid) while (rptr <= right) tarr[tptr++] = arr[rptr++];
	else while (lptr <= mid) tarr[tptr++] = arr[lptr++];
	tptr = 0;
	for (int i = left; i <= right; i++) arr[i] = tarr[tptr++];
}

void mergeSort(int* arr, int left, int right) {
	if (left >= right) return;
	int mid = (left + right) >> 1;
	mergeSort(arr, left, mid);
	mergeSort(arr, mid + 1, right);
	merge(arr, left, mid, right);
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
	mergeSort(arr, 0, n-1);
	printf("변경 후 : ");
	print(arr, n);

	return 0;
}