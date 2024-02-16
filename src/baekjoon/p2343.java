package baekjoon;

import java.util.Scanner;

public class p2343 {

    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        arr = new int[N];
        int l = 0, r = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            r += arr[i];
            l = Math.max(l, arr[i]);
        }

        while (l <= r) {
            int m = (l + r) / 2;
            int count = recur(m);

            if (count > M) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        System.out.println(l);
    }

    static int recur(int m) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (sum + arr[i] > m) {
                sum = 0;
                count++;
            }
            sum += arr[i];
        }

        if (sum != 0) {
            count++;
        }
        return count;
    }

}
