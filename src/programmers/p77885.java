package programmers;

public class p77885 {
    class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            int index = 0;

            for(int i=0;i<numbers.length;i++){
                if(numbers[i]%2L==0L){
                    answer[index++] += numbers[i]+1L;
                }else{
                    String str = Long.toString(numbers[i],2);
                    int lastIndex = str.lastIndexOf("0");
                    if(lastIndex != -1){
                        String value = str.substring(0,lastIndex) + "10"+str.substring(lastIndex+2, str.length());
                        answer[index++] = Long.parseLong(value,2);
                    }else{
                        String value = "10" + str.substring(1,str.length());
                        answer[index++] = Long.parseLong(value,2);
                    }
                }
            }
            return answer;
        }
    }

}
