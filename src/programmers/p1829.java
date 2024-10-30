package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p1829 {
    class Solution {
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;

            boolean[][] visited = new boolean[m][n];

            for(int i=0;i<picture.length;i++){
                for(int j=0;j<picture[0].length;j++){
                    if(!visited[i][j] && picture[i][j] != 0){
                        maxSizeOfOneArea = Math.max(bfs(i,j,picture,visited,picture[i][j]), maxSizeOfOneArea);
                        numberOfArea++;
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        public int bfs(int x, int y, int[][] picture, boolean[][] visited, int color ){
            int cnt = 1;
            visited[x][y] = true;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{x,y});
            while(!q.isEmpty()){
                int[] pop = q.poll();
                int px = pop[0];
                int py = pop[1];

                for(int i=0;i<4;i++){
                    int nx = px + dx[i];
                    int ny = py + dy[i];

                    if(nx <0 || nx >= picture.length || ny < 0 || ny>= picture[0].length) continue;
                    if(!visited[nx][ny] && picture[nx][ny] == color){
                        q.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        cnt++;
                    }
                }
            }
            return cnt;
        }
    }

}
