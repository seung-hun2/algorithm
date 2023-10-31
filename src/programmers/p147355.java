package programmers;

public class p147355 {
    class Solution {
        public int solution(String t, String p) {
            int answer = 0;
            long value=0;
            String s_value = "";

            for(int i=0;i<t.length()-p.length()+1;i++){
                s_value = t.substring(i,(i+p.length()));
                value  = Long.parseLong(s_value);
                if(value <= Long.parseLong(p)){
                    answer++;
                }
            }




            return answer;
        }
    }
}
