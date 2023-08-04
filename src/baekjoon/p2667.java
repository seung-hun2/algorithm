package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class p2667 {

    static int N,count;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int[][] arr;
    static boolean[][] visit;
    static ArrayList<Integer> answer;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];
        answer = new ArrayList<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j] && arr[i][j] == 1){
                    count = 1;
                    dfs(i,j);
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        sb.append(answer.size()).append('\n');
        for(int cnt: answer) sb.append(cnt).append('\n');
        System.out.println(sb.toString());


    }
    static void dfs(int x, int y){
        visit[x][y] = true;
        for(int k=0;k<4;k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
            if(arr[nx][ny] == 0 || visit[nx][ny]) continue;
            dfs(nx, ny);
            count++;
        }
    }
}
