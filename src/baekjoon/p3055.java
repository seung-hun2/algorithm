package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p3055 {

    static int R,C;
    static int[][] map,dist_water,dist_hedgehog;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new int[R][C];
        dist_hedgehog = new int[R][C];
        dist_water = new int[R][C];
        visited = new boolean[R][C];

        for(int i=0;i<R;i++){
            String str = sc.next();
            for(int j=0;j<C;j++){
                map[i][j] = str.charAt(j);
            }
        }

        bfs_water();
        bfs_hedgehog();

        for (int i=0;i<R;i++){
            for (int j=0;j<C;j++){
                if (map[i][j] == 'D'){
                    if (dist_hedgehog[i][j] == -1) System.out.println("KAKTUS");
                    else System.out.println(dist_hedgehog[i][j]);
                }
            }
        }

    }
    static void bfs_water() {
        Queue<Integer> Q = new LinkedList<>();
        // 모든 물의 위치를 Q에 전부 넣어주기!
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dist_water[i][j] = -1;
                visited[i][j] = false;
                if (map[i][j] == '*') {
                    Q.add(i);
                    Q.add(j);
                    dist_water[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;  // 지도를 벗어나는 곳으로 가는가?
                if (map[nx][ny] != '.') continue;  // 갈 수 있는 칸인지 확인해야 한다.
                if (visited[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?
                Q.add(nx);
                Q.add(ny);
                visited[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y] + 1;
            }
        }
    }

    // 고슴도치를 시작으로 동시에 BFS 시작!
    static void bfs_hedgehog() {
        Queue<Integer> Q = new LinkedList<>();
        // 고슴도치 위치를 Q에 넣어주기!
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dist_hedgehog[i][j] = -1;
                visited[i][j] = false;
                if (map[i][j] == 'S') {
                    Q.add(i);
                    Q.add(j);
                    dist_hedgehog[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        // BFS 과정 시작
        while (!Q.isEmpty()) {
            int x = Q.poll();
            int y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;  // 지도를 벗어나는 곳으로 가는가?
                if (map[nx][ny] != '.' && map[nx][ny] != 'D') continue;  // 갈 수 있는 칸인지 확인해야 한다.
                if (dist_water[nx][ny] != -1 && dist_water[nx][ny] <= dist_hedgehog[x][y] + 1) continue;  // 물에 잠기지는 않는가?
                if (visited[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?
                Q.add(nx);
                Q.add(ny);
                visited[nx][ny] = true;
                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] + 1;
            }
        }
    }


}
