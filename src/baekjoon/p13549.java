package baekjoon;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p13549 {

    static int N,K;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[100001];

        bfs(N, 0);

        System.out.println(ans);
    }
    static void bfs(int now, int value){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(now,value));
        while(!q.isEmpty()){
            Node next = q.poll();
            if(visited[next.now]) continue;
            visited[next.now] = true;
            if(next.now == K){
                ans = Math.min(ans, next.value);
                continue;
            }

            if(next.now * 2 <= 100000  && !visited[next.now*2]) q.add(new Node(next.now*2, next.value));
            if(next.now - 1 >= 0 && !visited[next.now-1]) q.add(new Node(next.now - 1, next.value+1));
            if(next.now + 1 <= 100000 && !visited[next.now+1]) q.add(new Node(next.now + 1, next.value+1));


        }
    }
    static class Node{
        int now;
        int value;
        Node(int now, int value){
            this.now = now;
            this.value = value;
        }
    }

}
