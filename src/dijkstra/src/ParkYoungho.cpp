#include <iostream>

using namespace std;

#define V 9
const int INF = 2147483647;

bool visit[V];
int dist[V];

void printSolution(int dist[], int n)
{
	for (int i = 0; i < V; i++)
		printf("%d %d\n", i, dist[i]);
}

int main() {
	int graph[V][V] = { 
		{ 0, 4, 0, 0, 0, 0, 0, 8, 0 },
		{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
		{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
		{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
		{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
		{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
		{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
		{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
		{ 0, 0, 2, 0, 0, 0, 6, 7, 0 }
	};

	for (int i = 0; i < V; i++) {
		dist[i] = INF;
	}

	dist[0] = 0;

	for (int i = 0; i < V - 1; i++) {
		int minVal = INF, minIndex;
		
		for (int j = 0; j < V; j++) {
			if (!visit[j] && dist[j] < minVal) {
				minVal = dist[j];
				minIndex = j;
			}
		}

		visit[minIndex] = true;

		for (int j = 0; j < V; j++) {
			if (!visit[j] && graph[minIndex][j] && dist[minIndex] != INF && dist[minIndex] + graph[minIndex][j] < dist[j]) {
				dist[j] = dist[minIndex] + graph[minIndex][j];
			}
		}
	}

	printSolution(dist, V);

	return 0;
}