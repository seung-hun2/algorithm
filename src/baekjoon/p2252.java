package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p2252 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer>[] list = new List[N+1];
        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        int[] indegree = new int[N+1];
        int[] check = new int[N+1];

        for(int i=0;i<M;i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            list[A].add(B);
            indegree[B]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int now = q.poll();
            check[now] = 1;
            System.out.print(now + " ");
            for(int next : list[now]){
                if(check[next] == 1) continue;
                indegree[next]--;
                if(indegree[next] == 0 ) q.add(next);
            }
        }

    }

}
