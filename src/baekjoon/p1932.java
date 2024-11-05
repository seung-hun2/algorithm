package baekjoon;

import java.util.Scanner;

public class p1932 {

    static int N;
    static int[][] arr, dp;
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N][N];
        dp = new int[N][N];



        for(int i=0;i<N;i++){
            for(int j=0;j<i+1;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<N;i++){
            dp[N-1][i] = arr[N-1][i];
        }
        System.out.println(solve(0,0));
    }

    static int solve(int depth, int idx){
        if(depth == N - 1) return dp[depth][idx];

        if(dp[depth][idx] == 0){
            dp[depth][idx] = Math.max(solve(depth+1,idx), solve(depth+1,idx+1)) + arr[depth][idx];
        }

        return dp[depth][idx];
    }

}
