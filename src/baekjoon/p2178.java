package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2178 {

    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N][M];
        map = new int[N][M];


        for(int i=0;i<N;i++){
            String str = sc.next();
            for(int j=0;j<M;j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[0][0] = true;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            for(int i=0;i<4;i++){
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                if(nx<0||nx>=N||ny<0||ny>=M) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;

                map[nx][ny] = map[arr[0]][arr[1]]+1;
                q.add(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }
    }
}
