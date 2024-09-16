package baekjoon;

import java.util.Scanner;

public class p2467 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // 이분 탐색
        long value = Long.MAX_VALUE;
        int a1 = 0, a2 = N-1;

        int  l = 0, r = N-1;
        while(l<r){
            long sum = arr[l] + arr[r];
            if(value > Math.abs(sum)){
                value = Math.abs(sum);
                a1 = l;
                a2 = r;
            }
            if(sum >= 0 ){
                r--;
            }else{
                l++;
            }
        }

        System.out.println(arr[a1] + " " + arr[a2]);



    }

}
