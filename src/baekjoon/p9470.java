package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p9470 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int tc=0;tc<T;tc++){
            int K = sc.nextInt();
            int M = sc.nextInt();
            int P = sc.nextInt();
            List<Integer>[] list = new ArrayList[M+1];
            int[] deg = new int[M+1];
            int[] order = new int[M+1];
            int[] maxCnt = new int[M+1];
            Queue<Integer> q = new LinkedList<>();

            for(int i=1;i<=M;i++){
                list[i] = new ArrayList<>();
            }
            for(int i=1;i<=P;i++){
                int A = sc.nextInt();
                int B = sc.nextInt();
                list[A].add(B);
                deg[B]++;
            }

            for(int i=1;i<=M;i++){
                if(deg[i] == 0){
                    q.add(i);
                    order[i]++;
                    maxCnt[i]++;
                }
            }

            int ans = 0;
            while(!q.isEmpty()){
                int x = q.poll();
                if(maxCnt[x] >= 2) order[x]++;
                ans = Math.max(ans, order[x]);
                for(int y : list[x]){
                    deg[y]--;
                    if(deg[y] == 0) q.add(y);
                    if(order[y] == order[x]) maxCnt[y]++;
                    else if(order[y] < order[x]){
                        order[y] = order[x];
                        maxCnt[y] = 1;
                    }
                }
            }

            System.out.println(K+" "+ans);
        }
    }

}
