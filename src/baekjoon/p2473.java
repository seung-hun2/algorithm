package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p2473 {


    static int N;
    static long[] arr;
    static long[] pick = new long[3];
    static long max = 3000000000L;


    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N =sc.nextInt();
        arr = new long[N];
        for(int i=0;i<N;i++) arr[i] = sc.nextLong();
        Arrays.sort(arr);

        for(int i=0;i<N-2;i++) func(i);
        Arrays.sort(pick);

        for(int i=0;i<3;i++){
            System.out.print(pick[i] + " ");
        }

    }

    static void func(int idx){

        int l = idx+1;
        int r = N-1;
        while(l<r){
            long sum = arr[l] + arr[r] + arr[idx];
            if(Math.abs(sum) < max){
                pick[0] = arr[l];
                pick[1] = arr[r];
                pick[2] = arr[idx];
                max = Math.abs(sum);
            }

            if(sum > 0) r--;
            else l++;
        }
    }

}
