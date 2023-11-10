package programmers;

import java.util.StringTokenizer;

public class p17683 {
    class Solution {
        public String solution(String m, String[] musicinfos) {
            String answer = "";
            int max = 0;
            m = convert(m);
            for(int i=0;i<musicinfos.length;i++){
                StringTokenizer st = new StringTokenizer(musicinfos[i],":,");
                int startH = Integer.parseInt(st.nextToken());
                int startM = Integer.parseInt(st.nextToken());
                int endH = Integer.parseInt(st.nextToken());
                int endM = Integer.parseInt(st.nextToken());
                String name = st.nextToken();
                String melody = st.nextToken();

                melody = convert(melody);
                int c = (endH-startH)*60 + endM-startM;
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<c;j++){
                    sb.append(melody.charAt(j%melody.length()));
                }
                System.out.println(sb.toString());
                if(sb.toString().contains(m)){
                    if(max < c){
                        answer = name;
                        max = c;
                    }
                }
            }
            return answer.equals("") ? "(None)" : answer;
        }
        public String convert(String m){
            m = m.replaceAll("A#","a");
            m = m.replaceAll("C#","c");
            m = m.replaceAll("D#","d");
            m = m.replaceAll("F#","f");
            m = m.replaceAll("G#","g");

            return m;
        }
    }

}
