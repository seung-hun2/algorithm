package programmers;

import java.util.Stack;

public class p49993 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            boolean[] check;
            Stack<Character> stack;

            for(int i=0;i<skill_trees.length;i++){
                stack = new Stack<>();
                check = new boolean[26];
                boolean ans = true;
                for(int j=skill.length()-1;j>=0;j--){
                    stack.push(skill.charAt(j));
                    check[skill.charAt(j)-'A'] = true;
                }
                for(int j=0;j<skill_trees[i].length();j++){
                    char ch = skill_trees[i].charAt(j);
                    // System.out.println(stack.peek());

                    if (check[ch-'A']){
                        if(stack.peek() == ch){
                            stack.pop();
                        }else{
                            ans = false;
                        }
                    }
                }
                if(ans) answer++;
            }


            return answer;
        }
    }
}
