package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1303 {

    static int N,M,wP,bP;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[M+1][N+1];
        visited = new boolean[M+1][N+1];

        for(int i=0;i<M;i++){
            String str = sc.next();
            for(int j=0;j<N;j++){
                map[i][j] = str.charAt(j);
            }
        }

        wP = 0;
        bP = 0;

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    bfs(i,j,map[i][j]);
                }
            }
        }

        System.out.println(wP + " " + bP);

    }

    static void bfs(int x, int y, char ch){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visited[x][y] = true;
        int size = 1;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx>=M || ny<0 || ny>=N) continue;
                if(visited[nx][ny] || map[nx][ny] != ch) continue;
                visited[nx][ny] = true;
                size++;
                q.add(new Node(nx, ny));
            }
        }

        if(ch == 'W') wP += size*size;
        else bP += size*size;

    }

    static class Node{
        int x,y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


}
