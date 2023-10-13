package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p15681 {

    static List<Integer>[] tree;
    static boolean[] check;
    static int[] sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int R = sc.nextInt();
        int Q = sc.nextInt();
        check = new boolean[N+1];
        sum = new int[N+1];
        tree = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=0;i<N-1;i++){
            int u = sc.nextInt(), v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }

        sum[R] = getSum(R);

        for(int i=0;i<Q;i++){
            int u = sc.nextInt();
            System.out.println(sum[u]);
        }

    }
    static int getSum(int node){
        if(sum[node] != 0) return sum[node];
        check[node] = true;
        int result = 1;
        for(int child : tree[node]){
            if(!check[child]){
                result += getSum(child);
            }
        }

        return sum[node] = result;
    }

}
