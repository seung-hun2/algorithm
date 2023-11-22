package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p12851 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] visited = new int[100001];
        int[] count = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;
        count[N] = 1;

        while(!q.isEmpty()){
            int now = q.poll();
            int[] next = {now-1,now+1,now*2};
            for(int i=0;i<3;i++){
                if(!isRange(next[i])) continue;
                if(visited[next[i]] == 0){
                    visited[next[i]] = visited[now] + 1;
                    q.add(next[i]);
                    count[next[i]] = count[now];
                }else if(visited[next[i]] == visited[now] + 1){
                    count[next[i]] += count[now];
                }
            }
        }

        System.out.println(visited[K]-1);
        System.out.println(count[K]);
    }

    static boolean isRange(int x){
        return x>=0 && x<=100000;
    }

}
