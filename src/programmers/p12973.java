package programmers;

import java.util.Stack;

public class p12973 {
    public int solution(String s)
    {
        int answer = 0;
        char c;
        Stack<Character> stack = new Stack<>();
        while(true){
            for(int i=0;i<s.length();i++){
                c = s.charAt(i);
                if(stack.isEmpty()) stack.push(c);
                else{
                    if(stack.peek() == c){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }
            }
            break;
        }
        if(stack.isEmpty()) answer = 1;

        return answer;
    }

}
