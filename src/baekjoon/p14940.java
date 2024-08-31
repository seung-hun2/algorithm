package baekjoon;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class p14940 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[][] ans = new int[N][M];
        int sx = 0;
        int sy = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int next = sc.nextInt();
                if (next == 1) {
                    map[i][j] = 1;
                } else if (next == 2) {
                    sx = i;
                    sy = j;
                } else {
                    map[i][j] = 0;
                }
            }
        }


        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy));
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] != 1) {
                    continue;
                }
                visited[nx][ny] = true;
                ans[nx][ny] = ans[now.x][now.y] + 1;
                q.add(new Node(nx, ny));
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (ans[i][j] == 0) {
                    if (map[i][j] != 0) {
                        sb.append(-1).append(" ");
                    } else {
                        sb.append(0).append(" ");
                    }
                } else {
                    sb.append(ans[i][j]).append(" ");
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    static class Node {

        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
