package baekjoon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p16234 {

    static int N,L,R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        map = new int[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        while(true){
            visited = new boolean[N][N];
            boolean check = false;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(!visited[i][j]){
                        if(solve(i,j)) check = true;
                    }
                }
            }
            if(!check) break;
            ans++;
        }


        System.out.println(ans);

    }

    static boolean solve(int x, int y){
        boolean check = false;
        Queue<Node> q = new LinkedList<>();
        List<Node> list = new ArrayList<>();
        q.add(new Node(x,y));
        list.add(new Node(x,y));

        visited[x][y] = true;
        int sum = map[x][y];

        while (!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
                if ( Math.abs(map[nx][ny]-map[now.x][now.y]) >= L && Math.abs(map[nx][ny]-map[now.x][now.y]) <= R){
                    list.add(new Node(nx,ny));
                    q.add(new Node(nx,ny));
                    sum += map[nx][ny];
                    visited[nx][ny] = true;
                    check = true;
                }
            }
        }

        if(list.size()>1) {
            for (Node node : list) {
                map[node.x][node.y] = sum / list.size();
            }
        }

        return check;
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
