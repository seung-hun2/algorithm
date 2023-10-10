package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p15656 {

    static int N, M;
    static int[] numbers, output;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N];
        output = new int[M];
        check = new boolean[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

        perm(0, 0);
        System.out.println(sb);
    }

    public static void perm(int depth, int start) {
        // base case
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(output[i]).append(" ");
            }
            sb.append('\n');
            return;
        }
        // recursive case
        for (int i = 0; i < N; i++) {
            output[depth] = numbers[i];
            perm(depth + 1, i);
        }

    }

}
