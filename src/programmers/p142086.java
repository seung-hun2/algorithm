package programmers;

public class p142086 {
    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[s.length()];
            answer[0] = -1;
            for(int i=1;i<s.length();i++){
                int x = s.lastIndexOf(s.substring(i,i+1),i-1);
                if(x!=-1){
                    answer[i] = i-x;
                }else{
                    answer[i] = -1;
                }
            }

            return answer;
        }
    }

}
