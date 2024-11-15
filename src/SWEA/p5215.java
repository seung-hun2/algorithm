package SWEA;

import java.util.Scanner;

public class p5215 {

    static int N,L,ans;
    static int[] taste,kcal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            N = sc.nextInt();
            L = sc.nextInt();
            taste = new int[N];
            kcal = new int[N];
            ans = 0;

            for(int i=0;i<N;i++){
                taste[i] = sc.nextInt();
                kcal[i] = sc.nextInt();
            }

            dp(0,0,0);

            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void dp(int idx, int t, int k){

        if(k > L) return;
        if(idx == N-1) {
            if(k+kcal[idx] <= L) ans = Math.max(t+taste[idx], ans);
            ans = Math.max(t, ans);
            return;
        }
        dp(idx+1, t, k);
        dp(idx+1, t + taste[idx], k + kcal[idx]);
    }

}
