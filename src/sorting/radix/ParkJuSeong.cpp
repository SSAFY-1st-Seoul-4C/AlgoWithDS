/*
기수(Radix) 정렬
시간복잡도 ??
*/
#include<iostream>
#include<queue>
using namespace std;

void print(int* arr, int n) {	// 배열 출력 함수
	for (int i = 0; i < n; i++) printf("%d ", arr[i]);
	printf("\n");
}

void radixSort(int* arr, int n) {
	int mul = 10;
	while (true) {
		bool flag = false;
		queue<int> q[10];
		for (int i = 0; i < n; i++) {
			int radix = (arr[i] % mul) / (mul / 10);
			if (radix != 0) flag = true;
			q[radix].push(arr[i]);
		}
		int index = 0;
		for (int i = 0; i < 10; i++) {
			while (!q[i].empty()) {
				int num = q[i].front();
				q[i].pop();
				arr[index++] = num;
			}
		}
		mul *= 10;
		if (!flag) break;
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
	radixSort(arr, n);
	printf("변경 후 : ");
	print(arr, n);

	return 0;
}