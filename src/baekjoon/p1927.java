package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class p1927 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<N;i++){
            int next = sc.nextInt();
            if(next==0){
                if(q.isEmpty()){
                    sb.append(0).append('\n');
                }else{
                    sb.append(q.poll()).append('\n');
                }
            }else{
                q.add(next);
            }
        }
        System.out.println(sb);

    }

}
