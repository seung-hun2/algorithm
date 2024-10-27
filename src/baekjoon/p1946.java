package baekjoon;

import java.util.Scanner;

public class p1946 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int tc=0;tc<T;tc++){
            int N = sc.nextInt();
            int[] work = new int[N+1];
            for(int i=0;i<N;i++){
                work[sc.nextInt()] = sc.nextInt();
            }

            int vot = work[1];
            int count = 1;
            for(int j=2;j<=N;j++){
                if(work[j] < vot){
                    vot = work[j];
                    count++;
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }

}
