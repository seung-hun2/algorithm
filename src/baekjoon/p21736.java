package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p21736 {

    static int N,M,ans;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        ans = 0;
        map = new char[N][M];
        visited = new boolean[N][M];
        int x = 0, y = 0;

        for(int i=0;i<N;i++){
            String str = sc.next();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j);
                if(str.charAt(j) == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x,y);

        if (ans == 0) {
            System.out.println("TT");
        } else {
            System.out.println(ans);
        }
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = true;
        while(!q.isEmpty()){
            int[] p = new int[2];
            p = q.poll();
            for(int i=0;i<4;i++){
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visited[nx][ny] || map[nx][ny] == 'X') continue;

                if(map[nx][ny] == 'P') {
                    ans++;
                }
                visited[nx][ny] = true;
                q.add(new int[]{nx,ny});
            }
        }
    }

}
