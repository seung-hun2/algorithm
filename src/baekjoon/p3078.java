package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p3078 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long sum =0;

        Queue<Integer>[] q = new LinkedList[21];
        for(int i=0;i<21;i++){
            q[i] = new LinkedList<>();
        }
        for(int i=0;i<N;i++){
            String str = sc.next();
            int sl = str.length();
            if(q[sl].isEmpty()){
                q[sl].add(i);
                continue;
            }
            while (!q[sl].isEmpty()){
                if(i-q[sl].peek()<=K){
                    sum += q[sl].size();
                    break;
                }
                q[sl].poll();
            }
            q[sl].add(i);
        }
        System.out.println(sum);

    }

}
