package baekjoon;

import java.util.Scanner;

public class p15620 {

    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        selected = new int[N + 1];
        recur(1);
        System.out.println(sb);
    }

    public static void recur(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for (int cand = selected[k-1]+1; cand <= N; cand++) {
                selected[k] = cand;
                recur(k + 1);
                selected[k] = 0;
            }
        }
    }

}
