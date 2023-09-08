package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p2230 {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int rightIndex=0, sum=arr[0], ans = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            while(rightIndex<N-1 && arr[rightIndex]-arr[i] < M){
                rightIndex++;
            }
            sum = arr[rightIndex]-arr[i];
            if(sum >= M) ans = Math.min(sum, ans);
        }
        System.out.println(ans);
    }

}
