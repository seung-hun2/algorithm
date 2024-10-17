package baekjoon;

import java.util.Scanner;

public class p2828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int J = sc.nextInt();

        int ans = 0;

        int start = 1, end = M ;

        for (int i = 0; i < J; i++) {
            int apple = sc.nextInt();
            if(start > apple){
                ans += start - apple;
                end -= start - apple;
                start = apple;
            }else if(end < apple){
                ans += apple - end;
                start += apple - end;
                end = apple;
            }
        }
        System.out.println(ans);

    }

}

