package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p2056 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] T = new int[N+1];
        int[] T_done = new int[N+1];
        int[] indeg = new int[N+1];
        List<Integer>[] work = new ArrayList[N+1];
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=N;i++) work[i] = new ArrayList<>();
        for(int i=1;i<=N;i++){
            T[i] = sc.nextInt();
            int cnt = sc.nextInt();
            while(cnt-->0){
                int next = sc.nextInt();
                work[next].add(i);
                indeg[i]++;
            }
        }

        for(int i=1;i<=N;i++){
            if(indeg[i] == 0){
                T_done[i] = T[i];
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int x = q.poll();
            for(int y : work[x]){
                indeg[y]--;
                if(indeg[y] == 0) q.add(y);
                T_done[y] = Math.max(T_done[y], T_done[x]+T[y]);
            }
        }

        int ans = 0;
        for(int i=1;i<=N;i++){
            ans = Math.max(ans, T_done[i]);
        }
        System.out.println(ans);
    }

}
