package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class p1920 {

    static int N,M;
    static int[] arr,num;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N =sc.nextInt();
        arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        M = sc.nextInt();
        num = new int[M];
        for(int i=0;i<M;i++){
            num[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        for(int i=0;i<M;i++){
            sb.append(find(num[i])).append('\n');
        }

        System.out.println(sb);
    }

    static int find(int value){

        int L = 0, R = N-1;
        boolean check = false;
        while(L<=R) {
            int mid = (L+R)/2;
            if(arr[mid] < value){
                L = mid+1;
            }else if(arr[mid] > value){
                R = mid-1;
            }else{
                check = true;
                break;
            }
        }

        if(check) return 1;
        else return 0;
    }

}
