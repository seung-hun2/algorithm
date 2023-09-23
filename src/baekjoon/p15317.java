package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p15317 {

    static long possible(int[] cost, int[] budget, int m){
        long needDiff = 0;
        for(int i=0;i<m;i++){
            needDiff += Math.max(cost[i] - budget[budget.length-m+i],0);
        }

        return needDiff;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int X = sc.nextInt();

        int[] cost = new int[N];
        for(int i=0;i<N;i++) cost[i] = sc.nextInt();

        int[] budget = new int[M];
        for(int i=0;i<M;i++) budget[i] = sc.nextInt();

        Arrays.sort(cost);
        Arrays.sort(budget);

        int l = 0;
        int r = Math.min(N,M);
        int ans = 0;
        while (l<=r){
            int m = (l+r)/2;
            if(possible(cost, budget, m) <= X){
                ans = m;
                l = m +1;
            }
            else r = m-1;
        }
        System.out.println(ans);
    }

}
