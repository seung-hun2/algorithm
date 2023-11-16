package baekjoon;

import java.util.Scanner;

public class p1699 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i=2;i<=N;i++){
            dp[i] = 10001;
            for(int j=1;j<=i/2;j++){
                if(j*j == i){
                    dp[i] = 1;
                    break;
                }
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }
        System.out.println(dp[N]);
    }

}
