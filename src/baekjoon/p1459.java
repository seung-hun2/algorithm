package baekjoon;

import java.util.Scanner;

public class p1459 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        long W = sc.nextLong();
        long S = sc.nextLong();

        int min = Math.min(X,Y);
        int max = Math.max(X,Y);
        int total = X + Y;

        long st = total * W;
        long cross = min*S + W*(max-min);
        long zigzag = ((total & 1) == 0) ? max * S : (max-1)*S + W;

        System.out.println(Math.min(zigzag,Math.min(st, cross)));
    }

}
