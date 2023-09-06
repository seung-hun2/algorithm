package baekjoon;

import java.util.Scanner;

public class p1654 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        long[] arr = new long[K];
        for(int i=0;i<K;i++){
            arr[i] = sc.nextInt();
        }
        long l = 0, r = (1L<<31)-1;
        long ans = 0;

        while (l<=r){
            long m  = (l+r)/2;
            int count = 0;
            for(int i=0;i<K;i++){
                if(arr[i]/m >0 ) count += arr[i]/m;
            }
            if(count < N)
                r = m -1;
            else {
                l = m+1;
                ans = m;
            }
        }

        System.out.println(ans);

    }

}
