package baekjoon;

import java.util.Scanner;

public class p1806 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        int rightIndex = 0, ans = Integer.MAX_VALUE;
        long sum = arr[0];
        for(int i=0;i<N;i++){
            while(rightIndex<N-1&& sum<S){
                sum += arr[++rightIndex];
            }
            if(sum >= S){
                ans = Math.min(ans, rightIndex-i+1);
            }
            sum -= arr[i];
        }
        if(ans == Integer.MAX_VALUE) ans = 0;
        System.out.println(ans);
    }

}
