package sorting.heap;

import java.util.Arrays;

public class LeeSangChul {
    private static int cnt;
    private final static int MAX_SIZE = 100;

    private static class Heap {
        private int[] arr = new int[MAX_SIZE];
        private int size = 0;

        boolean push(int num) {
            if (size + 1 == MAX_SIZE) return false;
            arr[++size] = num;
            int idx = size;
            while (idx != 1) {
                if (arr[idx / 2] <= arr[idx]) break;
                int tmp = arr[idx];
                arr[idx] = arr[idx / 2];
                arr[idx / 2] = tmp;
                idx >>= 1;
            }
            return true;
        }

        int pop() {
            if (size == 0) return -1;
            int ret = arr[1];
            arr[1] = arr[size];
            arr[size--] = 0;

            int idx = 1;
            while (idx <= size) {
                int next = idx;
                if (idx * 2 <= size && arr[idx] > arr[idx * 2]) next = idx * 2;
                if (idx * 2 + 1 <= size && arr[next] > arr[idx * 2 + 1]) next = idx * 2 + 1;
                if (idx == next) break;
                int tmp = arr[next];
                arr[next] = arr[idx];
                arr[idx] = tmp;
                idx = next;
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int arr[] = {69, 10, 30, 2, 16, 8, 31, 22};

        Heap heap = new Heap();
        for (Integer e : arr) heap.push(e);
        while (cnt < arr.length) {
            arr[cnt++] = heap.pop();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(cnt);
    }
}