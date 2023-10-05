package baekjoon;

import java.util.Scanner;

public class p17298 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        int[] ans = new int[N];
        int[] stack = new int[N];
        int topIndex = -1;
        for(int i=N-1;i>=0;i--){
            while(topIndex >= 0 && stack[topIndex] <= arr[i]) {
                topIndex--;
            }
            ans[i] = (topIndex >= 0 ? stack[topIndex] : -1);
            stack[++topIndex] = arr[i];
        }

        for(int i=0;i<N;i++){
            sb.append(ans[i]+" ");
        }
        System.out.println(sb);

    }

}
