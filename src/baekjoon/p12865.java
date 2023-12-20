package baekjoon;

import java.util.Scanner;

public class p12865 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] dp = new int[K+1];

        for(int i=0;i<N;i++){
            int w = sc.nextInt();
            int v = sc.nextInt();
            for(int j=K;j>=w;j--){
                dp[j] = Math.max(dp[j], dp[j-w] + v);
            }
        }

        System.out.println(dp[K]);
    }

}
