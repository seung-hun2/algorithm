package programmers;

public class p148653 {
    class Solution {
        public int solution(int storey) {
            int answer = 0;
            String str = String.valueOf(storey);
            int[] arr = new int[str.length()];
            for(int i=0;i<arr.length;i++){
                arr[i] = str.charAt(i)-'0';
            }

            int len = str.length()-1;
            for(int i=len;i>=0;i--){
                int num = arr[i];
                if(num > 5){
                    answer += 10 - num;
                    if(i==0) answer++;
                    else arr[i-1]++;
                }else if(num == 5 && i>0 && arr[i-1] >= 5){
                    arr[i-1]++;
                    answer+=5;
                }else{
                    answer += num;
                }
            }
            return answer;
        }
    }
}
