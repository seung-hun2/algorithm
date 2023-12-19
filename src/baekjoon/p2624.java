package baekjoon;

import java.util.Scanner;

public class p2624 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int k = sc.nextInt();
        int[][] dp = new int[k+1][T+1];
        dp[0][0] = 1;
        for(int i=1;i<=k;i++){
            int coinPrice = sc.nextInt();
            int coinCount = sc.nextInt();
            for(int value = 0;value<=T;value++){
                for(int cnt=0;cnt<=coinCount;cnt++){
                    int nextValue = value + coinPrice * cnt;
                    if(nextValue > T) break;
                    dp[i][nextValue] += dp[i-1][value];
                }
            }
        }
        System.out.println(dp[k][T]);
    }

}
