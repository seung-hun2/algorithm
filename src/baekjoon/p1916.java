package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p1916 {

    // 다익스트라 풀이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Edge>[] list = new ArrayList[N+1];
        int[] dist = new int[N+1];
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2)->o1.weight - o2.weight);

        for(int i=1;i<=N;i++) dist[i] = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++) list[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            list[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        pq.add(new Info(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Info x = pq.poll();
            if(dist[x.idx] != x.weight) continue;
            for(Edge edge : list[x.idx]){
                if(dist[x.idx] + edge.weight >= dist[edge.to]) continue;

                 dist[edge.to] = dist[x.idx] + edge.weight;
                 pq.add(new Info(edge.to, dist[edge.to]));
            }
        }

        System.out.println(dist[end]);

    }

    static class Info{
        int idx, weight;
        Info(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
    }

    static class Edge{
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
/*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        final int INF = 1000000000;
        int E = sc.nextInt();
        int[][] graph = new int[N+1][N+1];
        int[] cost = new int[N+1];
        boolean[] visited = new boolean[N+1];

        for(int i=0;i<=N;i++){
            cost[i] = INF;
            for(int j=0;j<=N;j++){
                graph[i][j] = INF;
            }
        }

        for(int i=0;i<E;i++){
            int src = sc.nextInt();
            int dist = sc.nextInt();
            int b_cost = sc.nextInt();
            if(graph[src][dist] > b_cost ) graph[src][dist] = b_cost;
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        cost[start] = 0;
        for(int i=1;i<=N;i++){
            int min = INF;
            int minIndex = -1;
            for(int j=1;j<=N;j++){
                if(cost[j] < min && !visited[j]){
                    min = cost[j];
                    minIndex = j;
                }
            }
            if(minIndex == -1) break;
            visited[minIndex] = true;
            for(int j=1;j<=N;j++){
                if(cost[j] > cost[minIndex] + graph[minIndex][j]){
                    cost[j] = cost[minIndex] + graph[minIndex][j];
                }
            }
        }
        System.out.println(cost[end]);


    }

 */

}
