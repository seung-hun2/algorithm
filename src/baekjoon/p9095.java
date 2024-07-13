package baekjoon;

import java.util.Scanner;

public class p9095 {

    static int ans,n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            n = sc.nextInt();
            ans = 0;
            dp(0);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void dp(int value){
        if(value == n){
            ans += 1;
            return;
        }
        if(value > n) return;
        dp(value+1);
        dp(value+2);
        dp(value+3);
    }

}
