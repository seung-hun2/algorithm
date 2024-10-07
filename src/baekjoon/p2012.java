package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p2012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        long ans = 0;
        for(int i=1;i<=N;i++){
            ans += Math.abs(arr[i-1] - i);
        }

        System.out.println(ans);
    }

}
