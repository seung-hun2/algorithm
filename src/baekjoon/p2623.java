package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p2623 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer>[] list = new ArrayList[N+1];
        int[] indegree = new int[N+1];
        int[] check = new int[N+1];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<=N;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++) {
            int cnt = sc.nextInt();
            int front = sc.nextInt();
            for(int j=2;j<=cnt;j++){
                int back = sc.nextInt();
                list[front].add(back);
                indegree[back]++;
                front = back;
            }
        }
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int now = q.poll();
            check[now] = 1;
            ans.add(now);
            if(ans.size() > N){
                System.out.println(0);
                return;
            }
            for(int next : list[now]){
                if(check[next] == 1) continue;
                indegree[next]--;
                if(indegree[next] == 0) q.add(next);
            }
        }
        for(int i=1;i<=N;i++){
            if (check[i] == 0){
                System.out.println(0);
                return;
            }
        }
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }

    }

}
