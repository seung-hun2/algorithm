package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p14425 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr);
        int answer = 0;
        for (int i = 0; i < M; i++) {
            String next = sc.next();
            if(isExist(arr,next)) answer++;
        }
        System.out.println(answer);


    }

    static boolean isExist(String[] arr, String x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (r + l) / 2;
            int result = arr[m].compareTo(x);
            if (result < 0) {
                l = m + 1;
            } else if (result > 0) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
