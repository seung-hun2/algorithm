package baekjoon;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->{
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if(abs1==abs2) return o1>o2 ? 1:-1;
            return abs1-abs2;
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            int x = sc.nextInt();
            if(x==0){
                if(q.isEmpty()){
                    sb.append(0).append('\n');
                }else{
                    sb.append(q.poll()).append('\n');
                }
            }else{
                q.add(x);
            }
        }
        System.out.println(sb);
    }

}
