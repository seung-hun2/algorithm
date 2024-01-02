package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p1766 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] indegree = new int[N+1];
        List<Integer>[] list = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            list[A].add(B);
            indegree[B]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int now = q.poll();
            System.out.print(now +" ");
            for(int next : list[now]){
                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }
    }

}
