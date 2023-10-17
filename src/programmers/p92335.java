package programmers;

import java.util.Stack;

public class p92335 {
    class Solution {

        public int solution(int n, int k) {
            int answer = 0;
            int num = n;
            Stack<Integer> stack = new Stack<>();
            while(num>k){
                stack.push(num%k);
                num /= k;
            }
            stack.push(num%k);


            while(!stack.isEmpty()){
                String str = "";
                while(stack.size()>0){
                    int x = stack.pop();
                    if(x == 0) break;
                    else str += String.valueOf(x);
                }
                if(!str.equals("") &&check(Long.parseLong(str))) answer++;
            }

            return answer;
        }
        public static boolean check(long n){
            if(n<=1) return false;
            else if(n==2) return true;
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0) return false;
            }
            return true;
        }
    }


}
