package sorting.shell;

import java.util.Arrays;

public class LeeSangChul {
    private static int cnt;

    private static void intervalSort(int[] arr, int begin, int interval) {
        int key, j;
        for (int i = begin + interval; i < arr.length; i += interval) {
            key = arr[i];
            for (j = i - interval; j >= begin && key < arr[j]; j -= interval) {
                arr[j + interval] = arr[j];
                cnt++;
            }
            arr[j + interval] = key;
        }
    }

    private static void shellSort(int[] arr) {
        int interval = arr.length / 2;
        while (interval > 0) {
            if (interval % 2 == 0) interval++;
            for (int i = 0; i < interval; i++) intervalSort(arr, i, interval);
            interval >>= 1;
            cnt++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {69, 10, 30, 2, 16, 8, 31, 22};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(cnt);
    }
}