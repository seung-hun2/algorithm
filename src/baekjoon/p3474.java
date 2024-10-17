package baekjoon;

import java.util.Scanner;

public class p3474 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++){
            int N = sc.nextInt();
            int five = 0;
            for(int j=5;j<=N;j*=5){
                five += N/j;
            }
            System.out.println(five);
        }
    }

}
