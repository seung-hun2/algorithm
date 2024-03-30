package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p11403 {

    static List<List<Integer>> l = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[][] answer;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for(int i=0;i<N;i++){
            l.add(new ArrayList<>());
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int s = sc.nextInt();
                if(s == 1) {
                    l.get(i).add(j);
                }
            }
        }


        answer = new boolean[N][N];
        for(int i=0;i<N;i++){
            for(int idx : l.get(i)) {
                dfs(i, idx);
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(answer[i][j]) sb.append("1").append(" ");
                else sb.append("0").append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }

    public static void dfs(int i, int idx){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        answer[i][idx] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int j: l.get(now)){
                if(answer[i][j]) continue;
                answer[i][j] = true;
                q.add(j);
            }
        }
    }

}
