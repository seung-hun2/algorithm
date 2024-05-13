package SWEA;

import java.io.StringBufferInputStream;
import java.util.Scanner;

public class p13218 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc<T;tc++){
            int N = sc.nextInt();
            sb.append("#").append(tc+1).append(" ").append(N/3).append('\n');
        }
        System.out.println(sb);
    }

}
