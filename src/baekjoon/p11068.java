package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p11068 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int x = Integer.parseInt(br.readLine());
            boolean ans = false;
            for(int j=2;j<=64;j++){
                int[] digit = convert(x,j);
                if(isPalindrome(digit)){
                    ans = true;
                    break;
                }
            }
            System.out.println(ans ? "1":"0");
        }

    }

    public static int[] convert(int x, int base) {

        int len = 0, copyX = x;
        while (copyX>0){
            copyX /= base;
            len++;
        }
        int[] reverseDigit = new int[len];
        len = 0 ;
        while (x > 0) {
            reverseDigit[len++] = x % base;
            x /= base;
        }
        return reverseDigit;
    }

    public static boolean isPalindrome(int[] digit){
        for(int i=0;i<digit.length;i++){
            if(digit[i] != digit[digit.length-i-1]){
                return false;
            }
        }
        return true;
    }

}
