package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p18404 {

    static int N,M;
    static int x,y;
    static int[][] map;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};
    static Queue<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        map = new int[N][N];
        q.add(x-1);
        q.add(y-1);
        bfs();
        for(int i=0;i<M;i++){
            sb.append(map[sc.nextInt()-1][sc.nextInt()-1]).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs(){

        while(!q.isEmpty()){
            int now_x = q.poll();
            int now_y = q.poll();
            for(int i=0;i<8;i++){
                int nx = now_x + dx[i];
                int ny = now_y + dy[i];
                if(nx <0 || nx>=N || ny<0 || ny>=N) continue;
                if(map[nx][ny] == 0){
                    map[nx][ny] = map[now_x][now_y] + 1;
                    q.add(nx);
                    q.add(ny);
                }
            }

        }
    }

}
