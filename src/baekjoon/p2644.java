package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p2644 {

    static int N,a,b,M,answer;
    static boolean[] visited;
    static List<List<Integer>> person;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        M = sc.nextInt();
        person = new ArrayList<>();
        visited = new boolean[N+1];
        answer = -1;

        for(int i=0;i<N+1;i++){
            person.add(new ArrayList<>());
        }
        for(int i=0;i<M;i++){
            int p1 = sc.nextInt();
            int p2 = sc.nextInt();
            person.get(p1).add(p2);
            person.get(p2).add(p1);
        }

        dfs(a,0);
        System.out.println(answer);
    }

    static void dfs(int idx, int count){
        visited[idx] = true;
        if(idx == b){
            answer = count;
        }
        for(int i: person.get(idx)){
            if(!visited[i]){
                visited[i] = true;
                dfs(i,count+1);
            }
        }
    }
}
