package SWEA;

import java.util.Scanner;

public class p1289 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int ans = 0;
            String str = sc.next();
            int before = str.charAt(0);
            char c = '0';
            if(before != c ) ans++;
            for (int j = 1; j < str.length(); j++) {
                if (before == str.charAt(j)) {
                    continue;
                } else {
                    ans++;
                    before = str.charAt(j);
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

}
