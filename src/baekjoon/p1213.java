package baekjoon;

import java.util.Scanner;

public class p1213 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ans = "";

        int[] alpha = new int[26];
        String str = sc.next();
        for(int i=0;i<str.length();i++){
            alpha[str.charAt(i)-'A']++;
        }

        int cnt = 0;
        for(int i=0;i<26;i++){
            if(alpha[i] %2 == 1) cnt++;
        }

        StringBuilder sb = new StringBuilder();
        if(cnt > 1) {
            System.out.println("I'm Sorry Hansoo");
        }else{
            for(int i=0;i<26;i++){
                for(int j=0;j<alpha[i]/2;j++){
                    sb.append((char)(i+'A'));
                }
            }
            ans += sb.toString();
            String end = sb.reverse().toString();
            sb = new StringBuilder();
            for(int i=0;i<26;i++){
                if(alpha[i]%2 == 1){
                    sb.append((char)(i+'A'));
                }
            }
            ans += sb.toString() + end;
            System.out.println(ans);
        }

    }

}
