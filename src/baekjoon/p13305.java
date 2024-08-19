package baekjoon;

import java.util.Scanner;

public class p13305 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] dist = new long[N-1];
        long[] oil = new long[N];
        for(int i=0;i<N-1;i++){
            dist[i] = sc.nextInt();
        }
        for(int i=0;i<N;i++){
            oil[i] = sc.nextInt();
        }

        long now = oil[0];
        long ans = now * dist[0];

        for(int i=1;i<N-1;i++){
            if(now > oil[i]) now = oil[i];
            ans += now * dist[i];
        }

        System.out.println(ans);
    }

}
