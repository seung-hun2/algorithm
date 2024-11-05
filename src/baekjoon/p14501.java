package baekjoon;

import java.util.Scanner;

public class p14501 {

    static int N,ans;
    static int[] T,P;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        T = new int[N];
        P = new int[N];
        ans = 0;
        int[] dp = new int[N+1];

        for(int i=0;i<N;i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for(int i=0;i<N;i++){
            if(i + T[i] <= N){
                dp[i + T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }


        System.out.println(dp[N]);
    }

}
