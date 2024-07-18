package baekjoon;

import java.util.Scanner;

public class p10870 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] fibo = new int[21];
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;

        for(int i=2;i<=N;i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        System.out.println(fibo[N]);
    }

}
