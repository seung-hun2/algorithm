package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p340211 {
    class Solution {

        int[][] map;
        Queue<Node>[] q;

        public int solution(int[][] points, int[][] routes) {
            q = new LinkedList[routes.length];
            for(int i=0;i<routes.length;i++){
                q[i] = new LinkedList<>();
            }
            int answer = 0;
            // 세로로 내려가는거 먼저 수행해야함
            // 시간을 전부 기록한 후
            for(int i=0;i<routes.length;i++){
                int start = routes[i][0]-1;
                int x = points[start][0];
                int y = points[start][1];
                q[i].add(new Node(x,y));
                for(int j=1;j<routes[0].length;j++){
                    int next = routes[i][j] -1;
                    int nx = points[next][0];
                    int ny = points[next][1];

                    int xp = nx - x;
                    int yp = ny - y;
                    while(xp != 0){
                        if(xp>0){
                            xp--;
                            x++;
                            q[i].add(new Node(x,y));
                        }else{
                            xp++;
                            x--;
                            q[i].add(new Node(x,y));
                        }
                    }

                    while(yp != 0){
                        if(yp>0){
                            yp--;
                            y++;
                            q[i].add(new Node(x,y));
                        }else{
                            yp++;
                            y--;
                            q[i].add(new Node(x,y));
                        }
                    }

                }


            }

            // 전체 체크한 후 2개 이상 있는 개수를 구하면 됨
            int cnt = 0;
            while(cnt != routes.length){
                map = new int[101][101];
                cnt = 0;
                for(int i=0;i<routes.length;i++){
                    if(q[i].isEmpty()){
                        cnt++;
                        continue;
                    }
                    Node tmp = q[i].poll();
                    map[tmp.x][tmp.y]++;
                }

                for(int i=0;i<101;i++){
                    for(int j=0;j<101;j++){
                        if(map[i][j] > 1) answer++;
                    }
                }
            }


            return answer;
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
