package baekjoon;

import java.util.Scanner;

public class p11726 {

    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 10007;
        }
        System.out.println(dp[n]);
    }

}
