package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p5567 {

    static int N,M,answer;
    static boolean[] visited;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N+1];
        answer = 0;
        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited[1] = true;
        bfs();

        System.out.println(answer);

    }

    static void bfs(){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,0));
        while (!q.isEmpty()){
            Node now = q.poll();
            if( now.depth > 1) continue;
            for(int next : list.get(now.idx)){
                if(visited[next]) continue;
                visited[next] = true;
                answer++;
                q.add(new Node(next, now.depth+1));
            }
        }
    }

    static class Node{
        int idx,depth;
        Node(int idx, int depth){
            this.idx = idx;
            this.depth = depth;
        }
    }

}
