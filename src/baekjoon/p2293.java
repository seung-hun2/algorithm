package baekjoon;

import java.util.Scanner;

public class p2293 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[K+1];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        dp[0] = 1;
        for(int i=0;i<N;i++){
            for(int j=0;j+arr[i]<=K;j++){
                dp[j+arr[i]] += dp[j];
            }
        }
        System.out.println(dp[K]);

    }

}
