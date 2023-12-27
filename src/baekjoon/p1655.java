package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;


public class p1655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> big = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int next = Integer.parseInt(br.readLine());
            if(small.size() == big.size()) small.offer(next);
            else big.offer(next);

            if(!small.isEmpty() && !big.isEmpty()){
                int s = small.peek();
                int b = big.peek();
                if(s>b){
                    small.poll();
                    big.poll();
                    small.offer(b);
                    big.offer(s);
                }
            }
            sb.append(small.peek()).append('\n');
        }
        System.out.println(sb);
    }

}
