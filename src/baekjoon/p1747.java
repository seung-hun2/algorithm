package baekjoon;

import java.util.Scanner;

public class p1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // 소수 이면서 팰린드롬인 수

        if(N == 1){
            System.out.println(2);
            System.exit(0);
        }
        while (true){
            if(isPrime(N) && check(N)){
                System.out.println(N);
                System.exit(0);
            }
            N++;
        }
    }

    static boolean isPrime(int N){
        for(int i=2;i<=Math.sqrt(N);i++){
            if(N%i == 0){
                return false;
            }
        }
        return true;
    }
    static boolean check(int N){
        String str = String.valueOf(N);
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

}
