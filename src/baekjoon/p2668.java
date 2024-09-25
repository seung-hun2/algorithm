package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class p2668 {

    static int N;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> ans;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1];
        visited = new boolean[N+1];
        ans = new ArrayList<>();
        for(int i=1;i<=N;i++){
            arr[i] = sc.nextInt();
        }

        for(int i=1;i<=N;i++){
            // dfs해서 최대 체크
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(ans);
        sb.append(ans.size()).append('\n');
        for(int i:ans){
            sb.append(i).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int start, int target){
        if(!visited[arr[start]]){
            visited[arr[start]] = true;
            dfs(arr[start], target);
            visited[arr[start]] = false;
        }

        if(arr[start] == target) ans.add(target);
    }

}
