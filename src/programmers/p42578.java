package programmers;

import java.util.HashMap;

public class p42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i=0;i<clothes.length;i++){
            hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1], 1) + 1);
        }
        for(String key : hash.keySet()){
            answer *= hash.get(key);
        }
        return answer-1;
    }

}
