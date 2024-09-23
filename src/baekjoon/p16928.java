package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p16928 {

    static int N, M, ans;
    static int[] map, cnt;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[101];
        cnt = new int[101];
        visited = new boolean[101];
        for (int i = 0; i < N; i++) {
            map[sc.nextInt()] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            map[sc.nextInt()] = sc.nextInt();
        }
        ans = Integer.MAX_VALUE;
        solve();
    }

    static void solve() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        cnt[1] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == 100) {
                System.out.println(cnt[now]);
                return;
            }
            for (int i = 1; i < 7; i++) {
                int next = now + i;
                if (next > 100) {
                    continue;
                }
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;

                if (map[next] != 0) {
                    if (!visited[map[next]]) {
                        q.add(map[next]);
                        visited[map[next]] = true;
                        cnt[map[next]] = cnt[now] + 1;
                    }
                } else {
                    q.add(next);
                    cnt[next] = cnt[now] + 1;
                }

            }
        }


    }

}
