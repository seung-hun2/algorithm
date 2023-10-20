package programmers;

import java.util.PriorityQueue;

public class p42626 {
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> que = new PriorityQueue<>();
            for(int i=0;i<scoville.length;i++){
                que.add(scoville[i]);
            }
            while(true){
                if(que.size() == 1 && que.peek() < K){
                    answer = -1;
                    break;
                }
                if(que.peek() >= K) {
                    break;
                }
                que.add(que.poll()+ que.poll()*2);
                answer++;
            }
            return answer;
        }
    }

}
