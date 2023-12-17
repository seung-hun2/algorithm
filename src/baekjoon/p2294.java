package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p2294 {

    static int N,K;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        int[] dp = new int[K+1];
        for(int i=1;i<=K;i++){
            dp[i] = 100001;
        }
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
            if(arr[i] <= K)
                dp[arr[i]] = 1;
        }
        for(int i=1;i<=K;i++){
            for(int j=0;j<N;j++){
                if(i+arr[j] <= K)
                    dp[i+arr[j]] = Math.min(dp[i]+1, dp[i+arr[j]]);
            }
        }
        if (dp[K] == 100001) {
            System.out.println(-1);
        }else{
            System.out.println(dp[K]);
        }
    }

}
