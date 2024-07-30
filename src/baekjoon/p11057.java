package baekjoon;

import java.util.Scanner;

public class p11057 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] dp = new int[N+1][10];

        for(int i=0;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int k=2;k<=N;k++){
            for(int i=0;i<=9;i++){
                for(int j=0;j<=9;j++){
                    dp[k][i] += dp[k-1][j] % 10007;
                }
            }
        }

        int ans = 0;
        for(int i=0;i<=9;i++){
            ans += dp[N][i];
            ans %= 10007;
        }

        System.out.println(ans);

    }

}
