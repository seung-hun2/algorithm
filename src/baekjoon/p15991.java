package baekjoon;

import java.util.Scanner;

public class p15991 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[100001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;
        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            if(dp[N]==0){
                for(int j=7;j<=N;j++){
                    dp[j] = (dp[j-2] + dp[j-4] + dp[j-6])%1000000009;
                }
            }
            sb.append(dp[N]).append('\n');
        }
        System.out.println(sb);
    }

}
