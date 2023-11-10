package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p86971 {
    class Solution {
        List<Integer>[] list;
        public int solution(int n, int[][] wires) {
            list = new ArrayList[n+1];
            int answer = n;
            for(int i=0;i<n+1;i++){
                list[i] = new ArrayList<>();
            }
            for(int i=0;i<wires.length;i++){
                list[wires[i][0]].add(wires[i][1]);
                list[wires[i][1]].add(wires[i][0]);
            }

            for(int i=0;i<wires.length;i++){
                int one = wires[i][0];
                int two = wires[i][1];

                list[one].remove(Integer.valueOf(two));
                list[two].remove(Integer.valueOf(one));

                int cnt = bfs(n, one);
                answer = Math.min(answer, Math.abs(n-2*cnt));

                list[one].add(two);
                list[two].add(one);
            }


            return answer;
        }
        int bfs(int n, int one){
            int result = 1;
            Queue<Integer> q = new LinkedList<>();
            boolean[] visit = new boolean[n+1];
            q.add(one);
            visit[one] = true;

            while(!q.isEmpty()){
                int next = q.poll();
                for(int i=0;i<list[next].size();i++){
                    if(!visit[list[next].get(i)]){
                        q.add(list[next].get(i));
                        visit[next] = true;
                        result++;
                    }
                }
            }

            return result;
        }
    }

}
