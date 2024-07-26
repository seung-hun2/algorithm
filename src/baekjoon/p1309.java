package baekjoon;

import java.util.Scanner;

public class p1309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] dp = new long[N+2];
        dp[0] = 1;
        dp[1] = 3;
        dp[2] = 7;
        for(int i=2;i<=N;i++){
            dp[i] = (dp[i-1]*2 + dp[i-2])%9901;
        }

        System.out.println(dp[N]%9901);

    }

}
