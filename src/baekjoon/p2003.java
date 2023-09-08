package baekjoon;

import java.util.Scanner;

public class p2003 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        int rightIndex = 0;
        int currentSum = arr[0];
        int ans = 0;
        for(int i=0;i<N;i++){
            while(currentSum < M && rightIndex< N-1){
                currentSum += arr[++rightIndex];
            }
            if(currentSum == M) ans++;
            currentSum -= arr[i];
        }
        System.out.println(ans);


    }

}
