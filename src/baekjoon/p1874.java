package baekjoon;

import java.util.Scanner;

public class p1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        int[] stack = new int[N];
        int topIndex = -1;
        int nextNum = 1;
        for(int x : arr){
            while (nextNum <= x){
                stack[++topIndex] = nextNum++;
                sb.append("+\n");
            }
            if(topIndex < 0 || stack[topIndex] != x){
                System.out.println("NO");
                return;
            }
            sb.append("-\n");
            --topIndex;
        }
        System.out.println(sb);
    }

}
