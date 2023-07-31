package programmers;

import java.util.HashMap;

public class p131127 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int days = 10;
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i=0;i<want.length;i++){
            hash.put(want[i], number[i]);
        }
        for(int i=0;i<discount.length-days+1;i++){
            HashMap<String, Integer> map = new HashMap<>();
            for(int j=0;j<days;j++){
                map.put(discount[i+j], map.getOrDefault(discount[i+j], 0)+1);
            }
            Boolean check = true;
            for(String key : hash.keySet()){
                if(hash.get(key) != map.get(key)){
                    check = false;
                    break;
                }
            }
            answer += check ? 1:0;
        }


        return answer;
    }

}
