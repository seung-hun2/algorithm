package baekjoon;

import java.util.Scanner;

public class p5557 {

    static int N;
    static int[] arr;
    static long ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        long[][] dp = new long[N-1][21];
        dp[0][arr[0]] = 1;

        for(int i=1;i<N-1;i++){
            for(int num=0;num<=20;num++){
                if(num-arr[i] >= 0) dp[i][num] += dp[i-1][num-arr[i]];
                if(num+arr[i] <= 20) dp[i][num] += dp[i-1][num+arr[i]];
            }
        }

        System.out.println(dp[N-2][arr[N-1]]);

    }

}
