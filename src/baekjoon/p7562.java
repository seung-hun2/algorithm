package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p7562 {

    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for(int tc=0;tc<t;tc++){
            int x = sc.nextInt();
            int[][] map = new int[x][x];
            boolean[][] visited = new boolean[x][x];
            Queue<Integer> q = new LinkedList<>();
            q.add(sc.nextInt());
            q.add(sc.nextInt());

            int a_x = sc.nextInt();
            int a_y = sc.nextInt();

            while(!q.isEmpty()){
                int now_x = q.poll();
                int now_y = q.poll();
                visited[now_x][now_y] = true;
                for(int i=0;i<8;i++){
                    int nx = now_x + dx[i];
                    int ny = now_y + dy[i];
                    if(nx < 0 || nx>=x || ny<0||ny>=x) continue;
                    if(visited[nx][ny]) continue;
                    map[nx][ny] = map[now_x][now_y]+1;
                    visited[nx][ny] = true;
                    q.add(nx);
                    q.add(ny);
                    if(nx == a_x && ny == a_y) break;
                }
            }

            sb.append(map[a_x][a_y]).append('\n');

        }
        System.out.println(sb);
    }

}
