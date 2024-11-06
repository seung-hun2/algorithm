package baekjoon;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2210 {

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[5][5];
        visited = new boolean[5][5];

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                bfs(i,j);
            }
        }
        System.out.println(hashSet.size());

    }

    static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y,0,""));
        visited[x][y] = true;
        while (!q.isEmpty()){
            Node now = q.poll();
            if(now.cnt == 6) {
                hashSet.add(Integer.parseInt(now.now));
                continue;
            }
            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= 5 || ny< 0 || ny>=5) continue;
                q.add(new Node(nx,ny,now.cnt+1,now.now+map[nx][ny]));
            }
        }

    }

    static class Node{
        int x;
        int y;
        int cnt;
        String now;
        Node(int x, int y, int cnt, String now){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.now = now;
        }
    }

}
