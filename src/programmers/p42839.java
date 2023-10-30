package programmers;

import java.util.ArrayList;
import java.util.List;

public class p42839 {
    class Solution {
        boolean[] check = new boolean[7];
        List<Integer> list = new ArrayList<>();
        public int solution(String numbers) {
            int answer = 0;
            for(int i=0;i<numbers.length();i++){
                dfs(numbers, "", i+1);
            }
            for(int i=0;i<list.size();i++){
                if(prime(list.get(i))) answer++;
            }

            return answer;
        }
        public void dfs(String str, String temp, int m ){
            if(temp.length() == m ){
                int num = Integer.parseInt(temp);
                if(!list.contains(num)) list.add(num);
            }

            for(int i=0;i<str.length();i++){
                if(!check[i]){
                    check[i] = true;
                    temp += str.charAt(i);
                    dfs(str, temp, m);
                    check[i] = false;
                    temp = temp.substring(0, temp.length()-1);
                }
            }
        }

        public boolean prime(int n){
            if(n<2) return false;
            for(int i=2;i*i<=n;i++){
                if(n%i == 0) return false;
            }
            return true;
        }


    }

}
