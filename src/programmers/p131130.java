package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class p131130 {
    static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    public int solution(int[] cards) {
        int answer= 0;
        int n =cards.length;
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(cards,i,visited,0);
            }
        }
        if(q.size()!=1){
            answer = q.poll()*q.poll();
        }
        return answer;
    }

    public void dfs(int[] cards, int num, boolean[] visited, int cnt){
        if(visited[num]){
            q.add(cnt);
            return;
        }
        visited[num] = true;
        dfs(cards, cards[num]-1, visited, cnt+1);
    }

}
