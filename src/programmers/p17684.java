package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p17684 {

    public static void main(String[] args) {
        int[] answer = solution("ABABABABABABABAB");
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }
    public static int[] solution(String msg) {

        List<Integer> al = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i=1;i<=26;i++){
            map.put(String.valueOf((char)('A'+i-1)),i);
        }

        // 아래 조건문은 마지막 저장부분까지 봐야함
        int check=0;
        while(check<msg.length()) {
            int index = check;
            String new_str = "";
            while (index < msg.length()) {
                new_str += msg.charAt(index++);
                System.out.println(new_str);
                if (!map.containsKey(new_str)) {
                    map.put(new_str, map.size() + 1);
                    al.add(map.get(new_str.substring(0, new_str.length() - 1)));
                    break;
                }

                check = index;
                if(check==msg.length()) al.add(map.get(new_str.substring(0, new_str.length())));
            }
        }

        int[] answer = new int[al.size()];
        for(int i=0;i<al.size();i++){
            answer[i] = al.get(i);
        }
        return answer;
    }

}
