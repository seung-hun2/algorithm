package baekjoon;

import java.util.Scanner;

public class p2758 {

    public static long[][] mem;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0;i<T;i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            mem = new long[N+1][M+1];
            for(int j=0;j<=N;j++){
                for(int k=0;k<=M;k++){
                    mem[j][k] = -1;
                }
            }
            System.out.println(recursive(N,M));
        }

    }
    public static long recursive(int i, int last){
        // base case
        if(last <= 0) return 0;
        if(i ==1) return last;

        // recursive case
        if(mem[i][last] == -1) {
            mem[i][last] = recursive(i - 1, last / 2) + recursive(i, last - 1);
        }
        return mem[i][last];

    }

}
