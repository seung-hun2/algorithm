package baekjoon;

import java.util.Scanner;

public class p2688 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[][] dp = new long[65][10];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=9;i++){
            dp[1][i] = 1;
        }
        int T = sc.nextInt();
        for(int k=2;k<=64;k++){
            for(int i=0;i<=9;i++){
                for(int j=i;j<=9;j++){
                    dp[k][i] += dp[k-1][j];
                }
            }
        }
        for(int tc=0;tc<T;tc++){
            int N = sc.nextInt();
            long ans=0;
            for(int i=0;i<=9;i++){
                ans += dp[N][i];
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

}
