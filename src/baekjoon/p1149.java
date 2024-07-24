package baekjoon;

import java.util.Scanner;

public class p1149 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] rgb = new int[3];
        int[][] dp = new int[N+1][3];

        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for(int i=1;i<=N;i++){
            for(int j=0;j<3;j++){
                rgb[j] = sc.nextInt();
            }
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[2];
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));

    }

}
