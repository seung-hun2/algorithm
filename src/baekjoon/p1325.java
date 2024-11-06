package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p1325 {

    static int[] cnt;
    static List<Integer>[] list;
    static boolean[] visited;
    static int N,M,ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        cnt = new int[N+1];

        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            list[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
        }

        for(int i=1;i<=N;i++){
            visited = new boolean[N+1];
            bfs(i);
        }

        for(int i=1;i<=N;i++){
            ans = Math.max(ans, cnt[i]);
        }

        for(int i=1;i<=N;i++){
            if(ans == cnt[i]){
                System.out.print(i +" ");
            }
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i:list[now]){
                if(visited[i]) continue;
                cnt[i]++;
                q.add(i);
                visited[i] = true;
            }
        }
    }
    static void solve(int idx){
        visited[idx] = true;

        for(int i: list[idx]){
            if(visited[i]) continue;
            cnt[i]++;
            solve(i);
        }
    }
}
