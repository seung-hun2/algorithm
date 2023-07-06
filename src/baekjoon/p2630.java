package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2630 {

    public static int[][] arr;
    public static int a = 0, b = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, n);

        System.out.println(a);
        System.out.println(b);


    }

    public static void recur(int row, int col, int size) {

        if (colorCheck(row, col, size)) {
            if (arr[row][col] == 0) {
                a++;
            } else {
                b++;
            }
            return;
        }
        int newSize = size / 2;
        recur(row, col, newSize);
        recur(row, col + newSize, newSize);
        recur(row + newSize, col, newSize);
        recur(row + newSize, col + newSize, newSize);

    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = arr[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

}
