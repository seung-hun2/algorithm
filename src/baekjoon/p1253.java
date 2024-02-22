package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p1253 {

    static int N;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1];
        for(int i=1;i<=N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr,1,N+1);

        int ans = 0;
        for(int i=1;i<=N;i++){
            if(func(i)) ans++;
        }

        System.out.println(ans);

    }

    static boolean func(int idx){
        int L = 1, R = N;
        int target = arr[idx];
        while(L<R){
            if(L == idx) L++;
            else if (R==idx) R--;
            else{
                if(arr[L] + arr[R] == target) return true;
                if(arr[L] + arr[R] > target) R--;
                else L++;
            }
        }
        return false;
    }



}
