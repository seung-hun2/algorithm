package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class p92341 {

    class Solution {
        public int[] solution(int[] fees, String[] records) {
            int[] answer;
            StringTokenizer st;

            // 값을 저장하는 map
            Map<Integer, Integer> map = new HashMap<>();
            // 정답 출력을 위해 더해주는 값을 저장하는 map
            // 차번호, 주차시간 저장
            Map<Integer, Integer> ans = new HashMap<>();


            for(int i=0;i<records.length;i++){
                st = new StringTokenizer(records[i], " ");
                String str_time = st.nextToken();
                int car = Integer.parseInt(st.nextToken());
                String check = st.nextToken();
                st = new StringTokenizer(str_time, ":");
                int time = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());

                if(check.equals("IN")){
                    map.put(car, time);
                }else if (check.equals("OUT")){
                    if(ans.containsKey(car)) ans.put(car, ans.get(car)+time-map.get(car));
                    else ans.put(car, time - map.get(car));
                    map.remove(car);
                }

            }

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(ans.containsKey(entry.getKey())) ans.put(entry.getKey(), ans.get(entry.getKey()) + 1439-entry.getValue());
                else ans.put(entry.getKey(), 1439-entry.getValue());
            }


            List<Integer> keySet = new ArrayList<>(ans.keySet());
            Collections.sort(keySet);
            answer = new int[keySet.size()];
            int index = 0;
            for(int i=0;i<keySet.size();i++){
                if(ans.get(keySet.get(i)) < fees[0]){
                    answer[index++] = fees[1];
                }else{
                    if((ans.get(keySet.get(i)) - fees[0])%fees[2] != 0) answer[index++] = fees[1] + ((ans.get(keySet.get(i)) - fees[0])/fees[2]+1)*fees[3];
                    else answer[index++] = fees[1] + (ans.get(keySet.get(i)) - fees[0])/fees[2]*fees[3];
                }
            }


            return answer;
        }
    }

}
