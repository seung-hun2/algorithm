package baekjoon;

import java.util.Scanner;

public class p1987 {

    static int R,C,answer;
    static int[] dx = {0,0,-1,1},dy={1,-1,0,0};
    static boolean[] arr;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        arr = new boolean[26];
        map = new int[R][C];
        answer = 1;

        for(int i=0;i<R;i++){
            String str = sc.next();
            for(int j=0;j<C;j++){
                map[i][j] = str.charAt(j)-'A';
            }
        }
        arr[map[0][0]] = true;

        int answer = solve(0,0);
        System.out.println(answer);

    }

    public static int solve(int x, int y){
        int result = 0;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0 || ny<0 || nx>=C || ny >=R) continue;
            if(arr[map[ny][nx]]) continue;

            arr[map[ny][nx]] = true;
            result = Math.max(result, solve(nx,ny));
            arr[map[ny][nx]] = false;

        }
        return result+1;
    }

}
