package programmers;

public class p12916 {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toUpperCase();
        int p_cnt=0, y_cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'P') p_cnt++;
            else if(s.charAt(i) == 'Y') y_cnt++;
        }
        if(p_cnt != y_cnt) answer = false;
        return answer;
    }

}
