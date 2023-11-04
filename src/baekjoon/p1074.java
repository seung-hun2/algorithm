package baekjoon;

import java.util.Scanner;

public class p1074 {

    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        count = 0;
        solve(N,r,c);
        System.out.println(count);
    }

    public static void solve(int n, int r, int c) {
        if(n == 0) return;

        int boardSize = 1 << n;
        int mid = boardSize / 2;

        if (r < mid && c < mid) {
            solve(n - 1, r, c);
        } else if (r < mid && c >= mid) {
            count += mid * mid;
            solve(n - 1, r, c - mid);
        } else if (r >= mid && c < mid) {
            count += mid * mid * 2;
            solve(n - 1, r - mid, c);
        } else {
            count += mid * mid * 3;
            solve(n - 1, r - mid, c - mid);
        }
    }

}
