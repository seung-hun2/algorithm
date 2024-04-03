package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p14502 {

    static int N,M,wall,answer;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] map, blank;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        blank = new int[N*M][2];
        visited = new boolean[N][M];
        answer = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0){
                    wall++;
                    blank[wall][0] = i;
                    blank[wall][1] = j;
                }
            }
        }
        // bfs로 체킹하고 ? 빈값 넣어야댐
        dfs(1,0);

        System.out.println(answer);


    }

    public static void dfs(int idx, int selected_cnt){
        if(selected_cnt == 3){
            bfs();
            return;
        }
        if(idx > wall) return;
        map[blank[idx][0]][blank[idx][1]] = 1;
        dfs(idx+1, selected_cnt+1);
        map[blank[idx][0]][blank[idx][1]] = 0;
        dfs(idx+1, selected_cnt);
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                visited[i][j] = false;
                if (map[i][j] == 2){
                    q.add(i);
                    q.add(j);
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int x = q.poll();
            int y = q.poll();
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx<0||nx>=N || ny<0||ny>=M) continue;
                if(visited[nx][ny] || map[nx][ny] != 0 )continue;
                visited[nx][ny] = true;
                q.add(nx);
                q.add(ny);
            }
        }

        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0 && !visited[i][j]) cnt++;
            }
        }
        answer = Math.max(answer, cnt);
    }


}
