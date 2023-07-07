package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1992 {

    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        recur(0, 0, n);
        System.out.println(sb);
    }

    public static void recur(int x, int y, int size) {
        if (check(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }
        int newSize = size / 2;
        sb.append('(');
        recur(x, y, newSize);
        recur(x, y + newSize, newSize);
        recur(x + newSize, y, newSize);
        recur(x + newSize, y + newSize, newSize);
        sb.append(')');

    }

    public static boolean check(int x, int y, int size) {
        int value = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
