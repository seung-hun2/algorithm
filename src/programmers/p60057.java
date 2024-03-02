package programmers;

public class p60057 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int count  = 1;
        if(s.length() == 1) return 1;
        for(int i=1;i<=s.length()/2;i++){
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0,i);
            for(int j=i;j<=s.length();j+=i){
                int endIdx = Math.min(j+i, s.length());
                String cur = s.substring(j,endIdx);
                if(prev.equals(cur)){
                    count++;
                }else{
                    if(count >= 2) sb.append(count);
                    sb.append(prev);
                    prev = cur;
                    count = 1;
                }
            }
            sb.append(prev);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }

}
