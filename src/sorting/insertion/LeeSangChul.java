package sorting.insertion;

import java.util.Arrays;

public class LeeSangChul {
    private static int cnt;

    private static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            for (; j >= 0 && key < arr[j]; j--) {
                arr[j + 1] = arr[j];
                cnt++;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int arr[] = {69, 10, 30, 2, 16, 8, 31, 22};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(cnt);
    }
}