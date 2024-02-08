package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p15970 {

    static List<Integer>[] point;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        point = new ArrayList[N];

        for(int i=0;i<N;i++){
            point[i] = new ArrayList<>();
        }
        for(int i=0;i<N;i++){
            int l = sc.nextInt();
            int color = sc.nextInt()-1;
            point[color].add(l);
        }
        for(int i=0;i<N;i++) {
            Collections.sort(point[i]);
        }

        int ans = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<point[i].size();j++){
                int left = toLeft(i,j) ;
                int right = toRight(i,j);
                ans += Math.min(left,right);
            }
        }

        System.out.println(ans);


    }

    static int toLeft(int color, int idx){
        if(idx == 0) return Integer.MAX_VALUE;
        return point[color].get(idx) - point[color].get(idx-1);
    }
    static int toRight(int color, int idx){
        if(idx == point[color].size()-1) return Integer.MAX_VALUE;
        return point[color].get(idx+1) - point[color].get(idx);
    }

}
