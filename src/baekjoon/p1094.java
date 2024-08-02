package baekjoon;

import java.util.Scanner;

public class p1094 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int cnt=0;
        for(int i=0;i<7;i++){
            if((X&(1<<i)) > 0) cnt++;
        }
        System.out.println(cnt);
    }

}
