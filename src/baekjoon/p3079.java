package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p3079 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        long max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        long result = Long.MAX_VALUE;
        long l = 0;
        long h = M * max;
        while (l <= h) {
            long mid = (l + h) / 2;
            long sum = 0;
            for (long idx : arr) {
                long cnt = mid / idx;
                if (sum >= M) {
                    break;
                }
                sum += cnt;
            }
            if (sum >= M) {
                h = mid - 1;
                result = Math.min(mid, result);
            } else {
                l = mid + 1;
            }
        }

        System.out.println(result);

    }

}
