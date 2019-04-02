#include <iostream>
#include <cstring>
#include <malloc.h>
using namespace std;

void _insert(int *a, int m, int key, int size) {
	int tmp = key % m;
	while (a[tmp] != -1)
		tmp = (tmp + 1) % m;  // arr[tmp]가 이미 차있으면 다음 index를 본다.
	a[tmp] = key;
}

void _delete(int *a, int m, int key, int size) {
	for (int i = 0; i < size; i++) {
		if (a[key%m] == -1) {	// hash table에 없으면 없는 원소다.
			cout << "No element" << '\n';
			break;
		}
		if (a[i] == key) {   // key를 찾으면 -1로 바꿔준다.
			a[i] = -1;
			cout << "deleted element " << key << '\n';
			break;
		}
	}
}

void _search(int *a, int m, int key, int size) {
	for (int i = 0; i < size; i++) {
		if (a[key%m] == -1) {
			cout << "No element" << '\n';
			break;
		}
		if (a[i] == key) {
			cout << "found elemnt in : " << i << '\n';
			break;
		}
	}
}

int main() {
	int hash_size, m;
	cout << "hash size 입력: ";
	cin >> hash_size;  // table 크기 입력
	int* arr = new int[hash_size];   // 배열로 hash table 구현

	cout << "hash 함수 입력 (mod m): ";
	cin >> m;
	for (int i = 0; i < hash_size; i++)
		arr[i] = -1;

	_insert(arr, m, 10, hash_size);
	_insert(arr, m, 234, hash_size);
	_insert(arr, m, 6, hash_size);
	_insert(arr, m, 435, hash_size);
	_insert(arr, m, 322, hash_size);
	_insert(arr, m, 77, hash_size);
	_delete(arr, m, 435, hash_size);
	_delete(arr, m, 32, hash_size);
	_search(arr, m, 435, hash_size);
	_search(arr, m, 77, hash_size);
	_search(arr, m, 10, hash_size);

	for (int i = 0; i < hash_size; i++)
		cout << arr[i] << ' ';

	return 0;
}