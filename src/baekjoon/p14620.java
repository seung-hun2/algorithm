package baekjoon;

import java.util.Scanner;

public class p14620 {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0,0);
        System.out.println(result);
    }
    static void dfs(int depth, int total){
        if(depth == 3){
            result = Math.min(result, total);
            return;
        }

        for(int i=1;i<N-1;i++){
            for(int j=1;j<N-1;j++){
                if(visited[i][j]) continue;
                if(visited[i-1][j]) continue;
                if(visited[i][j-1]) continue;
                if(visited[i+1][j]) continue;
                if(visited[i][j+1]) continue;

                visited[i][j] = true;
                visited[i-1][j] = true;
                visited[i][j-1] = true;
                visited[i+1][j] = true;
                visited[i][j+1] = true;

                int sum = map[i][j] + map[i-1][j] + map[i][j-1] + map[i+1][j] + map[i][j+1];
                dfs(depth+1, total + sum);

                visited[i][j] = false;
                visited[i-1][j] = false;
                visited[i][j-1] = false;
                visited[i+1][j] = false;
                visited[i][j+1] = false;
            }
        }

    }

}
