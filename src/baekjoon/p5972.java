package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class p5972 {

    static int N,M,ans;
    static List<Node>[] map;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        ans = 0;

        for(int i=1;i<=N;i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int A_i = sc.nextInt();
            int B_i = sc.nextInt();
            int C_i = sc.nextInt();
            map[A_i].add(new Node(B_i,C_i));
            map[B_i].add(new Node(A_i,C_i));

        }

        Arrays.fill(dist, Integer.MAX_VALUE);
        dfs(1,0);
        System.out.println(dist[N]);
    }

    static void dfs(int start, int value){
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
            return o1.dist - o2.dist;
        });
        dist[1] = 0;
        q.add(new Node(1,0));
        while(!q.isEmpty()){
            Node now = q.poll();
            if(!visited[now.x]) {
                visited[now.x] = true;
                for(int i=0;i<map[now.x].size();i++){
                    Node next = map[now.x].get(i);
                    if(dist[next.x] > dist[now.x] + next.dist){
                        dist[next.x] = dist[now.x] + next.dist;
                        q.add(new Node(next.x, dist[next.x]));
                    }
                }
            }
        }
    }

    static class Node{
        int x;
        int dist;
        Node(int x, int dist){
            this.x = x;
            this.dist = dist;
        }
    }

}
