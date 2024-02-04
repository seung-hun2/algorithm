package baekjoon;

import java.util.Scanner;

public class p2961 {

    static int N, min = Integer.MAX_VALUE;
    static int[] sour, bitter;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sour = new int[N];
        bitter = new int[N];

        for (int i = 0; i < N; i++) {
            sour[i] = sc.nextInt();
            bitter[i] = sc.nextInt();
        }
        recur(0, 0, 1, 0);
        System.out.println(min);


    }

    static void recur(int depth, int cnt, int s_sum, int b_sum) {
        if (depth == N) {
            if (cnt != 0) {
                min = Math.min(min, Math.abs(s_sum - b_sum));
            }
        } else {
            recur(depth + 1, cnt + 1, s_sum * sour[depth], b_sum + bitter[depth]);
            recur(depth + 1, cnt, s_sum, b_sum);
        }
    }

}
