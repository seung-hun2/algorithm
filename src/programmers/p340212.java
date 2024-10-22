package programmers;

public class p340212 {

    class Solution {
        public int solution(int[] diffs, int[] times, long limit) {
            long answer = 0;
            long l = 1;
            long r = limit;


            while(l <= r){
                long m = (l+r)/2;
                long value = 0;
                for(int i=0;i<diffs.length;i++){
                    if(diffs[i] <= m){
                        value += times[i];
                    }else{
                        value += (long)(diffs[i]-m)*(long)(times[i] + times[i-1]) + times[i];
                    }
                }

                if(value > limit){
                    l = m+1;
                }else{
                    r = m-1;
                }

            }
            answer = l;

            return (int)answer;
        }
    }
}
