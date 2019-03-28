package sorting.selection;

import java.util.Arrays;

public class LeeSangChul {
    private static int cnt;

    private static void selection(int[] arr) {
        for(int i = 0 ; i < arr.length - 1; i++) {
            int key = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[key] > arr[j]) key = j;
                cnt++;
            }
            if(key == i) continue;
            int tmp = arr[key];
            arr[key] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {69, 10, 30, 2, 16, 8, 31, 22};
        selection(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(cnt);
    }
}