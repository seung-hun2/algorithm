package baekjoon;

import java.util.Scanner;

public class p1159 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String no = "PREDAJA";
        int[] cnt = new int[26];
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            String next  = sc.next();
            cnt[next.charAt(0)-'a']++;
        }
        String ans = "";
        for(int i=0;i<26;i++){
            if(cnt[i] >= 5 ) ans += (char)(i+'a');
        }
        if (ans.equals("")) {
            System.out.println(no);
        }else{
            System.out.println(ans);
        }
    }

}
