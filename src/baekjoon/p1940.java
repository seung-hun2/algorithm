package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p1940 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        // 1 2 3 4 5 7
        int start = 0;
        int end = N-1;
        int cnt = 0;

        while(start < end){
            if(arr[start] + arr[end] < M){
                start++;
            }else if(arr[start] + arr[end] > M){
                end--;
            }else{
                start++;
                end--;
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}
