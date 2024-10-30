package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p15686 {

    static int N,M,ans;
    static int[][] map;
    static boolean[] open;
    static List<Point> person, chicken;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        person = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) person.add(new Point(i,j));
                else if(map[i][j] == 2) chicken.add(new Point(i,j));
            }
        }

        ans = Integer.MAX_VALUE;
        open = new boolean[chicken.size()];

        dfs(0,0);
        System.out.println(ans);
        System.out.println();

    }

    static void dfs(int start, int cnt){
        if(cnt == M){
            int res = 0;

            for(int i=0;i<person.size();i++){
                int tmp = Integer.MAX_VALUE;
                for(int j=0;j<chicken.size();j++){
                    if(open[j]){
                        int dist = Math.abs(person.get(i).x - chicken.get(j).x)
                            + Math.abs(person.get(i).y - chicken.get(j).y);
                        tmp = Math.min(tmp, dist);
                    }
                }
                res += tmp;
            }

            ans = Math.min(ans, res);
            return;
        }

        for(int i=start;i<chicken.size();i++){
            open[i] = true;
            dfs(i+1,cnt+1);
            open[i] = false;
        }
    }

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

}
