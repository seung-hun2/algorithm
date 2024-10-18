package baekjoon;

import java.security.cert.PolicyQualifierInfo;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1189 {

    static int R,C,K;
    static int ans;
    static boolean[][] map;
    static boolean[][] visited;

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        map = new boolean[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++){
            String str = sc.next();
            for(int j=0;j<C;j++){
                if(str.charAt(j) == '.') map[i][j] = true;
            }
        }

        visited[R-1][0] = true;
        dfs(R-1,0,1);
        System.out.println(ans);

     }
     static void dfs(int r, int c, int moved){
        if(r == 0 && c == C-1){
            if(moved == K){
                ans++;
            }
            return;
        }

        for(int i=0;i<4;i++){
            int nx = r + dx[i];
            int ny = c + dy[i];
            if(nx < 0 || nx >= R || ny<0 || ny>=C) continue;
            if(visited[nx][ny] || !map[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx,ny,moved+1);
            visited[nx][ny] = false;

        }
     }

}
