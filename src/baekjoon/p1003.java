package baekjoon;

import java.util.Scanner;

public class p1003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        int[] fibo0 = new int[41];
        int[] fibo1 = new int[41];

        fibo0[0] = 1;
        fibo0[1] = 0;
        fibo1[0] = 0;
        fibo1[1] = 1;

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            for(int j=2;j<=N;j++){
                fibo0[j] = fibo0[j-1] + fibo0[j-2];
                fibo1[j] = fibo1[j-1] + fibo1[j-2];
            }
            sb.append(fibo0[N]).append(" ").append(fibo1[N]).append('\n');
        }

        System.out.println(sb);
    }

}
