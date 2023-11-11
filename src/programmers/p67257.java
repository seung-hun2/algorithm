package programmers;

import java.util.ArrayList;
import java.util.List;

public class p67257 {
    class Solution {
        String[][] arr = {{"+","-","*"},{"+","*","-"},{"-","+","*"},{"-","*","+"},{"*","-","+"},{"*","+","-"}};

        public long solution(String expression) {
            long answer = Long.MIN_VALUE;
            List<String> list = new ArrayList<>();

            int start = 0;
            for(int i=0;i<expression.length();i++){
                if(expression.charAt(i)== '-' || expression.charAt(i)== '+' || expression.charAt(i)== '*' ){
                    list.add(expression.substring(start,i));
                    list.add(expression.charAt(i)+"");
                    start = i + 1;
                }
            }
            list.add(expression.substring(start));

            for(int i=0;i<6;i++){
                List<String> al = new ArrayList<>(list);
                for(int j=0;j<3;j++){
                    for(int k=0;k<al.size();k++){
                        if(al.get(k).equals(arr[i][j])){
                            al.set(k-1,String.valueOf(calc(al.get(k-1),al.get(k),al.get(k+1))));
                            al.remove(k);
                            al.remove(k);
                            k--;
                        }
                    }
                }
                answer = Math.max(answer, Math.abs(Long.parseLong(al.get(0))));
            }


            return answer;
        }

        public long calc(String num1, String ex, String num2){
            long o1 = Long.parseLong(num1);
            long o2 = Long.parseLong(num2);

            if(ex.equals("*")){
                return o1 * o2;
            }else if(ex.equals("-")){
                return o1 - o2;
            }else{
                return o1 + o2;
            }
        }
    }
}
