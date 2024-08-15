package baekjoon;

import java.util.Scanner;

public class p1495 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int[] V = new int[N+1];
        boolean[][] dp = new boolean[N+1][M+1];
        dp[0][S] = true;

        for(int i=1;i<=N;i++){
            V[i] = sc.nextInt();
            for(int j=0;j<=M;j++){
                if(dp[i-1][j]){
                    int plus = j + V[i];
                    int minus = j - V[i];

                    if(plus <= M) dp[i][plus] = true;
                    if(minus >= 0) dp[i][minus] = true;
                }
            }
        }

        int ans = -1;
        for(int i=M;i>=0;i--){
            if(dp[N][i]){
                ans = i;
                break;
            }
        }

        System.out.println(ans);

    }

}
