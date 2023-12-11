package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p10451 {

    static int N;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++){
            N = sc.nextInt();
            int ans = 0;

            /*
            bfs code

            arr = new int[N];

            boolean[] visited = new boolean[N];
            for(int i=0;i<N;i++){
                arr[i] = sc.nextInt()-1;
            }
            for(int i=0;i<N;i++){
                if(visited[i]) continue;
                visited[i] = true;
                ans++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while (!q.isEmpty()){
                    int next = q.poll();
                    if(!visited[arr[next]]){
                        q.add(arr[next]);
                        visited[arr[next]] = true;
                    }
                }
            }
            */
            arr = new int[N+1];
            visited = new boolean[N+1];
            for(int i=1;i<=N;i++){
                arr[i] = sc.nextInt();
            }
            for(int i=1;i<=N;i++){
                if(!visited[i]){
                    dfs(i);
                    ans++;
                }
            }

            System.out.println(ans);

        }

    }
    static void dfs(int node){
        visited[node] = true;
        if(!visited[arr[node]]){
            dfs(arr[node]);
        }

    }

}
