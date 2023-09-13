package baekjoon;

import java.util.Scanner;

public class p1100 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ans = 0 ;
        for(int i=0;i<8;i++){
            String str = sc.next();
            for(int j=0;j<8;j++){
                if(str.charAt(j) == 'F'&& (i+j)%2==0) ans++;
            }
        }
        System.out.println(ans);
    }

}
