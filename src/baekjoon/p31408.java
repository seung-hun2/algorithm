package baekjoon;

import java.util.Scanner;

public class p31408 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[100001];

        for(int i=0;i<N;i++){
            arr[sc.nextInt()]++;
        }
        int max = 0;
        for(int i=1;i<=100000;i++){
            max = Math.max(arr[i],max);
        }

        if ( 2* max - N  <= 1) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }


    }

}
