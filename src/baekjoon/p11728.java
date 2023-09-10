package baekjoon;

import java.util.Scanner;

public class p11728 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr1 = new int[N];
        int[] arr2 = new int[M];
        int[] ans = new int[N+M];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) arr1[i] = sc.nextInt();
        for(int i=0;i<M;i++) arr2[i] = sc.nextInt();

        int pt1 = 0, pt2 = 0;
        int idx = 0;
        while(pt1<N && pt2<M){
            if(arr1[pt1]< arr2[pt2]) ans[idx++] = arr1[pt1++];
            else ans[idx++] = arr2[pt2++];
        }
        while(pt1<N) ans[idx++] = arr1[pt1++];
        while(pt2<M) ans[idx++] = arr2[pt2++];
        for (int i = 0; i < idx; i++) {
            sb.append(ans[i]+" ");
        }

        System.out.println(sb);
    }

}
