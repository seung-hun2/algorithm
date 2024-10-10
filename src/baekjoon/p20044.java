package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p20044 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n*2];
        for(int i=0;i<n*2;i++) arr[i] = sc.nextInt();

        Arrays.sort(arr);
        int idx = n*2-1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min, arr[i]+arr[idx--]);
        }
        System.out.println(min);
    }

}
