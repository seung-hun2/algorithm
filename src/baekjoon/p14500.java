package baekjoon;

import java.util.Scanner;

public class p14500 {

    static int N,M,ans = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N][M];
        map = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j] = true;
                solve(i,j,1,map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(ans);
    }

    static void solve(int r, int c, int depth, int value){
        if(depth == 4){
            ans = Math.max(ans, value);
            return;
        }

        for(int i=0;i<4;i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if(nx <0 || nx >= N || ny < 0 || ny >= M )continue;
            if(visited[nx][ny]) continue;
            if(depth == 2){
                visited[nx][ny] = true;
                solve(r,c, depth + 1, value + map[nx][ny] );
                visited[nx][ny] = false;
            }
            visited[nx][ny] = true;
            solve(nx, ny, depth + 1, value + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }

}
