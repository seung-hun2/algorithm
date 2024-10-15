package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p11655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                char nextCh = (char) (ch + 13);
                if (nextCh > 'Z') {
                    nextCh = (char) (nextCh - 'Z' + 'A' - 1);
                    sb.append(nextCh);
                } else {
                    sb.append(nextCh);
                }
            } else if (ch >= 'a' && ch <= 'z') {
                char nextCh = (char) (ch + 13);
                if (nextCh > 'z') {
                    nextCh = (char) (nextCh - 'z' + 'a' - 1);
                    sb.append(nextCh);
                } else {
                    sb.append(nextCh);
                }
            } else {
                sb.append(ch);
            }
        }

        System.out.println(sb);

    }

}
