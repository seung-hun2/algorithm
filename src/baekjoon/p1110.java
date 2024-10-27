package baekjoon;

import java.util.Scanner;

public class p1110 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cycle = 0;
        int ori = N;

        while(true){
            N = ((N%10)*10) + (((N/10) + (N%10))%10);
            cycle++;

            if(ori == N) break;
        }

        System.out.println(cycle);
    }

}
