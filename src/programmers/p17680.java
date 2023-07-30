package programmers;

import java.util.ArrayList;

public class p17680 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> al = new ArrayList<>();
        if(cacheSize == 0) return cities.length * 5;

        for(int i=0;i<cities.length;i++){
            cities[i] = cities[i].toUpperCase();
            if(al.contains(cities[i])){
                answer++;
                al.remove(cities[i]);
                al.add(cities[i]);
            }else{
                if(al.size() == cacheSize){
                    al.remove(0);
                }
                answer += 5;
                al.add(cities[i]);
            }
        }
        return answer;
    }

}
