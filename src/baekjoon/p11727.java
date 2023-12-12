package baekjoon;

import java.util.Scanner;

public class p11727 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[1000];
        arr[0] = 1;
        arr[1] = 3;
        for(int i=2;i<N;i++){
            arr[i] = (arr[i-2]*2 + arr[i-1])%10007;
        }
        System.out.println(arr[N-1]);

    }

}
