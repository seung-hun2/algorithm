package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p2637 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Toy>[] toy = new ArrayList[N+1];
        Queue<Integer> q = new LinkedList<>();
        int[] indeg = new int[N+1];
        int[][] cnt = new int[N+1][N+1];

        for(int i=1;i<=N;i++) toy[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            int Y = sc.nextInt();
            int X = sc.nextInt();
            int K = sc.nextInt();

            toy[X].add(new Toy(Y,K));
            indeg[Y]++;
        }

        for(int i=1;i<=N;i++){
            if(indeg[i] == 0){
                q.add(i);
                cnt[i][i] = 1;
            }
        }

        while(!q.isEmpty()){
            int x = q.poll();
            for(Toy toy1 : toy[x]){
                int y = toy1.y, k = toy1.k;
                indeg[y]--;
                for(int i=1;i<=N;i++){
                    cnt[y][i] += cnt[x][i] * k;
                }
                if(indeg[y] == 0) q.add(y);
            }
        }

        for(int i=1;i<=N;i++){
            if (cnt[N][i] != 0) {
                System.out.println(i + " " + cnt[N][i]);
            }
        }

    }

    static class Toy{
        int y, k;
        Toy(int y, int k){
            this.y = y;
            this.k = k;
        }
    }

}
