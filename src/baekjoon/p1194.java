package baekjoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1194 {

    static int N, M;
    static char[][] maze;
    static int[][][] distance;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static final int DOOR = 1;
    static final int KEY = 2;
    static final int EXIT = 3;
    static final int WALL = 4;
    static final int NONE = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        maze = new char[N][M];
        distance = new int[N][M][1 << 6];
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                maze[i][j] = c;
                if (c == '0') {
                    q.add(new Point(i, j, 0));
                    distance[i][j][0] = 1;
                }
            }
        }

        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                int next = maze[nx][ny];
                switch (getType(next)){
                    case WALL: break;
                    case NONE :
                        if(distance[nx][ny][now.key] == 0){
                            distance[nx][ny][now.key]  = distance[now.x][now.y][now.key]+1;
                            q.add(new Point(nx,ny,now.key));
                        }
                        break;

                    case EXIT :
                        System.out.println(distance[now.x][now.y][now.key]);
                        return ;

                    case KEY :
                        int nextKey = now.key | 1<<(next-'A');
                        if(distance[nx][ny][nextKey] == 0){
                            distance[nx][ny][nextKey] = distance[now.x][now.y][now.key] + 1;
                            q.add(new Point(nx,ny,nextKey));
                        }
                        break;

                    case DOOR :
                        if((now.key & (1 << (next-'A'))) == 0) continue;
                        if(distance[nx][ny][now.key] == 0){
                            distance[nx][ny][now.key] = distance[now.x][now.y][now.key] + 1;
                            q.add(new Point(nx,ny,now.key));
                        }
                        break;

                }
            }
        }
        System.out.println(-1);
    }

    static int getType(int c) {
        if (c == '#') {
            return WALL;
        } else if (c == '.' || c == '0') {
            return NONE;
        } else if (c >= 'a' && c <= 'z') {
            return KEY;
        } else if (c >= 'A' && c <= 'Z') {
            return DOOR;
        } else if (c == '1') {
            return EXIT;
        }
        return -1;
    }

    static class Point {

        int x, y, key;

        public Point(int x, int y, int key) {
            this.x = x;
            this.y = y;
            this.key = key;
        }
    }


}
