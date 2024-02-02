package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p2529 {

    static int N;
    static char[] arr = new char[10]; // 부등호는 최대 9개임
    static boolean[] visited = new boolean[10]; // 0~9까지 check
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++)
            arr[i] = sc.next().charAt(0);

        dfs("", 0);
        Collections.sort(ans);

        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));

    }

    private static void dfs(String num, int idx) {
        if (idx == N + 1) {
            ans.add(num);
        }
        else {
            for (int i = 0; i <= 9; i++) {
                if (visited[i])
                    continue;
                if (idx == 0 || ck(Character.getNumericValue(num.charAt(idx - 1)), i, arr[idx - 1])) {
                    visited[i] = true;
                    dfs(num + i, idx + 1);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean ck(int a, int b, char c) {
        if (c == '<') {
            if (a > b) return false;
        } else if (c == '>') {
            if (a < b) return false;
        }
        return true;
    }

}
