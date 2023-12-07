package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p14442 {

    static int N, M, K;
    static int[][] map;
    static int[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        map = new int[N][M];
        visited = new int[N][M][K+1];
        visited[0][0][0] = 1;

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                int c = str.charAt(j) - '0';
                map[i][j] = c;
            }
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.x == N - 1 && now.y == M - 1) {
                System.out.println(visited[N - 1][M - 1][now.cnt]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny][now.cnt] == 0){
                    if (map[nx][ny] == 0){
                        visited[nx][ny][now.cnt] = visited[now.x][now.y][now.cnt] + 1;
                        q.add(new Node(nx,ny,now.cnt));
                    }else{
                        if(now.cnt < K && visited[nx][ny][now.cnt+1] == 0){
                            visited[nx][ny][now.cnt+1] = visited[now.x][now.y][now.cnt] + 1;
                            q.add(new Node(nx,ny,now.cnt+1));
                        }
                    }
                }
            }

        }
        System.out.println(-1);

    }

    static class Node {

        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

}
