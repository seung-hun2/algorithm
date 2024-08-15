package baekjoon;

import java.util.Scanner;

public class p23971 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        int col = H/(N+1);
        int row = W/(M+1);
        if(H%(N+1) != 0) col++;
        if(W%(M+1) != 0) row++;
        int ans = col * row;
        System.out.println(ans);
    }
}
