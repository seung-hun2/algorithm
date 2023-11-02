package programmers;

public class p178870 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int N = sequence.length;
            int start = 0, end = N;
            int sum =0;
            for(int l=0,r=0;l<N;l++){
                while(r < N && sum <k){
                    sum += sequence[r++];
                }
                if(sum == k){
                    int range = r-l-1;
                    if((end - start) > range){
                        start = l;
                        end = r-1;
                    }
                }
                sum -= sequence[l];
            }
            int[] answer = {start, end};
            return answer;
        }
    }
}
