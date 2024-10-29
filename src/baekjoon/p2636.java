package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2636 {

    static int N,M,cheese, time;

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        cheese = 0;
        time = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) cheese++;
            }
        }

        boolean check = true;

        int cnt = 0;
        while(cheese != 0){
            cnt = cheese;
            time++;
            visited = new boolean[N][M];
            bfs();
        }

        System.out.println(time);
        System.out.println(cnt);


    }
    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        visited[0][0] = true;
        while (!q.isEmpty()){
            Node now = q.poll();
            for(int r=0;r<4;r++){
                int nx = now.x + dx[r];
                int ny = now.y + dy[r];
                if(nx <0 || nx >= N || ny <0 || ny>=M) continue;
                if(visited[nx][ny] ) continue;
                if(map[nx][ny] == 0){
                    q.add(new Node(nx,ny));
                }else{
                    cheese--;
                    map[nx][ny] = 0;
                }
                visited[nx][ny] = true;
            }
        }

    }

    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
