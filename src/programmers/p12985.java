package programmers;

public class p12985 {
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        while(true){
            answer++;


            if(a%2 == 0 && a>b && a-1==b){
                break;
            }else if(b%2 == 0 &&a<b && b-1 == a){
                break;
            }

            if(a%2 == 0 ) a /= 2;
            else a = a/2 + 1;

            if(b%2 == 0 ) b /= 2;
            else b = b/2 + 1;
        }

        return answer;
    }
}
