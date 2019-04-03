package sorting.bubble;

import java.util.Arrays;

public class LeeSangChul {
    static int cnt;
    private static void bubble(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 1; j < arr.length - i; j++) {
                cnt++;
                if(arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {69, 10, 30, 2, 16, 8, 31, 22};
        bubble(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(cnt);
    }
}