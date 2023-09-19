package baekjoon;

import java.util.Scanner;

public class p2702 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = gcd(a,b);
            System.out.print(a*b/k+" ");
            System.out.println(k);
        }
    }
    static int gcd(int a, int b){
        if(a%b ==0) return b;
        return gcd(b, a%b);
    }

}
