package baekjoon;

import java.util.Scanner;

public class p15990 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[][] dp = new long[100001][4];
        StringBuilder sb = new StringBuilder();
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][3] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;

        for(int tc=0;tc<T;tc++){
            int N = sc.nextInt();
            for(int j=4;j<=N;j++){
                dp[j][1] = (dp[j-1][2] + dp[j-1][3]) % 1000000009;
                dp[j][2] = (dp[j-2][1] + dp[j-2][3]) % 1000000009;
                dp[j][3] = (dp[j-3][1] + dp[j-3][2]) % 1000000009;
            }
            long next = (dp[N][1] + dp[N][2] + dp[N][3]) % 1000000009;
            sb.append(next).append('\n');
        }

        System.out.println(sb);
    }

}
