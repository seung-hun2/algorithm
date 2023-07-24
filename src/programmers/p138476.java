package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int size: tangerine){
            map.put(size, map.getOrDefault(size, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        int i = 0;
        while(k>0){
            k -= map.get(list.get(i));
            answer++;
            i++;
        }
        return answer;
    }

}
