package baekjoon;

import java.util.Scanner;

public class p6236 {


    static boolean isPossible(int[] arr, int drawAmount, int maxDrawCount) {
        int drawCount = 1;
        int current = drawAmount;
        for (int useAmount : arr) {
            if (useAmount > drawAmount) {
                return false;
            }
            if (useAmount > current) {
                if (drawCount == maxDrawCount) {
                    return false;
                }
                drawCount++;
                current = drawAmount;
            }
            current -= useAmount;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int l = 1, r = N * 10000;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (l > arr[i]) {
                l = arr[i];
            }
        }

        int ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(arr, m, M)) {
                r = m - 1;
                ans = m;
            } else {
                l = m + 1;
            }
        }
        System.out.println(ans);
    }

}
