package SWEA;

import java.util.Scanner;

public class p4406 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            String str = sc.next();
            String ans = "";
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                if(ch=='a' || ch=='e' || ch=='i'
                ||ch=='o' || ch=='u') continue;
                else ans += ch;
            }

            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

}
