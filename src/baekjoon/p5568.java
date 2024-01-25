package baekjoon;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class p5568 {

    static int n,k;
    static int[] arr;
    static int[] value;
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        value = new int[k];
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        recur(0);
        System.out.println(set.size());

    }

    static void recur(int depth){
        if(depth == k){
            String str = "";
            for(int i=0;i<k;i++){
                str += String.valueOf(value[i]);
            }
            set.add(Integer.parseInt(str));
        }else{
            for(int i=0;i<n;i++){
                if(visited[i]) continue;
                visited[i] = true;
                value[depth] = arr[i];
                recur(depth+1);
                value[depth] = 0;
                visited[i] = false;
            }
        }
    }

}
