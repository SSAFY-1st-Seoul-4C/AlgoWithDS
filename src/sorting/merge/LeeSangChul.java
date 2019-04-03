package sorting.merge;

import java.util.Arrays;

public class LeeSangChul {
    private static int cnt;
    private static int[] mergeList;

    public static void main(String[] args) {
        int arr[] = {69, 10, 30, 2, 16, 8, 31, 22};
        mergeList = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(cnt);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        cnt++;
        if (left >= right) return;
        int mid = (left + right) >> 1;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        int l = left;
        int r = mid + 1;
        int k = left;
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) mergeList[k++] = arr[l++];
            else mergeList[k++] = arr[r++];
        }
        while (l <= mid) mergeList[k++] = arr[l++];
        while (r <= right) mergeList[k++] = arr[r++];
        for(int i = left; i <= right;i++) arr[i] = mergeList[i];
    }
}