package baekjoon;

import java.util.Scanner;

public class p11047 {

    static int N, K;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        int cnt=0;

        for(int i=N-1;i>=0;i--){
            if(K==0) break;
            if(K/arr[i] != 0){
                cnt += K/arr[i];
                K %= arr[i];
            }
        }
        System.out.println(cnt);
    }

}
