#include <iostream>

using namespace std;

void swap(int* a, int* b) {
	int tmp = *a;
	*a = *b;
	*b = tmp;
}

void quickSort(int arr[], int start, int end) {

	if (start >= end) return;

	int mid = (start + end) / 2;
	int pivot = arr[mid];

	swap(&arr[start], &arr[mid]);

	int p = start + 1, q = end;

	while (1) {
		while (arr[p] <= pivot) p++;
		while (arr[q] > pivot) q--;

		if (p > q) break;

		swap(&arr[p], &arr[q]);
	}

	swap(&arr[start], &arr[q]);

	quickSort(arr, start, q - 1);
	quickSort(arr, q + 1, end);

}

void printArray(int arr[], int n) {
	for (int i = 0; i < n; i++) {
		cout << arr[i] << " ";
	}
}

int main() {
	int arr[] = { 12, 3, 11, 13, 5, 6 };
	int n = sizeof(arr) / sizeof(arr[0]);

	quickSort(arr, 0, n - 1);
	printArray(arr, n);

	return 0;
}