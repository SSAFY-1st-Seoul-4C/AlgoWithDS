package dijkstra.src;

import java.util.Arrays;
import java.util.Scanner;

public class LeeSangChul {
    private static int n;
    private static int[][] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        list = new int[n][n];
        int strt = sc.nextInt();
        int end = sc.nextInt();

        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) list[i][j] = sc.nextInt();

        System.out.println(dijkstra(strt, end));
    }

    private static class Heap {
        private Node arr[] = new Node[n + 1];
        private int size = 0;

        private int getSize() {
            return size;
        }

        private Node pop() {
            if (size == 0) return null;
            Node ret = arr[1];
            int idx = 1;

            arr[1] = arr[size];
            arr[size--] = null;

            while (idx <= size) {
                Node tmp = arr[idx];
                int next = idx;
                if (idx * 2 <= size && arr[idx].cost > arr[idx * 2].cost) next = idx * 2;
                if (idx * 2 + 1 <= size && arr[next].cost > arr[idx * 2 + 1].cost) next = idx * 2 + 1;
                if (idx == next) break;
                arr[idx] = arr[next];
                arr[next] = tmp;
                idx = next;
            }
            return ret;
        }

        private void push(Node e) {
            if (size + 1 == n + 1) return;
            arr[++size] = e;
            int idx = size;
            while (idx != 1) {
                if (arr[idx].cost >= arr[idx / 2].cost) break;
                Node tmp = arr[idx];
                arr[idx] = arr[idx / 2];
                arr[idx / 2] = tmp;
                idx /= 2;
            }
        }
    }

    private static int dijkstra(int start, int end) {
        int dist[] = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Heap heap = new Heap();
        heap.push(new Node(start, 0));
        dist[start] = 0;

        while (heap.getSize() != 0) {
            Node tmp = heap.pop();
            if (tmp == null) break;
            int now = tmp.now;
            int cost = tmp.cost;
            if (cost > dist[now]) continue;

            for (int i = 0; i < list[now].length; i++) {
                int nextCost = list[now][i];
                if (nextCost != 0 && dist[i] > nextCost + cost) {
                    dist[i] = nextCost + cost;
                    heap.push(new Node(i, dist[i]));
                }
            }
        }

        return dist[end];
    }

    private static class Node implements Comparable<Node> {
        int now, cost;

        private Node(int now, int cost) {
            this.now = now;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

}
/*
3
0 2
0 1 3
0 0 1
0 0 0
 */