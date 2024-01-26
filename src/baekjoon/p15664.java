package baekjoon;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p15664 {

    static int N,M;
    static int[] arr,value;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        value = new int[N];
        visited = new boolean[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        recur(0,0);

        System.out.println(sb);

    }

    public static void recur(int start, int depth){
        if(depth == M){
            for(int i=0;i<M;i++){
                sb.append(value[i]).append(' ');
            }
            sb.append('\n');
        }else{
            int before = -1;
            for(int i=start;i<N;i++){
                if (visited[i] || before == arr[i]) continue;
                visited[i] = true;
                before = arr[i];
                value[depth] = arr[i];
                recur(i+1, depth+1);
                visited[i] = false;
            }
        }
    }

}
