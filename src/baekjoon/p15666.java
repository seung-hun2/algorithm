package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p15666 {

    static int N,M;
    static int[] arr,value;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        value = new int[M];
        arr = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        recur(0,0);
        System.out.println(sb);
    }

    static void recur(int start,int depth){
        if(depth == M){
            for(int i=0;i<M;i++) sb.append(value[i]).append(' ');
            sb.append('\n');
        }else{
            int before = -1;
            for(int i=start;i<N;i++){
                if(before == arr[i]) continue;
                value[depth] = arr[i];
                before = arr[i];
                recur(i,depth+1);
                value[depth] = 0;
            }
        }
    }

}
