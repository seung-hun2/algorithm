package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0;tc<T;tc++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] time = new int[N+1];
            int[] indegree = new int[N+1];
            int[] dp = new int[N+1];
            int[][] adj = new int[N+1][N+1];
            for(int i=1;i<=N;i++){
                time[i] = sc.nextInt();
            }
            for(int i=0;i<K;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj[a][b] = 1 ;
                indegree[b]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=1;i<=N;i++){
                if(indegree[i] == 0) {
                    q.add(i);
                    dp[i] = time[i];
                }
            }
            while(!q.isEmpty()){
                int now = q.poll();
                for(int next =1;next<=N;next++){
                    if(adj[now][next] == 1){
                        indegree[next]--;
                        dp[next] = Math.max(dp[next], dp[now] + time[next]);
                        if(indegree[next] == 0 )q.add(next);
                    }
                }
            }

            int w = sc.nextInt();
            System.out.println(dp[w]);

        }
    }

}
