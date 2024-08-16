package baekjoon;

import java.util.Scanner;

public class p4659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pos = "> is acceptable.\n";
        String impos = "> is not acceptable.\n";
        StringBuilder sb = new StringBuilder();
        String next;

        while (true){
            next = sc.next();
            if(next.equals("end")) break;
            int cnt = 0;
            boolean flag = false;
            char prev = '.';

            for(int i=0;i<next.length();i++){
                if(isVowel(next.charAt(i))) flag = true;

                if(isVowel(next.charAt(i)) != isVowel(prev)) cnt = 1;
                else cnt++;

                if(cnt > 2 || (prev == next.charAt(i) && (next.charAt(i) != 'e' && next.charAt(i) != 'o')) ){
                    flag = false;
                    break;
                }

                prev = next.charAt(i);
            }

            if(flag) sb.append('<').append(next).append(pos);
            else sb.append('<').append(next).append(impos);

        }
        System.out.println(sb);
    }

    static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

}
