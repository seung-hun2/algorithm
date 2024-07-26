package baekjoon;

import java.util.Scanner;

public class p9465 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++){
            int n = sc.nextInt();
            int[][] st = new int[n+1][2];
            int[][] dp = new int[n+1][2];
            for(int j=0;j<2;j++){
                for(int i=1;i<=n;i++){
                    st[i][j] = sc.nextInt();
                }
            }

            dp[1][0] = st[1][0];
            dp[1][1] = st[1][1];

            for(int i=2;i<=n;i++){
                dp[i][0] = Math.max(dp[i-1][1], dp[i-2][1]) + st[i][0];
                dp[i][1] = Math.max(dp[i-1][0], dp[i-2][0]) + st[i][1];
            }

            System.out.println(Math.max(dp[n][0],dp[n][1]));
        }
    }

}
