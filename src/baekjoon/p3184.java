package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p3184 {

    static int[] dy = {0,0,-1,1}, dx ={1,-1,0,0};
    static char[][] map;
    static boolean[][] visited;
    static int R,C,total_S = 0, total_W = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++){
            String str = sc.next();
            for(int j=0;j<C;j++){
                map[i][j] = str.charAt(j);
            }
        }

        // 같은 지역에 있는 양 수와 늑대 수를 체크해서 더 큰 값을 유지시킨다.
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(!visited[i][j] && map[i][j] != '#'){
                    dfs(i,j);
                }
            }
        }

        System.out.println(total_S + " " + total_W);
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        Queue<Node> q = new LinkedList<>();
        int s = 0,w = 0;
        q.add(new Node(x,y));
        if(map[x][y] == 'v') w++;
        else if(map[x][y] == 'o') s++;
        while(!q.isEmpty()){
            Node n = q.poll();
            for(int i=0;i<4;i++){
                int nx = n.x + dx[i];
                int ny = n.y + dy[i];
                if(nx <0 || nx >= R || ny<0 || ny>=C) continue;
                if(visited[nx][ny] || map[nx][ny] == '#') continue;

                visited[nx][ny] = true;
                q.add(new Node(nx,ny));
                if(map[nx][ny] == 'v') w++;
                else if(map[nx][ny] == 'o') s++;
            }
        }
        if(s <= w) total_W += w;
        else total_S += s;

    }

    static class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
