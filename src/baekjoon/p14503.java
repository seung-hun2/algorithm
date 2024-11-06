package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p14503 {

    static int N,M,ans = 1;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        map = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
            }
        }
        dfs(r,c,d);

        System.out.println(ans);

    }

    static void dfs(int r, int c, int d){

        map[r][c] = -1;
        for(int i=0;i<4;i++){
            d = (d+3)%4;
            int nx = r + dx[d];
            int ny = c + dy[d];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(map[nx][ny] == 0) {
                ans++;
                dfs(nx, ny, d);
                return;
            }
        }

        int dir = (d+2)%4;
        int nx = r + dx[dir];
        int ny = c + dy[dir];
        if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1){
            dfs(nx,ny,d);
        }
    }

    static class Node{
        int x;
        int y;
        int d;
        Node(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

}
