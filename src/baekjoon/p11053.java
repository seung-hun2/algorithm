package baekjoon;

import java.util.Scanner;

public class p11053 {

    static int N,ans;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr =new int[N];
        int[] dp = new int[N];

        ans = 0;
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();

        for(int i=0;i<N;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }


        for(int i=0;i<N;i++){
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }


}
