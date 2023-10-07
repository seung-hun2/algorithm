package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p138477 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> al = new ArrayList<>();
        for(int i=0;i<score.length;i++){
            if(i<k-1){
                al.add(score[i]);
                al.sort(Collections.reverseOrder());
                answer[i] = al.get(al.size()-1);
            }else{
                al.add(score[i]);
                al.sort(Collections.reverseOrder());
                answer[i] = al.get(k-1);
            }

        }

        return answer;
    }
}
