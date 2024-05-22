package baekjoon;

import java.util.Scanner;

public class p3584 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] par, check;
        for (int tc = 0; tc < T; tc++) {
            int N = sc.nextInt();
            par = new int[N+1];
            check = new int[N+1];
            for (int i = 0; i < N-1; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                par[B] = A;
            }
            int x = sc.nextInt();
            int y = sc.nextInt();

            while(x>0){
                check[x] = 1;
                x = par[x];
            }

            while(y>0 && check[y] == 0){
                y = par[y];
            }
            System.out.println(y);
        }
    }

}
