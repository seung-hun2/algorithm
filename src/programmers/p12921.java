package programmers;

public class p12921 {
    public int solution(int n) {
        int answer = 1;

        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) answer += 1;
        }

        return answer;
    }

    // 소수 판별 메서드
    private boolean isPrime(int num) {
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
