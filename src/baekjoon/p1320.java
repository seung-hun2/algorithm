package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class p1320 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        String maxTitle = "";
        int maxCount = 0;
        for(Map.Entry<String, Integer> title: map.entrySet()){
            String titleName = title.getKey();
            int count = title.getValue();
            if(count>maxCount || (count == maxCount && titleName.compareTo(maxTitle)<0)){
                maxTitle = titleName;
                maxCount = count;
            }
        }

        System.out.println(maxTitle);



    }

}
