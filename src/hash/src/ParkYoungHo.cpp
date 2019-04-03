#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_TABLE 5 // 테이블 크기
#define MAX_KEY 8 // include null
#define MAX_DATA 12 // 해시테이블에 넣을 데이터의 수
#define DELETE_COUNT 6 // 삭제할 데이터의 수
#define FIND_COUNT 8 // 찾을 데이터의 수

struct Node {
	char key[MAX_KEY];
	int value;
	Node * next;
};

Node * tb[MAX_TABLE]; // 해시 테이블(해당 인덱스에 리스트로 작성)
char keys[MAX_DATA][MAX_KEY]; // 문자열 key들
int values[MAX_DATA]; // key에 대응하는 값들

void init() {

	// 해시테이블 초기화
	for (int i = 0; i < MAX_TABLE; ++i) {
		Node * cur = tb[i];
		Node * tmp;
		while (cur != NULL) {
			tmp = cur;
			cur = cur->next;
			free(tmp);
		}
		tb[i] = NULL;
	}

	// 랜덤함수를 위한 srand와 seed
	srand(time(NULL));

	// key에 대응하는 값들 초기화
	for (int i = 0; i < MAX_DATA; ++i) {
		values[i] = rand() % 100 + 1;
	}

	// 문자열 key들 초기화
	for (int i = 0; i < MAX_DATA; ++i) {
		for (int j = 0; j < MAX_KEY - 1; ++j) {
			keys[i][j] = rand() % 26 + 97; // ASCII 97 ~ 122
		}
		keys[i][MAX_KEY - 1] = '\0';
	}

}

void my_str_cpy(char * dest, const char * src) {

	while (*src != '\0') {
		*dest = *src;
		dest++; src++;
	}
	*dest = '\0';
	
}

int my_str_cmp(const char * str1, const char * str2) {

	while (*str1 != '\0' && (*str1 == *str2)) {
		str1++;
		str2++;
	}
	return *str1 - *str2;

}

int hash(const char * str) {
	int hash = 401;
	int c;

	while (*str != '\0') {
		hash = ((hash << 4) + (int)(*str)) % MAX_TABLE;
		str++; 
	}

	return hash % MAX_TABLE;
}

void add(const char * key, int value) {

	Node * new_node = (Node *)malloc(sizeof(Node));
	my_str_cpy(new_node->key, key);
	new_node->value = value;
	new_node->next = NULL;

	int index = hash(key);

	if (tb[index] == NULL) {
		tb[index] = new_node;
	}

	else {

		Node * cur = tb[index];

		while (cur != NULL) {

			// key가 중복이면 값을 바꾸기
			if (my_str_cmp(cur->key, key) == 0) {
				cur->value = value;
				return;
			}

			cur = cur->next;
		}

		// 중복이 아니면 앞에다가 추가
		new_node->next = tb[index];
		tb[index] = new_node;
	}
}

bool find(const char * key, int * val) {

	int index = hash(key);

	Node * cur = tb[index];

	// 하나하나 찾아가면서 확인
	while (cur != NULL) {
		if (my_str_cmp(cur->key, key) == 0) {
			*val = cur->value;
			return true;
		}
		cur = cur->next;
	}

	return false;

}

bool destroy(const char * key) {

	int index = hash(key);

	// 처음이 비어있는지 확인
	if (tb[index] == NULL) {
		return false;
	}

	// 첫번째
	if (my_str_cmp(tb[index]->key, key) == 0) {
		Node * first = tb[index];
		tb[index] = tb[index]->next;
		free(first);
		return true;
	}

	// 나머지의 경우
	else {

		Node * cur = tb[index]->next;
		Node * prev = tb[index];

		while (cur != NULL && my_str_cmp(cur->key, key) != 0) {
			prev = cur;
			cur = cur->next;
		}

		if (cur == NULL) return false;

		prev->next = cur->next;
		free(cur);
		return true;
	}
}

void print_hash() {

	for (int i = 0; i < MAX_TABLE; ++i) {
		if (tb[i] != NULL) {

			printf("index : %d\n", i);

			Node * cur = tb[i];

			while (cur != NULL) {
				printf("{ %s, %d }, ", cur->key, cur->value);
				cur = cur->next;
			}
			printf("\n");
		}
	}

}

int main() {

	char tmp_key[MAX_KEY];
	init();

	// Add

	printf("Add to hash table\n");
	for (int i = 0; i < MAX_DATA; ++i) {
		add(keys[i], values[i]);
	}

	print_hash();


	printf("\n");

	// Delete

	printf("Deleted keys : ");
	for (int i = 0; i < DELETE_COUNT; ++i) {
		my_str_cpy(tmp_key, keys[rand() % MAX_DATA]);
		printf("%s ", tmp_key);
		destroy(tmp_key);
	}
	printf("\n");

	print_hash();


	printf("\n");

	// Find

	int val;
	printf("Found : ");
	for (int i = 0; i < FIND_COUNT; ++i) {
		my_str_cpy(tmp_key, keys[rand() % MAX_DATA]);
		if (find(tmp_key, &val)) {
			printf("{ %s, %d } ", tmp_key, val);
		}
	}
	printf("\n");

	return 0;
}