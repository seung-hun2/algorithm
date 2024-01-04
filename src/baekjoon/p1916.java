package baekjoon;

import java.util.Scanner;

public class p1916 {

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

}
