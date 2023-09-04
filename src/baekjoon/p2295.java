package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p2295 {

    static boolean isExist(int[] sum, int target) {
        int l = 0, r = sum.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (target > sum[m]) {
                l = m + 1;
            } else if (target < sum[m]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] sum = new int[N * (N + 1) / 2];
        int sumIndex = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                sum[sumIndex++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sum);
        int ans = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int target = arr[i] - arr[j];
                if (isExist(sum, target)) {
                    ans = Math.max(ans, arr[i]);
                }
            }
        }

        System.out.println(ans);
    }

}
