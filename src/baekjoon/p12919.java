package baekjoon;

import java.util.Scanner;

public class p12919 {

    static String S;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        String T = sc.next();

        // 1. 문자열 뒤에 A 추가한다.
        // 2. 문자열 뒤에 B를 추가하고 문자열을 뒤집는다.


        solve(T);
        System.out.println(0);
    }

    static void solve(String now){

        if(now.length() == 0 || now.length() < S.length()) return;
        if(now.equals(S)){
            System.out.println(1);
            System.exit(0);
        }

        int len = now.length();
        if(now.charAt(now.length()-1) == 'A'){
            solve(now.substring(0,len-1));
        }
        if(now.charAt(0) == 'B'){
            solve(new StringBuilder(now.substring(1)).reverse().toString());
        }
    }

}
