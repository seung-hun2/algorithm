package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p9934 {

    static int K;
    static int[] arr;
    static List<List<Integer>> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        arr = new int[(int)Math.pow(2,K)-1];
        for(int i=0;i<arr.length;i++) arr[i] = sc.nextInt();

        list = new ArrayList<>();
        for(int i=0;i<K;i++){
            list.add(new ArrayList<>());
        }

        search(0,arr.length-1,0);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<K;i++){
            for(int j:list.get(i)){
                sb.append(j).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void search(int start, int end, int depth){
        if(depth == K) return;

        int mid = (start+end)/2;
        list.get(depth).add(arr[mid]);

        search(start, mid-1, depth+1);
        search(mid+1, end, depth+1);
    }

}
