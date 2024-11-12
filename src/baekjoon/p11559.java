package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import javax.swing.undo.CannotUndoException;
import javax.xml.stream.events.NotationDeclaration;

public class p11559 {

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new char[12][6];
        // R G B P Y
        for(int i=0;i<12;i++){
            String str = sc.next();
            for(int j=0;j<6;j++){
                map[i][j] = str.charAt(j);
            }
        }

        int ans = 0;
        while(true){
            visited = new boolean[12][6];
            boolean check = false;
            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    if(visited[i][j]) continue;
                    if(map[i][j] == 'R' || map[i][j] == 'G' || map[i][j] == 'B' ||
                        map[i][j] == 'P' || map[i][j] == 'Y' ) {
                        if(find(new Node(i, j), new ArrayList<>())) check = true;
                    }
                }
            }
            if(!check) break;
            down();
//            for(int i=0;i<12;i++){
//                for(int j=0;j<6;j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            ans++;
        }

        System.out.println(ans);
    }

    // 뿌요 찾기
    static boolean find(Node start, List<Node> list){
        list.add(start);
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[start.x][start.y] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx < 0 || nx >= 12 || ny < 0 || ny >= 6) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] != map[now.x][now.y]) continue;
                visited[nx][ny] = true;
                list.add(new Node(nx,ny));
                q.add(new Node(nx,ny));
            }
        }

        if(list.size() >= 4){
            for(Node n : list){
                map[n.x][n.y] = '.';
            }
            return true;
        }
        return false;
    }

    // 터지고 난 후 중력
    static void down(){
        Queue<Character> q;
        for(int i=0;i<6;i++){
            q = new LinkedList<>();
            for(int j=11;j>=0;j--){
                if(map[j][i] != '.'){
                    q.add(map[j][i]);
                }
            }
            int size = q.size();
            if(size > 0){
                for(int j=11;j>=12-size;j--){
                    map[j][i] = q.poll();
                }
                for(int j=11-size;j>=0;j--){
                    map[j][i] = '.';
                }
            }
        }
    }

    static class Node{
        int x;
        int y;
        char color;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        Node(int x, int y, char color){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
