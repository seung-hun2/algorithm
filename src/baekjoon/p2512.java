package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p2512 {

    static int N, charge;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        charge = sc.nextInt();
        Arrays.sort(arr);
        int l = 0, r = arr[N-1];

        while (l <= r) {
            int mid = (l + r) / 2;
            long sum = 0;
            for(int i=0;i<N;i++){
                if(arr[i] > mid) sum += mid;
                else sum += arr[i];
            }
            if(sum<=charge){
                l = mid+1;
            }else{
                r = mid- 1;
            }
        }
        System.out.println(r);

    }

}
