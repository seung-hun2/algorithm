package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p7576 {

    static int N,M;
    static int[][] box;
    static int[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        box = new int[N][M];
        visited = new int[N][M];
        Queue<Point> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1){
                    q.add(new Point(i,j));
                    visited[i][j] = 1;
                }
            }
        }


        while(!q.isEmpty()){
            Point now = q.poll();
            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx<0||nx>=N||ny<0||ny>=M) continue;
                if(visited[nx][ny] == 0 && box[nx][ny] == 0){
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    q.add(new Point(nx,ny));
                }
            }
        }

        int max = 0;
        boolean check = true;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                max = Math.max(max, visited[i][j]);
                if(visited[i][j] == 0 && box[i][j] == 0){
                    check = false;
                    break;
                }
            }
        }
        if (check) {
            System.out.println(max-1);
        }else{
            System.out.println(-1);
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
