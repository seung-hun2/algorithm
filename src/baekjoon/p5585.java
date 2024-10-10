package baekjoon;

import java.util.Scanner;

public class p5585 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {500,100,50, 10,5,1};

        int money = 1000 - sc.nextInt();

        int cnt = 0;
        int idx = 0;
        while(money > 0 || idx < 6){
            if(money/arr[idx] != 0){
                cnt += money/arr[idx];
                money %= arr[idx];
            }
            idx++;

        }
        System.out.println(cnt);
    }

    ///999 1 4 1 4 4
}
