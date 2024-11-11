package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p13913 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        visited = new boolean[100001];
        if(N == K){
            System.out.println(0);
            System.out.println(K);
            return;
        }
        if(N > K){
            System.out.println(N-K);
            for(int i=N;i>=K;i--){
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }
        bfs(N,K);

        System.out.println(sb);
    }

    static void bfs(int now, int destiny){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(now,0, now + ""));

        while (!q.isEmpty()){
            Node next = q.poll();
            if(next.x == destiny){
                sb.append(next.cnt).append('\n').append(next.order);
                return;
            }
            int[] arr = new int[]{next.x-1, next.x+1, next.x*2};
            for(int i=0;i<3;i++){
                if(!isRange(arr[i])) continue;
                if(!visited[arr[i]]){
                    q.add(new Node(arr[i], next.cnt+1, next.order + " "+ arr[i]));
                }
            }
            visited[next.x] = true;
        }
    }

    static boolean isRange(int x){
        return x>=0 && x<=100000;
    }
    static class Node{
        int x;
        int cnt;
        String order;
        Node(int x, int cnt, String order){
            this.x = x;
            this.cnt = cnt;
            this.order = order;
        }
    }
}
