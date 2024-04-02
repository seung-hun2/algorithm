package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p2251 {

    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visit;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        StringBuilder sb =  new StringBuilder();
        limit = new int[3];
        for(int i=0;i<3;i++) limit[i] = sc.nextInt();
        visit = new boolean[205][205][205];
        possible = new boolean[205];

        bfs(0,0,limit[2]);
        for(int i=0;i<=limit[2];i++){
            if(possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);



    }
    static void bfs(int x1, int x2, int x3){
        Queue<State> q = new LinkedList<>();
        visit[x1][x2][x3] = true;
        q.add(new State(new int[] {x1,x2,x3}));
        while(!q.isEmpty()){
            State st = q.poll();
            if(st.x[0] == 0) possible[st.x[2]] = true;
            for (int from=0; from<3;from++){
                for(int to=0;to<3;to++){
                    if(from == to) continue;
                    State next = st.move(from,to,limit);
                    if(!visit[next.x[0]][next.x[1]][next.x[2]]){
                        visit[next.x[0]][next.x[1]][next.x[2]] = true;
                        q.add(next);
                    }
                }
            }
        }
    }

    static class State{
        int[] x;
        State(int[] _x){
            x = new int[3];
            for(int i=0;i<3;i++){
                x[i] = _x[i];
            }
        }

        State move(int from, int to, int[] limit){
            int[] nX = new int[]{x[0],x[1],x[2]};
            if(x[from] + x[to] >= limit[to]){
                nX[from] -= limit[to] - x[to];
                nX[to] = limit[to];
            }else{
                nX[to] += nX[from];
                nX[from] = 0;
            }
            return new State(nX);
        }
    }

}
