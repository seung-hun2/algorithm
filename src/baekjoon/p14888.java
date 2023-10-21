package baekjoon;

import java.util.Scanner;

public class p14888 {

    static final int PLUS = 0;
    static final int MINUS = 1;
    static final int MUL = 2;
    static final int DIV = 3;
    static int[] A, arr = new int[4];
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        A = new int[N];
        arr = new int[4];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            arr[i] = sc.nextInt();
        }

        solve(1, A[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int index, int sum) {
        // base case
        if (index == N) {
            if (sum > max) {
                max = sum;
            }
            if (sum < min) {
                min = sum;
            }
            return;
        }
        // recursive case
        for (int i = 0; i < 4; i++) {
            if (arr[i] > 0) {
                arr[i]--;
                switch (i) {
                    case PLUS :
                        solve(index + 1, sum + A[index]);
                        break;
                    case MINUS:
                        solve(index + 1, sum - A[index]);
                        break;
                    case MUL :
                        solve(index + 1, sum * A[index]);
                        break;
                    case DIV :
                        solve(index + 1, sum / A[index]);
                        break;
                }
                arr[i]++;
            }
        }

    }
}
