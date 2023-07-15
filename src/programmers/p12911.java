package programmers;

public class p12911 {
    public int solution(int n) {
        int answer = 0;
        int pCnt = Integer.bitCount(n);
        int cnt = 0;
        while(true){
            n++;
            cnt = Integer.bitCount(n);
            if(pCnt == cnt){
                answer = n;
                break;
            }
        }
        return answer;
    }

}
