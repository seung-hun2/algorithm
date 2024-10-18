package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p2583 {

    static int M, N, K;
    static boolean[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        list = new ArrayList<>();

        map = new boolean[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            int lx = sc.nextInt();
            int ly = sc.nextInt();
            int rx = sc.nextInt();
            int ry = sc.nextInt();

            for (int j = ly; j < ry; j++) {
                for (int k = lx; k < rx; k++) {
                    map[j][k] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && !map[i][j]) {
                    dfs(j, i);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        if (list.size() != 0) {
            for (int i : list) {
                System.out.print(i + " ");
            }
        }


    }

    static void dfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[y][x] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (map[ny][nx] || visited[ny][nx]) {
                    continue;
                }
                visited[ny][nx] = true;

                q.add(new Node(nx, ny));
                cnt++;
            }
        }

        list.add(cnt);


    }

    static class Node {

        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}