package baekjoon;

import java.util.Scanner;

public class p10815 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[20000001];
        for(int i=0;i<N;i++){
            arr[sc.nextInt()+10000000]++;
        }
        StringBuilder sb = new StringBuilder();
        int M = sc.nextInt();
        for(int i=0;i<M;i++){
            if(arr[sc.nextInt()+10000000] != 0) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);

    }

}
