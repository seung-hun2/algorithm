package programmers;

import java.util.PriorityQueue;

public class p142085 {
    public int solution(int n, int k, int[] enemy) {
        if(enemy.length == k) return k;

        int count = 0;
        int remain = n;
        int i;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> -(o1-o2));
        for(i=0;i<enemy.length;i++){
            int cur = enemy[i];
            pq.add(cur);
            remain -= cur;

            if(remain<0){
                if(count<k){
                    remain += pq.poll();
                    count++;
                }else break;
            }
        }
        return i;
    }

}
