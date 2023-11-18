package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p2573 {

    static int N,M;
    static boolean[][] visited;
    static int[][] map;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static List<Ice> iceList;
    static class Ice{
        int row,col,height;

        public Ice(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];
        iceList = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] > 0){
                    iceList.add(new Ice(i,j,map[i][j]));
                }
                visited[i][j] = true;
            }
        }

        // 시간이 흐를때마다 빙산 녹이기
        for(int year= 1;!iceList.isEmpty();year++){
            for(Ice ice : iceList ){
                for(int j=0;j<4;j++){
                    int nx = ice.row + dx[j];
                    int ny = ice.col + dy[j];
                    if(map[nx][ny] == 0) ice.height--;
                }
            }

            for(int i=0;i<iceList.size();i++){
                Ice ice = iceList.get(i);
                if(ice.height <= 0){
                    map[ice.row][ice.col] = 0;
                    iceList.set(i,iceList.get(iceList.size()-1));
                    iceList.remove(iceList.size()-1);
                    i--;
                }
                // 빙산이 남아있다면 연결되어 있는지 탐색하도록 세팅
                else{
                    visited[ice.row][ice.col] = false;
                }
            }

            if(iceList.size() > 0 && dfs(iceList.get(0).row,iceList.get(0).col) != iceList.size()){
                System.out.println(year);
                System.exit(0);
            }
        }
        System.out.println(0);
    }
    static int dfs(int r, int c){
        visited[r][c] = true;
        int cnt = 1;
        for(int i=0;i<4;i++){
            int nx = r + dx[i];
            int ny = c + dy[i];
            if(visited[nx][ny]) continue;
            cnt += dfs(nx,ny);
        }
        return cnt;
    }

}
