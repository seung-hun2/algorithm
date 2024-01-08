package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p1162 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        List<Node>[] graph = new ArrayList[n+1];
        long[][] cost = new long[n+1][k+1];
        final Long INF = Long.MAX_VALUE/2;
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
            for(int j=0;j<=k;j++){
                cost[i][j] = INF;
            }
        }

        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int b_cost = sc.nextInt();
            graph[a].add(new Node(b,b_cost,0));
            graph[b].add(new Node(a,b_cost,0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
           return Long.compare(o1.cost,o2.cost);
        });
        cost[1][0] = 0;
        pq.offer(new Node(1,0,0));
        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(cost[now.dist][now.cnt] < now.cost) continue;
            for(Node next : graph[now.dist]){
                if(cost[next.dist][now.cnt] > cost[now.dist][now.cnt] + next.cost){
                    cost[next.dist][now.cnt] = cost[now.dist][now.cnt] + next.cost;
                    pq.offer(new Node(next.dist, cost[next.dist][now.cnt], now.cnt));
                }
                if(now.cnt+1 <= k && cost[next.dist][now.cnt+1] > cost[now.dist][now.cnt]){
                    cost[next.dist][now.cnt+1] = cost[now.dist][now.cnt];
                    pq.offer(new Node(next.dist, cost[next.dist][now.cnt+1], now.cnt+1));
                }
            }
        }
        long ans = INF;
        for(int i=0;i<=k;i++){
            ans = Math.min(ans, cost[n][i]);
        }
        System.out.println(ans);

    }

    static class Node{
        int dist;
        long cost;
        int cnt;

        public Node(int dist, long cost, int cnt) {
            this.dist = dist;
            this.cost = cost;
            this.cnt = cnt;
        }
    }

}
