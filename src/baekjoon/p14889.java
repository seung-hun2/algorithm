package baekjoon;

import java.util.Scanner;

public class p14889 {

    static int N, min = Integer.MAX_VALUE,M;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visited = new boolean[N];
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        recur(0,0);
        System.out.println(min);
    }

    static void recur(int idx, int depth){
        if(depth == N/2){
            int start = 0;
            int link = 0;
            for(int i=0;i<N-1;i++){
                for(int j=i+1;j<N;j++){
                    if(visited[i] && visited[j]){
                        start += arr[i][j];
                        start += arr[j][i];
                    }else if( !visited[i] && !visited[j]){
                        link += arr[i][j];
                        link += arr[j][i];
                    }
                }
            }

            int value = Math.abs(start-link);
            if(value ==0){
                System.out.println(value);
                System.exit(0);
            }
            min = Math.min(value,min);

        }else{
            for(int i=idx;i<N;i++) {
                if (visited[i]) continue;
                visited[i] = true;
                recur(i+1, depth+1);
                visited[i] = false;
            }

        }
    }

}
