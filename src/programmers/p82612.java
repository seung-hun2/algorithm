package programmers;

public class p82612 {
    public long solution(int price, int money, int count) {
        long answer = 0;
        long total=0;

        for(int i=1; i<count+1; i++){
            total += price*i;
        }
        if(money<total)
            answer = total-money;
        else
            answer = 0;

        return answer;
    }
}
