package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class p42583 {
    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            Queue<int[]> q = new LinkedList<>();

            int size = 0;
            int time = 0;
            // q[0] 에는 weight, q[1] 에는 시간
            while(truck_weights.length > size){
                time++;
                // 시간이 지나면 뺴내야함
                if(!q.isEmpty()){
                    if( q.peek()[1] + bridge_length <= time ) {
                        q.poll();
                    }
                }

                int qsize = q.size();
                int total = 0;
                for(int i=0;i<qsize;i++){
                    total += q.peek()[0];
                    q.add(q.poll());
                }
                if(total+truck_weights[size] > weight){
                    // 들어가면 안댐
                }else{
                    q.add(new int[]{truck_weights[size++],time});
                }
            }
            int asize = q.size()-1;
            for(int i=0;i<asize;i++){
                q.poll();
            }
            int[] ans = q.poll();


            answer = ans[1] + bridge_length;

            return answer;
        }


    }

}
