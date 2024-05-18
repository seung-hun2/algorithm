package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p8673 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();


        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int K = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();

            for(int i = 0; i < (int)Math.pow(2, K); i++) {
                queue.add(sc.nextInt());
            }

            int ans = 0;
            while(queue.size() >= 2) {
                int a = queue.poll();
                int b = queue.poll();

                queue.add(Math.max(a,b));
                ans += Math.abs(a-b);
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

}
