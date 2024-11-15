package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class p1860 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();
            int[] time = new int[N];
            for(int i=0;i<N;i++){
                time[i] = sc.nextInt();
            }
            int[] can = new int[11112];
            can[M] = K;
            for(int i=M;i<2*M;i++){
                can[i] = K;
            }
            for(int i=M*2;i<11112;i++){
                can[i] = can[i-M] + K;
            }

            Arrays.sort(time);
            boolean check = true;
            int minus = 0;
            for(int i=0;i<N;i++){
                if(can[time[i]] - minus >= 1) {
                    minus ++;
                }else {
                    check = false;
                    break;
                }

            }
            String ans = "Possible";
            if(!check) ans = "Impossible";
            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }
        System.out.println(sb);
    }

}