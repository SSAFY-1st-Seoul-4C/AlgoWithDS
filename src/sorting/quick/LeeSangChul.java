package sorting.quick;

import java.util.Arrays;
import java.util.Random;

public class LeeSangChul {
    private static int cnt;
    private static Random random;

    public static void main(String[] args) {
        int arr[] = {69, 10, 30, 2, 16, 8, 31, 22};
        random = new Random();
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(cnt);
    }
    private static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
    private static void quickSort(int[] arr, int left, int right) {
        cnt++;
        if(left >= right) return;

        int l = left;
        int r = right + 1;
        int pivot = left + Math.abs(random.nextInt() % (right - left + 1));

        swap(arr, l, pivot);
        while(l < r) {
            do{ l++; } while(l <= right && arr[left] > arr[l]);
            do{ r--; } while(left < r && arr[left] < arr[r]);
            if(l < r) swap(arr, l, r);
        }
        swap(arr, r, left);
        quickSort(arr, left, r - 1);
        quickSort(arr, r + 1, right);
    }
}