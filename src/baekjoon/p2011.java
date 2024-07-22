package baekjoon;

import java.util.Scanner;

public class p2011 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int N = str.length();
        int[] d = new int[N];

        if(str.charAt(0) != '0') d[0] = 1;

        for(int i=1;i<N;i++){
            if(str.charAt(i) != '0') d[i] = d[i-1];
            if(check(str.charAt(i-1), str.charAt(i))){
                if(i>=2) d[i] += d[i-2];
                else d[i] += 1;
                d[i] %= 1000000;
            }
        }

        System.out.println(d[N-1]);

    }
    static boolean check(char A, char B){
        if(A == '0') return false;
        if(A == '1') return true;
        if(A >= '3') return false;
        return B <= '6';
    }

}
