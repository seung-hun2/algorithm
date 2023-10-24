package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class p42888 {
    class Solution {
        public List<String> solution(String[] record) {
            List<String> list = new ArrayList<>();

            StringTokenizer st;
            Map<String, String> map = new HashMap<>();
            Queue<String[]> queue = new LinkedList<>();

            for(int i=0;i<record.length;i++){
                st = new StringTokenizer(record[i], " ");
                String check = st.nextToken();

                if(check.equals("Enter")){
                    String uid = st.nextToken();
                    String nick = st.nextToken();
                    map.put(uid, nick);
                    queue.add(new String[]{uid, "Enter"});
                }else if(check.equals("Leave")){
                    String uid = st.nextToken();
                    queue.add(new String[]{uid, "Leave"});
                }else{
                    //  change 닉네임
                    String uid = st.nextToken();
                    String nick = st.nextToken();
                    map.put(uid,nick);
                }
            }
            while(!queue.isEmpty()){
                String[] str = queue.poll();
                if(str[1].equals("Enter")){
                    // 들어온거 체크
                    list.add(map.get(str[0]) + "님이 들어왔습니다.");

                }else{
                    // 나간거 체크
                    list.add(map.get(str[0]) + "님이 나갔습니다.");
                }
            }

            return list;
        }
    }

}
