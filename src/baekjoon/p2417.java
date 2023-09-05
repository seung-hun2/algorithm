package baekjoon;

import java.util.Scanner;

public class p2417 {

    static long N, answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        binarySearch();
        System.out.println(answer);
    }

    static void binarySearch() {
        long start = 0;
        long end = N;

        while (start <= end) {
            long m = (start + end) / 2;
            if (Math.pow(m, 2) >= N) {
                answer = m;
                end = m - 1;
            } else {
                start = m + 1;
            }
        }
    }

}
