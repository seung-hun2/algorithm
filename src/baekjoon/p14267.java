package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p14267 {

    static int[] like;
    static int[] parents;
    static List<Integer>[] tree;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        like = new int[N+1];
        parents = new int[N+1];
        tree = new ArrayList[N+1];

        for(int i=1;i<=N;i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=1;i<=N;i++){
            parents[i] = sc.nextInt();
            if(parents[i]!=-1) {
                tree[parents[i]].add(i);
            }
        }

        for(int i=0;i<M;i++){
            int idx = sc.nextInt();
            int value = sc.nextInt();
            like[idx] += value;
        }
        find(1);

        for(int i=1;i<=N;i++){
            System.out.print(like[i]+" ");
        }
    }

    public static void find(int idx){
        for(int child : tree[idx]){
            like[child] += like[idx];
            find(child);
        }
    }

}
