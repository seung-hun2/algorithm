package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p15665 {

    static int N,M;
    static int[] arr,value;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        value = new int[M];
        visited = new boolean[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        recur(0);
        System.out.println(sb);
    }

    public static void recur(int depth){
        if(depth == M){
            for(int i=0;i<M;i++){
                sb.append(value[i]).append(' ');
            }
            sb.append('\n');
        }else{
            int before = -1;
            for(int i=0;i<N;i++){
                if(before == arr[i]) continue;
                before = arr[i];
                value[depth] = arr[i];
                recur(depth+1);
                value[depth] = 0;
            }
        }
    }

}
