package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p19598 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Meeting> metting = new ArrayList<>();
        for(int i=0;i<N;i++){
            metting.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }
        metting.sort((o1,o2)->{
            if(o1.start == o2.start) return o1.end - o2.end;
            return o1.start-o2.start;
        });
        PriorityQueue<Meeting> q = new PriorityQueue<>((o1,o2)->{
            return o1.end - o2.end;
        });

        int ans = 1;
        for(Meeting m : metting){
            if(q.isEmpty()){
                q.offer(m);
                continue;
            }
            while(!q.isEmpty() && q.peek().end <= m.start) q.poll();
            q.offer(m);
            ans = Math.max(ans, q.size());
        }

        System.out.println(ans);

    }

    static class Meeting{
        int start, end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
