package baekjoon;

import java.util.Scanner;

public class p15831 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int B = sc.nextInt();
        int W = sc.nextInt();
        char[] color = sc.next().toCharArray();

        int countBlack = 0;
        int countWhite = 0;
        int nextIndex = 0;
        int ans = 0;

        for (int i = 0; i < N; i++) {
            while (nextIndex < N) {
                if (color[nextIndex] == 'B' && countBlack == B) {
                    break;
                }
                if (color[nextIndex++] == 'W') {
                    countWhite++;
                } else {
                    countBlack++;
                }
            }
            if (countWhite >= W) {
                ans = Math.max(ans, nextIndex - i);
            }
            if(color[i] == 'W') countWhite--;
            else countBlack--;
        }
        System.out.println(ans);

    }

}
