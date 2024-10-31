package baekjoon;

import java.util.Scanner;

public class p6064 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc =0;tc<T;tc++){
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int lcm  = M*N / gcd(M,N);
            int n = 0;
            int ans = -1;
            while(n*M < lcm){
                if((n*M + x - y)%N == 0){
                    ans = n*M + x;
                    break;
                }
                n++;
            }
            System.out.println(ans);
        }
    }

    static int gcd(int n1, int n2){
        if(n2 == 0) return n1;
        return gcd(n2,n1%n2);
    }

}
