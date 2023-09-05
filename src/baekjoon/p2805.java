package baekjoon;

import java.util.Scanner;

public class p2805 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        int l = 0, r = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            if (r < arr[i]) {
                r = arr[i];
            }
        }
        while (l <= r) {
            long sum = 0;
            int mid = (l + r) / 2;
            for (int i = 0; i < N; i++) {
                if (arr[i] - mid > 0) {
                    sum += arr[i] - mid;
                }
            }
            if(sum<M) r = mid-1;
            else l = mid + 1;
        }

        System.out.println(l-1);
    }

}
