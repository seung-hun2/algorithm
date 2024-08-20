package baekjoon;

import java.util.Scanner;

public class p1515 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int pt = 0;
        int base = 0;
        while(base++ <= 30000){
            String tmp = String.valueOf(base);
            for(int i=0;i<tmp.length();i++){
                if(tmp.charAt(i) == str.charAt(pt)) pt++;
                if(pt == str.length()){
                    System.out.println(base);
                    return;
                }
            }
        }
    }

}
