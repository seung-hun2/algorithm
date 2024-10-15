package baekjoon;

import java.util.Scanner;

public class p10988 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int result = 1;

        String str = sc.next();
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                result = 0;
                break;
            }
        }
        System.out.println(result);
    }

}
