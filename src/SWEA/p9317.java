package SWEA;

import java.util.Scanner;

public class p9317 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int N = sc.nextInt();
            String f = sc.next();
            String s = sc.next();
            int ans = 0;

            for(int i=0;i<N;i++){
                if(f.charAt(i) == s.charAt(i)) ans++;
            }

            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

}
