package baekjoon;

import java.util.Scanner;

public class p10971 {

    static int[][] map;
    static boolean[] visit;
    static int N,answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visit = new boolean[N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.nextInt();
            }
        }

        recur(0,0,0,0);
        System.out.println(answer);
    }
    public static void recur(int x, int y,int sum, int cnt){
        // base case

        if(cnt == N && x==y){
            answer = Math.min(answer, sum);
            return;
        }

        // recursive case
        for(int i=0;i<N;i++){
            if(!visit[i] && map[y][i] != 0){
                visit[i] = true;
                recur(x,i,sum+map[y][i], cnt+1);
                visit[i] = false;
            }
        }

    }

}
