package programmers;

import java.util.Stack;

public class p154539 {
    class Solution {
        public int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Stack<Integer> stack = new Stack<>();
            int[] arr = new int[numbers.length];
            stack.push(0);

            for(int i=1;i<numbers.length;i++){
                while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
            while(!stack.isEmpty()){
                answer[stack.pop()] = -1;
            }
            return answer;
        }
    }

}
