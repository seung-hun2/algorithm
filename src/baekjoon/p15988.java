package baekjoon;

import java.util.Scanner;

public class p15988 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        dp[4] = 7;
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            if(dp[N] == 0) {
                for (int j = 4; j <= N; j++) {
                    dp[j] = (dp[j - 3] + dp[j - 2] + dp[j - 1])%1000000009;
                }
            }
            sb.append(dp[N]).append('\n');
        }
        System.out.println(sb);
    }

}
