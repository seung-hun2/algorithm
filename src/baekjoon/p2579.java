package baekjoon;

import java.util.Scanner;

public class p2579 {

    static int N;
    static int[] stair;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stair = new int[N+1];
        int[][] dp = new int[N+1][2];

        for(int i=1;i<=N;i++){
            stair[i] = sc.nextInt();
        }

        boolean check = false;
        dp[1][0] = stair[1];
        for(int i=2;i<=N;i++){
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stair[i];
            dp[i][1] = dp[i-1][0] + stair[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));

    }

}
