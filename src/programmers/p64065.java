package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class p64065 {
    public int[] solution(String s) {
        StringTokenizer st = new StringTokenizer(s, "},{");
        HashMap<Integer, Integer> num = new HashMap<Integer, Integer>();
        while(st.hasMoreTokens())
        {
            int n = Integer.parseInt(st.nextToken());
            num.put(n, num.containsKey(n) ? num.get(n) + 1 : 1);
        }

        List<Integer> keySet = new ArrayList<Integer>(num.keySet());
        Collections.sort(keySet, (v1,v2) -> (num.get(v2)-num.get(v1)));

        int[] answer = new int[keySet.size()];
        for(int i=0;i<keySet.size();i++){
            answer[i] = keySet.get(i);
        }

        return answer;
    }

}
