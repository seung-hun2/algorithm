package baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1966 {

    static class Job{
        int index;
        int priority;
        Job (int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=0;i<tc;i++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            Integer[] seq = new Integer[N];
            Queue<Job> q = new LinkedList<>();
            for(int j=0;j<N;j++) {
                seq[j] = sc.nextInt();
                q.add(new Job(j, seq[j]));
            }
            Arrays.sort(seq, Collections.reverseOrder());

            for(int j=0;j<N;j++){
                while (q.peek().priority != seq[j]){
                    q.offer(q.poll());
                }
                if(q.peek().index == M) {
                    System.out.println(j+1);
                }
                q.poll();
            }


        }
    }

}
