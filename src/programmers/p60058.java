package programmers;

import java.util.Stack;

public class p60058 {
    class Solution {
        public String solution(String p) {
            if(p.length() == 0) return "";
            int check = 0;
            int x = 0;

            for(int i=0;i<p.length();i++){
                if(p.charAt(i) == '(') check++;
                else check--;

                if(check == 0) {
                    x = i;
                    break;
                }

            }
            String u = p.substring(0,x+1);
            String v = p.substring(x+1);

            System.out.println(x);
            System.out.println("check 하기 전 u : "+ u);
            if(check(u)){
                return u + solution(v);
            }

            return "(" + solution(v) + ")" + reverse(u);
        }
        public String reverse(String u){
            System.out.println("u : "+u);
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<u.length()-1;i++){
                if(u.charAt(i) == '('){
                    sb.append(')');
                }else{
                    sb.append('(');
                }
            }
            System.out.println(sb.toString());
            return sb.toString();
        }
        // 올바른 문자열 체크
        public boolean check(String str){
            Stack<Character> stack = new Stack<>();
            char[] arr = str.toCharArray();
            for(int i=0;i<arr.length;i++){
                if(arr[i] == '(') stack.push(arr[i]);
                else{
                    if(stack.isEmpty()){
                        return false;
                    }
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) return false;

            return true;
        }
    }
}
