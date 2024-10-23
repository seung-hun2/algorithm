package programmers;

import java.util.StringTokenizer;

public class p340213 {
    class Solution {
        int len;
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            String answer = "";
            StringTokenizer st;

            st = new StringTokenizer(video_len,":");
            len = Integer.parseInt(st.nextToken())* 60 + Integer.parseInt(st.nextToken());
            st = new StringTokenizer(pos,":");
            int now = Integer.parseInt(st.nextToken())* 60 + Integer.parseInt(st.nextToken());
            st = new StringTokenizer(op_start,":");
            int start = Integer.parseInt(st.nextToken())* 60 + Integer.parseInt(st.nextToken());
            st = new StringTokenizer(op_end,":");
            int end = Integer.parseInt(st.nextToken())* 60 + Integer.parseInt(st.nextToken());

            if(now >= start && now <= end) now = end;

            for(int i=0;i<commands.length;i++){
                if(commands[i].equals("next")){
                    now += 10;
                    if(len < now) now = len;
                }else {
                    now -= 10;
                    if(now < 0) now = 0;
                }

                if(now >= start && now <= end) now = end;
            }
            answer = String.format("%02d:%02d", now/60, now%60);
            return answer;
        }

    }

}
