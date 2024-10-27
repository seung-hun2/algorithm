package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2589 {


    static int L,W,ans;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static char[][] map;
    static boolean[][] visited;
    static int[][] count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        W = sc.nextInt();
        map = new char[L][W];
        visited = new boolean[L][W];
        ans = 0;

        for(int i=0;i<L;i++){
            String str = sc.next();
            for(int j=0;j<W;j++){
                map[i][j] = str.charAt(j);
            }
        }


        for(int i=0;i<L;i++){
            for(int j=0;j<W;j++){
                if(map[i][j] == 'L') {
                    visited = new boolean[L][W];
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans);

    }

    static void bfs(int i, int j){
        Queue<Node> q= new LinkedList<>();
        q.add(new Node(i,j,0));
        visited[i][j] = true;
        int len = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int r=0;r<4;r++){
                int nx = now.x + dy[r];
                int ny = now.y + dx[r];
                if(nx < 0 || nx >= L || ny < 0 || ny >= W) continue;
                if(visited[nx][ny] || map[nx][ny]=='W') continue;
                visited[nx][ny] = true;
                q.add(new Node(nx,ny, now.dist+1));
                len = Math.max(len, now.dist+1);
            }
        }

        ans = Math.max(len, ans);
    }

    static class Node{
        int x;
        int y;
        int dist;
        Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

}
