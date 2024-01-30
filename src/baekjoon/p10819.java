package baekjoon;

import java.util.Scanner;

public class p10819 {

    static int N,max = Integer.MIN_VALUE;
    static int[] arr, selected;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        selected = new int[N];
        visited = new boolean[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        recur(0);
        System.out.println(max);
    }

    static void recur(int depth){
        if(depth == N){
            max = Math.max( getResult(), max);
        }else{
            for(int i=0;i<N;i++){
                if(visited[i]) continue;
                visited[i] = true;
                selected[depth] = arr[i];
                recur(depth+1);
                visited[i] = false;
            }
        }
    }

    static int getResult(){
        int sum = 0;
        for(int i=0;i<N-1;i++){
            sum += Math.abs(selected[i] - selected[i+1]);
        }
        return sum;
    }

}
