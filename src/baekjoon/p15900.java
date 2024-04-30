package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p15900 {

    static int N,ans;
    static List<List<Integer>> list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[N+1];
        for(int i=0;i<=N;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        ans = 0 ;
        dfs(1,0);
        System.out.println(ans%2==0 ? "No" : "Yes");
    }

    public static void dfs(int node, int cnt){
        visited[node] = true;
        for(int next : list.get(node)){
            if(!visited[next]) dfs(next,cnt+1);
        }

        if(node != 1 && list.get(node).size() == 1) ans += cnt;
    }

}
