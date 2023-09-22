package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p7795 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int c=0;c<T;c++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[] a = new int[N];
            int[] b = new int[M];
            for(int i=0;i<N;i++) a[i] = sc.nextInt();
            for(int i=0;i<M;i++) b[i] = sc.nextInt();
            Arrays.sort(a);
            Arrays.sort(b);

            int bi=0;
            int ans=0;
            for(int i=0;i<N;i++){
                while(bi<M && b[bi] < a[i]) bi++;
                ans += bi;
            }
            System.out.println(ans);
        }
    }

}
