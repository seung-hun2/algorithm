package baekjoon;

import java.util.Scanner;

public class p9655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 1 || N == 3) {
            System.out.println("SK");
        }else if(N == 2){
            System.out.println("CY");
        }else {
            if (N % 2 == 0) {
                System.out.println("CY");
            } else {
                System.out.println("SK");
            }
        }
    }

}
