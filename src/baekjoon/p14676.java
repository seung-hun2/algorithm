package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p14676 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        List<Integer>[] building = new ArrayList[N+1];
        int[] now = new int[N+1];
        int[] indeg = new int[N+1];
        int[] satis = new int[N+1];

        for(int i=1;i<=N;i++) {
            building[i] = new ArrayList<>();
        }


        for(int i=0;i<M;i++){
            int X = sc.nextInt();
            int Y = sc.nextInt();
            building[X].add(Y);
            indeg[Y]++;
        }

        boolean check = false;
        for(int i=0;i<K;i++){
            int X = sc.nextInt();
            int Y = sc.nextInt();

            if(X == 1){
                // 건물을 건설할 수 있는지 체크한다음
                if(satis[Y] < indeg[Y]) check = true;
                // 건물을 건설해야한다.
                now[Y]++;

                if(now[Y] == 1){
                    for(int a : building[Y]) satis[a]++;
                }
            }else{
                if(now[Y] == 0) check = true;
                now[Y]--;

                if(now[Y] == 0){
                    for(int a : building[Y]) satis[a]--;
                }
            }
        }

        if (check) System.out.println("Lier!");
        else System.out.println("King-God-Emperor");

    }

}
