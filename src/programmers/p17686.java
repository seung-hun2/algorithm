package programmers;

import java.util.Arrays;

public class p17686 {
    class Solution {
        public String[] solution(String[] files) {
            String[] answer = new String[files.length];
            String[][] answer2 = new String[files.length][3];
            for(int i=0;i<files.length;i++){
                int start=-1,end=-1;
                boolean first = true;
                int size = 0;

                for(int j=0;j<files[i].length();j++){
                    if(Character.isDigit(files[i].charAt(j))){
                        if(first){
                            start = j;
                            first = false;
                        }
                        size++;
                    }else{
                        if(!first) break;
                    }
                }

                end = start + size - 1;

                String head = files[i].substring(0,start);
                String number = files[i].substring(start, end+1);
                String tail = files[i].substring(end+1);

                answer2[i][0] = head;
                answer2[i][1] = number;
                answer2[i][2] = tail;
            }

            Arrays.sort(answer2, (o1,o2)->{
                if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase()) > 0){
                    return 1;
                }else if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase())<0){
                    return -1;
                }else{
                    if(Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])){
                        return 1;
                    }else if(Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            });

            for(int i=0;i<answer.length;i++){
                answer[i] = answer2[i][0] + answer2[i][1] + answer2[i][2];
            }
            return answer;
        }
    }

}
