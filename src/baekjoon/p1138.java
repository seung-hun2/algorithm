package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p1138 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = sc.nextInt();

        List<Integer> ans = new ArrayList<>();

        for(int i=N-1;i>=0;i--){
            ans.add(arr[i],i);
        }

        for(int i:ans){
            System.out.print((i+1)+" ");
        }
    }

}
