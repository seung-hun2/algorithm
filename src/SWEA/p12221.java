package SWEA;

import java.util.Scanner;

public class p12221 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int ans = -1;
            if(A < 10 && B < 10) ans = A*B;
            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

}
