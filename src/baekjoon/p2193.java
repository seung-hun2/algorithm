package baekjoon;

import java.util.Scanner;

public class p2193 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dp = new long[N+2];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=N-1;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        System.out.println(dp[N-1]);
    }

}
