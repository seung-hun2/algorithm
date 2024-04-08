package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p1389 {

    static int N,M,answer,ans_value;
    static List<List<Integer>> list = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        answer = 0;
        ans_value = Integer.MAX_VALUE;

        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i=1;i<N+1;i++){
            bfs(i);
        }

        System.out.println(answer);

    }

    static void bfs(int start){
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.add(new Node(start,0));
        int result = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int next : list.get(now.idx)){
                if(visited[next]) continue;
                result += now.cnt + 1;
                visited[next] = true;
                q.add(new Node(next, now.cnt+1));
            }
        }

        if(result < ans_value){
            ans_value = result;
            answer = start;
        }
    }

    static class Node{
        int idx,cnt;
        Node(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
