package programmers;

public class p181187 {
    public long solution(int r1, int r2) {
        long answer = 0;
        long r1_x = (long)Math.pow(r1,2);
        long r2_x = (long)Math.pow(r2,2);

        long sum2 = 0, sum1 = 0, side = 0;
        for(long i=0;i<=r2;i++){
            long y2 = (long)Math.sqrt(r2_x-(long)Math.pow(i,2));
            long y1 = (long)Math.sqrt(r1_x-(long)Math.pow(i,2));
            if(Math.sqrt((r1_x-Math.pow(i,2)))%1 == 0) side++;
            answer+= (y2-y1)*4;
        }


        return answer;
    }

}
