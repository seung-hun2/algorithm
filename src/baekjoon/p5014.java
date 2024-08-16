package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p5014 {

    static int F, S, G;
    static int[] dir = new int[2];
    static int[] move;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        dir[0] = sc.nextInt();
        dir[1] = -sc.nextInt();
        move = new int[F+1];

        bfs(S);
    }

    static void bfs(int value){
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[F+1];
        q.add(value);
        check[value] = true;
        move[S] = 0;

        while(!q.isEmpty()){
            int now = q.poll();
            if(now == G){
                System.out.println(move[now]);
                return;
            }

            for(int i=0;i<2;i++){
                int next = now +dir[i];
                if(next > F || next < 1) continue;
                if(check[next]) continue;

                check[next] = true;
                move[next] = move[now] + 1;
                q.add(next);
            }
        }

        System.out.println("use the stairs");

    }

}
