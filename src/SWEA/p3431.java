package SWEA;

import java.util.Scanner;

public class p3431 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int L = sc.nextInt();
            int U = sc.nextInt();
            int X = sc.nextInt();

            if(X < L) sb.append("#"+tc+" ").append(L-X).append('\n');
            else if(X < U) sb.append("#"+tc+" ").append(0).append('\n');
            else if(X > U) sb.append("#"+tc+" ").append(-1).append('\n');

        }

        System.out.println(sb);

    }

}
