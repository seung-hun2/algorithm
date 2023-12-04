package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p5427 {

    static int w, h;
    static int[][] fire;
    static int[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int t = 0; t < N; t++) {
            w = sc.nextInt();
            h = sc.nextInt();
            fire = new int[h][w];
            visited = new int[h][w];
            Queue<Point> q = new LinkedList<>();
            Queue<Point> fireQ = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String str = sc.next();
                for (int j = 0; j < w; j++) {
                    char c = str.charAt(j);
                    if (c == '#') {
                        visited[i][j] = fire[i][j] = -1;
                    } else if (c == '@') {
                        q.add(new Point(i, j));
                        visited[i][j] = 1;
                    } else if (c == '*') {
                        fireQ.add(new Point(i, j));
                        fire[i][j] = 1;
                    }
                }
            }

            while (!fireQ.isEmpty()) {
                Point now = fireQ.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (isRange(nx, ny)) {
                        continue;
                    }
                    if (fire[nx][ny] == 0) {
                        fire[nx][ny] = fire[now.x][now.y] + 1;
                        fireQ.add(new Point(nx, ny));
                    }
                }
            }

            boolean isEscaped = false;
            while (!q.isEmpty()) {
                Point now = q.poll();
                if (isExit(now.x, now.y)) {
                    System.out.println(visited[now.x][now.y]);
                    isEscaped = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if (isRange(nx, ny)) {
                        continue;
                    }
                    if (visited[nx][ny] != 0) {
                        continue;
                    }
                    if (fire[nx][ny] == 0 || fire[nx][ny] > visited[now.x][now.y] + 1) {
                        visited[nx][ny] = visited[now.x][now.y] + 1;
                        q.add(new Point(nx, ny));
                    }
                }
            }

            if (!isEscaped) {
                System.out.println("IMPOSSIBLE");
            }

        }
    }

    static boolean isRange(int x, int y) {
        return x < 0 || x >= h || y < 0 || y >= w;
    }

    static boolean isExit(int x, int y) {
        return x == 0 || x == h - 1 || y == 0 || y == w - 1;
    }

    static class Point {

        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
