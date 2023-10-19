package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p1759 {

    static int L, C;
    static char[] input, password;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        input = new char[C];
        password = new char[L];
        for (int i = 0; i < C; i++) {
            input[i] = sc.next().charAt(0);
        }

        Arrays.sort(input);
        generate(0, 0, 0);

    }

    static void generate(int length, int index, int vowelCnt) {
        // base
        if (length == L) {
            if (vowelCnt >= 1 && L - vowelCnt >= 2) {
                System.out.println(password);
            }
            return;
        }
        // recursive
        if (index < C) {

            password[length] = input[index];
            int v = isVowel(input[index]) ? 1 : 0;
            generate(length + 1, index + 1, vowelCnt + v);

            password[length] = 0;
            generate(length, index + 1, vowelCnt);
        }

    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
