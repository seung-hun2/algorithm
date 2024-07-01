package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p1516 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        List<Integer>[] building = new ArrayList[N + 1];
        int[] T = new int[N + 1];
        int[] T_done = new int[N + 1];
        int[] indeg = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            building[i] = new ArrayList<>();
        }
        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            while (true) {
                int next = sc.nextInt();
                if (next == -1) {
                    break;
                }
                building[next].add(i);
                indeg[i]++;
            }
        }
        for(int i=1;i<=N;i++){
            if(indeg[i] == 0){
                q.add(i);
                T_done[i] = T[i];
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int a : building[x]) {
                indeg[a]--;
                if (indeg[a] == 0) {
                    q.add(a);
                }
                T_done[a] = Math.max(T_done[a], T_done[x] + T[a]);
            }

        }

        for (int i = 1; i <= N; i++) {
            sb.append(T_done[i]).append('\n');
        }
        System.out.println(sb);
    }

}
