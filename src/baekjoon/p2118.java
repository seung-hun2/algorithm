package baekjoon;

import java.util.Scanner;

public class p2118 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int pairIndex = 0;
        int distClockWise = 0, distCountClockWise = sum;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            while(distClockWise < distCountClockWise){
                distClockWise += arr[pairIndex];
                distCountClockWise -= arr[pairIndex];
                pairIndex = (pairIndex+1)%N;
            }
            ans = Math.max(ans, distCountClockWise);
            distClockWise -= arr[i];
            distCountClockWise += arr[i];
        }
        System.out.println(ans);
    }

}
