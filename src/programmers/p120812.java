package programmers;

import java.util.Arrays;

public class p120812 {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int max = array[array.length - 1];
        int[] count = new int[max+1];

        for(int i=0;i<array.length;i++) count[array[i]]++;

        int top = count[0];

        for(int i=1;i<count.length;i++){
            if(top<count[i]){
                top = count[i];
                answer = i;
            }else if(top == count[i]){
                answer = -1;
            }
        }

        return answer;
    }

}
