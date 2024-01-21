package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p159993 {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    int[] lever = new int[2];

    public int solution(String[] maps) {
        int answer = 0;

        String[][] map = new String[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[] start = new int[2];

        for(int i = 0; i < maps.length; i++) {
            String[] temp = maps[i].split("");
            map[i] = temp;
            for(int j = 0; j < temp.length; j++) {
                if(temp[j].equals("S")) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        int first = bfs(map, visited, start, "L");
        if(first == -1) {
            return -1;
        }

        visited = new boolean[maps.length][maps[0].length()];
        int second = bfs(map, visited, lever, "E");
        if(second == -1) {
            return -1;
        }

        answer = first + second;
        return answer;
    }

    public int bfs(String[][] map, boolean[][] visited, int[] start, String target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int cnt = temp[2];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                    if(map[nx][ny].equals(target)) {
                        lever[0] = nx;
                        lever[1] = ny;
                        return cnt + 1;
                    }
                    if(!map[nx][ny].equals("X") && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, cnt + 1});
                    }
                }
            }
        }
        return -1;
    }

}
