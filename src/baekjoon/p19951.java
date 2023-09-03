package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p19951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] delta = new int[N+2];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            delta[a] += k;
            delta[b+1] -= k;
        }
        int[] accDelta = new int[N+1];
        for(int i=1;i<=N;i++){
            accDelta[i] = accDelta[i-1] + delta[i];
        }

        for(int i=1;i<=N;i++){
            System.out.print(arr[i] + accDelta[i] + " ");
        }
        System.out.println();



    }

}
