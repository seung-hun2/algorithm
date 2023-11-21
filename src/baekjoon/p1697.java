package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1697 {

    static int[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        visited = new int[100001];
        bfs(N,K);
        System.out.println(visited[K] - 1);
    }
    public static void bfs(int N, int K){

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;
        while (!q.isEmpty()){
            int next = q.poll();
            if(next == K) break;
            int[] arr = new int[]{next-1,next+1,next*2};
            for(int i=0;i<3;i++){
                if(!isRange(arr[i])) continue;
                if(visited[arr[i]] == 0){
                    visited[arr[i]] = visited[next] + 1;
                    q.add(arr[i]);
                }
            }
        }
    }



    static boolean isRange(int x) {
        return x >= 0 && x <= 100000;
    }

}
