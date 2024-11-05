package baekjoon;

import java.util.Scanner;

public class p15489 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int W = sc.nextInt();
        int[][] dp = new int[R+W+1][R+W+1];
        dp[1][1] = 1;
        for(int i=2;i<=R+W;i++){
            for(int j=1;j<=i;j++){
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int sum = 0;
        for(int i=0;i<W;i++){
            for(int j=0;j<=i;j++){
                sum += dp[R+i][C+j];
            }
        }
        System.out.println(sum);

    }

}
