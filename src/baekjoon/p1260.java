package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1260 {

    static int N,M,V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        visit = new boolean[N+1];

        for(int i=1;i<=N;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adj[x].add(y);
            adj[y].add(x);
        }
        for(int i=1;i<=N;i++){
            Collections.sort(adj[i]);
        }
        dfs(V);
        sb.append('\n');
        for(int i=1;i<=N;i++) visit[i] = false;
        bfs(V);
        System.out.println(sb);


    }
    public static void dfs(int x){
        visit[x] = true;
        sb.append(x).append(' ');

        for(int y: adj[x]){
            if(visit[y]) continue;
            dfs(y);
        }

    }

    public static void bfs(int x){

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;

        while(!q.isEmpty()){
            x = q.poll();
            sb.append(x).append(' ');
            for(int y : adj[x]){
                if(visit[y]) continue;
                q.add(y);
                visit[y] = true;
            }
        }
    }
}
