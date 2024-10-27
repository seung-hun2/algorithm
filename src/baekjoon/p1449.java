package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p1449 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int last = arr[0] + L - 1;
        int cnt = 1;

        for(int i=1;i<N;i++){
            if(last < arr[i]){
                last = arr[i] + L -1;
                cnt++;
            }
        }
        System.out.println(cnt);
    }

}
