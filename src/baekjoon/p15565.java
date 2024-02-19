package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p15565 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
            if(arr[i] == 1) list.add(i);
        }

        if(list.size()<K) {
            System.out.println(-1);
            return;
        }

        int start = 0, end = K-1;
        int min = Integer.MAX_VALUE, cnt =0;
        while(true){
            if(end == list.size()) break;
            cnt = list.get(end) - list.get(start) + 1;
            min = Math.min(cnt, min);
            start++;
            end++;
        }

        System.out.println(min);

    }

}
