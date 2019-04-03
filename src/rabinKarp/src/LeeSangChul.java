package rabinKarp.src;

import java.util.LinkedList;
import java.util.Scanner;

public class LeeSangChul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        String pattern = sc.nextLine();
        int targetSize = target.length();
        int patternSize = pattern.length();
        if (targetSize < patternSize) System.out.println(0);
        else {
            final int D = 31;
            final int MOD = (int)1e9 + 7;
            long head = 1;
            long patternHash = 0;
            long nowHash = 0;

            for (int i = 0; i < patternSize; i++) {
                patternHash = (patternHash * D + pattern.charAt(i)) % MOD;
                nowHash = (nowHash * D + target.charAt(i)) % MOD;
                if (i != 0) head = (head * D) % MOD;
            }
            LinkedList<Integer> ans = new LinkedList<>();
            for (int i = 0; i <= targetSize - patternSize; i++) {
                if(nowHash == patternHash) ans.add(i + 1);
                if(i + patternSize == targetSize) break;
                nowHash = (D * (nowHash - target.charAt(i) * head) + target.charAt(i + patternSize)) % MOD;
                if(nowHash < 0) nowHash += MOD;
            }
            System.out.println(ans.size());
            for(Integer e: ans) System.out.print(e + " ");
        }
    }
}