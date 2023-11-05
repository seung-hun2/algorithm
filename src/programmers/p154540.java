package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p154540 {
    class Solution {
        boolean[][] check;
        char[][] map;
        int[] dx={0,0,-1,1};
        int[] dy = {1,-1,0,0};
        public List<Integer> solution(String[] maps) {
            List<Integer> answer = new ArrayList<>();
            map = new char[maps.length][maps[0].length()];
            check = new boolean[maps.length][maps[0].length()];
            for(int i=0;i<maps.length;i++){
                map[i] = maps[i].toCharArray();
            }

            for(int i=0;i<map.length;i++){
                for(int j=0;j<map[i].length;j++){
                    if(!check[i][j] && map[i][j] != 'X') answer.add(bfs(i,j));
                }
            }
            if(answer.size() == 0) answer.add(-1);
            Collections.sort(answer);

            return answer;
        }
        public int bfs(int x, int y){
            int sum = 0;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{x,y});
            check[x][y] = true;

            while(!q.isEmpty()){
                int[] c = q.poll();
                int cx = c[0];
                int cy = c[1];
                sum += map[cx][cy] - '0';
                for(int i=0;i<4;i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if(nx < 0 || nx >= map.length || ny <0 || ny >= map[0].length) continue;
                    if(check[nx][ny] || map[nx][ny] == 'X') continue;

                    check[nx][ny] = true;
                    q.add(new int[]{nx,ny});
                }
            }

            return sum;
        }
    }

}
