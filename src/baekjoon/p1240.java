package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1240 {

    static int N, M, max;
    static List<Node>[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int dist = sc.nextInt();
            arr[x].add(new Node(y, dist));
            arr[y].add(new Node(x, dist));
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            dfs(A, B, 0);
            System.out.println(max);
            max = 0;
            visited = new boolean[N + 1];
        }
    }

    static void dfs(int x, int y, int dist) {
        if (x == y) {
            max = dist;
            return;
        }

        visited[x] = true;
        for (int i = 0; i < arr[x].size(); i++) {
            if(!visited[arr[x].get(i).next]){
                dfs(arr[x].get(i).next, y, dist+arr[x].get(i).dist);
            }
        }


    }

    static class Node {

        int next;
        int dist;

        public Node(int next, int dist) {
            this.next = next;
            this.dist = dist;
        }
    }

}
