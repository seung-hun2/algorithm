package programmers;

public class p87946 {
    class Solution {
        static boolean[] visit;
        static int answer=0;
        public int solution(int k, int[][] dungeons) {
            visit = new boolean[dungeons.length];
            dfs(0,dungeons,k);
            return answer;
        }
        public void dfs(int depth, int[][] dungeons, int p){
            for(int i=0;i<dungeons.length;i++){
                if(dungeons[i][0] > p || visit[i]) continue;
                visit[i] = true;
                dfs(depth+1, dungeons, p-dungeons[i][1]);
                visit[i] = false;
            }
            answer = Math.max(answer,depth);
        }
    }

}
