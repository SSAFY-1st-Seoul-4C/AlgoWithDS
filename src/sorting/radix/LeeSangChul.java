package sorting.radix;

import java.util.Arrays;
import java.util.LinkedList;

public class LeeSangChul {
    private static int cnt;

    public static void main(String[] args) {
        int arr[] = {69, 10, 30, 2, 16, 8, 31, 22};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(cnt);
    }

    private static void radixSort(int[] arr) {
        LinkedList<Integer>[] counter = new LinkedList[10];
        for(int i =0;i<10;i++) counter[i] = new LinkedList<>();

        int maxIdx = getMaxIdx(arr);
        int mod = 10;
        int mock = 1;

        for(int i = 0 ; i < maxIdx; i++, mod *= 10, mock *= 10) {
            for(Integer e: arr) {
                int n = (e % mod) / mock;
                counter[n].add(e);
            }
            int idx = 0;
            for(int j = 0 ; j < counter.length; j++) {
                Integer v = null;
                while((v = counter[j].poll()) != null) {
                    arr[idx++] = v;
                }
            }
        }
    }

    private static int getMaxIdx(int[] arr) {
        int maxN = 0;
        int ret = 0;
        for(Integer e: arr) maxN = Math.max(maxN, e);
        while(maxN > 0) {
            maxN /= 10;
            ret++;
        }
        return ret;
    }
}