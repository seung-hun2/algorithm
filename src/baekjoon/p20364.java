package baekjoon;

import java.util.Scanner;

public class p20364 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int Q = sc.nextInt();
        boolean[] arr = new boolean[N+1];

        while(Q-->0){
            int x = sc.nextInt();
            int y = x;
            int res = 0;

            while(x>0){
                if(arr[x]) res = x;
                x /= 2;
            }
            arr[y] = true;
            sb.append(res).append('\n');
        }
        System.out.println(sb);

    }

}
