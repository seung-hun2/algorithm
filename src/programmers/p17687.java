package programmers;

public class p17687 {

    class Solution {
        public String solution(int n, int t, int m, int p) {
            String answer = "";
            String str = "";
            str = solve(n,t,m);

            for(int i=0;i<t;i++){
                answer += str.charAt(i*m+p-1);
            }

            answer = answer.toUpperCase();
            System.out.println(answer);
            return answer;
        }
        public String solve(int n, int t, int m){
            String str = "";
            for(int i=0;i<=t*m;i++){
                str += Integer.toString(i,n);
            }
            return str;
        }
    }
}
