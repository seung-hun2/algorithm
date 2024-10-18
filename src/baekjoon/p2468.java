package baekjoon;

import java.util.Scanner;

public class p2468 {

    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                max = Math.max(map[i][j], max);
            }
        }

        int ans = 0;
        for (int i = 0; i <= max; i++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] > i && !visited[j][k]) {
                        cnt++;
                        dfs(j, k, i);
                    }
                }
                ans = Math.max(cnt, ans);
            }
        }
        System.out.println(ans);

    }

    static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (visited[nx][ny] || map[nx][ny] <= h) {
                continue;
            }
            dfs(nx, ny, h);
        }
    }

}
