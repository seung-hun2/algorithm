package programmers;

public class p42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int i=3;i<(brown+yellow);i++){
            int j= (brown + yellow) / i;
            if((brown+yellow) % i == 0 && j >= 3){
                int col = Math.max(i,j);
                int row = Math.min(i,j);
                int center = (col-2) * (row-2);

                if(center == yellow){
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }

}
