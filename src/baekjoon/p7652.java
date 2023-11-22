package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p7652 {

    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static int N;
    static int[][] board;
    static int[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int t=0;t<tc;t++){
            N = sc.nextInt();
            board = new int[N][N];
            visited = new int[N][N];
            Point start = new Point(sc.nextInt(), sc.nextInt());
            Point end = new Point(sc.nextInt(), sc.nextInt());
            Queue<Point> q = new LinkedList<>();
            q.add(start);
            visited[start.x][start.y] = 1;
            while (!q.isEmpty()){
                Point now = q.poll();
                if(now.x == end.x && now.y == end.y){
                    System.out.println(visited[now.x][now.y] -1);
                    break;
                }
                for(int i=0;i<8;i++){
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                    if(nx<0||ny<0 || nx>=N||ny>=N) continue;
                    if(visited[nx][ny] == 0){
                        visited[nx][ny] = visited[now.x][now.y]+1;
                        q.add(new Point(nx,ny));
                    }
                }
            }
        }
    }

    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
