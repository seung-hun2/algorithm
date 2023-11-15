package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p2606 {

    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] check;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int com = sc.nextInt();
        int N = sc.nextInt();
        check = new boolean[com+1];
        for(int i=0;i<=com;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<N;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1);
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
                    q.add(list.get(next).get(i));
                    check[list.get(next).get(i)] = true;
                    answer++;
                }
            }
        }
    }
}
