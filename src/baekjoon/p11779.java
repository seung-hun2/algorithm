package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class p11779 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge>[] graph = new ArrayList[n+1];
        final int INF = 1000000000;
        boolean[] check = new boolean[n+1];
        int[] cost = new int[n+1];
        int[] path = new int[n+1];

        for(int i=0;i<=n;i++){
            cost[i] = INF;
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int b_cost = sc.nextInt();
            graph[a].add(new Edge(b, b_cost));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->{
           return o1.cost- o2.cost;
        });
        pq.offer(new Edge(start,0));
        cost[start] = 0;
        while (!pq.isEmpty()){
            Edge now = pq.poll();
            if(cost[now.dist] < now.cost) continue;
            for (Edge next : graph[now.dist]){
                if(cost[now.dist] + next.cost < cost[next.dist]){
                    cost[next.dist] = cost[now.dist] + next.cost;
                    pq.offer(new Edge(next.dist, cost[next.dist]));
                    path[next.dist] = now.dist;
                }
            }
        }
        System.out.println(cost[end]);
        Stack<Integer> stack = new Stack<>();
        int now = end;
        while(now != 0){
            stack.push(now);
            now = path[now];
        }
        System.out.println(stack.size());
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
    static class Edge{
        int dist;
        int cost;

        public Edge(int dist, int cost) {
            this.dist = dist;
            this.cost = cost;
        }
    }

}
