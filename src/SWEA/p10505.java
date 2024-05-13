package SWEA;

import java.util.Scanner;

public class p10505 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++){
            int N = sc.nextInt();
            int[] arr = new int[N];
            double av = 0.0;

            for(int i=0;i<N;i++){
                arr[i] = sc.nextInt();
                av += arr[i];
            }
            av /= N;

            int cnt = 0;
            for(int i=0;i<N;i++){
                if(av >= arr[i]) cnt++;
            }

            sb.append("#").append(tc).append(" ").append(cnt).append('\n');
        }
        System.out.println(sb);
    }

}
