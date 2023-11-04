package baekjoon;

import java.util.Scanner;

public class p1629 {

    static int C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        C = sc.nextInt();

        System.out.println(power(A,B));
    }
    public static long power(long a, long b){
        if(b==1) return a%C;
        long half = power(a,b/2);
        if(b%2==0){
            return (half * half)%C;
        }else{
            return (half * half)%C * a % C ;
        }
    }
}
