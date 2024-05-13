package SWEA;

import java.util.Scanner;

public class p12368 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc<T;tc++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            sb.append("#").append(tc+1).append(" ").append((A+B)%24).append('\n');
        }
        System.out.println(sb);
    }

}
