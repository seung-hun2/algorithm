package baekjoon;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p11724 {
    static List<List<Integer>> list = new ArrayList<>();
    static int answer;
    static boolean[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int M = sc.nextInt();
        answer = 0;
        check = new boolean[N+1];

        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
            list.get(v).add(u);
        }
        for(int i=1;i<=N;i++){
            if(!check[i]){
                bfs(i);
                answer++;
            }
        }
        System.out.println(answer);
    }
    public static void bfs(int start){
        check[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int next = q.poll();
            for(int i=0;i<list.get(next).size();i++){
                if(!check[list.get(next).get(i)]){
                    check[list.get(next).get(i)] = true;
                    q.add(list.get(next).get(i));
                }
            }
        }

    }

}
