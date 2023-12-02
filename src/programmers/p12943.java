package programmers;

public class p12943 {
    public int solution(long num) {
        long answer = num;
        int cnt = 0;
        boolean check = true;
        while(answer != 1){
            cnt++;
            if(cnt>=500) {
                check = false;
                break;
            }
            if(answer%2 ==0) answer /= 2;
            else answer = answer*3+1;

            if(answer == 1) break;
        }
        return check ? cnt: -1;
    }

}
