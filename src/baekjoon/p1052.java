package baekjoon;

import java.util.Scanner;

public class p1052 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int ans = 0;
        while(Integer.bitCount(N) > K){
            ans += N &(-N);
            N += N & (-N);
        }
        System.out.println(ans);
    }

}
