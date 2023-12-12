package baekjoon;

import java.util.Scanner;

public class p2156 {

    static int[] arr;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1];
        int[][] d = new int[3][N+1];
        for(int i=1;i<=N;i++){
            arr[i] = sc.nextInt();
        }
        d[0][1] = 0;
        d[1][1] = arr[1];
        d[2][1] = arr[1];
        for(int i=2;i<=N;i++){
            d[0][i] = Math.max(d[0][i-1],Math.max(d[1][i-1], d[2][i-1]));
            d[1][i] = d[0][i-1] + arr[i];
            d[2][i] = d[1][i-1] + arr[i];
        }
        System.out.println(Math.max(d[0][N],Math.max(d[1][N], d[2][N])));
    }
}
