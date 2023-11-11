package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p155651 {
    class Solution {
        public int solution(String[][] book_time) {

            Arrays.sort(book_time, (o1,o2)->{
                return o1[0].toString().compareTo(o2[0].toString());
            });
            List<Integer> list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(book_time[0][1], ":");

            list.add(Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()));
            for(int i=1;i<book_time.length;i++){
                st = new StringTokenizer(book_time[i][0], ":");
                int h = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                boolean check = false;
                for(int j=0;j<list.size();j++){
                    if(list.get(j) + 10 <= h*60+m){
                        st = new StringTokenizer(book_time[i][1], ":");
                        list.set(j,Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()));
                        check = true;
                        break;
                    }
                }
                if(!check){
                    st = new StringTokenizer(book_time[i][1], ":");
                    list.add(Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()));
                }
            }
            return list.size();
        }
    }

}
