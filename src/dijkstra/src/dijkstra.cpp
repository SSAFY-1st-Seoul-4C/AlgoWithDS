#include <iostream>
#include <vector>
using namespace std;

int INF = 9999999;
int adj[9999][9999];
void dijkstra(int n) { // start node 0
	vector<int> vertex(n);
	vector<int> dist(n);
	vector<int> prev(n);

	for (int i = 0; i < n; i++) {
		dist[n] = INF;
		vertex[i] = i;
	}

	dist[0] = 0; // start node

	while (!vertex.empty()) {  // vertex 다 돌 때까지
		int mini = vertex[0], minNode = 0;
		for (int i = 0; i < vertex.size(); i++) {  // 가장 dist 작은 vertex 찾기
			if (mini > dist[i]) {
				mini = dist[i];
				minNode = i;
			}
		}
		vertex.erase(vertex.begin() + minNode); // vertex 삭제
		for (int i = 0; i < n; i++) {
			if (adj[minNode][i] > 0) {  // 인접행렬
				int tmp = dist[minNode] + adj[minNode][i];
				if (tmp < dist[i]) { // 더 짧은 새로운 경로 
					dist[i] = tmp;
					prev[i] = minNode;
				}
			}
		}
	}
	return;
}


int main() {
	dijkstra(10);
	return 0;
}