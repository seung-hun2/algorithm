package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p15654 {
    static int N,M;
    static int[] numbers,output;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        numbers = new int[N];
        output = new int[M];
        check = new boolean[N];
        for(int i=0;i<N;i++) numbers[i] = sc.nextInt();
        Arrays.sort(numbers);

        perm(0);
    }

    public static void perm(int depth){
        // base case
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<M;i++){
                sb.append(output[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        // recursive case
        for(int i=0;i<N;i++){
            if(!check[i]){
                check[i] = true;
                output[depth] = numbers[i];
                perm(depth+1);
                check[i] = false;
            }
        }
    }
}
