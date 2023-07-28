package programmers;

public class p12945 {
    public int solution(int n) {
        int answer = 0;
        answer = fibo(n);
        return answer;
    }
    public static int fibo(int n){
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<=n;i++){
            arr[i] = (arr[i-1] + arr[i-2])%1234567;
        }

        return arr[n]%1234567;
    }

}