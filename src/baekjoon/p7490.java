package baekjoon;

import java.util.Scanner;

public class p7490 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 0; tc < T; tc++) {
            int num = sc.nextInt();
            dfs(num, 1, 1, 1, 0, "1");
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int max, int now, int num, int sign, int sum, String str) {
        if (max == now) {
            sum += num * sign;
            if (sum == 0) {
                sb.append(str).append('\n');
            }
            return;
        }
        dfs(max, now + 1, num * 10 + (now + 1), sign, sum, str + " " + String.valueOf(now + 1));
        dfs(max, now + 1, now + 1, 1, sum + (num * sign), str + "+" + String.valueOf(now + 1));
        dfs(max, now + 1, now + 1, -1, sum + (num * sign), str + "-" + String.valueOf(now + 1));
    }

}
