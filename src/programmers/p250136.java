package programmers;

import java.util.*;
public class p250136 {
    class Solution {
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        boolean[][] visited;
        int[] num;
        int n,m;

        public int solution(int[][] land) {
            int answer = 0;
            n = land.length;
            m = land[0].length;
            visited = new boolean[n][m];
            num = new int[m];

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(!visited[i][j] && land[i][j] == 1){
                        bfs(land,i,j);
                    }
                }
            }
            int max = 0;
            for(int i=0;i<m;i++){
                System.out.println("i "+i + "num[i] :"+num[i]);
                if(max < num[i]){
                    max = num[i];
                }
            }
            answer = max;

            return answer;
        }
        void bfs(int[][] land, int x, int y){
            Queue<Node> q = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            int size = 1;
            q.add(new Node(x,y));
            set.add(y);
            visited[x][y] = true;

            while(!q.isEmpty()){
                Node now = q.poll();
                for(int i=0;i<4;i++){
                    int nx = now.x + dy[i];
                    int ny = now.y + dx[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if(visited[nx][ny] || land[nx][ny] == 0) continue;
                    q.add(new Node(nx,ny));
                    visited[nx][ny] = true;
                    size++;
                    set.add(ny);
                }
            }

            for(int i:set){
                num[i] += size;
            }
        }
        class Node{
            int x;
            int y;
            Node(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
    }

}
