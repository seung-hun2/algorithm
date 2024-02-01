package baekjoon;

import java.util.Scanner;

public class p10974 {

    static int N;
    static int[] arr,value;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        value = new int[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            arr[i] = i+1;
        }
        recur(0);
        System.out.println(sb);
    }

    static void recur(int depth){
        if(depth == N){
            for(int i=0;i<N;i++) sb.append(value[i]).append(' ');
            sb.append('\n');
        }else{
            for(int i=0;i<N;i++){
                if(visited[i]) continue;
                value[depth] = arr[i];
                visited[i] = true;
                recur(depth+1);
                visited[i] = false;
            }
        }
    }

}
