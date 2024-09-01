package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class p1446 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = sc.nextInt();

        List<Node> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int len = sc.nextInt();
            if(end > D) continue;
            if(end-start > len) list.add(new Node(start, end, len));
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.start == o2.start) return o1.end-o2.end;
            return o1.start - o2.start;
        });

        int[] dist = new int[D+1];
        int move = 0;
        int idx = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;


        while(move < D){
            if(idx < list.size()){
                Node node = list.get(idx);
                if(move == node.start){
                    dist[node.end] = Math.min(dist[move] + node.len , dist[node.end]);
                    idx++;
                }else{
                    dist[move+1] = Math.min(dist[move+1], dist[move] + 1);
                    move++;
                }
            }else{
                dist[move+1] = Math.min(dist[move+1], dist[move] + 1);
                move++;
            }
        }

        System.out.println(dist[D]);


    }


    static class Node{
        int start;
        int end;
        int len;
        Node(int start, int end, int len){
            this.start = start;
            this.end = end;
            this.len = len;
        }
    }
}
