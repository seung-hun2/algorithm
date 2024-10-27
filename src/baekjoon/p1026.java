package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p1026 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        for(int i=0;i<N;i++) A[i] = sc.nextInt();
        for(int i=0;i<N;i++) B[i] = sc.nextInt();

        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            int max = 0;
            int maxIdx = 0;
            for(int j=0;j<N;j++){
                if(max < B[j]){
                    maxIdx = j;
                    max = B[j];
                }
            }

            arr[i] = max;
            B[maxIdx] = 0;
        }
        Arrays.sort(A);
        int ans = 0;
        for(int i=0;i<N;i++){
            ans += arr[i] * A[i];
        }
        System.out.println(ans);
    }

}
